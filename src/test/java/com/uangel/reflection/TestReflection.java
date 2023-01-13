package com.uangel.reflection;

import model.msg.FieldInfo;
import model.msg.MsgInfo;
import org.junit.Test;
import scenario.phases.SendPhase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dajin kim
 */
public class TestReflection {

    private static final String PROTO_PKG_BASE = "com.uangel.protobuf";

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
        hFieldInfos.add(new FieldInfo("type", "str", "CALL_CLOSE_REQ", ""));
        hFieldInfos.add(new FieldInfo("tId", "str", "", "java.util.UUID.randomUUID().toString()"));
        hFieldInfos.add(new FieldInfo("msgFrom", "str", "AI_AIWF", ""));
        hFieldInfos.add(new FieldInfo("reasonCode", "int", "200", ""));
        hFieldInfos.add(new FieldInfo("reason", "str", "success", ""));
        hFieldInfos.add(new FieldInfo("timestamp", "str", "", "java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm:ss.SSS\"))"));
        headerMsg.setFieldInfos(hFieldInfos);

        // Body (CallCloseReq)
        MsgInfo bodyMsg = new MsgInfo();
        bodyMsg.setClassName("CallCloseReq");
        // Body Fields
        List<FieldInfo> bFieldInfos = new ArrayList<>();
        bFieldInfos.add(new FieldInfo("callId", "str", "testCallId", ""));
        bodyMsg.setFieldInfos(bFieldInfos);

        msgInfos.add(headerMsg);
        msgInfos.add(bodyMsg);
        sendPhase.setMsgInfos(msgInfos);

        return sendPhase;
    }

}
