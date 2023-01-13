package model.msg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author dajin kim
 */
@Getter
@Setter
@ToString
public class MsgInfo {
    private String className;
    private List<FieldInfo> fieldInfos;

}
