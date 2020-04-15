package com.company;

import com.company.db.*;
import com.company.entity.*;
import com.company.util.*;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // ввод времени вручную
            //добавление add batch
//            String s = "2020-11-11 12:30";
//            Timestamp timestamp = TimestampUtil.stringToTimestamp(s);
//            Batch batch = Batch.createItemForSaving(123456789, 1000, timestamp, 5, 5);
//            BatchConnector.add(batch);
 //           showAllBatch();

            List<FullInfo> fullInfo = FullInfoConnector.getFullInfoYear(2020);
            for (FullInfo item : fullInfo) {
                System.out.println(item.toLongString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }






    public static void showAllBatch() throws SQLException {
        List<Batch> list = BatchConnector.getAll();
        for (Batch item : list) {
            System.out.println(item);
        }
    }


    public static void showAllProduction() throws SQLException {
        List<Production> list = ProductionConnector.getAll();
        for (Production item : list) {
            System.out.println(item);
        }
    }

    public static void showAllFactory() throws SQLException {
        List<Factory> list = FactoryConnector.getAll();
        for (Factory item : list) {
            System.out.println(item);
        }
    }
}
