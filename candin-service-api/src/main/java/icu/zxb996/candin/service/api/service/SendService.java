package icu.zxb996.candin.service.api.service;

import icu.zxb996.candin.service.api.domain.BatchSendRequest;
import icu.zxb996.candin.service.api.domain.SendRequest;
import icu.zxb996.candin.service.api.domain.SendResponse;

/**
 * 发送接口
 *
 * @author gavin
 * @date 2022/9/28 15:44
 */

public interface SendService {

    /**
     * 单文案发送接口
     *
     * @param sendRequest 发送的参数
     * @return
     */
    SendResponse send(SendRequest sendRequest);

    /**
     * 多文案发送接口
     *
     * @param batchSendRequest 批量发送的参数
     * @return
     */
    SendResponse batchSend(BatchSendRequest batchSendRequest);

}
