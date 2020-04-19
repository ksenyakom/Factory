package com.company.MenuPack;

import com.company.db.BatchConnector;
import com.company.entity.Batch;
import com.company.util.TimestampUtil;

import java.sql.SQLException;
import java.sql.Timestamp;

public class EnterBatchData {

    public static Batch enterBatchDataForAdd(String s) {
        System.out.println(s);
        while (true) {

            Batch batchEnter = enterBatchData(false);

            if ((batchEnter.getBatchNumber() == 0) || (batchEnter.getBatchValue() == 0) ||
                    (batchEnter.getProductionId() == 0) || (batchEnter.getFactoryId() == 0)) {
                System.out.println("Введите все данные!!!!");

            } else
                return batchEnter;
        }
    }

    public static Batch enterBatchDataForUpdate(String s) throws SQLException {
        int batchId = ConsoleReader.userIntChoice(s);
        Batch b = BatchConnector.getById(batchId);
        System.out.println(b);

        System.out.println("Введите новые данные:");
        Batch batchEnter = enterBatchData(true);

        if (batchEnter.getBatchNumber() > 0) b.setBatchNumber(batchEnter.getBatchNumber());
        if (batchEnter.getBatchValue() > 0) b.setBatchValue(batchEnter.getBatchValue());
        if (batchEnter.getBatchDate() != null) b.setBatchDate(batchEnter.getBatchDate());
        if (batchEnter.getProductionId() != 0) b.setProductionId(batchEnter.getProductionId());
        if (batchEnter.getFactoryId() != 0) b.setFactoryId(batchEnter.getFactoryId());
        return b;
    }

    
    private static Batch enterBatchData(boolean update) {
        int batchNumber = ConsoleReader.userIntChoice("Введите номер партии: ");
        int batchValue = ConsoleReader.userIntChoice("Введите объем партии: ");

        Timestamp batchDate;
        if (update) { // при обновлении объекта
             batchDate = EnterTimestamp.enterForObject("Введите дату партии (2020-11-11 12:30): ");
        }else {// При добавлении нового объекта
            batchDate = EnterTimestamp.enterForObject("Введите дату партии (2020-11-11 12:30), Enter - ввести сегодняшнюю: ");
            if (batchDate == null) batchDate = TimestampUtil.getNowSqlTimestamp();
        }

        int productionId = ConsoleReader.userIntChoice("Введите id продукции: ");
        int factoryId = ConsoleReader.userIntChoice("Введите id завода: ");

        return Batch.createItemForSaving(batchNumber, batchValue, batchDate, productionId, factoryId);
    }








}
