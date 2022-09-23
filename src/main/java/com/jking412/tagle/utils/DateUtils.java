package com.jking412.tagle.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    public static String getDate(int day){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(date.getTime() + 60 * 60 * 24 * 1000L * day));
    }

    public static boolean checkDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            sdf.parse(date);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
