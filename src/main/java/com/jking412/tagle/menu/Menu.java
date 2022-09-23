package com.jking412.tagle.menu;

import java.io.*;
import java.util.Scanner;

public class Menu {
    public static String defaultBanner = " _________  ________  ________  ___       _______      \n" +
            "|\\___   ___\\\\   __  \\|\\   ____\\|\\  \\     |\\  ___ \\     \n" +
            "\\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\___|\\ \\  \\    \\ \\   __/|    \n" +
            "     \\ \\  \\ \\ \\   __  \\ \\  \\  __\\ \\  \\    \\ \\  \\_|/__  \n" +
            "      \\ \\  \\ \\ \\  \\ \\  \\ \\  \\|\\  \\ \\  \\____\\ \\  \\_|\\ \\ \n" +
            "       \\ \\__\\ \\ \\__\\ \\__\\ \\_______\\ \\_______\\ \\_______\\\n" +
            "        \\|__|  \\|__|\\|__|\\|_______|\\|_______|\\|_______|\n";
    public static void outPutBanner() throws Exception{
        File file = new File("banner.txt");
        if(!file.exists()){
            System.out.println(defaultBanner);
            return;
        }
        OutputStream outputStream = new PrintStream(System.out);
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        for(int i = 0 ; i < len ; i++){
            outputStream.write(bytes[i]);
        }
    }
    public static void mainMenu() {
        System.out.println("1.日常任务");
        System.out.println("2.我的习惯");
        System.out.println("3.定制奖惩项");
        System.out.println("4.积分记录");
        System.out.println("5.退出");
//        System.out.println("请输入序号：");
    }

    public static void dailyTaskMenu() {
        System.out.println("1.添加任务");
        System.out.println("2.删除任务");
        System.out.println("3.修改任务");
        System.out.println("4.查看任务");
        System.out.println("5.修改完成情况");
        System.out.println("6.返回上一级");
//        System.out.println("请输入序号：");
    }


    public static void habitTaskMenu() {
        System.out.println("1.添加习惯");
        System.out.println("2.删除习惯");
        System.out.println("3.修改习惯");
        System.out.println("4.查看习惯");
        System.out.println("5.修改完成情况");
        System.out.println("6.返回上一级");
//        System.out.println("请输入序号：");
    }

    public static void rewardPunishmentMenu() {
        System.out.println("1.添加奖惩项");
        System.out.println("2.删除奖惩项");
        System.out.println("3.修改奖惩项");
        System.out.println("4.查看奖惩项");
        System.out.println("5.修改完成情况");
        System.out.println("6.返回上一级");
//        System.out.println("请输入序号：");
    }

    public static void operationMenu() {
        System.out.println("1.查看积分记录");
        System.out.println("2.给记录添加备注");
        System.out.println("3.返回上一级");
//        System.out.println("请输入序号：");
    }
}
