package com.jking412.tagle.entity.readlistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.jking412.tagle.common.TagleExcel;
import com.jking412.tagle.entity.Operation;
import org.springframework.stereotype.Component;

@Component
public class OperationReadListener implements ReadListener<Operation> {
    @Override
    public void invoke(Operation operation, AnalysisContext analysisContext) {
        TagleExcel.operations.add(operation);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        System.out.println("Operation 读取完毕");
    }
}
