package icu.zxb996.candin.support.pipeline;

/**
 * 业务执行器
 *
 * @author gavin
 * @date 2022/9/29 19:12
 */
public interface BusnissProcess<T extends ProcessModel> {

    /**
     * 真正的处理逻辑
     *
     * @param context
     */
    void process(ProcessContext<T> context);
}
