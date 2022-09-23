package com.jking412.tagle.controller;

import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.menu.Menu;

import java.util.Map;
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
            System.out.println("输入错误，请重新输入");
            System.out.println("请输入你的操作，按下操作前的序号即可\n");
            startOperation();
        }
    }

    public static void showOperation(){
        if(Operation.operations.size() == 0) {
            System.out.println("暂无操作记录\n");
            return;
        }
        for(int i = 0; i < Operation.operations.size(); i++){
            System.out.println(i + ".  " + Operation.operations.get(i));
        }
        startOperation();
    }

    public static void updateOperationRemark(){
        if(Operation.operations.size() == 0) {
            System.out.println("暂无操作记录\n");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < Operation.operations.size(); i++){
            System.out.println(i + ".  " + Operation.operations.get(i).getOperation());
        }
        System.out.println("请输入你要修改备注的操作序号:\n");
        int index = scanner.nextInt();
        if(index >= Operation.operations.size()){
            System.out.println("输入的操作不存在，请重新输入");
            updateOperationRemark();
            return;
        }
        System.out.println("请输入你修改后的备注:\n");
        String remark = scanner.next();
        Operation.operations.get(index).setRemark(remark);
        System.out.println("修改成功");
        startOperation();
    }

}
