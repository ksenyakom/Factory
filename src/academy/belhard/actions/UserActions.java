package academy.belhard.actions;

import academy.belhard.db.BatchConnector;
import academy.belhard.db.FactoryConnector;
import academy.belhard.db.FullInfoConnector;
import academy.belhard.db.ProductionConnector;
import academy.belhard.enter.data.EnterBatchData;
import academy.belhard.enter.data.EnterFactoryData;
import academy.belhard.enter.data.EnterProductionData;
import academy.belhard.enter.data.EnterTimestamp;
import academy.belhard.entity.Batch;
import academy.belhard.entity.Factory;
import academy.belhard.entity.FullInfo;
import academy.belhard.entity.Production;
import academy.belhard.util.BatchUtil;
import academy.belhard.util.FactoryUtil;
import academy.belhard.util.FullInfoUtil;
import academy.belhard.util.ProductionUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class UserActions {

    // FullInfo
    public static void getReportForPeriod() throws SQLException {
        Timestamp ts1 = EnterTimestamp.enterForSqlQuery("Вывести отчет с (YYYY-MM-DD): ");
        Timestamp ts2 = EnterTimestamp.enterForSqlQuery(" по (YYYY-MM-DD): ");

        if (ts2.after(ts1)) {

            List<FullInfo> list = FullInfoConnector.getJoinForPeriod(ts1, ts2);
            FullInfoUtil.showFullInfo(list);
        }else System.out.println("Ошибка. Вторая дата раньше первой");
    }

    public static void getFullReport() throws SQLException {
        List<FullInfo> list = FullInfoConnector.getFullJoin();
        FullInfoUtil.showFullInfo(list);
    }

    public static void getReportByFactoryId() throws SQLException {
        int id = ConsoleReader.userIntChoice("Введите id завода: ");
        List<FullInfo> list = FullInfoConnector.getFullInfoByID(id);
        FullInfoUtil.showFullInfo(list);
    }


    // Batch
    public static void addBatch() throws SQLException {
        Batch batch = EnterBatchData.enterBatchDataForAdd("Введите данные новой партии: ");
        BatchConnector.add(batch);
        System.out.println("Сохранено: ");
        BatchUtil.showAllBatch();
    }

    public static void updateBatch() throws SQLException {
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

    public static void getByIdBatch() throws SQLException {
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
        Production production = ProductionConnector.getById(id);
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
        System.out.println(FactoryConnector.getById(factory.getId()));
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
        Factory factory = FactoryConnector.getById(id);
        System.out.println(factory);
    }

}
