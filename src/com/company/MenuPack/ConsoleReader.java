package com.company.MenuPack;

import java.util.Scanner;

public class ConsoleReader {

    private static final Scanner scanner = new Scanner(System.in);

    public static int userIntChoice(String ss){
        while (true) {
            try {
                System.out.print(ss);
                String s = scanner.nextLine();
                if (s.isEmpty()) return 0;
                else {
                    return Integer.parseInt(s);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Вы не ввели число.");
            }

        }
    }

    public static String userStringChoice(String ss) {
        System.out.print(ss);
        return scanner.nextLine();
    }


}
