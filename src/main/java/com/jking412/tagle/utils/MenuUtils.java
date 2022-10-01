package com.jking412.tagle.utils;

import com.jking412.tagle.tagleenum.Message;

public class MenuUtils {

    /**
     * @param colour  颜色代号：背景颜色代号(41-46)；前景色代号(31-36)
     * @param content 要打印的内容
     */
    private static String getFormatLogString(String content, int colour) {
        return String.format("\033[%dm%s\033[0m", colour, content);
    }
    public static void outputMsg(Message message){
        String type = message.getType();
        if(type.equals("msg")){
            System.out.println("请你输入一个值");
            System.out.println(getFormatLogString(message.getMessage(), message.getColor()));
        }else if(type.equals("error")){
            System.out.println("输入错误，请重新输入");
            System.out.println(getFormatLogString(message.getMessage(), message.getColor()));
        } else if (type.equals("tip")) {
            System.out.println(getFormatLogString(message.getMessage(), message.getColor()));
        }
    }
}
