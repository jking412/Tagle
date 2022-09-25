package com.jking412.tagle.controller;

import com.jking412.tagle.entity.HabitTask;
import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.menu.Menu;
import com.jking412.tagle.tagleenum.Message;
import com.jking412.tagle.utils.DateUtils;
import com.jking412.tagle.utils.MenuUtils;
import com.jking412.tagle.utils.TaskUtils;

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
        } else if (choice.equals("5")) {
            modifyHabitTask();
        } else if(choice.equals("6")) {
            return;
        }else{
            MenuUtils.outputMsg(Message.inputParseError);
            startHabitTask();
        }
    }

    public static void addHabitTask(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入习惯任务内容:\n");
        String content = scanner.next();
        System.out.println("请输入坚持的目标天数:\n");
        int days = TaskUtils.readInt(0, Integer.MAX_VALUE);
        HabitTask.habitTasks.add(new HabitTask(content, days));
        MenuUtils.outputMsg(Message.successMsg);
    }

    public static void deleteHabitTask(){
        if(HabitTask.habitTasks.size() == 0){
            MenuUtils.outputMsg(Message.noContentMsg);
            startHabitTask();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < HabitTask.habitTasks.size(); i++){
            System.out.println(i + ". " + HabitTask.habitTasks.get(i).getTaskName());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        int index = TaskUtils.readInt(0, HabitTask.habitTasks.size() - 1);
        HabitTask.habitTasks.remove(index);
        MenuUtils.outputMsg(Message.successMsg);
        startHabitTask();
    }

    public static void updateHabitTask(){
        if(HabitTask.habitTasks.size() == 0){
            MenuUtils.outputMsg(Message.successMsg);
            startHabitTask();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < HabitTask.habitTasks.size(); i++){
            System.out.println(i + ". " + HabitTask.habitTasks.get(i).getTaskName());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        int index = TaskUtils.readInt(0, HabitTask.habitTasks.size() - 1);
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
            int days = TaskUtils.readInt(0, Integer.MAX_VALUE);
            HabitTask.habitTasks.get(index).setTargetDay(days);
        }else if(choice.equals("3")) {
            System.out.println("请输入新的开始时间,格式遵循 yyyy-MM-dd :\n");
            String startTime = scanner.next();
            if(!DateUtils.checkDate(startTime)){
                System.out.println("日期格式错误，请重新输入");
                updateHabitTask();
                return;
            }
            HabitTask.habitTasks.get(index).setStartDate(startTime);
        }else if(choice.equals("4")) {
            System.out.println("请输入新的结束时间:\n");
            String endTime = scanner.next();
            if(!DateUtils.checkDate(endTime)){
                System.out.println("日期格式错误，请重新输入");
                updateHabitTask();
                return;
            }
            HabitTask.habitTasks.get(index).setEndDate(endTime);
        }else if (choice.equals("5")) {
            System.out.println("请输入新的完成天数:\n");
            int finishDay = TaskUtils.readInt(0, Integer.MAX_VALUE);
            HabitTask.habitTasks.get(index).setFinishedDayNum(finishDay);
        }else if (choice.equals("6")) {
            System.out.println("请输入新的未完成天数:\n");
            int unfinishDay = TaskUtils.readInt(0, Integer.MAX_VALUE);
            HabitTask.habitTasks.get(index).setUnFinishedDayNum(unfinishDay);
        }else if (choice.equals("7")) {
            System.out.println("请输入新的奖励积分:\n");
            int reward = TaskUtils.readInt(0, Integer.MAX_VALUE);
            HabitTask.habitTasks.get(index).setTaskScore(reward);
        }else if (choice.equals("8")) {
            System.out.println("请输入新的损失积分:\n");
            int loss = TaskUtils.readInt(0, Integer.MAX_VALUE);
            HabitTask.habitTasks.get(index).setTaskLostScore(loss);
        }else if (choice.equals("9")) {
            System.out.println("请输入新的备注:\n");
            String remark = scanner.next();
            HabitTask.habitTasks.get(index).setTaskRemark(remark);
        }else if (choice.equals("10")) {
            return;
        }else{
            MenuUtils.outputMsg(Message.inputParseError);
            updateHabitTask();
            return;
        }
        startHabitTask();
    }

    public static void showHabitTask(){
        if(HabitTask.habitTasks.size() == 0){
            MenuUtils.outputMsg(Message.noContentMsg);
            startHabitTask();
            return;
        }
        for(int i = 0 ; i < HabitTask.habitTasks.size(); i++){
            System.out.println(i + ". " + HabitTask.habitTasks.get(i));
        }
        startHabitTask();
    }

    public static void modifyHabitTask(){
        for (int i = 0; i < HabitTask.habitTasks.size(); i++) {
            System.out.println(i + ". " + HabitTask.habitTasks.get(i).getTaskName());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        Scanner scanner = new Scanner(System.in);
        int index = TaskUtils.readInt(0, HabitTask.habitTasks.size() - 1);
        HabitTask habitTask = HabitTask.habitTasks.get(index);
        System.out.println("请输入选项前的序号，进行修改\n");
        System.out.println("1. 坚持一天");
        System.out.println("2. 放弃一天");
        System.out.println("3. 返回上一级");
        String choice = scanner.next();
        if(choice.equals("1")) {
            habitTask.setFinishedDayNum(habitTask.getFinishedDayNum() + 1);
            Operation.operations.add(new Operation("第"+index+"个习惯"+habitTask.getTaskName()
                    +"你坚持了一天", habitTask.getTaskScore()));
            System.out.println("你现在距离完成目标还有"+(habitTask.getTargetDay()-habitTask.getFinishedDayNum())+"天");
        }else if (choice.equals("2")){
            habitTask.setUnFinishedDayNum(habitTask.getUnFinishedDayNum()+1);
            Operation.operations.add(new Operation("第"+index+"个习惯"+habitTask.getTaskName()
                    +"你放弃了一天", habitTask.getTaskScore()));
        } else if (choice.equals("3")) {
            return;
        }else{
            MenuUtils.outputMsg(Message.inputParseError);
            modifyHabitTask();
            return;
        }
        MenuUtils.outputMsg(Message.successMsg);
    }

}
