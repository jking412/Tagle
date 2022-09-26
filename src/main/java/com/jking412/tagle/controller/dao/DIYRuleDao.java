package com.jking412.tagle.controller.dao;

import com.jking412.tagle.common.TagleExcel;
import com.jking412.tagle.entity.DIYRule;
import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.tagleenum.Message;
import com.jking412.tagle.utils.MenuUtils;
import com.jking412.tagle.utils.TaskUtils;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class DIYRuleDao {

    public void addDefinedScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入自定义规则内容:\n");
        String content = scanner.next();
        System.out.println("请输入自定义规则分值:\n");
        int score = TaskUtils.readInt();
        TagleExcel.diyRules.add(new DIYRule(content, score));
        MenuUtils.outputMsg(Message.successMsg);
    }

    public void deleteDefinedScore() {
        if (TagleExcel.diyRules.size() == 0) {
            MenuUtils.outputMsg(Message.noContentMsg);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < TagleExcel.diyRules.size(); i++) {
            System.out.println(i + ". " + TagleExcel.diyRules.get(i).getScoreName());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        int index = TaskUtils.readInt(0, TagleExcel.diyRules.size() - 1);
        TagleExcel.diyRules.remove(index);
        MenuUtils.outputMsg(Message.successMsg);
    }

    public void updateDefinedScore() {
        if (TagleExcel.diyRules.size() == 0) {
            MenuUtils.outputMsg(Message.noContentMsg);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < TagleExcel.diyRules.size(); i++) {
            System.out.println(i + ". " + TagleExcel.diyRules.get(i).getScoreName());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        int index = TaskUtils.readInt(0, TagleExcel.diyRules.size() - 1);
        System.out.println(TagleExcel.diyRules.get(index));
        System.out.println("1. 更新自定义规则内容");
        System.out.println("2. 更新自定义规则分值");
        System.out.println("3. 更新备注");
        System.out.println("4. 返回");
        MenuUtils.outputMsg(Message.inputOrderMsg);
        String choice = scanner.next();
        if (choice.equals("1")) {
            System.out.println("请输入新的自定义规则内容:\n");
            String content = scanner.next();
            TagleExcel.diyRules.get(index).setScoreName(content);
        } else if (choice.equals("2")) {
            System.out.println("请输入新的自定义规则分值:\n");
            int score = TaskUtils.readInt();
            TagleExcel.diyRules.get(index).setScore(score);
        } else if (choice.equals("3")) {
            System.out.println("请输入新的备注:\n");
            String remark = scanner.next();
            TagleExcel.diyRules.get(index).setRemark(remark);
        } else if (choice.equals("4")) {
            return;
        } else {
            MenuUtils.outputMsg(Message.inputParseError);
            updateDefinedScore();
            return;
        }
        MenuUtils.outputMsg(Message.successMsg);
    }

    public void showDefinedScore() {
        if (TagleExcel.diyRules.size() == 0) {
            MenuUtils.outputMsg(Message.noContentMsg);
            return;
        }
        for (int i = 0; i < TagleExcel.diyRules.size(); i++) {
            System.out.println(i + ". " + TagleExcel.diyRules.get(i));
        }
    }

    public void modifyDefinedScore() {
        if (TagleExcel.diyRules.size() == 0) {
            MenuUtils.outputMsg(Message.noContentMsg);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < TagleExcel.diyRules.size(); i++) {
            System.out.println(i + ". " + TagleExcel.diyRules.get(i).getScoreName());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        int index = TaskUtils.readInt();
        MenuUtils.outputMsg(Message.successMsg);
        TagleExcel.operations.add(new Operation("第" + index + "个自定义规则" + TagleExcel.diyRules.get(index).getScoreName()
                + "被执行了一次", TagleExcel.diyRules.get(index).getScore()));
    }


}
