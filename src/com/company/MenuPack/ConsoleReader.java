package com.company.MenuPack;

import com.company.db.BatchConnector;
import com.company.entity.Batch;
import com.company.entity.Factory;
import com.company.entity.Production;
import com.company.util.TimestampUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Scanner;

public class ConsoleReader {

    private static final Scanner scanner = new Scanner(System.in);

    public static int userIntChoice(String ss) {
        System.out.print(ss);
        String s = scanner.nextLine();
        if (s.isEmpty()) return 0;
        else
            return Integer.parseInt(s);
    }

    public static String userStringChoice(String ss) {
        System.out.print(ss);
        return scanner.nextLine();
    }







}
