package com.jking412.tagle.entity.readlistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.jking412.tagle.common.TagleExcel;
import com.jking412.tagle.entity.DIYRule;
import org.springframework.stereotype.Component;

@Component
public class DIYRuleReadListener implements ReadListener<DIYRule> {
    @Override
    public void invoke(DIYRule DIYRule, AnalysisContext analysisContext) {
        TagleExcel.diyRules.add(DIYRule);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        System.out.println("DefinedScore 读取完毕");
    }
}

