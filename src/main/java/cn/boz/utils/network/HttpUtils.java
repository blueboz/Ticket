package cn.boz.utils.network;

import java.util.Map;

public interface HttpUtils {
    public String post(String url);
    public String post(String url, Map<String,String> params);
    public String get(String url);
    public String get(String url, Map<String,String> params);
}
