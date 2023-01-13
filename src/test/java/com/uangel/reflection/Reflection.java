package com.uangel.reflection;


import com.google.gson.JsonElement;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import com.uangel.protobuf.Message;
import model.msg.FieldInfo;
import model.msg.MsgInfo;
import scenario.phases.SendPhase;
import util.JsonUtil;
import util.ReflectionUtil;
import util.StringUtil;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dajin kim
 */
public class Reflection {

    private URLClassLoader classLoader;
    private static final String PKG_BASE = "com.uangel.protobuf.";
    private static final String PKG_PATH_HEADER = PKG_BASE + "Header";
    private static final String PKG_PATH_BODY = PKG_BASE + "CallCloseReq";
    private static final String PKG_PATH_MESSAGE = PKG_BASE + "Message";

    public Reflection() {
    }

    /**
     * @fn loadJarFile
     * @brief load Jar File
     * @param jarFilePath jar 파일 경로
     * */
    public void loadJarFile(String jarFilePath) {
        File jarFile = new File(jarFilePath);

        try {
            URL classURL = new URL("jar:" + jarFile.toURI().toURL() + "!/");
            classLoader = new URLClassLoader(new URL[]{classURL});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @fn getClass
     * @brief load Class Type from jar
     * @param name 클래스 이름
     * */
    public Class<?> getClass(String name) {
        try {
            return classLoader.loadClass(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @fn getClassObject
     * @brief load Class from jar & Create Object
     * @param name 객체를 생성할 클래스 이름
     * */
    public Object getClassObject(String name) {
        try {
            Class<?> c = classLoader.loadClass(name);
            Constructor<?> constructor = c.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @fn invokeMethod
     * @brief invoke method without Parameter
     * @param methodName 실행할 메서드 이름
     * @param obj 메서드가 있는 클래스 인스턴스
     *            클래스를 "new"로 생성하거나, "newInstance()"로 생성된 Object
     * */
    public Object invokeMethod(String methodName, Object obj) {
        try {
            // 매개 변수 없는 메소드 호출 및 실행
            Method method = obj.getClass().getMethod(methodName);
            return method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Object invokeMethod(String className, String methodName) {
        Object obj = getClassObject(className);
        return invokeMethod(methodName, obj);
    }

    /**
     * @fn invokeMethodWparam
     * @brief invoke method with Parameter
     * @param methodName 실행할 메서드 이름
     * @param obj 메서드가 있는 클래스의 객체
     * @param parameter 메서드 실행에 필요한 매개 변수
     * @param paramType 매개 변수의 타입
     * */
    private Object invokeMethodWparam(String methodName, Object obj, Object parameter, Class<?> paramType) {
        try {
            // paramType 매개 변수 있는 methodName 이름의 메소드 호출
            Method method = obj.getClass().getMethod(methodName, paramType);
            // 호출한 메소드 실행 with parameter
            return method.invoke(obj, parameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @fn invokeStrMethod
     * @brief invoke method with String Parameter
     * @param methodName 실행할 메서드 이름
     * @param obj 메서드가 있는 클래스의 객체
     * @param parameter 메서드 실행에 필요한 String 타입 매개 변수
     * */
    public Object invokeStrMethod(String methodName, Object obj, String parameter) {
        // String 타입의 매개 변수 있는 methodName 이름의 메소드 호출, 실행
        return invokeMethodWparam(methodName, obj, parameter, String.class);
    }

    /**
     * @fn invokeIntMethod
     * @brief invoke method with int Parameter
     * @param methodName 실행할 메서드 이름
     * @param obj 메서드가 있는 클래스의 객체
     * @param parameter 메서드 실행에 필요한 int 타입 매개 변수
     * */
    public Object invokeIntMethod(String methodName, Object obj, int parameter) {
        // int 타입의 매개 변수 있는 methodName 이름의 메소드 호출
        // 호출한 메소드 실행 with int parameter
        return invokeMethodWparam(methodName, obj, parameter, int.class);
    }

    public Object invokeLongMethod(String methodName, Object obj, long parameter) {
        return invokeMethodWparam(methodName, obj, parameter, long.class);
    }

    public Object invokeBoolMethod(String methodName, Object obj, boolean parameter) {
        return invokeMethodWparam(methodName, obj, parameter, boolean.class);
    }

    /**
     * @fn invokeByteMethod
     * @brief invoke method with Byte Array Parameter
     * @param className 메서드가 있는 클래스 이름
     * @param methodName 실행할 메서드 이름
     * @param parameter 메서드 실행에 필요한 Byte Array 타입(Object 로 전달) 매개 변수
     * */
    public Object invokeByteMethod(String className, String methodName, Object parameter) {
        Object obj = getClassObject(className);
        // byte[] 타입의 매개 변수 있는 methodName 이름의 메소드 호출
        return invokeMethodWparam(methodName, obj, parameter, byte[].class);
    }

    /**
     * @fn invokeObjMethod
     * @brief invoke method with Object Parameter
     * @param methodName 실행할 메서드 이름
     * @param obj 메서드가 있는 클래스의 객체
     * @param parameter 메서드 실행에 필요한 Object 타입 매개 변수
     * */
    public Object invokeObjMethod(String methodName, Object obj, Object parameter) {
        // parameter.class 타입의 매개 변수 있는 methodName 이름의 메소드 호출
        // 호출한 메소드 실행 with object parameter
        return invokeMethodWparam(methodName, obj, parameter, parameter.getClass());
    }


    public Object getNewBuilder(String className) {
        return invokeMethod(className, "newBuilder");
    }

    public byte[] toByteArray(Object msgObj) {
        Object msgByteObj = invokeMethod("toByteArray", msgObj);
        byte[] msgByteArr = (byte[]) msgByteObj;
        System.out.println("toByteArray : \r\n" + msgByteArr);
        return msgByteArr;
    }

    public Object build(Object builderObj) {
        return invokeMethod("build", builderObj);
    }

    public Object parseFrom(String className, byte[] bytes) {
        return invokeByteMethod(className, "parseFrom", bytes);
    }

    public String getMethodName(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    public String getJsonElementName(String className) {
        return className.substring(0, 1).toLowerCase() + className.substring(1);
    }

    public String getExecResult(String execCmd) throws Exception {
        if (StringUtil.isNull(execCmd))
            return null;

        ReflectionUtil.TypeValuePair typeValuePair = ReflectionUtil.exec(execCmd);
        if (typeValuePair == null || typeValuePair.value == null)
            return null;

        return typeValuePair.value.toString();
    }

    /**
     * Create Message
     * */
    public void process() {
        if (classLoader == null) return;

        try {
            // get Header.Builder
            Object hBuilder = getNewBuilder(PKG_PATH_HEADER);

            // set Header
            hBuilder = invokeObjMethod("setType", hBuilder, "CALL_CLOSER_REQ");

            String value = getExecResult("java.util.UUID.randomUUID().toString()");
            hBuilder = invokeObjMethod("setTId", hBuilder, value);

            hBuilder = invokeObjMethod("setMsgFrom", hBuilder, "AI_AIWF");
            hBuilder = invokeObjMethod("setReason", hBuilder, "success");
            hBuilder = invokeIntMethod("setReasonCode", hBuilder, 200);

            value = getExecResult("java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm:ss.SSS\"))");
            hBuilder = invokeObjMethod("setTimestamp", hBuilder, value);

            // Build Header
            Object hMsgResult = build(hBuilder);

            System.out.println("Header Builder Class : " + hBuilder.getClass());
            System.out.println("Header Msg Result Class : " + hMsgResult.getClass());
            System.out.println("Header Msg Result : \r\n" + hMsgResult);

            System.out.println("===========================================================");

            // get Body.Builder
            Object bBuilder = getNewBuilder(PKG_PATH_BODY);

            // set Body
            bBuilder = invokeObjMethod("setCallId", bBuilder, "testCallId");

            // Build Body
            Object bMsgResult = build(bBuilder);

            System.out.println("Body Builder Class : " + bBuilder.getClass());
            System.out.println("Body Msg Result Class : " + bMsgResult.getClass());
            System.out.println("Body Msg Result : \r\n" + bMsgResult);

            System.out.println("===========================================================");

            // get Message.Builder
            Object msgBuilder = getNewBuilder(PKG_PATH_MESSAGE);

            // set Header
            msgBuilder = invokeObjMethod("setHeader", msgBuilder, hMsgResult);
            // set Body
            msgBuilder = invokeObjMethod("setCallCloseReq", msgBuilder, bMsgResult);

            // Build Message
            Object msgResult = build(msgBuilder);

            System.out.println("Message Builder Class : " + msgBuilder.getClass());
            System.out.println("Message Result Class : " + msgResult.getClass());
            System.out.println("Message Result : \r\n" + msgResult);

            System.out.println("===========================================================");
            // 1. Object(Message) -> ByteArray -> 전송
            byte[] msgByteArr = toByteArray(msgResult);

            // 2. ByteArray -> Message
            // 2-1. Byte Array Reflection (메시지 받았을 때 파싱)
            //Object obj = msgByteArr;        // msgByteObj.equals(obj) : true
            Object o = parseFrom(PKG_PATH_MESSAGE, msgByteArr);
            System.out.println("ByteToObject : \r\n" + o);
            String json = buildProto(o);
            System.out.println("PrettyJson : \r\n" + json);
            String callId = JsonUtil.json2String(json, "callCloseReq", "callId").orElse("");
            System.out.println("JsonUtil Result : " + callId);

            // 2-2. ProtoBuf Class Method (메시지 받은 쪽에서 파싱 잘 되는지 확인)
            Message msg = Message.parseFrom(msgByteArr);
            System.out.println("Message.ParseFrom Result : \r\n" + msg);

            System.out.println(Message.MLOGINREQ_FIELD_NUMBER);
            System.out.println("===========================================================");

            // Test Field/Method
            //System.out.println("Header Class Fields : " + getFieldNames(headerObj.getClass().getDeclaredFields()));
            //System.out.println("Message Class Fields : " + getFieldNames(msgObj.getClass().getDeclaredFields()));

            //System.out.println("Header Class Methods : " + getMethodNames(headerObj.getClass().getDeclaredMethods()));
            //System.out.println("Message Class Methods : " + getMethodNames(msgObj.getClass().getMethods()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getFieldNames(Field[] fields) {
        return Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());
    }

    public List<String> getMethodNames(Method[] methods) {
        return Arrays.stream(methods).map(Method::getName).collect(Collectors.toList());
    }

    public byte[] createSendMsg(SendPhase sendPhase, String pkgBase) {
        try {
            if (!pkgBase.endsWith(".")) {
                pkgBase += ".";
            }

            // get Builder
            String msgClassName = pkgBase + sendPhase.getClassName();
            Object msgBuilder = getNewBuilder(msgClassName);

            // set subMessages
            for (MsgInfo msgInfo : sendPhase.getMsgInfos()) {
                Object subMsgObj = getSubMessage(msgInfo, pkgBase);
                if (subMsgObj == null) continue;
                msgBuilder = invokeObjMethod(getMethodName(msgInfo.getClassName()), msgBuilder, subMsgObj);
            }

            // Build Message
            Object msgResult = build(msgBuilder);
            System.out.println("Result : \r\n" + msgResult);
            // send msg by RabbitMQ Server
            byte[] msgByteArr = toByteArray(msgResult);

            // 메시지 받았다고 가정하고 처리
            processRecvMsg(msgByteArr, sendPhase, pkgBase);

            return msgByteArr;
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void processRecvMsg(byte[] msg, SendPhase sendPhase, String pkgBase) throws InvalidProtocolBufferException {

        if (!pkgBase.endsWith(".")) {
            pkgBase += ".";
        }
        String className = pkgBase + sendPhase.getClassName();

        // 1. Byte -> Object
        Object msgObj = parseFrom(className, msg);
        System.out.println("ByteToObject : \r\n" + msgObj);

        // 2. Object -> Pretty Json
        String json = buildProto(msgObj);
        System.out.println("PrettyJson : \r\n" + json);

        // 3. Parse KeyWord
        String keyWord = "callId";
        String callId = parseKeyWord(sendPhase.getMsgInfos(), json, keyWord);
        System.out.println("JsonUtil Result : " + callId);

    }

    public String parseKeyWord(List<MsgInfo> msgInfos, String json, String keyWord) {
        String value = null;
        for (MsgInfo msgInfo : msgInfos) {
            String elementName = getJsonElementName(msgInfo.getClassName());
            value = JsonUtil.json2String(json, elementName, keyWord).orElse("");
            System.out.println("ElementName : " + elementName + ", value : " + value);
            if (StringUtil.notNull(value)) break;
        }
        return value;
    }

    public Object getSubMessage(MsgInfo msgInfo, String pkgBase) {

        try {
            Object builder = getNewBuilder(pkgBase + msgInfo.getClassName());

            List<FieldInfo> fieldInfos = msgInfo.getFieldInfos();

            for (FieldInfo fieldInfo : fieldInfos) {
                String methodName = getMethodName(fieldInfo.getName());
                String type = fieldInfo.getType();
                String value = fieldInfo.getValue();

                if (type.equals("int")) {
                    builder = invokeIntMethod(methodName, builder, Integer.parseInt(value));

                } else {
                    if (StringUtil.isNull(value)) {
                        String exec = fieldInfo.getExec();
                        value = getExecResult(exec);
                        if (value == null) continue;
                    }
                    builder = invokeObjMethod(methodName, builder, value);
                }
            }

            return build(builder);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Object -> JSON
    public static String buildProto(Object obj) throws InvalidProtocolBufferException {
        return JsonFormat.printer().includingDefaultValueFields().print((MessageOrBuilder) obj);
    }


}
