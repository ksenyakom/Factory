package academy.belhard.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimestampUtil {


    public static Timestamp stringToTimestamp(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date date;
        date = sdf.parse(s);
        return new Timestamp(date.getTime());
    }


    public static Timestamp getNowSqlTimestamp() {
        java.util.Date utilDate = new  java.util.Date();
        return new java.sql.Timestamp(utilDate.getTime());
    }

    public static String toString(Timestamp timestamp){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (timestamp != null)  return sdf.format(timestamp.getTime());
        else return " - ";
    }
}
