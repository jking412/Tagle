package com.jking412.tagle.common;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.jking412.tagle.tagleenum.DailyTaskStatus;

public class DailyTaskConvert implements Converter<DailyTaskStatus> {

    @Override
    public DailyTaskStatus convertToJavaData(ReadCellData readCellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if(readCellData.getStringValue().equals("未完成")) {
            return DailyTaskStatus.UNFINISHED;
        }else if(readCellData.getStringValue().equals("已完成")){
            return DailyTaskStatus.FINISHED;
        }else if(readCellData.getStringValue().equals("已放弃")){
            return DailyTaskStatus.ABANDONED;
        }
        return DailyTaskStatus.UNFINISHED;
    }

    @Override
    public WriteCellData<?> convertToExcelData(DailyTaskStatus value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new WriteCellData<>(value.getStatusString());
    }
}
