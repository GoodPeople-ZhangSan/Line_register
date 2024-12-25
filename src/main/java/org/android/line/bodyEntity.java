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

    public static RequestBody getBody_4() {
        long toTime_1 = System.currentTimeMillis();
        String toTime_2 = String.valueOf(System.currentTimeMillis() + 1000);

        String body = "{\"tdid\":\"n4919442860f222b4ece05da2646681c8\",\"tcid\":\"900072b76bab38678508373fb70b9c60\",\"tsid\":\"line\"," +
                "\"timestamp\":" + toTime_1 +
                ",\"events\":[{\"aName\":\"LINE\",\"aVer\":\"14.21.1\",\"pName\":\"ANDROID\",\"pVer\":\"12\",\"mVer\":\"4.7.4\",\"lang\":\"zh\",\"c\":\"CN\",\"mcc\":\"\",\"mnc\":\"\",\"model\":\"Pixel 5\",\"brand\":\"Google\",\"type\":\"S\"," +
                "\"timestamp\":" + toTime_2 +
                ",\"startTime\":" + toTime_2 +
                ",\"sessionTime\":0,\"seq\":1},{\"type\":\"R\",\"timestamp\":" + toTime_2 +
                ",\"startTime\":" + toTime_2 +
                ",\"sessionTime\":" + toTime_2 +
                ",\"aVer\":\"14.21.1\",\"pVer\":\"12\",\"mVer\":\"4.7.4\",\"c\":\"CN\",\"seq\":2}]}";
        return RequestBody.create(
                body, MediaType.parse("charset=utf-8"));
    }

    public static RequestBody getBody_5() {
        byte[] byteArray = {(byte) 0x82, 0x21, 0x01, 0x0f, 0x6e, 0x6f, 0x74, 0x69, 0x66, 0x79, 0x49, 0x6e, 0x73, 0x74, 0x61, 0x6c, 0x6c, 0x65, 0x64, 0x28, 0x20, 0x34, 0x39, 0x31, 0x39, 0x34, 0x34, 0x32, 0x38, 0x36, 0x30, 0x66, 0x32, 0x32, 0x32, 0x62, 0x34, 0x65, 0x63, 0x65, 0x30, 0x35, 0x64, 0x61, 0x32, 0x36, 0x34, 0x36, 0x36, 0x38, 0x31, 0x63, 0x38, 0x18, 0x1d, 0x41, 0x4e, 0x44, 0x52, 0x4f, 0x49, 0x44, 0x09, 0x31, 0x34, 0x2e, 0x32, 0x31, 0x2e, 0x31, 0x09, 0x41, 0x6e, 0x64, 0x72, 0x6f, 0x69, 0x64, 0x20, 0x4f, 0x53, 0x09, 0x31, 0x32, 0x00};
        String result = new String(byteArray);
        System.out.println(result);

        return RequestBody.create(
                result, MediaType.parse("application/x-thrift"));
    }

    public static RequestBody getBody_3() {
        // 创建body内容
        RequestBody requestBody = new FormBody.Builder().add("test", "test").build();
        return requestBody;
    }
}
