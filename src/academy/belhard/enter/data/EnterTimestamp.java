package academy.belhard.enter.data;

import academy.belhard.actions.ConsoleReader;
import academy.belhard.util.TimestampUtil;

import java.sql.Timestamp;
import java.text.ParseException;

public class EnterTimestamp {

    public static Timestamp enterForObject(String s) {
        Timestamp timestamp = null;
        while (true) {
            try {
                String date = ConsoleReader.userStringChoice(s);
                if (date.equals("")) break;
                timestamp = TimestampUtil.stringToTimestamp(date);
                break;
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Введите дату корректно в виде (2020-11-11 12:30)");
            }
        }

        return timestamp;
    }

    public static Timestamp enterForSqlQuery(String s) {
        Timestamp timestamp = null;
        while (true) {
            try {
                String date = ConsoleReader.userStringChoice(s);
                if (date.equals("")) break;
                date = date + " 00:00";
                timestamp = TimestampUtil.stringToTimestamp(date);
                break;
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Введите дату корректно в виде (2020-11-20)");
            }
        }

        return timestamp;
    }


}
