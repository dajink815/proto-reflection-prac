package com.uangel.reflection;

import model.msg.FieldInfo;
import model.msg.MsgInfo;
import org.junit.Test;
import scenario.phases.SendPhase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dajin kim
 */
public class TestReflection {

    private static final String PROTO_PKG_BASE = "com.uangel.protobuf";
    public static final Pattern keyPattern = Pattern.compile("\\[(.*?)\\]");

    @Test
    public void testJar() {
        Reflection reflection = new Reflection();
        String jarPath = "./src/main/resources/jar/aipbmsg-1.0.3.jar";
        reflection.loadJarFile(jarPath);
        reflection.process();
    }

    @Test
    public void testSendPhase() {
        SendPhase sendPhase = createSendPhase();
        System.out.println(sendPhase);

        Reflection reflection = new Reflection();
        String jarPath = "./src/main/resources/jar/aipbmsg-1.0.3.jar";
        reflection.loadJarFile(jarPath);
        reflection.createSendMsg(sendPhase, PROTO_PKG_BASE);
    }

    public static SendPhase createSendPhase() {
        SendPhase sendPhase = new SendPhase();
        sendPhase.setClassName("Message");

        List<MsgInfo> msgInfos = new ArrayList<>();

        // Header
        MsgInfo headerMsg = new MsgInfo();
        headerMsg.setClassName("Header");
        // Header Fields
        List<FieldInfo> hFieldInfos = new ArrayList<>();
        hFieldInfos.add(new FieldInfo("type", "str", "MEDIA_START_RES", ""));
        hFieldInfos.add(new FieldInfo("tId", "str", "[tId]", ""));
        hFieldInfos.add(new FieldInfo("msgFrom", "str", "AI_AIWF", ""));
        hFieldInfos.add(new FieldInfo("reasonCode", "int", "200", ""));
        hFieldInfos.add(new FieldInfo("reason", "str", "success", ""));
        hFieldInfos.add(new FieldInfo("timestamp", "str", "[timestamp]", ""));
        headerMsg.setFieldInfos(hFieldInfos);

        // Body (CallCloseReq)
        MsgInfo bodyMsg = new MsgInfo();
        bodyMsg.setClassName("MediaStartRes");
        // Body Fields
        List<FieldInfo> bFieldInfos = new ArrayList<>();
        bFieldInfos.add(new FieldInfo("callId", "str", "testCallId", ""));
        bFieldInfos.add(new FieldInfo("rtpIp", "str", "127.0.0.1", ""));
        bFieldInfos.add(new FieldInfo("rtpPort", "int", "5070", ""));
        bodyMsg.setFieldInfos(bFieldInfos);

        msgInfos.add(headerMsg);
        msgInfos.add(bodyMsg);
        sendPhase.setMsgInfos(msgInfos);

        return sendPhase;
    }

}
