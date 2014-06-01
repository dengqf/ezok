/*
 * DateUtil.java 
 * Version: 2.01   2014-4-2
 * 
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-4-2
 */
public class DateUtil {
    //    private static String defaultFormat = "yy-MM-dd HH:mm:ss";
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parseDate(String dateStr) {
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String parseDateStr(Date date) {
        String str = "";
        if (date != null) {
            str = format.format(date);

        }
        return str;
    }

    public static String parseDateStr(Date date,String format) {
        String str = "";
        SimpleDateFormat example = new SimpleDateFormat(format);
        if (date != null) {
            str = example.format(date);

        }
        return str;
    }
}
