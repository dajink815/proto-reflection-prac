package main;


import model.file.ProtoFileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.FileUtil;
import util.ReflectionUtil;
import util.SleepUtil;
import util.StringUtil;

/**
 * @author dajin kim
 */
public class RmqMsgMain {
    static final Logger log = LoggerFactory.getLogger(RmqMsgMain.class);

    private static final String PROJ_DIR = System.getProperty("user.dir");

    private static final String BASE_DIR = "src/main/java/";
    private static final String PROTOC_PATH = "./src/main/resources/protoc-3/bin/protoc";
    private static final String PROTO_FILE_DIR = "./src/main/resources/protoc/";
    private static final String PROTO_FILE_NAME = "RmqMessage.proto";

    public static void main(String[] args) throws Exception {
        ProtoFileInfo protoFileInfo = processProto();

/*        com.uangel.rmq.message.RmqHeader header = com.uangel.rmq.message.RmqHeader.newBuilder()
                .setType("HEARTBEAT_REQ")
                .setMsgFrom("AI_AIWF")
                .setReason("success")
                .setReasonCode(0)
                .build();

        System.out.println(header);*/

        StringBuilder sb = new StringBuilder();
/*        sb.append("RmqMessage.newBuilder()");
        sb.append(".setRmqHeader()");*/

        sb.append(protoFileInfo.getJavaPackage());
        sb.append(".RmqHeader.newBuilder()");
        sb.append(".setType(\"HEARTBEAT_REQ\")");
        //sb.append(".setTransactionId(UUID.randomUUID().toString())");
        sb.append(".setMsgFrom(\"AI_AIWF\")");
        sb.append(".setReason(\"success\")");
        sb.append(".setReasonCode(0)");
        sb.append("build();");

/*        ReflectionUtil.TypeValuePair typeValuePair = ReflectionUtil.exec(sb.toString());
        System.out.println(typeValuePair.type);
        System.out.println(typeValuePair.value);*/

        SleepUtil.trySleep(5000);

        ReflectionUtil.TypeValuePair typeValuePair = ReflectionUtil.exec("com.uangel.rmq.message.RmqHeader.newBuilder()\n" +
                "                .setType(\"HEARTBEAT_REQ\")\n" +
                "                .setMsgFrom(\"AI_AIWF\")\n" +
                "                .setReason(\"success\")\n" +
                "                .setReasonCode(0)\n" +
                "                .build()");
        System.out.println(typeValuePair.type);
        System.out.println(typeValuePair.value);
    }

    public static ProtoFileInfo processProto() {
        log.debug(PROJ_DIR);
        String protoPath = PROTO_FILE_DIR + PROTO_FILE_NAME;

        ProtoFileInfo protoFileInfo = FileUtil.readFile(PROTO_FILE_DIR, PROTO_FILE_NAME);
        //clearFile(protoFileInfo);
        clearDir(protoFileInfo);
        compileProtoFile(protoPath);

        return protoFileInfo;
    }

    public static void compileProtoFile(String protoFile) {
        try {
            String cmd = PROTOC_PATH + " --java_out=" + BASE_DIR + " " + protoFile;
            log.info("System Command Exec [{}]", cmd);
            Runtime.getRuntime().exec(cmd);
        } catch (Exception e) {
            log.error("Error  ", e);
        }
    }

    public static void clearFile(ProtoFileInfo info) {
        if (!info.isFinished()) {
            log.debug("ProtoFileInfo is Not Finished : {}", info);
            // package null -> proto package 사용

            if (StringUtil.isNull(info.getJavaPackage())) {

            }
            // class null -> proto file camelCase 변환 해서 사용


            return;
        } else {
            log.debug("ProtoFileInfo : {}", info);
        }

        log.debug(info.getJavaPackage());
        log.debug(info.getJavaClassName());

        String packagePath = info.getJavaPackage().replace('.', '/');
        String javaPath = BASE_DIR + packagePath + '/' + info.getJavaClassName() + ".java";
        boolean fileExist = FileUtil.isFileExist(javaPath);
        log.debug("{} File : {}", javaPath, fileExist);

        if (fileExist) {
            try {
                String cmd = "rm -f " + javaPath;
                log.info("File Removed [{}]", cmd);
                Runtime.getRuntime().exec(cmd);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void clearDir(ProtoFileInfo info) {
        if (!info.isFinished()) {
            log.debug("ProtoFileInfo is Not Finished : {}", info);
            // package null -> proto package 사용

            if (StringUtil.isNull(info.getJavaPackage())) {

            }
            // class null -> proto file camelCase 변환 해서 사용


            return;
        } else {
            log.debug("ProtoFileInfo : {}", info);
        }

        log.debug(info.getJavaPackage());
        log.debug(info.getJavaClassName());

        String packagePath = info.getJavaPackage().replace('.', '/');
        String dirPath = BASE_DIR + packagePath + '/';
        boolean fileExist = FileUtil.isFileExist(dirPath);
        log.debug("{} Dir : {}", dirPath, fileExist);

        if (fileExist) {
            try {
                String cmd = "rm -rf " + dirPath;
                log.info("Dir Removed [{}]", cmd);
                Runtime.getRuntime().exec(cmd);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }






}
