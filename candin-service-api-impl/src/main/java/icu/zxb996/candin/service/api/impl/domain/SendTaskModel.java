package icu.zxb996.candin.service.api.impl.domain;

import icu.zxb996.candin.service.api.domain.MessageParam;
import icu.zxb996.candin.support.domain.MessageTemplate;
import icu.zxb996.candin.support.pipeline.ProcessModel;
import icu.zxb996.domain.TaskInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 发送消息任务模型
 *
 * @author gavin
 * @date 2022/9/28 18:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendTaskModel implements ProcessModel {
    /**
     * 消息模板Id
     */
    private Long messageTemplateId;

    /**
     * 请求参数
     */
    private List<MessageParam> messageParamList;

    /**
     * 发送任务的信息
     */
    private List<TaskInfo> taskInfo;

    /**
     * 撤回任务的信息
     */
    private MessageTemplate messageTemplate;
}
