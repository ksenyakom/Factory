package com.company;

import com.company.MenuPack.ConsoleReader;
import com.company.MenuPack.EnterBatchData;
import com.company.MenuPack.EnterFactoryData;
import com.company.MenuPack.EnterProductionData;
import com.company.db.BatchConnector;
import com.company.db.FactoryConnector;
import com.company.db.ProductionConnector;
import com.company.entity.Batch;
import com.company.entity.Factory;
import com.company.entity.Production;
import com.company.util.BatchUtil;
import com.company.util.FactoryUtil;
import com.company.util.ProductionUtil;
import org.postgresql.util.PSQLException;

import java.sql.SQLException;

public class UserActions {

// Batch
    public static void addBatch() throws SQLException {
        Batch batch = EnterBatchData.enterBatchDataForAdd("Введите данные новой партии: ");
            BatchConnector.add(batch);
            System.out.println("Сохранено: ");
            BatchUtil.showAllBatch();
    }
    public static void updateBatch() throws SQLException,PSQLException{
            Batch batch = EnterBatchData.enterBatchDataForUpdate("Введите ID партии для редактирования:");
            BatchConnector.update(batch);
            System.out.println("Сохранено: ");
            System.out.println(BatchConnector.getById(batch.getId()));
    }
    public static void deleteBatch() throws SQLException {
        int id = ConsoleReader.userIntChoice("Введите ID партии для удаления:");
        if (BatchConnector.deleteById(id)) {
            System.out.println("Запись удалена.");
            BatchUtil.showAllBatch();
        } else System.out.println("Нет такой партии\n");
    }
    public static void getByIdBatch() throws SQLException,PSQLException {
        int id = ConsoleReader.userIntChoice("Введите ID ");
        Batch batch = BatchConnector.getById(id);
        System.out.println(batch);
    }

//Production
    public static void addProduction() throws SQLException {
        Production production = EnterProductionData.enterProductionForAdd("Введите данные новой продукции: ");
        ProductionConnector.add(production);
        System.out.println("Сохранено: ");
        ProductionUtil.showAllProduction();
    }

    public static void updateProduction() throws SQLException {
        Production production = EnterProductionData.enterProductionForUpdate("Введите ID для редактирования: ");
        ProductionConnector.update(production);
        System.out.println("Сохранено: ");
        System.out.println(ProductionConnector.getById(production.getId()));
    }
    public static void getByIdProduction() throws SQLException {
        int id = ConsoleReader.userIntChoice("Введите ID ");
        Production production= ProductionConnector.getById(id);
        System.out.println(production);
    }

    public static void deleteProduction() throws SQLException {
        int id = ConsoleReader.userIntChoice("Введите ID продукта для удаления:");
        if (ProductionConnector.deleteById(id)) {
            System.out.println("Запись удалена.");
            ProductionUtil.showAllProduction();
        } else System.out.println("Нет такого продукта или запись используется в другой таблице\n");
    }

// Factory
    public static void addFactory() throws SQLException {
        Factory factory = EnterFactoryData.enterFactoryForAdd("Введите данные нового Завода: ");
        FactoryConnector.add(factory);
        System.out.println("Сохранено: ");
        FactoryUtil.showAllFactory();
    }

    public static void updateFactory() throws SQLException {
        Factory factory = EnterFactoryData.enterFactoryForUpdate("Введите ID завода для редактирования: ");
        FactoryConnector.update(factory);
        System.out.println("Сохранено: ");
        System.out.println( FactoryConnector.getById(factory.getId()));
    }
    public static void deleteFactory() throws SQLException {
        int id = ConsoleReader.userIntChoice("Введите ID завода для удаления:");
        if (FactoryConnector.deleteById(id)) {
            System.out.println("Запись удалена.");
            FactoryUtil.showAllFactory();
        } else System.out.println("Нет такого завода или запись используется в другой таблице\n");
    }
    public static void getByIdFactory() throws SQLException {
        int id = ConsoleReader.userIntChoice("Введите ID ");
        Factory factory= FactoryConnector.getById(id);
        System.out.println(factory);
    }

}
