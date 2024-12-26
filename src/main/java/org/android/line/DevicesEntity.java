package org.android.line;

import org.json.JSONObject;

import java.util.UUID;

public class DevicesEntity {
    // 设置一些固定值
    public final String gcm_ver = "244738029";
    public final String app_ver = "142110270";
    public final String cert = "89396DC419292473972813922867E6973D6F5C50";
    public final String appid = "1:4586549225:android:9581cf5057737b34";
    public final String app_ver_name = "14.21.1";


    // Fid 在register3也使用了
    private String fid;
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


    public DevicesEntity() {
        // 设置android_id
        String randomAndroidId = ArgUtils.generateRandomString(16);
        setAndroid_id(randomAndroidId);

        // 设置 did
        setDid(ArgUtils.toMD5(randomAndroidId));

        // 设置 tdid，在event请求中使用时需要在开头加上  "n"
        setTdid("n" + getDid());

        // 设置 tcid
        String replaceAll = UUID.nameUUIDFromBytes(getTdid().getBytes()).toString().replaceAll("-", "");
        setTcid(replaceAll);

        // 设置fid
        setFid(ArgUtils.getFid());

        // 输出
        System.out.println("生成的android_id：" + getAndroid_id());
        System.out.println("生成的did：" + getDid());
        System.out.println("生成的tdid：" + getTdid());
        System.out.println("生成的tcid：" + getTcid());
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

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

}
