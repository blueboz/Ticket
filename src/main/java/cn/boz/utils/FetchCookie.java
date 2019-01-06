package cn.boz.utils;

import java.net.*;
import java.util.List;

public class FetchCookie {
    public static void main(String args[]) throws Exception {
        String urlString = "https://www.baidu.com";
        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        Object obj = connection.getContent();
        url = new URL(urlString);
        connection = url.openConnection();
        obj = connection.getContent();
        CookieStore cookieJar = manager.getCookieStore();
        List<HttpCookie> cookies = cookieJar.getCookies();
        for (HttpCookie cookie : cookies) {
            System.out.println(cookie);
        }
    }
}