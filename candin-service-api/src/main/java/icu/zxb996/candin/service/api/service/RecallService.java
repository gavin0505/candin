package icu.zxb996.candin.service.api.service;

import icu.zxb996.candin.service.api.domain.SendRequest;
import icu.zxb996.candin.service.api.domain.SendResponse;

/**
 * 撤回接口
 *
 * @author gavin
 * @date 2022/9/28 15:44
 */
public interface RecallService {

    /**
     * 根据模板ID撤回消息
     *
     * @param sendRequest
     * @return
     */
    SendResponse recall(SendRequest sendRequest);
}
