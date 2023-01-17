package com.uangel.json;

import model.msg.FieldInfo;
import model.msg.MsgInfo;
import org.junit.Test;
import scenario.phases.SendPhase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dajin kim
 */
public class TestJson {

    @Test
    public void createJsonMsgTest() throws Exception {
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.createJsonMsg(createSendPhase());
    }

    public static SendPhase createSendPhase() {
        SendPhase sendPhase = new SendPhase();
        sendPhase.setClassName("Message");

        List<MsgInfo> msgInfos = new ArrayList<>();

        // Header
        MsgInfo headerMsg = new MsgInfo();
        headerMsg.setClassName("header");
        // Header Fields
        List<FieldInfo> hFieldInfos = new ArrayList<>();
        hFieldInfos.add(new FieldInfo("type", "str", "MEDIA_START_RES", ""));
        hFieldInfos.add(new FieldInfo("tId", "str", "[tId]", ""));
        hFieldInfos.add(new FieldInfo("msgFrom", "str", "AI_AIWF", ""));
        hFieldInfos.add(new FieldInfo("reasonCode", "int", "200", ""));
        hFieldInfos.add(new FieldInfo("reason", "str", "success", ""));
        hFieldInfos.add(new FieldInfo("timestamp", "str", "[timestamp]", ""));
        headerMsg.setFieldInfos(hFieldInfos);

        // Body (MediaStartRes)
        MsgInfo bodyMsg = new MsgInfo();
        bodyMsg.setClassName("body");
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
