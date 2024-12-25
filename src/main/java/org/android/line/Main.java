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
        RequestBody body2 = bodyEntity.getBody_2();
        System.out.println(body2);
        // 发送第二次请求
        OkhttpUtils.doPost(urlEntity.getUrl_2(), headerEntity.getHeader_2(), body2);

        // 发送第三次请求
        System.out.println("发送第三次请求");
//        OkhttpUtils.doGet(urlEntity.getUrl_3(), headerEntity.getHeader_3());

        // 发送第四次请求
//        System.out.println("发送第四次请求");
//        byte[] byteArray = {(byte) 0x82, 0x21, 0x01, 0x0f, 0x6e, 0x6f, 0x74, 0x69, 0x66, 0x79, 0x49, 0x6e, 0x73, 0x74, 0x61, 0x6c, 0x6c, 0x65, 0x64, 0x28, 0x20, 0x36, 0x64, 0x65, 0x62, 0x62, 0x38, 0x31, 0x32, 0x61, 0x62, 0x65, 0x65, 0x32, 0x30, 0x37, 0x64, 0x62, 0x33, 0x35, 0x34, 0x62, 0x34, 0x63, 0x30, 0x31, 0x64, 0x63, 0x35, 0x63, 0x66, 0x66, 0x34, 0x18, 0x1d, 0x41, 0x4e, 0x44, 0x52, 0x4f, 0x49, 0x44, 0x09, 0x31, 0x34, 0x2e, 0x32, 0x31, 0x2e, 0x31, 0x09, 0x41, 0x6e, 0x64, 0x72, 0x6f, 0x69, 0x64, 0x20, 0x4f, 0x53, 0x09, 0x31, 0x32, 0x00};
//        String result = new String(byteArray);
//        System.out.println(result);
//        OkhttpUtils.doPost(urlEntity.getUrl_4(), headerEntity.getHeader_4(), bodyEntity.getBody_4());
//
//        System.out.println("结束");

//        bodyEntity.getBody_4();
    }


}