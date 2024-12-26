package org.android.line;

import com.google.common.primitives.Bytes;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;


public class BodyEntity {
    public static RequestBody getBody_1(String fid, String appid) throws JSONException {
        // 创建body内容
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fid", fid);
        jsonObject.put("appId", appid);
        jsonObject.put("authVersion", "FIS_v2");
        jsonObject.put("sdkVersion", "a:18.0.0");

        String json = jsonObject.toString();

        return RequestBody.create(
                json, MediaType.parse("application/json; charset=utf-8"));
    }


    public static RequestBody getBody_2(String app_ver_name, String app_ver) {
        // 创建body内容，需要注意的是，第三个内容中的时间戳在最早
        String json3 = ArgUtils.get_Envelope_3(app_ver_name, app_ver);
        String json1 = ArgUtils.get_Envelope_1();
        String json2 = ArgUtils.get_Envelope_2();
        String body = json1 + "\n" + json2 + "\n" + json3 + "\n";

        System.out.println("构造完成的body参数为：" + body);
        return RequestBody.create(
                body, MediaType.get("application/x-sentry-envelope"));
    }

    public static RequestBody getBody_4(String tDid, String tCid, String app_ver_name) {
        // 准备时间戳
        long toTime_1 = System.currentTimeMillis();
        String toTime_2 = String.valueOf(System.currentTimeMillis() + 1000);

        // 准备body
        String body = "{\"tdid\":\"" + tDid +
                "\",\"tcid\":\"" + tCid +
                "\",\"tsid\":\"line\"," +
                "\"timestamp\":" + toTime_1 +
                ",\"events\":[{\"aName\":\"LINE\",\"aVer\":\"" + app_ver_name +
                "\",\"pName\":\"ANDROID\",\"pVer\":\"12\",\"mVer\":\"4.7.4\",\"lang\":\"zh\",\"c\":\"CN\",\"mcc\":\"\",\"mnc\":\"\",\"model\":\"Pixel 5\",\"brand\":\"Google\",\"type\":\"S\"," +
                "\"timestamp\":" + toTime_2 +
                ",\"startTime\":" + toTime_2 +
                ",\"sessionTime\":0,\"seq\":1},{\"type\":\"R\",\"timestamp\":" + toTime_2 +
                ",\"startTime\":" + toTime_2 +
                ",\"sessionTime\":" + toTime_2 +
                ",\"aVer\":\"" + app_ver_name +
                "\",\"pVer\":\"12\",\"mVer\":\"4.7.4\",\"c\":\"CN\",\"seq\":2}]}";
        return RequestBody.create(
                body, MediaType.parse("charset=utf-8"));
    }

    public static RequestBody getBody_5(byte[] byteArray2) {
        byte[] byteArray1 = {(byte) 0x82, 0x21, 0x01, 0x0f, 0x6e, 0x6f, 0x74, 0x69, 0x66, 0x79, 0x49, 0x6e, 0x73, 0x74, 0x61, 0x6c, 0x6c, 0x65, 0x64, 0x28, 0x20};
        byte[] byteArray3 = {0x18, 0x1d, 0x41, 0x4e, 0x44, 0x52, 0x4f, 0x49, 0x44, 0x09, 0x31, 0x34, 0x2e, 0x32, 0x31, 0x2e, 0x31, 0x09, 0x41, 0x6e, 0x64, 0x72, 0x6f, 0x69, 0x64, 0x20, 0x4f, 0x53, 0x09, 0x31, 0x32, 0x00};
        byte[] result = Bytes.concat(byteArray1, byteArray2, byteArray3);
        System.out.println("生成的第五次请求的body为：" + new String(result));

        return RequestBody.create(
                result, MediaType.parse("application/x-thrift"));
    }

    public static RequestBody getBody_6(DevicesEntity devicesEntity) {
        // 创建body内容
        RequestBody requestBody = new FormBody.Builder()
                .add("X-subtype", devicesEntity.subtype)
                .add("sender", devicesEntity.subtype)
                .add("X-app_ver", devicesEntity.app_ver)
                .add("X-osv", devicesEntity.x_osv)
                .add("X-cliv", devicesEntity.x_cliv)
                .add("X-gmsv", devicesEntity.gcm_ver)
                .add("X-appid", devicesEntity.getFid())
                .add("X-scope", "*")
                .add("X-Goog-Firebase-Installations-Auth", devicesEntity.getInstallations_auth())
                .add("X-gmp_app_id", devicesEntity.appid)
                .add("X-firebase-app-name-hash", devicesEntity.app_name_hash)
                .add("X-app_ver_name", devicesEntity.app_ver_name)
                .add("app", "jp.naver.line.android")
                .add("device", devicesEntity.google_android_id)
                .add("app_ver", devicesEntity.app_ver)
                .add("info", devicesEntity.info)
                .add("gcm_ver", devicesEntity.gcm_ver)
                .add("plat", "0")
                .add("cert", devicesEntity.cert)
                .add("target_ver", devicesEntity.target_ver)
                .build();
        return requestBody;
    }
}
