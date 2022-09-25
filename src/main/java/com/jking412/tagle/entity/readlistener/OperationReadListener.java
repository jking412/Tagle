package com.jking412.tagle.entity.readlistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.jking412.tagle.entity.Operation;

public class OperationReadListener implements ReadListener<Operation> {
    @Override
    public void invoke(Operation operation, AnalysisContext analysisContext) {
        Operation.operations.add(operation);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        System.out.println("Operation 读取完毕");
    }
}
