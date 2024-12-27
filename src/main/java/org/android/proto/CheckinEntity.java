package org.android.proto;

import org.android.line.DevicesEntity;

import java.util.Arrays;

public class CheckinEntity {
    public static byte[] getCheckBodyProto(DevicesEntity devicesEntity) {
        // 构造主 proto
        CheckinBodyProto.Checkin.Builder checkinBuild = CheckinBodyProto.Checkin.newBuilder();
        checkinBuild
                .setA2(0)
                .setA3("1-da39a3ee5e6b4b0d3255bfef95601890afd80709")
                .setA4(null)
                .setA6("zh-Hans-CN")
                .setA9(null)
                .setA10(null)
                .setA11("空的{}")
                .setA12("Asia/Shanghai")
                .setA13(0)
                .setA14(3)
                .setA15(null)
                .setA16(null)
                .setA18(null)
                .setA19("wifi")
                .setA20(0)
                .setA22(0)
                .setA24(null)
                .setA26(0)
                .setA29(0)
                .setA30(0)
                .setA31(0)
                .build();


        //序列化
        CheckinBodyProto.Checkin checkin = checkinBuild.build();
        //转换成字节数组
        byte[] checkinByteArray = checkin.toByteArray();
        System.out.println("CheckinBody-protobuf数据bytes[]:" + Arrays.toString(checkinByteArray));
        System.out.println("CheckinBody-protobuf序列化大小: " + checkinByteArray.length);
        return checkinByteArray;
    }
}
