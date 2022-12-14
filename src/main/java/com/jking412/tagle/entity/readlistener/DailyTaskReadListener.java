package com.jking412.tagle.entity.readlistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.jking412.tagle.common.TagleExcel;
import com.jking412.tagle.core.TagleContext;
import com.jking412.tagle.entity.DailyTask;
import org.springframework.stereotype.Component;

@Component
public class DailyTaskReadListener implements ReadListener<DailyTask> {

    @Override
    public void invoke(DailyTask dailyTask, AnalysisContext analysisContext) {
        TagleExcel.dailyTasks.add(dailyTask);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        System.out.println("DailyTask 读取完毕");
    }
}
