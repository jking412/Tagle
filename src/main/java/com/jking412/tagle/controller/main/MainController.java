package com.jking412.tagle.controller.main;

import com.jking412.tagle.controller.menu.DIYRuleMenuController;
import com.jking412.tagle.controller.menu.DailyTaskMenuController;
import com.jking412.tagle.controller.menu.HabitTaskMenuController;
import com.jking412.tagle.controller.menu.OperationMenuController;
import com.jking412.tagle.core.TagleController;
import com.jking412.tagle.tagleenum.Message;
import com.jking412.tagle.utils.MenuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainController implements TagleController {

    private DailyTaskMenuController dailyTaskMenuController;
    private HabitTaskMenuController habitTaskMenuController;
    private DIYRuleMenuController diyRuleMenuController;
    private OperationMenuController operationMenuController;
    @Autowired
    public MainController(DailyTaskMenuController dailyTaskMenuController,
                          DIYRuleMenuController diyRuleMenuController,
                          HabitTaskMenuController habitTaskMenuController,
                          OperationMenuController operationMenuController){
        this.dailyTaskMenuController = dailyTaskMenuController;
        this.habitTaskMenuController = habitTaskMenuController;
        this.diyRuleMenuController = diyRuleMenuController;
        this.operationMenuController = operationMenuController;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        MenuUtils.outputMsg(Message.inputOrderMsg);
        do{
            String input = scanner.next();
            if(input.equals("5")){
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
            dailyTaskMenuController.run();
        }else if(choice.equals("2")){
            habitTaskMenuController.run();
        }else if(choice.equals("3")){
            diyRuleMenuController.run();
        }else if(choice.equals("4")){
            operationMenuController.run();
        }else{
            MenuUtils.outputMsg(Message.inputParseError);
        }
    }

    private void printMenu(){
        System.out.println("1. 日常任务");
        System.out.println("2. 我的习惯");
        System.out.println("3. 自定义规则");
        System.out.println("4. 我的历史操作");
        System.out.println("5. 退出Tagle");
    }

}
