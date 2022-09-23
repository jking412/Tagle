package com.jking412.tagle.controller;

import com.jking412.tagle.entity.DailyTask;
import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.menu.Menu;
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
        }else if(choice.equals("5")) {
            return;
        }else{
            System.out.println("输入错误，请重新输入");
            System.out.println("请输入你的操作，按下操作前的序号即可\n");
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
        for(int i = 0 ; i < DailyTask.dailyTasks.size(); i++){
            System.out.println(i + ". " + DailyTask.dailyTasks.get(i).getTaskName());
        }
        System.out.println("请输入你要删除的任务序号:\n");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        DailyTask.dailyTasks.remove(index);
        System.out.println("删除成功");
    }

    public static void updateDailyTask(){
        for(int i = 0 ; i < DailyTask.dailyTasks.size(); i++){
            System.out.println(i + ". " + DailyTask.dailyTasks.get(i).getTaskName());
        }
        System.out.println("请输入你要更新的任务序号:\n");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
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
                System.out.println("1. 未完成");
                System.out.println("2. 已完成");
                System.out.println("3. 已放弃");
                System.out.println("请输入你的操作，按下操作前的序号即可:\n");
                int baseScore = 0;
                int overScore = 0;
                if(dailyTask.getTaskStatus().equals("已完成")) {
                    baseScore = 25;
                }
                String taskStatus = scanner.next();
                if (taskStatus.equals("1")) {
                    dailyTask.setTaskStatus("未完成");
                } else if (taskStatus.equals("2")) {
                    dailyTask.setTaskStatus("已完成");
                    overScore = 25;
                } else if (taskStatus.equals("3")) {
                    dailyTask.setTaskStatus("已放弃");
                } else {
                    System.out.println("输入错误，操作失败");
                }
                Operation.operations.add(new Operation("更新任务状态", overScore - baseScore));
            }else if(choice.equals("3")){
                System.out.println("请输入新的任务奖励分数:\n");
                int rewardScore = scanner.nextInt();
                dailyTask.setTaskGetScore(rewardScore);
            }else if(choice.equals("4")){
                System.out.println("请输入新的任务惩罚分数:\n");
                int punishmentScore = scanner.nextInt();
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
                continue;
            }
        }

    }

    public static void showDailyTask(){
        ArrayList<DailyTask> dailyTasks = DailyTask.dailyTasks;
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
        }
    }

}
