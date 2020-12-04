package com.offcn.shop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2020/11/24 0024.
 */
public class StrToDate {
    public static Date getDate(String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date =null;
        try{
            date=simpleDateFormat.parse(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  date;
    }
}
