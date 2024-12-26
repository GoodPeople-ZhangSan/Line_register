package org.android.line;

import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    // 用于发送请求

    public static void main(String[] args) throws JSONException {
        // 进入Line，开始初始化
        System.out.println("进入Line，开始初始化");
        // 准备 tdid tcid 等一些参数
        AdbDevices adbDevices = new AdbDevices();

        System.out.println("发送第一次请求");
        // 发送第一次请求-installations
//        String requestBody_1 = OkhttpUtils.doPost(urlEntity.getUrl_1(), headerEntity.getHeader_1(), bodyEntity.getBody_1());
        // 提取body中的token，返回作用于后续X-Google-Firebase-Installations-Auth使用
//        adbDevices.setInstallations_auth(requestBody_1);


        System.out.println("发送第二次请求");
        // 发送第二次请求-envelope
//        OkhttpUtils.doPost(urlEntity.getUrl_2(), headerEntity.getHeader_2(), bodyEntity.getBody_2());

        // 发送第三次请求-R4
        System.out.println("发送第三次请求");
//        OkhttpUtils.doGet(urlEntity.getUrl_3(), headerEntity.getHeader_3());

        // 发送第四次请求-event
        System.out.println("发送第四次请求");
//        OkhttpUtils.doPost(urlEntity.getUrl_4(), headerEntity.getHeader_4(), bodyEntity.getBody_4(adbDevices));

        // 发送第五次请求-TalkServices.do
        System.out.println("发送第五次请求");
//        OkhttpUtils.doPost(urlEntity.getUrl_5(), headerEntity.getHeader_5(), bodyEntity.getBody_5(adbDevices));

        System.out.println("发送第六次请求");
        OkhttpUtils.doPost(urlEntity.getUrl_6(), headerEntity.getHeader_6(), bodyEntity.getBody_6(adbDevices));


        System.out.println("结束");

//        bodyEntity.getBody_4();
    }


}