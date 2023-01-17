package com.uangel.json;

import com.uangel.keyword.TestKeywordMapper;
import model.msg.FieldInfo;
import model.msg.MsgInfo;
import org.json.simple.JSONObject;
import scenario.phases.SendPhase;
import util.ProtoUtil;
import util.ReflectionUtil;
import util.StringUtil;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author dajin kim
 */
public class JsonBuilder {

    public void createJsonMsg(SendPhase sendPhase) throws Exception {
        JSONObject msg = new JSONObject();
        for (MsgInfo msgInfo : sendPhase.getMsgInfos()) {
            JSONObject data = getSubMessage(msgInfo);
            msg.put(msgInfo.getClassName(), data);
        }

        System.out.println("Pretty Json : \r\n" + ProtoUtil.buildPretty(msg));

        // Send Bytes
        String json = msg.toJSONString();
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
        System.out.println("Byte Array : " + bytes);

        json = ProtoUtil.buildPretty(new String(bytes));
        System.out.println("Byte to String : \r\n" + json);

        // Parse Fields


    }

    public JSONObject getSubMessage(MsgInfo msgInfo) throws Exception {
        JSONObject data = new JSONObject();

        List<FieldInfo> fieldInfos = msgInfo.getFieldInfos();
        for (FieldInfo fieldInfo : fieldInfos) {
            String name = fieldInfo.getName();
            String type = fieldInfo.getType();
            String value = fieldInfo.getValue();

            if (type.equals("int")) {
                data.put(name, Integer.parseInt(value));
            } else {
                if (StringUtil.isNull(value)) {
                    String exec = fieldInfo.getExec();
                    value = getExecResult(exec);
                    if (value == null) continue;
                }
                TestKeywordMapper keywordMapper = new TestKeywordMapper();
                value = keywordMapper.replaceKeyword(value);
                data.put(name, value);
            }

        }
        return data;
    }

    public String getExecResult(String execCmd) throws Exception {
        if (StringUtil.isNull(execCmd))
            return null;

        ReflectionUtil.TypeValuePair typeValuePair = ReflectionUtil.exec(execCmd);
        if (typeValuePair == null || typeValuePair.value == null)
            return null;

        return typeValuePair.value.toString();
    }
}
