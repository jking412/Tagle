package com.jking412.tagle.controller;

import com.jking412.tagle.entity.DefinedScore;
import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.menu.Menu;

import java.util.Scanner;

public class DefinedScoreController {
    public static void startDefinedScore(){
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("DefinedScore\n");
        Menu.rewardPunishmentMenu();
        choice = scanner.next();
        if(choice.equals("1")) {
            addDefinedScore();
        }else if(choice.equals("2")) {
            deleteDefinedScore();
        }else if(choice.equals("3")) {
            updateDefinedScore();
        }else if(choice.equals("4")) {
            showDefinedScore();
        }else if(choice.equals("5")) {
            modifyDefinedScore();
        }else if(choice.equals("6")) {
            return;
        } else{
            System.out.println("输入错误，请重新输入");
            System.out.println("请输入你的操作，按下操作前的序号即可\n");
            startDefinedScore();
        }
    }

    public static void addDefinedScore(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入自定义规则内容:\n");
        String content = scanner.next();
        System.out.println("请输入自定义规则分值:\n");
        int score = scanner.nextInt();
        DefinedScore.definedScores.add(new DefinedScore(content, score));
        System.out.println("添加成功");
        startDefinedScore();
    }

    public static void deleteDefinedScore(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < DefinedScore.definedScores.size(); i++){
            System.out.println(i + ". " + DefinedScore.definedScores.get(i).getScoreName());
        }
        System.out.println("请输入你要删除的自定义规则序号:\n");
        int index = scanner.nextInt();
        DefinedScore.definedScores.remove(index);
        System.out.println("删除成功");
        startDefinedScore();
    }

    public static void updateDefinedScore(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < DefinedScore.definedScores.size(); i++){
            System.out.println(i + ". " + DefinedScore.definedScores.get(i).getScoreName());
        }
        System.out.println("请输入你要更新的自定义规则序号:\n");
        int index = scanner.nextInt();
        System.out.println(DefinedScore.definedScores.get(index));
        System.out.println("1. 更新自定义规则内容");
        System.out.println("2. 更新自定义规则分值");
        System.out.println("3. 更新备注");
        System.out.println("4. 返回");
        System.out.println("请输入你的操作，按下操作前的序号即可\n");
        String choice = scanner.next();
        if(choice.equals("1")){
            System.out.println("请输入新的自定义规则内容:\n");
            String content = scanner.next();
            DefinedScore.definedScores.get(index).setScoreName(content);
            System.out.println("更新成功");
        }else if(choice.equals("2")){
            System.out.println("请输入新的自定义规则分值:\n");
            int score = scanner.nextInt();
            DefinedScore.definedScores.get(index).setScore(score);
            System.out.println("更新成功");
        }else if(choice.equals("3")) {
            System.out.println("请输入新的备注:\n");
            String remark = scanner.next();
            DefinedScore.definedScores.get(index).setRemark(remark);
            System.out.println("更新成功");
        }else if (choice.equals("4")){
            return;
        }else{
            System.out.println("输入错误，请重新输入");
            System.out.println("请输入你的操作，按下操作前的序号即可\n");
            updateDefinedScore();
        }
        startDefinedScore();
    }

    public static void showDefinedScore(){
        for(int i = 0 ; i < DefinedScore.definedScores.size(); i++){
            System.out.println(i + ". " + DefinedScore.definedScores.get(i));
        }
        startDefinedScore();
    }

    public static void modifyDefinedScore(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < DefinedScore.definedScores.size(); i++){
            System.out.println(i + ". " + DefinedScore.definedScores.get(i).getScoreName());
        }
        System.out.println("选择完成项:\n");
        int index = scanner.nextInt();
        Operation.operations.add(new Operation(DefinedScore.definedScores.get(index).getScoreName(), DefinedScore.definedScores.get(index).getScore()));
        startDefinedScore();
    }
}
