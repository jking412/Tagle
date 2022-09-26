package com.jking412.tagle.controller.menu;

import com.jking412.tagle.controller.dao.HabitTaskDao;
import com.jking412.tagle.core.TagleController;
import com.jking412.tagle.tagleenum.Message;
import com.jking412.tagle.utils.MenuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class HabitTaskMenuController implements TagleController {

    @Autowired
    private HabitTaskDao habitTaskDao;
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
            habitTaskDao.addHabitTask();
        } else if (choice.equals("2")) {
            habitTaskDao.deleteHabitTask();
        }else if (choice.equals("3")){
            habitTaskDao.updateHabitTask();
        }else if (choice.equals("4")){
            habitTaskDao.showHabitTask();
        }else if (choice.equals("5")){
            habitTaskDao.modifyHabitTask();
        }else {
            MenuUtils.outputMsg(Message.inputParseError);
        }
    }

    private void printMenu(){
        System.out.println("1.添加习惯");
        System.out.println("2.删除习惯");
        System.out.println("3.修改习惯");
        System.out.println("4.查看习惯");
        System.out.println("5.修改完成情况");
        System.out.println("6.返回上一级");
    }
}
