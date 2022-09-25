package com.jking412.tagle.entity.readlistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.jking412.tagle.entity.DefinedScore;

public class DefinedScoreReadListener implements ReadListener<DefinedScore> {
    @Override
    public void invoke(DefinedScore definedScore, AnalysisContext analysisContext) {
        DefinedScore.definedScores.add(definedScore);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        System.out.println("DefinedScore 读取完毕");
    }
}

