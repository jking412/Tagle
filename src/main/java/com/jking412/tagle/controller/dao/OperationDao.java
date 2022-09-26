package com.jking412.tagle.controller.dao;

import com.jking412.tagle.common.TagleExcel;
import com.jking412.tagle.entity.Operation;
import com.jking412.tagle.tagleenum.Message;
import com.jking412.tagle.utils.MenuUtils;
import com.jking412.tagle.utils.TaskUtils;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class OperationDao {

    public void showOperation() {
        if (TagleExcel.operations.size() == 0) {
            MenuUtils.outputMsg(Message.noContentMsg);
            return;
        }
        for (int i = 0; i < TagleExcel.operations.size(); i++) {
            System.out.println(i + ".  " + TagleExcel.operations.get(i));
        }
    }

    public void updateOperationRemark() {
        if (TagleExcel.operations.size() == 0) {
            MenuUtils.outputMsg(Message.noContentMsg);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < TagleExcel.operations.size(); i++) {
            System.out.println(i + ".  " + TagleExcel.operations.get(i).getOperation());
        }
        MenuUtils.outputMsg(Message.inputOrderMsg);
        int index = TaskUtils.readInt(0, TagleExcel.operations.size() - 1);
        System.out.println("请输入你修改后的备注:\n");
        String remark = scanner.next();
        TagleExcel.operations.get(index).setRemark(remark);
        MenuUtils.outputMsg(Message.successMsg);
    }

}
