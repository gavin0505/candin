package icu.zxb996.candin.service.api.impl.service;

import cn.monitor4all.logRecord.annotation.OperationLog;
import icu.zxb996.candin.service.api.domain.BatchSendRequest;
import icu.zxb996.candin.service.api.domain.SendRequest;
import icu.zxb996.candin.service.api.domain.SendResponse;
import icu.zxb996.candin.service.api.impl.domain.SendTaskModel;
import icu.zxb996.candin.service.api.service.SendService;
import icu.zxb996.candin.support.pipeline.ProcessContext;
import icu.zxb996.candin.support.pipeline.ProcessController;
import icu.zxb996.common.vo.BasicResultVO;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * 发送接口
 *
 * @author gavin
 * @date 2022/9/29 17:34
 */
public class SendServiceImpl implements SendService {

    @Resource
    private ProcessController processController;

    /**
     * 执行发送信息
     *
     * @param sendRequest 发送的参数
     * @return 响应结果
     */
    @Override
    @OperationLog(bizType = "SendService#send", bizId = "#sendRequest.messageTemplateId", msg = "#sendRequest")
    public SendResponse send(SendRequest sendRequest) {
        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .messageTemplateId(sendRequest.getMessageTemplateId())
                .messageParamList(Collections.singletonList(sendRequest.getMessageParam()))
                .build();

        ProcessContext context = ProcessContext.builder()
                .code(sendRequest.getCode())
                .processModel(sendTaskModel)
                .needBreak(false)
                .response(BasicResultVO.success())
                .build();

        ProcessContext process = processController.process(context);
        return new SendResponse(process.getResponse().getStatus(), process.getResponse().getMsg());
    }

    @Override
    public SendResponse batchSend(BatchSendRequest batchSendRequest) {
        return null;
    }
}
