package com.jking412.tagle.entity;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.jking412.tagle.entity.readListener.HabitTaskReadListener;
import com.jking412.tagle.utils.DateUtils;
import com.jking412.tagle.utils.ExcelUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HabitTask {

    @ExcelProperty(value = "任务", index = 0)
    private String taskName;

    @ExcelProperty(value = "目标天数", index = 1)
    private int targetDay;

    @ExcelProperty(value = "开始日期", index = 2)
    private String startDate;

    @ExcelProperty(value = "结束日期", index = 3)
    private String endDate;

    @ExcelProperty(value = "完成的天数", index = 4)
    private int FinishedDayNum;

    @ExcelProperty(value = "未完成的天数", index = 5)
    private int unFinishedDayNum;

    @ExcelProperty(value = "奖励积分", index = 6)
    private int taskScore;

    @ExcelProperty(value = "损失积分", index = 7)
    private int taskLostScore;

    @ExcelProperty(value = "备注", index = 8)
    private String taskRemark;
    @ExcelIgnore
    private static int sheetNum = 1;
    @ExcelIgnore
    public static final int sheetLength = 9;
    @ExcelIgnore
    public static ArrayList<HabitTask> habitTasks;

    public HabitTask(String taskName,int targetDay){
        this.taskName = taskName;
        this.targetDay = targetDay;
        this.startDate = DateUtils.getDate();
        this.endDate = DateUtils.getDate(targetDay);
        this.FinishedDayNum = 0;
        this.unFinishedDayNum = 0;
        this.taskScore = 25;
        this.taskLostScore = 0;
        this.taskRemark = "";
    }

    public static void readSheet() {
        habitTasks = new ArrayList<>();
        EasyExcel.read(ExcelUtils.excelName, HabitTask.class, new HabitTaskReadListener()).sheet(sheetNum).doRead();
    }
}
