package com.company.db;

import com.company.entity.Batch;
import com.company.entity.Factory;
import com.company.entity.FullInfo;
import com.company.entity.Production;
import com.company.util.BatchUtil;
import com.company.util.FactoryUtil;
import com.company.util.FullInfoUtil;
import com.company.util.ProductionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FullInfoConnector {

    private static final String JOIN_YEAR = "SELECT b.id AS b_id, f.id, batch_number,batch_value,batch_date,production_id," +
            " factory_id, full_name, short_name, city, workers_amount, name, code, volume, created_at, updated_at " +
            "FROM factory f JOIN  batch b ON (b.factory_id = f.id) JOIN production p ON (b.production_id = p.id)" +
            "WHERE  EXTRACT(YEAR FROM b.batch_date) = ? ";
    private static final String JOIN_MONTH = "SELECT *   " +
            "FROM factory f JOIN  batch b ON (b.factory_id = f.id) JOIN production p ON (b.production_id = p.id)" +
            "WHERE  EXTRACT(YEAR FROM b.batch_date) = ? AND EXTRACT(MONTH FROM b.batch_date) = ?";

    public static List<FullInfo> getFullInfoYear(int year) throws SQLException {
        List<FullInfo> list = new ArrayList<>();

        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(JOIN_YEAR)) {
            statement.setInt(1, year);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FullInfo fullInfo = FullInfoUtil.ToObject(resultSet);
                list.add(fullInfo);
            }
            resultSet.close();
        }
        return list;
    }



    public static List<FullInfo> getFullInfoMonth(int year, int month) throws SQLException {
        List<FullInfo> list = new ArrayList<>();

        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(JOIN_MONTH)) {
            statement.setInt(1, year);
            statement.setInt(2, month);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FullInfo fullInfo = FullInfoUtil.ToObject(resultSet);
                list.add(fullInfo);
            }
            resultSet.close();
        }
        return list;
    }


}
