package org.android.line;

public class adbDevices {
    // android_id
    private String android_id;
    // tdid
    private String tdid;



    public adbDevices() {
        // 设置android_id
        String randomAndroidId = argUtils.generateRandomString(16);
        setAndroid_id(randomAndroidId);

        // 设置 tdid
        setTdid(argUtils.toMD5(randomAndroidId));
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
