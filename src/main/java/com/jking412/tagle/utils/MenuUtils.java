package com.jking412.tagle.utils;

import com.jking412.tagle.tagleenum.Message;

public class MenuUtils {
    public static void outputMsg(Message message){
        String type = message.getType();
        if(type.equals("msg")){
            System.out.println("请你输入一个值");
            System.out.println(message.getMessage());
        }else if(type.equals("error")){
            System.out.println("输入错误，请重新输入");
            System.out.println(message.getMessage());
        } else if (type.equals("tip")) {
            System.out.println(message.getMessage());
        }
    }
}
