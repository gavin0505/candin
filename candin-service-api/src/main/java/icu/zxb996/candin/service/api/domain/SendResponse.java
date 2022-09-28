package icu.zxb996.candin.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 发送接口返回值
 *
 * @author gavin
 * @date 2022/9/28 15:45
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class SendResponse {

    /**
     * 响应状态
     */
    private String code;

    /**
     * 响应编码
     */
    private String msg;
}
