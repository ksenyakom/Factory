package com.company.util;

import com.company.db.BatchConnector;
import com.company.entity.Batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class BatchUtil {
    public static Batch toObject(ResultSet resultSet) throws SQLException {
        int id =  resultSet.getInt("id");
        int batchNumber = resultSet.getInt("batch_number");
        int batchValue = resultSet.getInt("batch_value");
        Timestamp batchDate = resultSet.getTimestamp ("batch_date");
        int prodId = resultSet.getInt("production_id");
        int factId = resultSet.getInt("factory_id");

        return new Batch(id, batchNumber,batchValue, batchDate,prodId, factId);
    }

    public static void showAllBatch () throws SQLException {
        List<Batch> list = BatchConnector.getAll();
        for (Batch item : list) {
            System.out.println(item);
        }
    }


}
