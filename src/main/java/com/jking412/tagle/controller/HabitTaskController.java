package com.jking412.tagle.controller;

import com.jking412.tagle.entity.HabitTask;
import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.menu.Menu;
import com.jking412.tagle.utils.DateUtils;

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
        int days;
        try{
            days = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入错误，请重新输入");
            addHabitTask();
            return;
        }
        if(days < 0){
            System.out.println("目标天数不应该是负数，请重新输入");
            addHabitTask();
            return;
        }
        HabitTask.habitTasks.add(new HabitTask(content, days));
        System.out.println("添加成功");
    }

    public static void deleteHabitTask(){
        if(HabitTask.habitTasks.size() == 0){
            System.out.println("当前没有习惯任务");
            startHabitTask();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < HabitTask.habitTasks.size(); i++){
            System.out.println(i + ". " + HabitTask.habitTasks.get(i).getTaskName());
        }
        System.out.println("请输入你要删除的习惯任务序号:\n");
        int index;
        try {
            index = scanner.nextInt();
        }catch (Exception e){
            System.out.println("输入错误，请重新输入");
            deleteHabitTask();
            return;
        }
        if(index < 0 || index >= HabitTask.habitTasks.size()){
            System.out.println("习惯任务序号不存在，请重新输入");
            deleteHabitTask();
            return;
        }
        HabitTask.habitTasks.remove(index);
        System.out.println("删除成功");
        startHabitTask();
    }

    public static void updateHabitTask(){
        if(HabitTask.habitTasks.size() == 0){
            System.out.println("当前没有习惯任务");
            startHabitTask();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < HabitTask.habitTasks.size(); i++){
            System.out.println(i + ". " + HabitTask.habitTasks.get(i).getTaskName());
        }
        System.out.println("请输入你要更新的习惯任务序号:\n");
        int index;
        try {
            index = scanner.nextInt();
        }catch (Exception e){
            System.out.println("输入错误，请重新输入");
            updateHabitTask();
            return;
        }
        if(index < 0 || index >= HabitTask.habitTasks.size()){
            System.out.println("习惯任务序号不存在，请重新输入");
            updateHabitTask();
            return;
        }
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
            int days;
            try{
                days = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("输入错误，请重新输入");
                updateHabitTask();
                return;
            }
            if(days < 0){
                System.out.println("目标天数不应该是负数，请重新输入");
                updateHabitTask();
                return;
            }
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
            int finishDay;
            try{
                finishDay = scanner.nextInt();
            }catch (Exception e){
                System.out.println("天数应该是一个大于等于零的整数");
                updateHabitTask();
                return;
            }
            if(finishDay < 0){
                System.out.println("天数应该是一个大于等于零的整数");
                updateHabitTask();
                return;
            }
            HabitTask.habitTasks.get(index).setFinishedDayNum(finishDay);
        }else if (choice.equals("6")) {
            System.out.println("请输入新的未完成天数:\n");
            int unfinishDay;
            try {
                unfinishDay = scanner.nextInt();
            }catch (Exception e){
                System.out.println("天数应该是一个大于等于零的整数");
                updateHabitTask();
                return;
            }
            if(unfinishDay < 0){
                System.out.println("天数应该是一个大于等于零的整数");
                updateHabitTask();
                return;
            }
            HabitTask.habitTasks.get(index).setUnFinishedDayNum(unfinishDay);
        }else if (choice.equals("7")) {
            System.out.println("请输入新的奖励积分:\n");
            int reward;
            try {
                reward = scanner.nextInt();
            }catch (Exception e){
                System.out.println("积分应该是一个大于等于零的整数");
                updateHabitTask();
                return;
            }
            if(reward < 0){
                System.out.println("这是一个奖励积分，不应该是负数");
                updateHabitTask();
                return;
            }

            HabitTask.habitTasks.get(index).setTaskScore(reward);
        }else if (choice.equals("8")) {
            System.out.println("请输入新的损失积分:\n");
            int loss;
            try {
                loss = scanner.nextInt();
            }catch (Exception e){
                System.out.println("积分应该是一个大于等于零的整数");
                updateHabitTask();
                return;
            }
            if(loss < 0){
                System.out.println("这是一个损失积分，不应该是负数");
                updateHabitTask();
                return;
            }
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
            return;
        }
        startHabitTask();
    }

    public static void showHabitTask(){
        if(HabitTask.habitTasks.size() == 0){
            System.out.println("当前没有习惯任务");
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
        System.out.println("请输入你要修改的习惯序号:\n");
        Scanner scanner = new Scanner(System.in);
        int index;
        try {
            index = scanner.nextInt();
        }catch (Exception e){
            System.out.println("不存在该习惯序号，请重新输入");
            modifyHabitTask();
            return;
        }
        if(index < 0 || index >= HabitTask.habitTasks.size()){
            System.out.println("不存在该习惯序号，请重新输入");
            modifyHabitTask();
            return;
        }
        HabitTask habitTask = HabitTask.habitTasks.get(index);
        System.out.println("请输入选项前的序号，进行修改\n");
        System.out.println("1. 坚持一天");
        System.out.println("2. 放弃一天");
        System.out.println("3. 返回上一级");
        String choice = scanner.next();
        if(choice.equals("1")) {
            habitTask.setFinishedDayNum(habitTask.getFinishedDayNum() + 1);
            Operation.operations.add(new Operation(habitTask.getTaskName(), habitTask.getTaskScore()));
            System.out.println("你现在距离完成目标还有"+(habitTask.getTargetDay()-habitTask.getFinishedDayNum())+"天");
        }else if (choice.equals("2")){
            habitTask.setUnFinishedDayNum(habitTask.getUnFinishedDayNum()+1);
            Operation.operations.add(new Operation(habitTask.getTaskName(), -habitTask.getTaskLostScore()));
        } else if (choice.equals("3")) {
            return;
        }else{
            System.out.println("输入错误，请重新输入");
            System.out.println("请输入你的操作，按下操作前的序号即可\n");
            modifyHabitTask();
            return;
        }
        System.out.println("修改成功");
    }

}
