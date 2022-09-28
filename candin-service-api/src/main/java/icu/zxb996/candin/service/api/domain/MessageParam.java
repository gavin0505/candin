package icu.zxb996.candin.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 消息参数
 *
 * @author gavin
 * @date 2022/9/28 15:53
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageParam {

    /**
     * &#064;Description 接收者
     * 多个用,逗号号分隔开
     * 【不能大于100个】
     * 必传
     */
    private String receiver;

    /**
     * &#064;Description 消息内容中的可变部分（占位符替换）
     * 可选
     */
    private Map<String, String> variables;

    /**
     * &#064;Description 扩展参数
     * 可选
     */
    private Map<String, String> extra;
}
