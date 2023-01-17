package com.uangel.keyword;

import util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dajin kim
 */
public class TestKeywordMapper {

    public static final Pattern keyPattern = Pattern.compile("\\[(.*?)\\]");
    private final Map<String, String> execCmdMap;

    {
        execCmdMap = new HashMap<>();
        execCmdMap.put("tId", "java.util.UUID.randomUUID().toString()");
        execCmdMap.put("timestamp", "java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm:ss.SSS\"))");
    }

    public TestKeywordMapper() {
    }

    public String replaceKeyword(String keyword) throws Exception {
        Matcher m = keyPattern.matcher(keyword);
        // [] 괄호 포함되어 있을 때
        if (m.find()) {
            // 중괄호 제외한 값
            String value = m.group(1);
            // 저장된 exec 명령어
            if (execCmdMap.containsKey(value)) {
                String cmd = execCmdMap.get(value);
                // exec 명령어로 Reflection 실행
                ReflectionUtil.TypeValuePair typeValuePair = ReflectionUtil.exec(cmd);
                if (typeValuePair != null) {
                    keyword = typeValuePair.value.toString();
                }
            }
        }
        return keyword;
    }
}
