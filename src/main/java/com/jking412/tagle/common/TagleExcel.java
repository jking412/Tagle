package com.jking412.tagle.common;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.jking412.tagle.entity.DailyTask;
import com.jking412.tagle.entity.DIYRule;
import com.jking412.tagle.entity.HabitTask;
import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.entity.readlistener.DailyTaskReadListener;
import com.jking412.tagle.entity.readlistener.DIYRuleReadListener;
import com.jking412.tagle.entity.readlistener.HabitTaskReadListener;
import com.jking412.tagle.entity.readlistener.OperationReadListener;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Data
public class TagleExcel {

    @Autowired
    private DailyTaskReadListener dailyTaskReadListener;
    @Autowired
    private HabitTaskReadListener habitTaskReadListener;
    @Autowired
    private DIYRuleReadListener DIYRuleReadListener;
    @Autowired
    private OperationReadListener operationReadListener;
    private final String excelName = "tagle.xlsx";
    public static ArrayList<DailyTask> dailyTasks = new ArrayList<>();
    public static ArrayList<DIYRule> diyRules = new ArrayList<>();
    public static ArrayList<HabitTask> habitTasks = new ArrayList<>();
    public static ArrayList<Operation> operations = new ArrayList<>();

    public TagleExcel() {
    }

    public void createExcel(){
        try(ExcelWriter excelWriter = EasyExcel.write(excelName).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build()){
            WriteSheet writeSheet = EasyExcel.writerSheet(0, "DailyTask").head(DailyTask.class).build();
            excelWriter.write(dailyTasks, writeSheet);
            writeSheet = EasyExcel.writerSheet(1, "HabitTask").head(HabitTask.class).build();
            excelWriter.write(habitTasks, writeSheet);
            writeSheet = EasyExcel.writerSheet(2, "DIYRule").head(DIYRule.class).build();
            excelWriter.write(diyRules, writeSheet);
            writeSheet = EasyExcel.writerSheet(3, "Operation").head(Operation.class).build();
            excelWriter.write(operations, writeSheet);
        }
    }

    public void readExcel(){
        EasyExcel.read(excelName,DailyTask.class,dailyTaskReadListener).sheet(0).doRead();
        EasyExcel.read(excelName,HabitTask.class,habitTaskReadListener).sheet(1).doRead();
        EasyExcel.read(excelName,DIYRule.class, DIYRuleReadListener).sheet(2).doRead();
        EasyExcel.read(excelName,Operation.class,operationReadListener).sheet(3).doRead();
    }
}
