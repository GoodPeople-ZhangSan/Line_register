package org.android.line;

public class UrlEntity {
    private static final String Host_1 = "https://firebaseinstallations.googleapis.com/v1/projects/jp-naver-line/installations";
    private static final String Host_2 = "https://ly.my.sentry.io/api/6/envelope/";
    private static final String Host_3 = "https://cix.line-apps.com/R4?";
    private static final String Host_4 = "https://legy.line-apps.com";
    private static final String Host_5 = "https://android.apis.google.com";
    private static final String Host_6 = "https://android.googleapis.com";

    public static String getUrl_1() {
        return Host_1;
    }

    public static String getUrl_2() {
        return Host_2;
    }

    public static String getUrl_3(String app_ver_name) {
        /*
        :path: /R4?type=Android_OS&version=14.21.1&regions=--CN&carrier=&time=1734678913&key=f9e44c154400ccca9a5e50a5144a5679
        :authority: cix.line-apps.com
         */
        String toTime = String.valueOf(System.currentTimeMillis() / 1000);
        String host = Host_3 + "type=Android_OS&version=" + app_ver_name + "&regions=--CN&carrier=&time=" + toTime + "&key=" + ArgUtils.get_key(toTime, app_ver_name);
        return host;
    }

    public static String getUrl_4() {
        return Host_4 + "/tr/event";
    }

    public static String getUrl_5() {
        return Host_4 + "/api/v4/TalkService.do";
    }


    public static String getUrl_6() {
        return Host_5 + "/c2dm/register3";
    }

    public static String getUrl_7() {
        return Host_6 + "/checkin";
    }
}
