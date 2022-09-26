package com.jking412.tagle.controller.menu;

import com.jking412.tagle.controller.dao.OperationDao;
import com.jking412.tagle.core.TagleController;
import com.jking412.tagle.tagleenum.Message;
import com.jking412.tagle.utils.MenuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class OperationMenuController implements TagleController {

    @Autowired
    private OperationDao operationDao;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        MenuUtils.outputMsg(Message.inputOrderMsg);
        do{
            String input = scanner.next();
            if(input.equals("3")){
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
            operationDao.showOperation();
        } else if (choice.equals("2")) {
            operationDao.updateOperationRemark();
        }else {
            MenuUtils.outputMsg(Message.inputParseError);
        }
    }

    private void printMenu(){
        System.out.println("1.查看积分记录");
        System.out.println("2.给记录添加备注");
        System.out.println("3.返回上一级");
    }

}
