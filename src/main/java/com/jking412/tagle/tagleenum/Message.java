package com.jking412.tagle.tagleenum;

import lombok.Getter;

@Getter
public enum Message {

    //31 红色
    //32 黄色
    //36 绿色

    inputOrderMsg("输入值是选项前的序号","msg",31),
    noContentMsg("当前条目没有内容，请先去添加内容","tip",32),
    successMsg("操作成功","tip",36),
    failMsg("操作失败","tip",32),
    inputIntError("输入值应该是一个整数","error",31),
    outRangeError("输入值不在合法范围内","error",31),
    inputParseError("你的输入无法被解析","error",31);

    private String message;
    private String type;

    private int color;

    Message(String message, String type,int color){
        this.message = message;
        this.type = type;
        this.color = color;
    }
}
