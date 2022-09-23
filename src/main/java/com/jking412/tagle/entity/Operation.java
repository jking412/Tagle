package com.jking412.tagle.entity;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.jking412.tagle.entity.readListener.OperationReadListener;
import com.jking412.tagle.utils.DateUtils;
import com.jking412.tagle.utils.ExcelUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {

    @ExcelProperty(value = "操作时间", index = 0)
    private String Date;

    @ExcelProperty(value = "操作内容", index = 1)
    private String operation;

    @ExcelProperty(value = "改变的积分", index = 2)
    private int changedScore;

    @ExcelProperty(value = "剩余积分", index = 3)
    private int leftScore;

    @ExcelProperty(value = "备注", index = 4)
    private String remark;

    private static int sheetNum = 3;
    public static final int sheetLength = 5;

    public static ArrayList<Operation> operations;

    public Operation(String operation, int changedScore){
        this.Date = DateUtils.getDate();
        this.operation = operation;
        this.changedScore = changedScore;
        this.leftScore += changedScore;
    }

    public static void readSheet(){
        operations = new ArrayList<>();
        EasyExcel.read(ExcelUtils.excelName,Operation.class,new OperationReadListener()).sheet(sheetNum).doRead();
    }

    public static void addOperation(Operation operation){
        operations.add(operation);

    }
}
