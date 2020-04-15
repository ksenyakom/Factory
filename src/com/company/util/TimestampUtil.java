package com.company.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimestampUtil {

    public static Timestamp stringToTimestamp(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date date;
        date = sdf.parse(s);
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    public static Timestamp getNowSqlTimestamp() {
        java.util.Date utilDate = new  java.util.Date();
        java.sql.Timestamp sqlTs = new java.sql.Timestamp(utilDate.getTime());
        return sqlTs;
    }
}
