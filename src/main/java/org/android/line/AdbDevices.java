package org.android.line;

import org.json.JSONObject;

import java.util.UUID;

public class AdbDevices {
    // android_id
    private String android_id;
    // did
    private String did;
    // tdid
    private String tdid;
    // tcid
    private String tcid;


    // X-Goog-Firebase-Installations-Auth
    private String installations_auth;


    public AdbDevices() {
        // 设置android_id
        String randomAndroidId = argUtils.generateRandomString(16);
        setAndroid_id(randomAndroidId);

        // 设置 did
        setDid(argUtils.toMD5(randomAndroidId));

        // 设置 tdid，在event请求中使用时需要在开头加上  "n"
        setTdid("n" + getDid());

        // 设置 tcid
        String replaceAll = UUID.nameUUIDFromBytes(getTdid().getBytes()).toString().replaceAll("-", "");
        setTcid(replaceAll);
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getTcid() {
        return tcid;
    }

    public void setTcid(String tcid) {
        this.tcid = tcid;
    }

    public String getTdid() {
        return tdid;
    }

    public void setTdid(String tdid) {
        this.tdid = tdid;
    }


    public String getAndroid_id() {
        return android_id;
    }

    public void setAndroid_id(String android_id) {
        this.android_id = android_id;
    }


    public String getInstallations_auth() {
        return installations_auth;
    }

    public void setInstallations_auth(String requestBody_1) {
        // 把返回body转为JSON
        JSONObject jsonObject_1 = new JSONObject(requestBody_1);
        // 访问authToken对象
        JSONObject authTokenObject = jsonObject_1.getJSONObject("authToken");
        // 从authToken对象中提取token，后续需要用到
        String authTokenObject_token = authTokenObject.getString("token");
        System.out.println("获取到的X-Google-Firebase-Installations-Auth：" + authTokenObject_token);
        // 赋值
        this.installations_auth = authTokenObject_token;
    }
}
