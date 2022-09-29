package icu.zxb996.common.vo;

import icu.zxb996.common.enums.RespStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 结果返回视图
 *
 * @author gavin
 * @date 2022/9/29 18:13
 */
@Getter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class BasicResultVO<T> {

    /**
     * 响应状态
     */
    private String status;

    /**
     * 响应编码
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;


    public BasicResultVO(RespStatusEnum status) {
        this(status, null);
    }

    public BasicResultVO(RespStatusEnum status, T data) {
        this(status, status.getMsg(), data);
    }

    public BasicResultVO(RespStatusEnum status, String msg, T data) {
        this.status = status.getCode();
        this.msg = msg;
        this.data = data;
    }

    /**
     * @return 默认成功响应
     */
    public static BasicResultVO<Void> success() {
        return new BasicResultVO<>(RespStatusEnum.SUCCESS);
    }

    /**
     * 自定义信息的成功响应
     * <p>通常用作插入成功等并显示具体操作通知如: return BasicResultVO.success("发送信息成功")</p>
     *
     * @param msg 信息
     * @return 自定义信息的成功响应
     */
    public static <T> BasicResultVO<T> success(String msg) {
        return new BasicResultVO<>(RespStatusEnum.SUCCESS, msg, null);
    }

    /**
     * 带数据的成功响应
     *
     * @param data 数据
     * @return 带数据的成功响应
     */
    public static <T> BasicResultVO<T> success(T data) {
        return new BasicResultVO<>(RespStatusEnum.SUCCESS, data);
    }

    /**
     * 自定义状态的失败响应
     *
     * @param status 状态
     * @return 自定义状态的失败响应
     */
    public static <T> BasicResultVO<T> fail(RespStatusEnum status) {
        return fail(status, status.getMsg());
    }

    /**
     * 自定义状态和信息的失败响应
     *
     * @param status 状态
     * @param msg    信息
     * @return 自定义状态和信息的失败响应
     */
    public static <T> BasicResultVO<T> fail(RespStatusEnum status, String msg) {
        return new BasicResultVO<>(status, msg, null);
    }
}
