package com.jking412.tagle.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.jking412.tagle.entity.DailyTask;
import com.jking412.tagle.entity.DefinedScore;
import com.jking412.tagle.entity.HabitTask;
import com.jking412.tagle.entity.Operation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static String excelName;

    public static void InitExcel(String name){
        excelName = name.concat(".xlsx");
        File file = new File(excelName);
        if(!file.exists()) {
            createExcel(excelName);
        }
        DailyTask.readSheet();
        DefinedScore.readSheet();
        HabitTask.readSheet();
        Operation.readSheet();
        System.out.println("Excel初始化完成\n");
    }

    public static void createExcel(String excelName){
        Workbook workBook = new XSSFWorkbook();
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(excelName);

            Sheet sheetDailyTask = workBook.createSheet("DailyTask");
            Row rowDailyTask = sheetDailyTask.createRow(0);
            rowDailyTask.createCell(0).setCellValue("日期");
            rowDailyTask.createCell(1).setCellValue("任务");
            rowDailyTask.createCell(2).setCellValue("完成情况");
            rowDailyTask.createCell(3).setCellValue("奖励积分");
            rowDailyTask.createCell(4).setCellValue("损失积分");
            rowDailyTask.createCell(5).setCellValue("备注");
            // 让列宽随着导出的列长自动适应
            autoSize(sheetDailyTask, DailyTask.sheetLength);


            Sheet sheetHabitTask = workBook.createSheet("HabitTask");
            Row rowHabitTask = sheetHabitTask.createRow(0);
            rowHabitTask.createCell(0).setCellValue("任务");
            rowHabitTask.createCell(1).setCellValue("目标天数");
            rowHabitTask.createCell(2).setCellValue("开始日期");
            rowHabitTask.createCell(3).setCellValue("结束日期");
            rowHabitTask.createCell(4).setCellValue("完成的天数");
            rowHabitTask.createCell(5).setCellValue("未完成的天数");
            rowHabitTask.createCell(6).setCellValue("奖励积分");
            rowHabitTask.createCell(7).setCellValue("损失积分");
            rowHabitTask.createCell(8).setCellValue("备注");
            autoSize(sheetHabitTask,HabitTask.sheetLength);


            Sheet sheetDefinedScore = workBook.createSheet("DefinedScore");
            Row rowDefinedScore = sheetDefinedScore.createRow(0);
            rowDefinedScore.createCell(0).setCellValue("积分内容");
            rowDefinedScore.createCell(1).setCellValue("积分");
            rowDefinedScore.createCell(2).setCellValue("完成次数");
            rowDefinedScore.createCell(3).setCellValue("备注");
            autoSize(sheetDefinedScore,DefinedScore.sheetLength);


            Sheet sheetOperation = workBook.createSheet("Operation");
            Row rowOperation = sheetOperation.createRow(0);
            rowOperation.createCell(0).setCellValue("操作时间");
            rowOperation.createCell(1).setCellValue("操作内容");
            rowOperation.createCell(2).setCellValue("改变的积分");
            rowOperation.createCell(3).setCellValue("剩余积分");
            rowOperation.createCell(4).setCellValue("备注");
            autoSize(sheetOperation,Operation.sheetLength);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workBook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveAllExcel(){
        saveExcel("DailyTask",DailyTask.class,DailyTask.dailyTasks);
        saveExcel("HabitTask",HabitTask.class,HabitTask.habitTasks);
        saveExcel("DefinedScore",DefinedScore.class,DefinedScore.definedScores);
        saveExcel("Operation",Operation.class,Operation.operations);
    }

    private static void saveExcel(String sheetName,Class<?> Class,ArrayList<?> list){
        EasyExcel.write(excelName,Class).sheet(sheetName).doWrite(list);
    }


    private static void autoSize(Sheet sheet,int len){
        // 让列宽随着导出的列长自动适应
        for (int i = 0; i < len; i++) {
            // 调整每一列宽度
            sheet.autoSizeColumn((short) i);
            // 解决自动设置列宽中文失效的问题，单个单元格的最大列宽为255个字符
            int maxWith = 255 * 256;
            int newWidth = sheet.getColumnWidth(i) * 17 / 10;
            if (newWidth < maxWith) {
                sheet.setColumnWidth(i, newWidth);
            }else {
                sheet.setColumnWidth(i, maxWith / 2);
            }
        }

    }

}
