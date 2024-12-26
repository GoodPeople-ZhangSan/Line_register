package org.android.line;

import java.util.HashMap;
import java.util.Map;

public class HeaderEntity {
    public static Map<String, String> getHeader_1() {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("Accept", "application/json");
        map.put("Content-Encoding", "gzip");
        map.put("Cache-Control", "no-cache");
        map.put("X-Android-Package", "jp.naver.line.android");
        map.put("x-firebase-client", "H4sIAAAAAAAAAKtWykhNLCpJSk0sKVayio7VUSpLLSrOzM9TslIyUqoFAFyivEQfAAAA");
        map.put("X-Android-Cert", "89396DC419292473972813922867E6973D6F5C50");
        map.put("x-goog-api-key", "AIzaSyBGRb2sEaaXjsKH6ea6f2xSiUeG4D8vaCY");
        map.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 12; Pixel 5 Build/SQ3A.220705.003.A1)");
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


    public static Map<String, String> getHeader_3() {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("user-agent", "Line/14.21.1");
        map.put("accept-encoding", "gzip");
        return map;
    }

    public static Map<String, String> getHeader_4() {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("x-line-ts-type", "EVENT");
        map.put("x-line-ts-version", "4.7.4");
        map.put("x-line-ts-platform", "ANDROID");
        map.put("content-type", "charset=utf-8");
        map.put("user-agent", "Line/14.21.1");
        map.put("x-line-application", "ANDROID	14.21.1	Android OS	12");
        map.put("x-lal", "zh-Hans_CN");
        map.put("x-lpv", "1");
        map.put("accept-encoding", "gzip");
        return map;
    }


    public static Map<String, String> getHeader_5() {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("user-agent", "Line/14.21.1");
        map.put("x-line-application", "ANDROID	14.21.1	Android OS	12");
        map.put("x-lal", "zh-Hans_CN");
        map.put("x-lpv", "1");
        map.put("content-type", "application/x-thrift");
        map.put("accept-encoding", "gzip");
        return map;
    }

    public static Map<String, String> getHeader_6(DevicesEntity devicesEntity) {
        // 创建header内容
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "AidLogin 3893309659413393401:3209926037022420383");
        map.put("app", "jp.naver.line.android");
        map.put("gcm_ver", devicesEntity.gcm_ver);
        map.put("app_ver", devicesEntity.app_ver);
        map.put("User-Agent", "com.google.android.gms/" + devicesEntity.gcm_ver + " (Linux; U; Android 12; zh_CN_#Hans; Pixel 5; Build/SQ3A.220705.003.A1; Cronet/132.0.6808.3)");
        map.put("accept-encoding", "gzip, deflate, br");
        map.put("content-type", "application/x-www-form-urlencoded");
        map.put("priority", "u=1, i");
        return map;
    }
}
