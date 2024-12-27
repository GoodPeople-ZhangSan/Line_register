package org.android.line;

import java.util.HashMap;
import java.util.Map;

public class HeaderEntity {
    public static Map<String, String> getHeader_1(String cert, String iPhoneUA_1) {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("Accept", "application/json");
        map.put("Content-Encoding", "gzip");
        map.put("Cache-Control", "no-cache");
        map.put("X-Android-Package", "jp.naver.line.android");
        map.put("x-firebase-client", "H4sIAAAAAAAAAKtWykhNLCpJSk0sKVayio7VUSpLLSrOzM9TslIyUqoFAFyivEQfAAAA");
        map.put("X-Android-Cert", cert);
        map.put("x-goog-api-key", "AIzaSyBGRb2sEaaXjsKH6ea6f2xSiUeG4D8vaCY");
        map.put("User-Agent", iPhoneUA_1);
        map.put("Host", "firebaseinstallations.googleapis.com");
        map.put("Connection", "Keep-Alive");
        map.put("Accept-Encoding", "gzip");
        return map;
    }

    public static Map<String, String> getHeader_2() {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("User-Agent", "sentry.java.android/7.17.0");
        map.put("X-Sentry-Auth", "Sentry sentry_version=7,sentry_client=sentry.java.android/7.17.0,sentry_key=033c95ffe2c00cfec4ff887ac0a3bf1c");
//        map.put("Content-Encoding", "gzip");
        map.put("Content-Type", "application/x-sentry-envelope");
        map.put("Accept", "application/json");
        map.put("Connection", "close");
        map.put("Host", "ly.my.sentry.io");
        map.put("Accept-Encoding", "gzip");
        return map;
    }


    public static Map<String, String> getHeader_3(String app_ver_name) {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("user-agent", "Line/" + app_ver_name);
        map.put("accept-encoding", "gzip");
        return map;
    }

    public static Map<String, String> getHeader_4(String app_ver_name) {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("x-line-ts-type", "EVENT");
        map.put("x-line-ts-version", "4.7.4");
        map.put("x-line-ts-platform", "ANDROID");
        map.put("content-type", "charset=utf-8");
        map.put("user-agent", "Line/" + app_ver_name);
        map.put("x-line-application", "ANDROID	" + app_ver_name + "	Android OS	12");
        map.put("x-lal", "zh-Hans_CN");
        map.put("x-lpv", "1");
        map.put("accept-encoding", "gzip");
        return map;
    }


    public static Map<String, String> getHeader_5(String app_ver_name) {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("user-agent", "Line/" + app_ver_name);
        map.put("x-line-application", "ANDROID	" + app_ver_name + "	Android OS	12");
        map.put("x-lal", "zh-Hans_CN");
        map.put("x-lpv", "1");
        map.put("content-type", "application/x-thrift");
        map.put("accept-encoding", "gzip");
        return map;
    }

    public static Map<String, String> getHeader_6(String app_ver, String gcm_ver, String iPhoneUA_2, String Authorization) {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "AidLogin " + Authorization);
        map.put("app", "jp.naver.line.android");
        map.put("gcm_ver", gcm_ver);
        map.put("app_ver", app_ver);
        map.put("User-Agent", "com.google.android.gms/" + gcm_ver + iPhoneUA_2);
        map.put("accept-encoding", "gzip, deflate, br");
        map.put("content-type", "application/x-www-form-urlencoded");
        map.put("priority", "u=1, i");
        return map;
    }

    public static Map<String, String> getHeader_7(String iPhoneUA_1) {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("Content-type", "application/x-protobuffer");
        map.put("Content-encoding", "gzip");
        map.put("Accept-encoding", "gzip");
        map.put("User-Agent", iPhoneUA_1);
        map.put("Host", "android.googleapis.com");
        map.put("Connection", "Keep-Alive");
        return map;
    }
}
