package com.jking412.tagle.entity.readlistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.jking412.tagle.entity.HabitTask;

public class HabitTaskReadListener implements ReadListener<HabitTask> {
    @Override
    public void invoke(HabitTask habitTask, AnalysisContext analysisContext) {
        HabitTask.habitTasks.add(habitTask);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        System.out.println("HabitTask 读取完毕");
    }
}
