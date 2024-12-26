package org.android.line;

import com.google.common.primitives.Bytes;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;


public class bodyEntity {
    public static RequestBody getBody_1() throws JSONException {
        // 创建body内容
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fid", argUtils.getFid());
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

    public static RequestBody getBody_4(AdbDevices adbDevices) {
        // 准备时间戳
        long toTime_1 = System.currentTimeMillis();
        String toTime_2 = String.valueOf(System.currentTimeMillis() + 1000);


        System.out.println("生成的android_id：" + adbDevices.getAndroid_id());
        System.out.println("生成的did：" + adbDevices.getDid());
        System.out.println("生成的tdid：" + adbDevices.getTdid());
        System.out.println("生成的tcid：" + adbDevices.getTcid());

        // 准备body
        String body = "{\"tdid\":\"" + adbDevices.getTdid() +
                "\",\"tcid\":\"" + adbDevices.getTcid() +
                "\",\"tsid\":\"line\"," +
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

    public static RequestBody getBody_5(AdbDevices adbDevices) {
        byte[] byteArray1 = {(byte) 0x82, 0x21, 0x01, 0x0f, 0x6e, 0x6f, 0x74, 0x69, 0x66, 0x79, 0x49, 0x6e, 0x73, 0x74, 0x61, 0x6c, 0x6c, 0x65, 0x64, 0x28, 0x20};
        byte[] byteArray2 = adbDevices.getDid().getBytes();
        byte[] byteArray3 = {0x18, 0x1d, 0x41, 0x4e, 0x44, 0x52, 0x4f, 0x49, 0x44, 0x09, 0x31, 0x34, 0x2e, 0x32, 0x31, 0x2e, 0x31, 0x09, 0x41, 0x6e, 0x64, 0x72, 0x6f, 0x69, 0x64, 0x20, 0x4f, 0x53, 0x09, 0x31, 0x32, 0x00};
        byte[] result = Bytes.concat(byteArray1, byteArray2, byteArray3);
        System.out.println("生成的第五次请求的body为：" + new String(result));

        return RequestBody.create(
                result, MediaType.parse("application/x-thrift"));
    }

    public static RequestBody getBody_6(AdbDevices adbDevices) {
        // 创建body内容
        RequestBody requestBody = new FormBody.Builder()
                .add("X-subtype", "4586549225")
                .add("sender", "4586549225")
                .add("X-app_ver", "142110270")
                .add("X-osv", "32")
                .add("X-cliv", "fcm-24.0.3")
                .add("X-gmsv", "212423054")
                .add("X-appid", "elLhk0LoQYu8QjZIYjmdYS")
                .add("X-scope", "*")
                .add("X-Goog-Firebase-Installations-Auth", "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHBJZCI6IjE6NDU4NjU0OTIyNTphbmRyb2lkOjk1ODFjZjUwNTc3MzdiMzQiLCJleHAiOjE3MzUyODM3MTUsImZpZCI6ImVsTGhrMExvUVl1OFFqWklZam1kWVMiLCJwcm9qZWN0TnVtYmVyIjo0NTg2NTQ5MjI1fQ.AB2LPV8wRQIgLbety__8j3PuwA90iAxjNLAEN24CFOTQtQHvAG81CG8CIQDAuT_nMoNTXyatkK_ilkDToBREK8h8m1vUogcPeAd-GQ")
                .add("X-gmp_app_id", "1%3A4586549225%3Aandroid%3A9581cf5057737b34")
                .add("X-firebase-app-name-hash", "R1dAH9Ui7M-ynoznwBdw01tLxhI")
                .add("X-app_ver_name", "14.21.1")
                .add("app", "jp.naver.line.android")
                .add("device", "4317700272594290259")
                .add("app_ver", "142110270")
                .add("info", "Y48DEYzm00cYUE1VIFLpkGhCCUnjPRk")
                .add("gcm_ver", "212423054")
                .add("plat", "0")
                .add("cert", "89396dc419292473972813922867e6973d6f5c50")
                .add("target_ver", "34")
                .build();
        return requestBody;
    }
}
