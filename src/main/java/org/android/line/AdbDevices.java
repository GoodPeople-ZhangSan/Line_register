package org.android.line;

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
}
