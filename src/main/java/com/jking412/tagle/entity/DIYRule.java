package com.jking412.tagle.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DIYRule {


    @ExcelProperty(value = "积分内容", index = 0)
    private String scoreName;

    @ExcelProperty(value = "积分", index = 1)
    private int score;

    @ExcelProperty(value = "完成次数", index = 2)
    private int finishedTimes;


    @ExcelProperty(value = "备注", index = 3)
    private String remark;

    public DIYRule(String scoreName, int score){
        this.scoreName = scoreName;
        this.score = score;
    }
}
