package com.company.util;

import com.company.db.ProductionConnector;
import com.company.entity.Production;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class ProductionUtil {
    public static Production toObject(ResultSet resultSet) throws SQLException {
        int id =  resultSet.getInt("id");
        String name = resultSet.getString("name");
        String code = resultSet.getString("code");
        int volume = resultSet.getInt("volume");
        Timestamp createdAt = resultSet.getTimestamp ("created_at");
        Timestamp updatedAt = resultSet.getTimestamp("updated_at");

        return new Production(id, name,code,volume, createdAt,updatedAt);
    }

    public static void showAllProduction () throws SQLException {
        List<Production> list = ProductionConnector.getAll();
        for (Production item : list) {
            System.out.println(item);
        }
    }
}
