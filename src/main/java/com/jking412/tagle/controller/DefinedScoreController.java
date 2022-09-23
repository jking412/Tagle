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
        int score;
        try{
            score = scanner.nextInt();
        }catch (Exception e){
            System.out.println("分值应该是一个整数，请重新输入");
            addDefinedScore();
            return;
        }
        DefinedScore.definedScores.add(new DefinedScore(content, score));
        System.out.println("添加成功");
        startDefinedScore();
    }

    public static void deleteDefinedScore(){
        if (DefinedScore.definedScores.size() == 0){
            System.out.println("当前没有自定义规则");
            startDefinedScore();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < DefinedScore.definedScores.size(); i++){
            System.out.println(i + ". " + DefinedScore.definedScores.get(i).getScoreName());
        }
        System.out.println("请输入你要删除的自定义规则序号:\n");
        int index;
        try {
            index = scanner.nextInt();
        }catch (Exception e){
            System.out.println("序号应该是一个整数，请重新输入");
            deleteDefinedScore();
            return;
        }
        if(index < 0 || index >= DefinedScore.definedScores.size()){
            System.out.println("不存在该规则，请重新输入");
            deleteDefinedScore();
            return;
        }
        DefinedScore.definedScores.remove(index);
        System.out.println("删除成功");
        startDefinedScore();
    }

    public static void updateDefinedScore(){
        if (DefinedScore.definedScores.size() == 0){
            System.out.println("当前没有自定义规则");
            startDefinedScore();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < DefinedScore.definedScores.size(); i++){
            System.out.println(i + ". " + DefinedScore.definedScores.get(i).getScoreName());
        }
        System.out.println("请输入你要更新的自定义规则序号:\n");
        int index;
        try {
            index = scanner.nextInt();
        }catch (Exception e){
            System.out.println("序号应该是一个整数，请重新输入");
            updateDefinedScore();
            return;
        }
        if(index < 0 || index >= DefinedScore.definedScores.size()){
            System.out.println("不存在该规则，请重新输入");
            updateDefinedScore();
            return;
        }
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
            int score;
            try {
                score = scanner.nextInt();
            }catch (Exception e){
                System.out.println("分值应该是一个整数，请重新输入");
                updateDefinedScore();
                return;
            }
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
            return;
        }
        System.out.println("修改成功");
        startDefinedScore();
    }

    public static void showDefinedScore(){
        if (DefinedScore.definedScores.size() == 0){
            System.out.println("当前没有自定义规则");
            startDefinedScore();
            return;
        }
        for(int i = 0 ; i < DefinedScore.definedScores.size(); i++){
            System.out.println(i + ". " + DefinedScore.definedScores.get(i));
        }
        startDefinedScore();
    }

    public static void modifyDefinedScore(){
        if (DefinedScore.definedScores.size() == 0){
            System.out.println("当前没有自定义规则");
            startDefinedScore();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < DefinedScore.definedScores.size(); i++){
            System.out.println(i + ". " + DefinedScore.definedScores.get(i).getScoreName());
        }
        System.out.println("选择完成项:\n");
        int index;
        try {
            index = scanner.nextInt();
        }catch (Exception e){
            System.out.println("序号应该是一个整数，请重新输入");
            modifyDefinedScore();
            return;
        }
        System.out.println("操作成功");
        Operation.operations.add(new Operation(DefinedScore.definedScores.get(index).getScoreName(), DefinedScore.definedScores.get(index).getScore()));
        startDefinedScore();
    }
}
