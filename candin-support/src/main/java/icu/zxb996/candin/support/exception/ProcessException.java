package icu.zxb996.candin.support.exception;

import icu.zxb996.candin.support.pipeline.ProcessContext;

/**
 * 自定义责任链异常处理
 *
 * @author gavin
 * @date 2022/9/29 19:21
 */
public class ProcessException extends RuntimeException {

    /**
     * 流程处理上下文
     */
    private final ProcessContext processContext;

    public ProcessException(ProcessContext processContext) {
        super();
        this.processContext = processContext;
    }

    public ProcessException(ProcessContext processContext, Throwable cause) {
        super(cause);
        this.processContext = processContext;
    }

    public ProcessContext getProcessContext() {
        return processContext;
    }
}
