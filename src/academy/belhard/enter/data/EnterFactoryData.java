package academy.belhard.enter.data;

import academy.belhard.actions.ConsoleReader;
import academy.belhard.db.FactoryConnector;
import academy.belhard.entity.Factory;

import java.sql.SQLException;

public class EnterFactoryData {

    public static Factory enterFactoryForAdd(String s) {
        while (true) {
            Factory factory = EnterFactoryData.enterFactoryData(s);
            if (factory.getShortName().isEmpty() || factory.getFullName().isEmpty() ||
                    factory.getCity().isEmpty() || factory.getWorkersAmount() == 0)
                System.out.println("Введите все данные!!!!");
            else return factory;
        }
    }

    public static Factory enterFactoryForUpdate(String s) throws SQLException {
        int factoryId = ConsoleReader.userIntChoice(s);
        Factory f = FactoryConnector.getById(factoryId);
        System.out.println(f);

        Factory factoryEnter = enterFactoryData("Введите новые данные:");
        if (!factoryEnter.getFullName().isEmpty()) f.setFullName(factoryEnter.getFullName());
        if (!factoryEnter.getShortName().isEmpty()) f.setShortName(factoryEnter.getShortName());
        if (!factoryEnter.getCity().isEmpty()) f.setCity(factoryEnter.getCity());
        if (factoryEnter.getWorkersAmount() != 0) f.setWorkersAmount(factoryEnter.getWorkersAmount());

        return f;
    }

        public static Factory enterFactoryData(String s) {
            System.out.println(s);
            String fullName = ConsoleReader.userStringChoice("Введите полное наименование: ");
            String shortName = ConsoleReader.userStringChoice("Введите  краткое наименование: ");
            String city = ConsoleReader.userStringChoice("Введите город: ");
            int workersAmount = ConsoleReader.userIntChoice("Введите количесво работников: ");

            return Factory.createItemForSaving(fullName, shortName, city, workersAmount);
        }
    }
