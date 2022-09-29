package icu.zxb996.candin.support.pipeline;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import icu.zxb996.candin.support.exception.ProcessException;
import icu.zxb996.common.enums.RespStatusEnum;
import icu.zxb996.common.vo.BasicResultVO;

import java.util.List;
import java.util.Map;

/**
 * 流程控制器
 *
 * @author gavin
 * @date 2022/9/29 19:00
 */
public class ProcessController {

    /**
     * 模板映射
     */
    private Map<String, ProcessTemplate> templateConfig = null;

    /**
     * 执行责任链
     *
     * @param context 责任链上下文
     * @return 返回上下文内容
     */
    public ProcessContext process(ProcessContext context) {

        /*
          前置检查
         */
        try {
            preCheck(context);
        } catch (ProcessException e) {
            // 返回异常结果
            return e.getProcessContext();
        }

        /*
          遍历流程结点
         */
        List<BusnissProcess> processList = templateConfig.get(context.getCode()).getProcessList();
        for (BusnissProcess busnissProcess : processList) {

            busnissProcess.process(context);

            if (context.getNeedBreak()) {
                break;
            }
        }
        return context;
    }

    /**
     * 执行前检查，出错则抛出异常
     * cc
     *
     * @param context 执行上下文
     * @throws ProcessException 异常信息
     */
    private void preCheck(ProcessContext context) throws ProcessException {

        // 上下文
        if (context == null) {
            context = new ProcessContext();
            context.setResponse(BasicResultVO.fail(RespStatusEnum.CONTEXT_IS_NULL));
            throw new ProcessException(context);
        }


        // 业务代码
        String businessCode = context.getCode();
        // Hutool判空
        if (StrUtil.isBlank(businessCode)) {
            context.setResponse(BasicResultVO.fail(RespStatusEnum.BUSINESS_CODE_IS_NULL));
            throw new ProcessException(context);
        }

        // 执行模板
        ProcessTemplate processTemplate = templateConfig.get(businessCode);
        if (processTemplate == null) {
            context.setResponse(BasicResultVO.fail(RespStatusEnum.PROCESS_TEMPLATE_IS_NULL));
            throw new ProcessException(context);
        }

        // 执行模板列表
        List<BusnissProcess> processList = processTemplate.getProcessList();
        if (CollUtil.isEmpty(processList)) {
            context.setResponse(BasicResultVO.fail(RespStatusEnum.PROCESS_LIST_IS_NULL));
            throw new ProcessException(context);
        }
    }
}
