package com.jking412.tagle.controller;

import com.jking412.tagle.TagleApplication;
import com.jking412.tagle.entity.DefinedScore;
import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.menu.Menu;
import com.jking412.tagle.tagleenum.Message;
import com.jking412.tagle.utils.MenuUtils;
import com.jking412.tagle.utils.TaskUtils;

import java.util.Scanner;

public class DefinedScoreController {
    public static void startDefinedScore(){
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("DefinedScore\n");
        Menu.rewardPunishmentMenu();
        MenuUtils.outputMsg(Message.inputOrderMsg);
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
            MenuUtils.outputMsg(Message.inputParseError);
            startDefinedScore();
        }
    }

    public static void addDefinedScore(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入自定义规则内容:\n");
        String content = scanner.next();
        System.out.println("请输入自定义规则分值:\n");
        int score = TaskUtils.readInt();
        DefinedScore.definedScores.add(new DefinedScore(content, score));
        MenuUtils.outputMsg(Message.successMsg);
        startDefinedScore();
    }

    public static void deleteDefinedScore(){
        if (DefinedScore.definedScores.size() == 0){
            MenuUtils.outputMsg(Message.noContentMsg);
            startDefinedScore();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < DefinedScore.definedScores.size(); i++){
            System.out.println(i + ". " + DefinedScore.definedScores.get(i).getScoreName());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        int index = TaskUtils.readInt(0,DefinedScore.definedScores.size() - 1);
        DefinedScore.definedScores.remove(index);
        MenuUtils.outputMsg(Message.successMsg);
        startDefinedScore();
    }

    public static void updateDefinedScore(){
        if (DefinedScore.definedScores.size() == 0){
            MenuUtils.outputMsg(Message.noContentMsg);
            startDefinedScore();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < DefinedScore.definedScores.size(); i++){
            System.out.println(i + ". " + DefinedScore.definedScores.get(i).getScoreName());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        int index = TaskUtils.readInt(0, DefinedScore.definedScores.size() - 1);
        System.out.println(DefinedScore.definedScores.get(index));
        System.out.println("1. 更新自定义规则内容");
        System.out.println("2. 更新自定义规则分值");
        System.out.println("3. 更新备注");
        System.out.println("4. 返回");
        MenuUtils.outputMsg(Message.inputOrderMsg);
        String choice = scanner.next();
        if(choice.equals("1")){
            System.out.println("请输入新的自定义规则内容:\n");
            String content = scanner.next();
            DefinedScore.definedScores.get(index).setScoreName(content);
        }else if(choice.equals("2")){
            System.out.println("请输入新的自定义规则分值:\n");
            int score = TaskUtils.readInt();
            DefinedScore.definedScores.get(index).setScore(score);
        }else if(choice.equals("3")) {
            System.out.println("请输入新的备注:\n");
            String remark = scanner.next();
            DefinedScore.definedScores.get(index).setRemark(remark);
        }else if (choice.equals("4")){
            return;
        }else{
            MenuUtils.outputMsg(Message.inputParseError);
            updateDefinedScore();
            return;
        }
        MenuUtils.outputMsg(Message.successMsg);
        startDefinedScore();
    }

    public static void showDefinedScore(){
        if (DefinedScore.definedScores.size() == 0){
            MenuUtils.outputMsg(Message.noContentMsg);
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
            MenuUtils.outputMsg(Message.noContentMsg);
            startDefinedScore();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < DefinedScore.definedScores.size(); i++){
            System.out.println(i + ". " + DefinedScore.definedScores.get(i).getScoreName());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        int index = TaskUtils.readInt();
        MenuUtils.outputMsg(Message.successMsg);
        Operation.operations.add(new Operation("第"+index+"个自定义规则"+DefinedScore.definedScores.get(index).getScoreName()
                +"被执行了一次", DefinedScore.definedScores.get(index).getScore()));
        startDefinedScore();
    }
}
