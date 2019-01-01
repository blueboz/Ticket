package cn.boz.utils.network;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网络工具
 */
public final class HttpUtilsImpl implements HttpUtils{

    private static Logger logger = LoggerFactory.getLogger(HttpUtilsImpl.class);

    public static  HttpUtils INST=new HttpUtilsImpl();

    private HttpClient httpClient;

    private HttpUtilsImpl(){
        httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(5000))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
    }

    public static HttpUtils getINST(){
       return INST;
    }

    @Override
    public String post(String url) throws IOException, InterruptedException {
        return post(url,new HashMap<>());
    }

    @Override
    public String post(String url, Map<String, String> params) throws IOException, InterruptedException {
        String param = genFormParams(params);
        logger.debug("params is"+param);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type","application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(param))
                .build();
        HttpResponse<String> rst = httpClient.send(request, new HttpResponse.BodyHandler<String>() {
            @Override
            public HttpResponse.BodySubscriber<String> apply(HttpResponse.ResponseInfo responseInfo) {
                HttpHeaders headers = responseInfo.headers();
                Map<String, List<String>> map = headers.map();
                map.forEach((k,v)->{
                    System.out.println(k+":"+v);
                });
                return HttpResponse.BodySubscribers.ofString(Charset.defaultCharset());
            }
        });
        //HttpResponse<String> rst = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return rst.body();
    }

    /**
     * 按照json格式的post请求
     * @param url
     * @param obj
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String post(String url,Object obj) throws IOException, InterruptedException {
        String json = JSON.toJSONString(obj);
        logger.debug("json is "+json);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpResponse<String> rst = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return rst.body();
    }

    /**
     * 不带参数的get请求
     * @param url 目标url
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public String get(String url) throws IOException, InterruptedException {
        return get(url,new HashMap<>());
    }

    /**
     * get请求
     * @param url 目标url
     * @param params 请求参数
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public String get(String url, Map<String, String> params) throws IOException, InterruptedException {
        String s = genFormParams(params);
        if(!s.isEmpty()){
            url+="?"+s;
        }
        logger.debug("full url is =>"+url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> send = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        return send.body();
    }

    /**
     * 得到form 表单样式的参数
     * @param params 参数map
     * @return 字符串
     */
    private String genFormParams(Map<String,String> params){
        StringBuilder sb = new StringBuilder();
        if(params!=null&&!params.isEmpty()){
            params.forEach((k,v)->{
                sb.append(k+"="+v+"&");
            });
            sb.deleteCharAt(sb.length()-1);
            logger.debug("url params is"+sb.toString());
        }
        return sb.toString();
    }
}
