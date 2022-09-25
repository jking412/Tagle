package com.jking412.tagle.tagleenum;

public enum DailyTaskStatus {
    UNFINISHED(0),
    FINISHED(1),
    ABANDONED(2);

    private int status;

    DailyTaskStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusString(){
        switch (status){
            case 0:
                return "未完成";
            case 1:
                return "已完成";
            case 2:
                return "已放弃";
            default:
                return "未完成";
        }
    }

}
