package scenario.phases;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.msg.MsgInfo;

import java.util.List;

/**
 * @author dajin kim
 */
@Getter
@Setter
@ToString
public class SendPhase extends MsgPhase {
    private String className;
    private List<MsgInfo> msgInfos;
}
