package org.android.line;

import org.json.JSONException;

public class Main {
    // 用于发送请求

    public static void main(String[] args) throws JSONException {
        // 进入Line，开始初始化
        System.out.println("进入Line，开始初始化");
        // 准备 tdid tcid 等一些参数
        DevicesEntity devicesEntity = new DevicesEntity();

        System.out.println("发送第一次请求");
        // 发送第一次请求-installations
        String requestBody_1 = OkhttpUtils.doPost(UrlEntity.getUrl_1(), HeaderEntity.getHeader_1(devicesEntity.cert), BodyEntity.getBody_1(devicesEntity.getFid(), devicesEntity.appid));
        // 提取body中的token，返回作用于后续X-Google-Firebase-Installations-Auth使用
        devicesEntity.setInstallations_auth(requestBody_1);


        System.out.println("发送第二次请求");
        // 发送第二次请求-envelope
        OkhttpUtils.doPost(UrlEntity.getUrl_2(), HeaderEntity.getHeader_2(), BodyEntity.getBody_2(devicesEntity.app_ver_name, devicesEntity.app_ver));

        // 发送第三次请求-R4
        System.out.println("发送第三次请求");
        OkhttpUtils.doGet(UrlEntity.getUrl_3(devicesEntity.app_ver_name), HeaderEntity.getHeader_3(devicesEntity.app_ver_name));

        // 发送第四次请求-event
        System.out.println("发送第四次请求");
        OkhttpUtils.doPost(UrlEntity.getUrl_4(), HeaderEntity.getHeader_4(devicesEntity.app_ver_name), BodyEntity.getBody_4(devicesEntity.getTdid(), devicesEntity.getTcid(), devicesEntity.app_ver_name));

        // 发送第五次请求-TalkServices.do
        System.out.println("发送第五次请求");
        OkhttpUtils.doPost(UrlEntity.getUrl_5(), HeaderEntity.getHeader_5(devicesEntity.app_ver_name), BodyEntity.getBody_5(devicesEntity.getDid().getBytes()));

        // 发送第六次请求-register3
        System.out.println("发送第六次请求");
        OkhttpUtils.doPost(UrlEntity.getUrl_6(), HeaderEntity.getHeader_6(devicesEntity.app_ver, devicesEntity.gcm_ver), BodyEntity.getBody_6(devicesEntity));


        System.out.println("结束");

//        BodyEntity.getBody_4();
    }


}