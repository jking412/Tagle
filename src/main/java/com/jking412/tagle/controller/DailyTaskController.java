package com.jking412.tagle.controller;

import com.jking412.tagle.entity.DailyTask;
import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.menu.Menu;
import com.jking412.tagle.status.DailyTaskStatus;
import com.jking412.tagle.utils.MenuUtils;
import com.jking412.tagle.utils.TaskUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class DailyTaskController {

    public static void startDailyTask(){
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("DailyTask\n");
        System.out.println("请输入你的操作，按下操作前的序号即可:");
        Menu.dailyTaskMenu();
        choice = scanner.next();
        if(choice.equals("1")) {
            addDailyTask();
        }else if(choice.equals("2")) {
            deleteDailyTask();
        }else if(choice.equals("3")) {
            updateDailyTask();
        }else if(choice.equals("4")) {
            showDailyTask();
        }else if(choice.equals("5")){
            modifyDailyTask();
        }else if(choice.equals("6")) {
            return;
        }else{
            MenuUtils.errorMsg("请输入你的操作，按下操作前的序号即可:");
            startDailyTask();
        }
    }

    public static void addDailyTask(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入任务名称:\n");
        String taskName = scanner.next();
        DailyTask dailyTask = new DailyTask(taskName);
        DailyTask.dailyTasks.add(dailyTask);
        startDailyTask();
    }

    public static void deleteDailyTask(){
        if (DailyTask.dailyTasks.size() == 0){
            System.out.println("当前没有任务，请先添加任务");
            startDailyTask();
        }
        for(int i = 0 ; i < DailyTask.dailyTasks.size(); i++){
            System.out.println(i + ". " + DailyTask.dailyTasks.get(i).getTaskName());
        }
        System.out.println("请输入你要删除的任务序号:\n");
        Scanner scanner = new Scanner(System.in);
        int index;
        try {
            index = scanner.nextInt();
        }catch (Exception e){
            MenuUtils.errorMsg();
            deleteDailyTask();
            return;
        }
        if(index < 0 || index >= DailyTask.dailyTasks.size()) {
            MenuUtils.errorMsg("输入的任务不存在，请重新输入");
            deleteDailyTask();
            return;
        }
        DailyTask.dailyTasks.remove(index);
        System.out.println("删除成功");
        startDailyTask();
    }

    public static void updateDailyTask(){
        if (DailyTask.dailyTasks.size() == 0){
            System.out.println("当前没有任务，请先添加任务");
            startDailyTask();
        }
        for(int i = 0 ; i < DailyTask.dailyTasks.size(); i++){
            System.out.println(i + ". " + DailyTask.dailyTasks.get(i).getTaskName());
        }
        System.out.println("请输入你要更新的任务序号:\n");
        Scanner scanner = new Scanner(System.in);
        int index;
        try{
            index = scanner.nextInt();
        }catch (Exception e){
            MenuUtils.errorMsg();
            updateDailyTask();
            return;
        }
        if(index < 0 || index >= DailyTask.dailyTasks.size()) {
            MenuUtils.errorMsg("输入的任务不存在，请重新输入");
            updateDailyTask();
            return;
        }
        DailyTask dailyTask = DailyTask.dailyTasks.get(index);
        System.out.println("1. 更新任务名称");
        System.out.println("2. 更新任务状态");
        System.out.println("3. 更新任务奖励分数");
        System.out.println("4. 更新任务惩罚分数");
        System.out.println("5. 更新任务备注");
        System.out.println("6. 返回");
        System.out.println("请输入你的操作，按下操作前的序号即可:\n");
        while (scanner.hasNext()){
            String choice = scanner.next();
            if(choice.equals("1")){
                System.out.println("请输入新的任务名称:\n");
                String taskName = scanner.next();
                dailyTask.setTaskName(taskName);
            }else if(choice.equals("2")){
                System.out.println("请输入新的任务状态:\n");
                System.out.println("0. 未完成");
                System.out.println("1. 已完成");
                System.out.println("2. 已放弃");
                System.out.println("请输入你的操作，按下操作前的序号即可:\n");
                int baseScore = 0;
                int overScore = 0;
                if(dailyTask.getTaskStatus().equals("已完成")) {
                    baseScore = 25;
                }
                String taskStatus = scanner.next();
                if (taskStatus.equals("0")) {
                    dailyTask.setTaskStatus(DailyTaskStatus.UNFINISHED);
                } else if (taskStatus.equals("1")) {
                    dailyTask.setTaskStatus(DailyTaskStatus.FINISHED);
                    overScore = 25;
                } else if (taskStatus.equals("2")) {
                    dailyTask.setTaskStatus(DailyTaskStatus.ABANDONED);
                } else {
                    MenuUtils.errorMsg("输入的任务状态不存在，请重新输入");
                    return;
                }
                Operation.addOperation(new Operation("更新任务状态", overScore - baseScore));
            }else if(choice.equals("3")){
                System.out.println("请输入新的任务奖励分数:\n");
                int rewardScore;
                try {
                    rewardScore = scanner.nextInt();
                }catch (Exception e){
                    System.out.println("分数应该是一个整数，操作失败");
                    return;
                }
                dailyTask.setTaskGetScore(rewardScore);
            }else if(choice.equals("4")){
                System.out.println("请输入新的任务惩罚分数:\n");
                int punishmentScore;
                try {
                    punishmentScore = scanner.nextInt();
                }catch (Exception e){
                    System.out.println("分数应该是一个整数，操作失败");
                    return;
                }
                dailyTask.setTaskLostScore(punishmentScore);
            }else if(choice.equals("5")){
                System.out.println("请输入新的任务备注:\n");
                String taskRemark = scanner.next();
                dailyTask.setTaskRemark(taskRemark);
            }else if(choice.equals("6")){
                return;
            }else{
                System.out.println("输入错误，请重新输入");
                System.out.println("请输入你的操作，按下操作前的序号即可:\n");
                return;
            }
        }
        System.out.println("更新成功");
        startDailyTask();
    }

    public static void showDailyTask(){
        ArrayList<DailyTask> dailyTasks = DailyTask.dailyTasks;
        if(dailyTasks.size() == 0){
            System.out.println("当前没有任务，请先添加任务");
            startDailyTask();
        }
        System.out.println("1. 显示所有任务");
        System.out.println("2. 显示未完成任务");
        System.out.println("3. 显示已完成任务");
        System.out.println("4. 显示已放弃任务");
        System.out.println("5. 返回");
        System.out.println("请输入你的操作，按下操作前的序号即可:\n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if(choice.equals("1")){
            for(int i = 0 ; i < dailyTasks.size(); i++){
                System.out.println(i+". "+dailyTasks.get(i).toString());
            }
        }else if(choice.equals("2")){
            for(int i = 0 ; i < dailyTasks.size(); i++){
                if(dailyTasks.get(i).getTaskStatus().equals("未完成")){
                    System.out.println(i+". "+dailyTasks.get(i).toString());
                }
            }
        }else if(choice.equals("3")){
            for(int i = 0 ; i < dailyTasks.size(); i++){
                if(dailyTasks.get(i).getTaskStatus().equals("已完成")){
                    System.out.println(i+". "+dailyTasks.get(i).toString());
                }
            }
        }else if(choice.equals("4")){
            for(int i = 0 ; i < dailyTasks.size(); i++){
                if(dailyTasks.get(i).getTaskStatus().equals("已放弃")){
                    System.out.println(i+". "+dailyTasks.get(i).toString());
                }
            }
        }else if(choice.equals("5")){
            return;
        }else{
            System.out.println("输入错误，请重新输入");
            System.out.println("请输入你的操作，按下操作前的序号即可:\n");
            showDailyTask();
            return;
        }
        startDailyTask();
    }

    public static void modifyDailyTask(){
        if (DailyTask.dailyTasks.size() == 0) {
            System.out.println("当前没有任务，请先添加任务");
            startDailyTask();
            return;
        }
        for(int i = 0 ; i < DailyTask.dailyTasks.size(); i++){
            System.out.println(i+". "+DailyTask.dailyTasks.get(i).toString());
        }
        System.out.println("请输入你要修改的任务序号:\n");
        Scanner scanner = new Scanner(System.in);
        int choice;
        try {
            choice = scanner.nextInt();
        }catch (Exception e){
            System.out.println("输入错误，任务序号应该是一个整数");
            modifyDailyTask();
            return;
        }
        if(choice < 0 || choice >= DailyTask.dailyTasks.size()){
            System.out.println("输入错误，请重新输入");
            System.out.println("请输入你的操作，按下操作前的序号即可:\n");
            modifyDailyTask();
            return;
        }
        DailyTask dailyTask = DailyTask.dailyTasks.get(choice);
        System.out.println("请输入新的任务状态:\n");
        System.out.println("0. 未完成");
        System.out.println("1. 已完成");
        System.out.println("2. 已放弃");
        System.out.println("请输入你的操作，按下操作前的序号即可:\n");
        int baseScore = 0;
        int overScore = 0;
        if(dailyTask.getTaskStatus().equals("已完成")) {
            baseScore = 25;
        }
        String taskStatus = scanner.next();
        boolean flag = true;
        if (taskStatus.equals("0")) {
            dailyTask.setTaskStatus(DailyTaskStatus.UNFINISHED);
        } else if (taskStatus.equals("1")) {
            dailyTask.setTaskStatus(DailyTaskStatus.FINISHED);
            overScore = 25;
        } else if (taskStatus.equals("2")) {
            dailyTask.setTaskStatus(DailyTaskStatus.ABANDONED);
        } else {
            flag = false;
            System.out.println("输入错误，操作失败");
        }
        if(flag){
            Operation.operations.add(new Operation("更新任务状态", overScore - baseScore));
            System.out.println("更新成功");
            startDailyTask();
        }else{
            System.out.println("更新失败");
            modifyDailyTask();
            return;
        }

    }

}
