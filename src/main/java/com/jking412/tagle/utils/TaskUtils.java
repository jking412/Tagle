package com.jking412.tagle.utils;

import com.jking412.tagle.tagleenum.Message;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskUtils {
    public static int readInt(){
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        while (scanner.hasNext()){
            try {
                value = scanner.nextInt();
            }catch (InputMismatchException e){
                MenuUtils.outputMsg(Message.inputIntError);
                continue;
            }
            break;
        }
        return value;
    }

    public static int readInt(int minValue,int maxValue){
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        while (scanner.hasNext()){
            try {
                value = scanner.nextInt();
            }catch (InputMismatchException e){
                MenuUtils.outputMsg(Message.inputIntError);
                continue;
            }
            if(value < minValue || value > maxValue){
                MenuUtils.outputMsg(Message.outRangeError);
                continue;
            }
            break;
        }
        return value;
    }


}
