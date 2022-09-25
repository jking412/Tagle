package com.jking412.tagle.controller;

import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.menu.Menu;
import com.jking412.tagle.tagleenum.Message;
import com.jking412.tagle.utils.MenuUtils;
import com.jking412.tagle.utils.TaskUtils;

import java.util.Scanner;

public class OperationController {
    public static void startOperation(){
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("Operation\n");
        Menu.operationMenu();
        choice = scanner.next();
        if(choice.equals("1")) {
            showOperation();
        } else if (choice.equals("2")) {
            updateOperationRemark();
        } else if(choice.equals("3")) {
            return;
        }else{
            MenuUtils.outputMsg(Message.inputParseError);
            startOperation();
        }
    }

    public static void showOperation(){
        if(Operation.operations.size() == 0) {
            MenuUtils.outputMsg(Message.noContentMsg);
            return;
        }
        for(int i = 0; i < Operation.operations.size(); i++){
            System.out.println(i + ".  " + Operation.operations.get(i));
        }
        startOperation();
    }

    public static void updateOperationRemark(){
        if(Operation.operations.size() == 0) {
            MenuUtils.outputMsg(Message.noContentMsg);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < Operation.operations.size(); i++){
            System.out.println(i + ".  " + Operation.operations.get(i).getOperation());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        int index = TaskUtils.readInt(0, Operation.operations.size() - 1);
        System.out.println("请输入你修改后的备注:\n");
        String remark = scanner.next();
        Operation.operations.get(index).setRemark(remark);
        MenuUtils.outputMsg(Message.successMsg);
        startOperation();
    }

}
