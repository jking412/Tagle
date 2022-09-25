package com.jking412.tagle.entity;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.jking412.tagle.entity.readlistener.DefinedScoreReadListener;
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
public class DefinedScore {


    @ExcelProperty(value = "积分内容", index = 0)
    private String scoreName;

    @ExcelProperty(value = "积分", index = 1)
    private int score;

    @ExcelProperty(value = "完成次数", index = 2)
    private int finishedTimes;


    @ExcelProperty(value = "备注", index = 3)
    private String remark;
    @ExcelIgnore
    private static int sheetNum = 2;
    @ExcelIgnore
    public static final int sheetLength = 4;
    @ExcelIgnore
    public static ArrayList<DefinedScore> definedScores;

    public DefinedScore(String scoreName, int score){
        this.scoreName = scoreName;
        this.score = score;
    }

    public static void readSheet(){
        definedScores = new ArrayList<>();
        EasyExcel.read(ExcelUtils.excelName,DefinedScore.class,new DefinedScoreReadListener()).sheet(sheetNum).doRead();
    }
}
