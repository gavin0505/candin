package icu.zxb996.candin.support.pipeline;

import java.util.List;

/**
 * 业务执行模板（把责任链的逻辑串起来）
 *
 * @author gavin
 * @date 2022/9/29 19:11
 */
public class ProcessTemplate {

    private List<BusnissProcess> processList;

    public List<BusnissProcess> getProcessList() {
        return processList;
    }

    public void setProcessList(List<BusnissProcess> processList) {
        this.processList = processList;
    }
}
