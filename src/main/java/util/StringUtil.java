package util;

/**
 * @author dajin kim
 */
public class StringUtil {

    private StringUtil() {
        // nothing
    }

    public static String parseValue(String value) {
        int targetNum = value.indexOf('"');
        int endNum =value.lastIndexOf('"');
        value = value.substring(targetNum + 1, endNum);
        return value;
    }

    public static boolean isNull(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean notNull(String str) {
        return str != null && !str.isEmpty();
    }

}
