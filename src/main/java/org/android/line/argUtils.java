package org.android.line;

import org.json.JSONException;

import java.security.MessageDigest;
import java.time.Instant;
import java.util.Base64;
import java.nio.ByteBuffer;
import java.util.UUID;

public class argUtils {
    // 用于生成fid时所需的运算值
    private static final byte f232672a = Byte.parseByte("01110000", 2);
    private static final byte f232673b = Byte.parseByte("00001111", 2);

    //生成UUID
    public static UUID getUUID() {
        UUID randomUUID = UUID.randomUUID();
        System.out.println("获取的UUID为：" + randomUUID);
        return randomUUID;
    }

    // 生成第一次请求所需body中内容fid
    public static String getFid() {

        UUID randomUUID = getUUID();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[17]);
        wrap.putLong(randomUUID.getMostSignificantBits());
        wrap.putLong(randomUUID.getLeastSignificantBits());
        byte[] array = wrap.array();
        byte b12 = array[0];
        array[16] = b12;
        array[0] = (byte) ((b12 & f232673b) | f232672a);
        String result = Base64.getUrlEncoder().encodeToString(array).substring(0, 22);
        System.out.println("生成的fid为：" + result);
        return result;
    }

    // 生成第二次请求所需body中内容
    public static String get_Envelope_1() throws JSONException {
        // 创建数据
        return "{\"sdk\":{\"name\":\"sentry.java.android\",\"version\":\"7.17.0\",\"packages\":[{\"name\":\"maven:io.sentry:sentry\",\"version\":\"7.17.0\"},{\"name\":\"maven:io.sentry:sentry-android-core\",\"version\":\"7.17.0\"},{\"name\":\"maven:io.sentry:sentry-android-ndk\",\"version\":\"7.17.0\"}],\"integrations\":[\"ViewHierarchy\",\"UncaughtExceptionHandler\",\"ShutdownHook\",\"SendCachedEnvelope\",\"Ndk\",\"ActivityLifecycle\",\"ActivityBreadcrumbs\",\"UserInteraction\",\"AppComponentsBreadcrumbs\",\"SystemEventsBreadcrumbs\",\"AppLifecycle\",\"NetworkBreadcrumbs\"]},\"" +
                "sent_at\":\"" + get_ToTime() + "\"}";
    }

    public static String get_Envelope_2() throws JSONException {
        // 创建数据
        return "{\"content_type\":\"application/json\",\"type\":\"session\",\"length\":293}";
    }


    public static String get_Envelope_3() throws JSONException {
        // 创建当前时间
        String nowTime = get_ToTime();
        // 创建数据
        return "{\"sid\":\"" + getUUID() + "\"," +
                "\"did\":\"" + getUUID() + "\",\"init\":true," +
                "\"started\":\"" + nowTime + "\",\"status\":\"ok\",\"errors\":0,\"timestamp\":\"" +
                nowTime + "\",\"attrs\":{\"release\":\"jp.naver.line.android@14.21.1+142110270\",\"environment\":\"production\"}}";
    }

    public static String get_ToTime() {
        // 获取当前时间的Instant对象
        Instant now = Instant.now();
        // 直接使用Instant的toString方法获取ISO 8601格式的字符串
        String timestamp = now.toString();
        System.out.println("当前时间的时间戳: " + timestamp);
        return timestamp;
    }

    // 用于获取第三次请求 R4中的 key
    public static String get_key(String timeStamp) {
        String verify_str = "Android_OS14.21.1--CN";
        String all_str = verify_str + "" + timeStamp;
        // 用于存放md5后的byte
        byte[] key_byte = new byte[0];
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] verify_byte = all_str.getBytes("UTF-8");
            byte[] fixed_byte = {76, 96, 94, -1, -33, 61, -4, -95, 33, 125, 72, 23, 64, 32, 86, -111, -128, -36, 35, 56, -91, 119, 42, -128, -19, 10, -86, 1, -68, -48, -96, -113};

            md5.update(verify_byte);
            md5.update(fixed_byte);
            key_byte = md5.digest();

        } catch (Exception e) {
            System.out.println("获取Key异常：" + e);
        }

        // 将哈希值字节数组转换为十六进制字符串
        StringBuilder hexString = new StringBuilder();
        for (byte b : key_byte) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        if (hexString.toString().length() == 32) {
            System.out.println("获取Key成功");
        } else {
            System.out.println("获取Key失败");
        }

        System.out.println("获取到的Key为："+hexString.toString());
        return hexString.toString();
    }
}
