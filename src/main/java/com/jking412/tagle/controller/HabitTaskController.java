package com.jking412.tagle.controller;

import com.jking412.tagle.entity.HabitTask;
import com.jking412.tagle.menu.Menu;

import java.util.Scanner;

public class HabitTaskController {
    public static void startHabitTask(){
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("HabitTask\n");
        Menu.habitTaskMenu();
        choice = scanner.next();
        if(choice.equals("1")) {
            addHabitTask();
        }else if(choice.equals("2")) {
            deleteHabitTask();
        } else if(choice.equals("3")) {
            updateHabitTask();
        }else if(choice.equals("4")) {
            showHabitTask();
        }else if(choice.equals("5")) {
            return;
        }else{
            System.out.println("输入错误，请重新输入");
            System.out.println("请输入你的操作，按下操作前的序号即可\n");
            startHabitTask();
        }
    }

    public static void addHabitTask(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入习惯任务内容:\n");
        String content = scanner.next();
        System.out.println("请输入坚持的目标天数:\n");
        int days = scanner.nextInt();
        HabitTask habitTasks = new HabitTask(content, days);
        HabitTask.habitTasks.add(habitTasks);
        System.out.println("添加成功");
    }

    public static void deleteHabitTask(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < HabitTask.habitTasks.size(); i++){
            System.out.println(i + ". " + HabitTask.habitTasks.get(i).getTaskName());
        }
        System.out.println("请输入你要删除的习惯任务序号:\n");
        int index = scanner.nextInt();
        HabitTask.habitTasks.remove(index);
        System.out.println("删除成功");
    }

    public static void updateHabitTask(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < HabitTask.habitTasks.size(); i++){
            System.out.println(i + ". " + HabitTask.habitTasks.get(i).getTaskName());
        }
        System.out.println("请输入你要更新的习惯任务序号:\n");
        int index = scanner.nextInt();
        System.out.println("1. 更新任务内容");
        System.out.println("2. 更新坚持的目标天数");
        System.out.println("3. 更新开始时间");
        System.out.println("4. 更新结束时间");
        System.out.println("5. 更新完成天数");
        System.out.println("6. 更新未完成天数");
        System.out.println("7. 更新奖励积分");
        System.out.println("8. 更新损失积分");
        System.out.println("9. 更新备注");
        System.out.println("10. 返回上一级");
        String choice = scanner.next();
        if(choice.equals("1")) {
            System.out.println("请输入新的任务内容:\n");
            String content = scanner.next();
            HabitTask.habitTasks.get(index).setTaskName(content);
        }else if(choice.equals("2")) {
            System.out.println("请输入新的坚持的目标天数:\n");
            int days = scanner.nextInt();
            HabitTask.habitTasks.get(index).setTargetDay(days);
        }else if(choice.equals("3")) {
            System.out.println("请输入新的开始时间:\n");
            String startTime = scanner.next();
            HabitTask.habitTasks.get(index).setStartDate(startTime);
        }else if(choice.equals("4")) {
            System.out.println("请输入新的结束时间:\n");
            String endTime = scanner.next();
            HabitTask.habitTasks.get(index).setEndDate(endTime);
        }else if (choice.equals("5")) {
            System.out.println("请输入新的完成天数:\n");
            int finishDay = scanner.nextInt();
            HabitTask.habitTasks.get(index).setFinishedDayNum(finishDay);
        }else if (choice.equals("6")) {
            System.out.println("请输入新的未完成天数:\n");
            int unfinishDay = scanner.nextInt();
            HabitTask.habitTasks.get(index).setUnFinishedDayNum(unfinishDay);
        }else if (choice.equals("7")) {
            System.out.println("请输入新的奖励积分:\n");
            int reward = scanner.nextInt();
            HabitTask.habitTasks.get(index).setTaskScore(reward);
        }else if (choice.equals("8")) {
            System.out.println("请输入新的损失积分:\n");
            int loss = scanner.nextInt();
            HabitTask.habitTasks.get(index).setTaskLostScore(loss);
        }else if (choice.equals("9")) {
            System.out.println("请输入新的备注:\n");
            String remark = scanner.next();
            HabitTask.habitTasks.get(index).setTaskRemark(remark);
        }else if (choice.equals("10")) {
            return;
        }else{
            System.out.println("输入错误，请重新输入");
            System.out.println("请输入你的操作，按下操作前的序号即可\n");
            updateHabitTask();
        }
    }

    public static void showHabitTask(){
        for(int i = 0 ; i < HabitTask.habitTasks.size(); i++){
            System.out.println(i + ". " + HabitTask.habitTasks.get(i).getTaskName() + " " + HabitTask.habitTasks.get(i).getTargetDay()
            + " " + HabitTask.habitTasks.get(i).getStartDate()+ " " + HabitTask.habitTasks.get(i).getEndDate()+ " " + HabitTask.habitTasks.get(i).getFinishedDayNum()
            + " " + HabitTask.habitTasks.get(i).getUnFinishedDayNum() + " " + HabitTask.habitTasks.get(i).getTaskScore()
            + " " + HabitTask.habitTasks.get(i).getTaskLostScore()+ " " + HabitTask.habitTasks.get(i).getTaskRemark());
        }
    }

}
