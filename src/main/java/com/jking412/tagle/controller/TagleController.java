package com.jking412.tagle.controller;

import com.jking412.tagle.entity.DailyTask;
import com.jking412.tagle.menu.Menu;
import com.jking412.tagle.tagleenum.Message;
import com.jking412.tagle.utils.ExcelUtils;
import com.jking412.tagle.utils.MenuUtils;

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
        MenuUtils.outputMsg(Message.inputOrderMsg);
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
                ExcelUtils.saveExcel();
                break;
            }else {
                MenuUtils.outputMsg(Message.inputParseError);
            }
            Menu.mainMenu();
            MenuUtils.outputMsg(Message.inputOrderMsg);
        }
    }
}
