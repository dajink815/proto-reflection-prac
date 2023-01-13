package util;

import model.file.ProtoFileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author dajin kim
 */
public class FileUtil {
    static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    private static final String JAVA_PACKAGE = "java_package";
    private static final String JAVA_CLASS_NAME = "java_outer_classname";

    private FileUtil() {
        // nothing
    }

    public static ProtoFileInfo readFile(String fileDir, String fileName) {
        ProtoFileInfo protoFileInfo = new ProtoFileInfo();
        protoFileInfo.setFileName(fileName);        // "RmqMessage.proto"
        try (BufferedReader br = new BufferedReader(new FileReader(fileDir + fileName))) {
            String strLine;
            int index = 1;
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains(JAVA_PACKAGE)) {
                    log.debug("{} Found [{}]", JAVA_PACKAGE, index);
                    protoFileInfo.setJavaPackage(StringUtil.parseValue(strLine));
                }
                if (strLine.contains(JAVA_CLASS_NAME)) {
                    log.debug("{} Found [{}]", JAVA_CLASS_NAME, index);
                    protoFileInfo.setJavaClassName(StringUtil.parseValue(strLine));
                }

                if (protoFileInfo.isFinished()) {
                    log.debug("Finished [{}]", index);
                    return protoFileInfo;
                }
                index++;
            }
        } catch (Exception e) {
            log.error("FileUtil.readFile Error", e);
        }
        return protoFileInfo;
    }


    public static boolean isFileExist(String filePathName) {
        File file = new File(filePathName);
        return file.exists();
    }

    public static void writeFile(String fileName, String data, boolean append) {
        File file = new File(fileName);
        try(FileWriter fw = new FileWriter(file, append)) {
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            log.error("FileUtil.writeFile Error", e);
        }
    }

/*    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                sb.append(strLine);
                sb.append("\r\n");
            }
        } catch (Exception e) {
            log.error("FileUtil.readFile Error", e);
        }
        return sb.toString();
    }*/
}
