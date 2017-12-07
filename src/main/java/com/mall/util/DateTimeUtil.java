package com.mall.util;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * Created by eid on 2017/12/5.
 */
public class DateTimeUtil {
    //joda-time
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    //str ->Date
    public static Date StrToDate(String datetimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(datetimeStr);
        return dateTime.toDate();
    }

    //Date->str
    public static String dateToStr(Date date){
        if (date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return  dateTime.toString(STANDARD_FORMAT);
    }
}
