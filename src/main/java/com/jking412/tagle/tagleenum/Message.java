package com.jking412.tagle.tagleenum;

import lombok.Getter;

@Getter
public enum Message {

    inputOrderMsg("输入值是选项前的序号","msg"),
    noContentMsg("当前条目没有内容，请先去添加内容","tip"),
    successMsg("操作成功","tip"),
    failMsg("操作失败","tip"),
    inputIntError("输入值应该是一个整数","error"),
    outRangeError("输入值不在合法范围内","error"),
    inputParseError("你的输入无法被解析","error");

    private String message;
    private String type;

    Message(String message, String type){
        this.message = message;
        this.type = type;
    }
}
