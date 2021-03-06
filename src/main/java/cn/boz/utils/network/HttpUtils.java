package cn.boz.utils.network;

import java.io.IOException;
import java.util.Map;

public interface HttpUtils {
    public String post(String url) throws IOException, InterruptedException;
    public String post(String url, Map<String,String> params) throws IOException, InterruptedException;
    public String get(String url) throws IOException, InterruptedException;
    public String get(String url, Map<String,String> params) throws IOException, InterruptedException;
}
