package com.company.MenuPack;

import com.company.db.BatchConnector;
import com.company.db.ProductionConnector;
import com.company.entity.Batch;
import com.company.entity.Production;

import java.sql.SQLException;

public class EnterProductionData {

    public static Production enterProductionForAdd(String s) {
        while (true) {
            Production production = enterProductionData(s);
            if (production.getName().isEmpty() || production.getCode().isEmpty() ||
                    production.getVolume()==0)
                System.out.println("Введите все данные!!!!");
            else return production;
        }
    }

    public static Production enterProductionForUpdate(String s) throws SQLException{
        int prodId = ConsoleReader.userIntChoice(s);
        Production p = ProductionConnector.getById(prodId);
        System.out.println(p);

        Production prodEnter = enterProductionData("Введите новые данные:");
         if (!prodEnter.getName().isEmpty()) p.setName(prodEnter.getName());
         if (!prodEnter.getCode().isEmpty()) p.setCode(prodEnter.getCode());
         if (prodEnter.getVolume() !=0) p.setVolume(prodEnter.getVolume());

            return p;
    }

    public static Production enterProductionData(String s) {
        System.out.println(s);
        String name = ConsoleReader.userStringChoice("Введите наименование: ");
        String code = ConsoleReader.userStringChoice("Введите артикул: ");
        int volume = ConsoleReader.userIntChoice("Введите объем: ");

        return Production.createItemForSaving(name, code, volume);
    }
}
