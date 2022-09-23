package com.jking412.tagle.controller;

import com.jking412.tagle.entity.DailyTask;
import com.jking412.tagle.menu.Menu;
import com.jking412.tagle.utils.ExcelUtils;

import java.util.Scanner;

public class TagleController {
    public static void startTagle(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("欢迎使用Tagle!\n");
        try {
            Menu.outPutBanner();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n");
        Menu.mainMenu();
        System.out.println("请输入你的操作，按下操作前的序号即可:\n");
        while (scanner.hasNext()){
            String input = scanner.next();
            if(input.equals("1")){
                DailyTaskController.startDailyTask();
            }else if(input.equals("2")) {
                HabitTaskController.startHabitTask();
            }else if(input.equals("3")) {
                DefinedScoreController.startDefinedScore();
            }else if(input.equals("4")) {
                OperationController.startOperation();
            }else if(input.equals("5")) {

                System.out.println("感谢使用Tagle，再见");
                ExcelUtils.saveAllExcel();
                break;
            }else {
                System.out.println("输入错误，请重新输入");
                System.out.println("请输入你的操作，按下操作前的序号即可\n");
            }
            Menu.mainMenu();
            System.out.println("请输入你的操作，按下操作前的序号即可:");
        }
    }
}
