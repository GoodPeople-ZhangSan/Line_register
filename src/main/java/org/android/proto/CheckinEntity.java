package org.android.proto;

import com.google.protobuf.Int32Value;
import org.android.line.ArgUtils;
import org.android.line.DevicesEntity;

import java.util.Arrays;

public class CheckinEntity {
    public static byte[] getCheckBodyProto(DevicesEntity devicesEntity) {
        // 构造一个空的 A11
        CheckinBodyProto.A11.Builder a11 = CheckinBodyProto.A11.newBuilder();

        // 构造 B4
        CheckinBodyProto.A4.Builder a4 = getProtoA4(devicesEntity);

        CheckinBodyProto.A18.Builder a18 = CheckinBodyProto.A18.newBuilder();

        // 构造主 proto
        CheckinBodyProto.Checkin.Builder checkinBuild = CheckinBodyProto.Checkin.newBuilder();
        checkinBuild.setA2(0)
                .setA3("1-da39a3ee5e6b4b0d3255bfef95601890afd80709")
                .setA4(a4)
                .setA6("zh-Hans-CN")
                .setA9("null")
                .setA10("null")
                .setA11(a11)
                .setA12("Asia/Shanghai")
                .setA13(0)
                .setA14(3)
                .setA15("null")
                .setA16("null")
                .setA18(a18)
                .setA19("wifi")
                .setA20(0)
                .setA22(0)
                .setA24("null")
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
        System.out.println("CheckinBody-protobuf数据hex:" + ArgUtils.bytesToHex(checkinByteArray));
        System.out.println("CheckinBody-protobuf序列化大小: " + checkinByteArray.length);
        return checkinByteArray;
    }

    private static CheckinBodyProto.A4.Builder getProtoA4(DevicesEntity devicesEntity) {
        // 构造 A4 中所需的 B1
        CheckinBodyProto.B1.Builder b1 = CheckinBodyProto.B1.newBuilder();

        // 构造 A4 中所需的 B15
        CheckinBodyProto.B15.Builder b15 = CheckinBodyProto.B15.newBuilder();
        b15.setE1(9).setE2(1)
                .setE3("com.google.android.setupwizard")
                .setE4("boa")
                .setE5(1).build();

        // 构造需要返回的 A4
        CheckinBodyProto.A4.Builder a4 = CheckinBodyProto.A4.newBuilder();
        a4.setB1(b1).setB2(0)
                .setB8("WIFI::")
                .setB9(0)
                .setB14(2)
                .setB15(b15)
                .setB18(1)
                .setB19("WIFI")
                .setB20(2).build();

        // 返回构造好的B4
        return a4;
    }
}
