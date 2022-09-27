package com.jking412.tagle.controller.menu;

import com.jking412.tagle.controller.dao.DailyTaskDao;
import com.jking412.tagle.core.TagleController;
import com.jking412.tagle.tagleenum.Message;
import com.jking412.tagle.utils.MenuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DailyTaskMenuController implements TagleController {

    @Autowired
    private DailyTaskDao dailyTaskDao;


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        MenuUtils.outputMsg(Message.inputOrderMsg);
        do{
            String input = scanner.next();
            if(input.equals("6")){
                break;
            }
            toChildController(input);
            printMenu();
            MenuUtils.outputMsg(Message.inputOrderMsg);
        }while (scanner.hasNext());
    }

    @Override
    public void toChildController(String choice) {
        if(choice.equals("1")){
            dailyTaskDao.addDailyTask();
        } else if (choice.equals("2")) {
            dailyTaskDao.deleteDailyTask();
        }else if (choice.equals("3")){
            dailyTaskDao.updateDailyTask();
        }else if (choice.equals("4")){
            dailyTaskDao.showDailyTask();
        }else if (choice.equals("5")){
            dailyTaskDao.modifyDailyTask();
        }else {
            MenuUtils.outputMsg(Message.inputParseError);
        }
    }

    private void printMenu(){
        System.out.println("1.添加任务");
        System.out.println("2.删除任务");
        System.out.println("3.修改任务");
        System.out.println("4.查看任务");
        System.out.println("5.修改完成情况");
        System.out.println("6.返回上一级");
    }
}
