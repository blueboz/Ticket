package cn.boz.utils.network;

import java.net.http.HttpClient;
import java.time.Duration;
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
        return null;
    }

    @Override
    public String post(String url, Map<String, String> params) {
        return null;
    }

    @Override
    public String get(String url) {
        return null;
    }

    @Override
    public String get(String url, Map<String, String> params) {
        return null;
    }
}
