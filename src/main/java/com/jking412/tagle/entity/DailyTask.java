package com.jking412.tagle.entity;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.jking412.tagle.entity.readListener.DailyTaskReadListener;
import com.jking412.tagle.utils.DateUtils;
import com.jking412.tagle.utils.ExcelUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyTask {


    @ExcelProperty(value = "日期", index = 0)
    private String date;

    @ExcelProperty(value = "任务", index = 1)
    private String taskName;

    @ExcelProperty(value = "完成情况", index = 2)
    private String taskStatus;

    @ExcelProperty(value = "奖励积分", index = 3)
    private int taskGetScore;

    @ExcelProperty(value = "损失积分", index = 4)
    private int taskLostScore;

    @ExcelProperty(value = "备注", index = 5)
    private String taskRemark;

    @ExcelIgnore
    private static int sheetNum = 0;
    @ExcelIgnore
    public static final int sheetLength = 6;
    @ExcelIgnore
    public static ArrayList<DailyTask> dailyTasks;

    public DailyTask(String taskName){
        this.date = DateUtils.getDate();
        this.taskName = taskName;
        this.taskStatus = "未完成";
        this.taskGetScore = 25;
        this.taskLostScore = 0;
        this.taskRemark = "";
    }


    public static void readSheet(){
        dailyTasks = new ArrayList<>();
        EasyExcel.read(ExcelUtils.excelName,DailyTask.class,new DailyTaskReadListener()).sheet(sheetNum).doRead();
    }
}
