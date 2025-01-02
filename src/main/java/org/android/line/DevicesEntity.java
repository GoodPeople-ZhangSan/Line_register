package org.android.line;

import org.json.JSONObject;

import java.util.UUID;

public class DevicesEntity {
    // 一些手机版本的固定信息
    public final String adbDevices = "16091FDD4000W9";
    public final String iPhoneVer = "12";
    public final String iPhoneMode = "Pixel 5";
    public final String iPhoneBuild = "SQ3A.220705.003.A1";
    public final String iPhoneUA_1 = "Dalvik/2.1.0 (Linux; U; Android 12; Pixel 5 Build/SQ3A.220705.003.A1)";
    public final String iPhoneUA_2 = " (Linux; U; Android 12; zh_CN_#Hans; Pixel 5; Build/SQ3A.220705.003.A1; Cronet/132.0.6808.3)";

    // 设置一些protobuf中需要的固定值
    public final String proto_4_1_1 = "google/redfin/redfin:12/SQ3A.220705.003.A1/8672226:user/release-keys";
    public final String proto_4_1_4 = "g7250-00202-220422-B-8489468";
    public final String proto_4_1_5 = "r3-0.4-8351081";
    public final int proto_4_1_8 = 212423054;
    // 补丁包发布时间
    public final String proto_4_1_19= "2022-07-05";


    // 设置一些固定值
    public final String gcm_ver = "244738029";
    public final String app_ver = "142110270";
    public final String cert = "89396DC419292473972813922867E6973D6F5C50";
    public final String appid = "1:4586549225:android:9581cf5057737b34";
    public final String app_ver_name = "14.21.1";
    public final String subtype = "4586549225";
    public final String x_osv = "32";
    public final String x_cliv = "fcm-24.0.3";
    public final String app_name_hash = "R1dAH9Ui7M-ynoznwBdw01tLxhI";
    public final String target_ver = "34";

    // Google注册初始值，一个手机一个
    public final String google_android_id = "3893309659413393401";
    public final String google_security_token = "3209926037022420383";
    public final String info = "M7C2F_SYAuoTUE1VIFLpkGgyUckxPhk";


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

    // Authorization
    private String Authorization;
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

        // 设置 Authorization
        setAuthorization(google_android_id + ":" + google_security_token);

        // 输出
        System.out.println("生成的setAuthorization：" + getAuthorization());
        System.out.println("生成的android_id：" + getAndroid_id());
        System.out.println("生成的fid：" + getFid());
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

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String authorization) {
        Authorization = authorization;
    }

}
