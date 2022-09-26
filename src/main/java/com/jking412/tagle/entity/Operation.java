package com.jking412.tagle.entity;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.jking412.tagle.common.TagleExcel;
import com.jking412.tagle.entity.readlistener.OperationReadListener;
import com.jking412.tagle.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Operation {

    @Autowired
    @ExcelIgnore
    private TagleExcel tagleExcel;

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

    public Operation(String operation, int changedScore){
        this.Date = DateUtils.getDate();
        this.operation = operation;
        this.changedScore = changedScore;
        this.remark = "";
        ArrayList<Operation> operations = TagleExcel.operations;
        if(operations.isEmpty()){
            this.leftScore = changedScore;
        }else{
            this.leftScore = operations.get(operations.size() - 1).getLeftScore() + changedScore;
        }
    }
}
