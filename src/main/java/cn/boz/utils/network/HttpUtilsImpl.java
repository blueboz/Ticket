package cn.boz.utils.network;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public final class HttpUtilsImpl implements HttpUtils{

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
    public String post(String url) {
        return post(url,new HashMap<>());
    }

    @Override
    public String post(String url, Map<String, String> params) {
        return null;
    }

    public String post(String url,Object obj){
        return "";
    }

    @Override
    public String get(String url) throws IOException, InterruptedException {
        return get(url,new HashMap<>());
    }

    @Override
    public String get(String url, Map<String, String> params) throws IOException, InterruptedException {
        if(params!=null&&!params.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("?");
            params.forEach((k,v)->{
                sb.append(k+"="+v+"&");
            });
            sb.deleteCharAt(sb.length()-1);
            url+=sb.toString();

        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> send = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        return send.body();
    }
}
