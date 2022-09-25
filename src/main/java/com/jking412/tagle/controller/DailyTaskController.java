package com.jking412.tagle.controller;

import com.jking412.tagle.entity.DailyTask;
import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.menu.Menu;
import com.jking412.tagle.tagleenum.DailyTaskStatus;
import com.jking412.tagle.tagleenum.Message;
import com.jking412.tagle.utils.MenuUtils;
import com.jking412.tagle.utils.TaskUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class DailyTaskController {

    public static void startDailyTask(){
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("DailyTask\n");
        MenuUtils.outputMsg(Message.inputOrderMsg);
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
            MenuUtils.outputMsg(Message.inputParseError);
            startDailyTask();
            return;
        }
    }

    public static void addDailyTask(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入任务名称:\n");
        String taskName = scanner.next();
        DailyTask dailyTask = new DailyTask(taskName);
        DailyTask.dailyTasks.add(dailyTask);
        MenuUtils.outputMsg(Message.successMsg);
        startDailyTask();
    }

    public static void deleteDailyTask(){
        if (DailyTask.dailyTasks.size() == 0){
            MenuUtils.outputMsg(Message.noContentMsg);
            startDailyTask();
        }
        for(int i = 0 ; i < DailyTask.dailyTasks.size(); i++){
            System.out.println(i + ". " + DailyTask.dailyTasks.get(i).getTaskName());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        Scanner scanner = new Scanner(System.in);
        int index;
        index = TaskUtils.readInt(0,DailyTask.dailyTasks.size() - 1);
        DailyTask.dailyTasks.remove(index);
        MenuUtils.outputMsg(Message.successMsg);
        startDailyTask();
    }

    public static void updateDailyTask(){
        if (DailyTask.dailyTasks.size() == 0){
            MenuUtils.outputMsg(Message.noContentMsg);
            startDailyTask();
        }
        for(int i = 0 ; i < DailyTask.dailyTasks.size(); i++){
            System.out.println(i + ". " + DailyTask.dailyTasks.get(i).getTaskName());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        Scanner scanner = new Scanner(System.in);
        int index;
        index = TaskUtils.readInt(0,DailyTask.dailyTasks.size() - 1);
        DailyTask dailyTask = DailyTask.dailyTasks.get(index);
        System.out.println("1. 更新任务名称");
        System.out.println("2. 更新任务状态");
        System.out.println("3. 更新任务奖励分数");
        System.out.println("4. 更新任务惩罚分数");
        System.out.println("5. 更新任务备注");
        System.out.println("6. 返回");
        MenuUtils.outputMsg(Message.inputOrderMsg);
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
            MenuUtils.outputMsg(Message.inputOrderMsg);
            int baseScore = 0;
            int overScore = 0;
            if(dailyTask.getTaskStatus().getStatusString().equals("已完成")) {
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
                MenuUtils.outputMsg(Message.inputIntError);
                return;
            }
            Operation.operations.add(new Operation("第"+choice+"个日常任务"+dailyTask.getTaskName()+"被修改为"
                    +dailyTask.getTaskStatus().getStatusString(), overScore - baseScore));
        }else if(choice.equals("3")){
            System.out.println("请输入新的任务奖励分数:\n");
            int rewardScore = TaskUtils.readInt();
            dailyTask.setTaskGetScore(rewardScore);
        }else if(choice.equals("4")){
            System.out.println("请输入新的任务惩罚分数:\n");
            int punishmentScore = TaskUtils.readInt();
            dailyTask.setTaskLostScore(punishmentScore);
        }else if(choice.equals("5")){
            System.out.println("请输入新的任务备注:\n");
            String taskRemark = scanner.next();
            dailyTask.setTaskRemark(taskRemark);
        }else if(choice.equals("6")){
            return;
        }else{
            MenuUtils.outputMsg(Message.inputParseError);
            updateDailyTask();
            return;
        }
        MenuUtils.outputMsg(Message.successMsg);
        startDailyTask();
    }

    public static void showDailyTask(){
        ArrayList<DailyTask> dailyTasks = DailyTask.dailyTasks;
        if(dailyTasks.size() == 0){
            MenuUtils.outputMsg(Message.noContentMsg);
            startDailyTask();
        }
        System.out.println("1. 显示所有任务");
        System.out.println("2. 显示未完成任务");
        System.out.println("3. 显示已完成任务");
        System.out.println("4. 显示已放弃任务");
        System.out.println("5. 返回");
        MenuUtils.outputMsg(Message.inputOrderMsg);
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if(choice.equals("1")){
            for(int i = 0 ; i < dailyTasks.size(); i++){
                System.out.println(i+". "+dailyTasks.get(i).toString());
            }
        }else if(choice.equals("2")){
            for(int i = 0 ; i < dailyTasks.size(); i++){
                if(dailyTasks.get(i).getTaskStatus().getStatusString().equals("未完成")){
                    System.out.println(i+". "+dailyTasks.get(i).toString());
                }
            }
        }else if(choice.equals("3")){
            for(int i = 0 ; i < dailyTasks.size(); i++){
                if(dailyTasks.get(i).getTaskStatus().getStatusString().equals("已完成")){
                    System.out.println(i+". "+dailyTasks.get(i).toString());
                }
            }
        }else if(choice.equals("4")){
            for(int i = 0 ; i < dailyTasks.size(); i++){
                if(dailyTasks.get(i).getTaskStatus().getStatusString().equals("已放弃")){
                    System.out.println(i+". "+dailyTasks.get(i).toString());
                }
            }
        }else if(choice.equals("5")){
            return;
        }else{
            MenuUtils.outputMsg(Message.inputParseError);
            showDailyTask();
            return;
        }
        startDailyTask();
    }

    public static void modifyDailyTask(){
        if (DailyTask.dailyTasks.size() == 0) {
            MenuUtils.outputMsg(Message.noContentMsg);
            startDailyTask();
            return;
        }
        for(int i = 0 ; i < DailyTask.dailyTasks.size(); i++){
            System.out.println(i+". "+DailyTask.dailyTasks.get(i).toString());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        Scanner scanner = new Scanner(System.in);
        int choice = TaskUtils.readInt(0,DailyTask.dailyTasks.size() - 1);
        DailyTask dailyTask = DailyTask.dailyTasks.get(choice);
        System.out.println("请输入新的任务状态:\n");
        System.out.println("0. 未完成");
        System.out.println("1. 已完成");
        System.out.println("2. 已放弃");
        MenuUtils.outputMsg(Message.inputOrderMsg);
        int baseScore = 0;
        int overScore = 0;
        if(dailyTask.getTaskStatus().getStatusString().equals("已完成")) {
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
            MenuUtils.outputMsg(Message.failMsg);
        }
        if(flag){
            Operation.operations.add(new Operation("第"+choice+"个日常任务"+dailyTask.getTaskName()+"被修改为"
                    +dailyTask.getTaskStatus().getStatusString(), overScore - baseScore));
            MenuUtils.outputMsg(Message.successMsg);
            startDailyTask();
        }else{
            MenuUtils.outputMsg(Message.failMsg);
            modifyDailyTask();
            return;
        }
    }

}
