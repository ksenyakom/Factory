package com.company;

import com.company.MenuPack.ConsoleReader;
import com.company.MenuPack.ShowMenu;
import com.company.db.*;
import com.company.entity.*;
import com.company.util.*;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.List;

public class Main {
    public static int userChoice;

    public static void main(String[] args) {
        try {
            boolean cycle = true;
            while (cycle) {
                ShowMenu.showMainMenu();
                userChoice = ConsoleReader.userIntChoice("");
                switch (userChoice) {
                    case 1:
                        FactoryUtil.showAllFactory();
                        secondMenu();
                        break;
                    case 2:
                        BatchUtil.showAllBatch();
                        secondMenu();
                        break;
                    case 3:
                        ProductionUtil.showAllProduction();
                        secondMenu();
                        break;
                    case 4:
                        List<FullInfo> fullInfo = FullInfoConnector.getFullInfoYear(2020);
                        fullInfo.forEach(System.out::println);
                        break;
                    case 5:
                        cycle = false;
                        break;
                    default:
                        System.out.println("Введенная команда не существует или не реализована.");
                        break;
                }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        System.out.println("Программа завершена.");
    }

    public static void secondMenu() throws SQLException {

        boolean cycle = true;
        while (cycle) {
            ShowMenu.showSecondMenu();
            int userChoice1 = ConsoleReader.userIntChoice("");
try {
    switch (userChoice1) {
        case (1): {
            if (userChoice == 1) UserActions.addFactory();
            if (userChoice == 2) UserActions.addBatch();
            if (userChoice == 3) UserActions.addProduction();
            break;
        }
        case (2): {
            if (userChoice == 1) UserActions.updateFactory();
            if (userChoice == 2) UserActions.updateBatch();
            if (userChoice == 3) UserActions.updateProduction();
            break;
        }
        case (3): {
            if (userChoice == 1) UserActions.deleteFactory();
            if (userChoice == 2) UserActions.deleteBatch();
            if (userChoice == 3) UserActions.deleteProduction();
            break;
        }
        case (4): {
            if (userChoice == 1) UserActions.getByIdFactory();
            if (userChoice == 2) UserActions.getByIdBatch();
            if (userChoice == 3) UserActions.getByIdProduction();
            break;
        }
        case (5): {
            cycle = false;
        }

    }
} catch (PSQLException e){
    System.out.println("Нет такого айди!!!!");
}
        }

    }


}
