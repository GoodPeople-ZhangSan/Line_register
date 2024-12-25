package org.android.line;

import org.android.thrift.Pair;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import static org.android.line.argUtils.getFid;

public class bodyEntity {
    public static RequestBody getBody_1() throws JSONException {

        // 创建body内容
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fid", getFid());
        jsonObject.put("appId", "1:4586549225:android:9581cf5057737b34");
        jsonObject.put("authVersion", "FIS_v2");
        jsonObject.put("sdkVersion", "a:18.0.0");

        String json = jsonObject.toString();

        return RequestBody.create(
                json, MediaType.parse("application/json; charset=utf-8"));
    }


    public static RequestBody getBody_2() {
        // 创建body内容，需要注意的是，第三个内容中的时间戳在最早
        String json3 = argUtils.get_Envelope_3();
        String json1 = argUtils.get_Envelope_1();
        String json2 = argUtils.get_Envelope_2();
        String body = json1 + "\n" + json2 + "\n" + json3 + "\n";

        System.out.println("构造完成的body参数为：" + body);
        return RequestBody.create(
                body, MediaType.get("application/x-sentry-envelope"));
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            // 将每个字节转换为两位十六进制数，并添加到StringBuilder中
            // %02X 表示大写十六进制，且不足两位时前面补0
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    public static RequestBody getBody_4() {
        byte[] byteArray = {(byte) 0x82, 0x21, 0x01, 0x0f, 0x6e, 0x6f, 0x74, 0x69, 0x66, 0x79, 0x49, 0x6e, 0x73, 0x74, 0x61, 0x6c, 0x6c, 0x65, 0x64, 0x28, 0x20, 0x36, 0x64, 0x65, 0x62, 0x62, 0x38, 0x31, 0x32, 0x61, 0x62, 0x65, 0x65, 0x32, 0x30, 0x37, 0x64, 0x62, 0x33, 0x35, 0x34, 0x62, 0x34, 0x63, 0x30, 0x31, 0x64, 0x63, 0x35, 0x63, 0x66, 0x66, 0x34, 0x18, 0x1d, 0x41, 0x4e, 0x44, 0x52, 0x4f, 0x49, 0x44, 0x09, 0x31, 0x34, 0x2e, 0x32, 0x31, 0x2e, 0x31, 0x09, 0x41, 0x6e, 0x64, 0x72, 0x6f, 0x69, 0x64, 0x20, 0x4f, 0x53, 0x09, 0x31, 0x32, 0x00};
        String result = new String(byteArray);
        System.out.println(result);

        return RequestBody.create(
                result, MediaType.parse("application/x-thrift; charset=UTF-8"));

    }

    public static RequestBody getBody_3() {
        // 创建body内容
        RequestBody requestBody = new FormBody.Builder().add("test", "test").build();
        return requestBody;
    }
}
