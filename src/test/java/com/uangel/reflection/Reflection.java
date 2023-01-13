package com.uangel.reflection;


import com.uangel.protobuf.Message;
import util.ReflectionUtil;

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

    public Reflection() {
    }

    /**
     * @fn loadJarFile
     *
     *
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
     * @fn getClassObject
     *
     *
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
     * @param c 메서드가 있는 클래스
     * @param methodName 실행할 메서드 이름
     * @param obj 메서드가 있는 클래스 인스턴스
     *            클래스를 "new"로 생성하거나, "newInstance()"로 생성된 Object
     * */
    public Object invokeMethod(Class<?> c, String methodName, Object obj) {
        try {
            // 매개 변수 없는 메소드 호출 및 실행
            Method method = c.getMethod(methodName);
            return method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Object invokeMethod(String methodName, Object obj) {
        return invokeMethod(obj.getClass(), methodName, obj);
    }
    public Object invokeMethod(String className, String methodName) {
        Object obj = getClassObject(className);
        return invokeMethod(obj.getClass(), methodName, obj);
    }

    private Object invokeMethodWparam(Class<?> c, String methodName, Object obj, Object parameter, Class<?> paramType) {
        try {
            // paramType 매개 변수 있는 methodName 이름의 메소드 호출
            Method method = c.getMethod(methodName, paramType);
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
     * @param c 메서드가 있는 클래스
     * @param methodName 실행할 메서드 이름
     * @param obj 메서드가 있는 클래스의 객체
     * @param parameter 메서드 실행에 필요한 String 타입 매개 변수
     * */
    public Object invokeStrMethod(Class<?> c, String methodName, Object obj, String parameter) {
        // String 타입의 매개 변수 있는 methodName 이름의 메소드 호출, 실행
        return invokeMethodWparam(c, methodName, obj, parameter, String.class);
    }
    public Object invokeStrMethod(String methodName, Object obj, String parameter) {
        return invokeMethodWparam(obj.getClass(), methodName, obj, parameter, String.class);
    }

    /**
     * @fn invokeIntMethod
     * @brief invoke method with int Parameter
     * @param c 메서드가 있는 클래스
     * @param methodName 실행할 메서드 이름
     * @param obj 메서드가 있는 클래스의 객체
     * @param parameter 메서드 실행에 필요한 int 타입 매개 변수
     * */
    public Object invokeIntMethod(Class<?> c, String methodName, Object obj, int parameter) {
        // int 타입의 매개 변수 있는 methodName 이름의 메소드 호출
        // 호출한 메소드 실행 with int parameter
        return invokeMethodWparam(c, methodName, obj, parameter, int.class);
    }
    public Object invokeIntMethod(String methodName, Object obj, int parameter) {
        return invokeMethodWparam(obj.getClass(), methodName, obj, parameter, int.class);
    }

    /**
     * @fn invokeByteMethod
     * @brief invoke method with Byte Array Parameter
     * @param c 메서드가 있는 클래스
     * @param methodName 실행할 메서드 이름
     * @param obj 메서드가 있는 클래스의 객체
     * @param parameter 메서드 실행에 필요한 Byte Array 타입(Object 로 전달) 매개 변수
     * */
    public Object invokeByteMethod(Class<?> c, String methodName, Object obj, Object parameter) {
        // byte[] 타입의 매개 변수 있는 methodName 이름의 메소드 호출
        return invokeMethodWparam(c, methodName, obj, parameter, byte[].class);

    }
    public Object invokeByteMethod(String className, String methodName, Object parameter) {
        Object obj = getClassObject(className);
        return invokeMethodWparam(obj.getClass(), methodName, obj, parameter, byte[].class);
    }

    /**
     * @fn invokeObjMethod
     * @brief invoke method with Object Parameter
     * @param c 메서드가 있는 클래스
     * @param methodName 실행할 메서드 이름
     * @param obj 메서드가 있는 클래스의 객체
     * @param parameter 메서드 실행에 필요한 Object 타입 매개 변수
     * */
    public Object invokeObjMethod(Class<?> c, String methodName, Object obj, Object parameter) {
        // parameter.class 타입의 매개 변수 있는 methodName 이름의 메소드 호출
        // 호출한 메소드 실행 with object parameter
        return invokeMethodWparam(c, methodName, obj, parameter, parameter.getClass());
    }
    public Object invokeObjMethod(String methodName, Object obj, Object parameter) {
        return invokeMethodWparam(obj.getClass(), methodName, obj, parameter, parameter.getClass());
    }

    /**
     * Create Message
     * */
    public void process() {
        if (classLoader == null) return;

        try {
            // get Header.Builder
            Object hBuilderObj = invokeMethod("com.uangel.protobuf.Header", "newBuilder");

            // set Header
            hBuilderObj = invokeStrMethod("setType", hBuilderObj, "CALL_CLOSER_REQ");

            String execCmd = "java.util.UUID.randomUUID().toString()";
            String value = ReflectionUtil.exec(execCmd).value.toString();
            hBuilderObj = invokeStrMethod("setTId", hBuilderObj, value);

            hBuilderObj = invokeStrMethod("setMsgFrom", hBuilderObj, "AI_AIWF");
            hBuilderObj = invokeStrMethod("setReason", hBuilderObj, "success");
            hBuilderObj = invokeIntMethod("setReasonCode", hBuilderObj, 200);

            execCmd = "java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm:ss.SSS\"))";
            value = ReflectionUtil.exec(execCmd).value.toString();
            hBuilderObj = invokeStrMethod("setTimestamp", hBuilderObj, value);

            // Build Header
            Object hBuildResultObj = invokeMethod("build", hBuilderObj);

            System.out.println("Header Builder Class : " + hBuilderObj.getClass());
            System.out.println("Header Build Result Class : " + hBuildResultObj.getClass());
            System.out.println("Header Object : \r\n" + hBuildResultObj);

            System.out.println("===========================================================");

            // get Body.Builder
            Object bBuilderObj = invokeMethod("com.uangel.protobuf.CallCloseReq", "newBuilder");

            // set Body
            bBuilderObj = invokeStrMethod("setCallId", bBuilderObj, "testCallId");

            // Build Body
            Object bBuildResultObj = invokeMethod("build", bBuilderObj);

            System.out.println("Body Builder Class : " + bBuilderObj.getClass());
            System.out.println("Body Build Result Class : " + bBuildResultObj.getClass());
            System.out.println("Body Object : \r\n" + bBuildResultObj);

            System.out.println("===========================================================");

            // get Message.Builder
            Object msgBuilderObj = invokeMethod("com.uangel.protobuf.Message", "newBuilder");

            // set Header
            msgBuilderObj = invokeObjMethod("setHeader", msgBuilderObj, hBuildResultObj);
            // set Body
            msgBuilderObj = invokeObjMethod("setCallCloseReq", msgBuilderObj, bBuildResultObj);

            // Build Message
            Object msgBuildResultObj = invokeMethod("build", msgBuilderObj);

            System.out.println("Message Builder Class : " + msgBuilderObj.getClass());
            System.out.println("Message Build Result Class : " + msgBuildResultObj.getClass());
            System.out.println("Message Object : \r\n" + msgBuildResultObj);

            System.out.println("===========================================================");
            // 1. Object(Message) -> ByteArray -> 전송
            Object msgByteObj = invokeMethod("toByteArray", msgBuildResultObj);
            byte[] msgByteArr = (byte[]) msgByteObj;
            System.out.println("msgByteArr : \r\n" + msgByteArr);
            System.out.println("newString : \r\n" + new String(msgByteArr));

            // 2. ByteArray -> Message
            // 2-1. Byte Array Reflection (메시지 받았을 때 파싱)
            //Object obj = msgByteArr;        // msgByteObj.equals(obj) : true
            Object o = invokeByteMethod("com.uangel.protobuf.Message", "parseFrom", msgByteArr);
            System.out.println("ByteToObject : \r\n" + o);
            // 2-2. Reflection
            //Object m = invokeByteMethod("parseFrom", msgBuildResultObj, msgByteObj);
            //System.out.println("Reflection ParseFrom Result : \r\n" + m);
            // 2-3. ProtoBuf Class Method (메시지 받은 쪽에서 파싱 잘 되는지 확인)
            Message msg = Message.parseFrom(msgByteArr);
            System.out.println("Message.ParseFrom Result : \r\n" + msg);

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



}
