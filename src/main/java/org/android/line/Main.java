package org.android.line;

import okhttp3.RequestBody;
import org.json.JSONException;

public class Main {
    // 用于发送请求

    public static void main(String[] args) throws JSONException {


        // 进入Line，开始初始化
        System.out.println("进入Line，开始初始化");
        // firebaseinstallations.googleapis.com  /v1/projects/jp-naver-line/installations
        System.out.println("发送第一次请求");
        // 发送第一次请求
//        OkhttpUtils.doPost(urlEntity.getUrl_1(), headerEntity.getHeader_1(), bodyEntity.getBody_1());

        System.out.println("发送第二次请求");
        // 发送第二次请求
//        OkhttpUtils.doPost(urlEntity.getUrl_2(), headerEntity.getHeader_2(), bodyEntity.getBody_2());

        // 发送第三次请求
        System.out.println("发送第三次请求");
//        OkhttpUtils.doGet(urlEntity.getUrl_3(), headerEntity.getHeader_3());

        // 发送第四次请求-event
        System.out.println("发送第四次请求");
//        OkhttpUtils.doPost(urlEntity.getUrl_4(), headerEntity.getHeader_4(), bodyEntity.getBody_4());

        // 发送第五次请求-TalkServices.do
        System.out.println("发送第五次请求");
        OkhttpUtils.doPost(urlEntity.getUrl_5(), headerEntity.getHeader_5(), bodyEntity.getBody_5());

        System.out.println("结束");

//        bodyEntity.getBody_4();
    }


}