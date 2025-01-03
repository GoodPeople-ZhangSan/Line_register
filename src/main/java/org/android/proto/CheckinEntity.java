package org.android.proto;

import com.google.protobuf.Int32Value;
import org.android.line.ArgUtils;
import org.android.line.DevicesEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckinEntity {
    // 构造主protobuf文件
    public static byte[] getCheckBodyProto(DevicesEntity devicesEntity) {
        // 构造一个 A11
        CheckinBodyProto.A11.Builder a11 = CheckinBodyProto.A11.newBuilder();

        // 构造 A4
        CheckinBodyProto.A4.Builder a4 = getProtoA4(devicesEntity);

        // 构造 A18
        CheckinBodyProto.A18.Builder a18 = getProtoA18();

        // 构造主 proto
        CheckinBodyProto.Checkin.Builder checkinBuild = CheckinBodyProto.Checkin.newBuilder();
        checkinBuild.setA2(0)
                .setA3("1-da39a3ee5e6b4b0d3255bfef95601890afd80709")
                .setA4(a4)
                .setA6("zh-Hans-CN")
                .setA9("null")
                .setA10(devicesEntity.getIMEI())
                .setA11(a11)
                .setA12("Asia/Shanghai")
                .setA13(0)
                .setA14(3)
                .setA15("null")
                .setA16(devicesEntity.getAdbDevices())
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

    // 构造主proto 中的 A4
    private static CheckinBodyProto.A4.Builder getProtoA4(DevicesEntity devicesEntity) {
        // 构造 A4 中所需的 B1
        CheckinBodyProto.B1.Builder b1 = getProtoB1(devicesEntity);

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

    // 构造 A4 中的 B1
    private static CheckinBodyProto.B1.Builder getProtoB1(DevicesEntity devicesEntity) {
        // 构造B1中的 C15
        CheckinBodyProto.C15 c15builder_1 = CheckinBodyProto.C15.newBuilder().setD1(1).setD2("android-google").build();
        CheckinBodyProto.C15 c15builder_2 = CheckinBodyProto.C15.newBuilder().setD1(2).setD2("ms-android-google").build();
        CheckinBodyProto.C15 c15builder_3 = CheckinBodyProto.C15.newBuilder().setD1(3).setD2("ms-android-google").build();
        CheckinBodyProto.C15 c15builder_4 = CheckinBodyProto.C15.newBuilder().setD1(4).setD2("gmm-android-google").build();
        CheckinBodyProto.C15 c15builder_5 = CheckinBodyProto.C15.newBuilder().setD1(5).setD2("mvapp-android-google").build();
        CheckinBodyProto.C15 c15builder_6 = CheckinBodyProto.C15.newBuilder().setD1(6).setD2("am-android-google").build();
        CheckinBodyProto.C15 c15builder_9 = CheckinBodyProto.C15.newBuilder().setD1(9).setD2("ms-android-google").build();
        CheckinBodyProto.C15 c15builder_10 = CheckinBodyProto.C15.newBuilder().setD1(10).setD2("play-ms-android-google").build();
        CheckinBodyProto.C15 c15builder_11 = CheckinBodyProto.C15.newBuilder().setD1(11).setD2("play-ad-ms-android-google").build();
        CheckinBodyProto.C15 c15builder_12 = CheckinBodyProto.C15.newBuilder().setD1(12).setD2("pg-android-google").build();

        // 设置 C15 字段的值  repeated
        List<CheckinBodyProto.C15> c15 = new ArrayList<>();
        c15.add(c15builder_1);
        c15.add(c15builder_2);
        c15.add(c15builder_3);
        c15.add(c15builder_4);
        c15.add(c15builder_5);
        c15.add(c15builder_6);
        c15.add(c15builder_9);
        c15.add(c15builder_10);
        c15.add(c15builder_11);
        c15.add(c15builder_12);

        // 构造B1
        CheckinBodyProto.B1.Builder b1builder = CheckinBodyProto.B1.newBuilder();
        b1builder.setC1(devicesEntity.proto_4_1_1)
                .setC2("redfin")
                .setC3("google")
                .setC4(devicesEntity.proto_4_1_4)
                .setC5(devicesEntity.proto_4_1_5)
                .setC6("android-google")
                .setC7((int) (System.currentTimeMillis() / 1000) - 10000)
                .setC8(devicesEntity.proto_4_1_8)
                .setC9("redfin")
                .setC10(32)
                .setC11(devicesEntity.iPhoneMode)
                .setC12("Google")
                .setC13("redfin")
                .setC14(0)
                .addAllC15(c15)
                .setC19(devicesEntity.proto_4_1_19).build();

        // 返回 B1
        return b1builder;
    }

    private static CheckinBodyProto.A18.Builder getProtoA18() {
        //
        // 构造A18中所需的G11,使用 Arrays.asList 赋值多个字符串
        List<String> stringsG9 = Arrays.asList("string1", "string2", "string3");
        List<String> stringsG10 = Arrays.asList("string1", "string2", "string3");
        List<String> stringsG11 = Arrays.asList("arm64-v8a", "armeabi-v7a", "armeabi");
        List<String> stringsG14 = Arrays.asList("string1", "string2", "string3");
        List<String> stringsG15 = Arrays.asList("string1", "string2", "string3");

        // 构造A18中所需的G26
        CheckinBodyProto.G26.Builder g26builder = CheckinBodyProto.G26.newBuilder();


        // 构造主A18
        CheckinBodyProto.A18.Builder a18builder = CheckinBodyProto.A18.newBuilder();
        a18builder.setG1(3)
                .setG2(1)
                .setG3(1)
                .setG4(2)
                .setG5(0)
                .setG6(0)
                .setG7(440)
                .setG8(196610)
                .addAllG9(stringsG9)
                .addAllG10(stringsG10)
                .addAllG11(stringsG11)
                .setG12(1080)
                .setG13(2340)
                .addAllG14(stringsG14)
                .addAllG15(stringsG15)
                .setG18(392)
                .setG19(0)
                .setG20(0)
                .setG21(8)
                .addG26(g26builder)
                .setG28(0)
                .setG29("G5NZ6")
                .setG30(2)
                .build();

        return a18builder;
    }
}
