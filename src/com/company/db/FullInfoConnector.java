package com.company.db;

import com.company.entity.FullInfo;
import com.company.util.FullInfoUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FullInfoConnector {

    private static final String JOIN_BY_FACTORY_ID = "SELECT b.id AS b_id, batch_number,batch_value,batch_date,production_id,factory_id," +
            " p.id AS p_id,name, code, volume, created_at, updated_at," +
            " f.id AS id,full_name, short_name, city, workers_amount " +
            " FROM factory f JOIN  batch b ON (b.factory_id = f.id) JOIN production p ON (b.production_id = p.id) " +
            " WHERE  f.id = ?";

    private static final String FULL_JOIN = "SELECT b.id AS b_id, batch_number,batch_value,batch_date,production_id,factory_id," +
            " p.id as p_id,name, code, volume, created_at, updated_at," +
            " f.id as id,full_name, short_name, city, workers_amount" +
            " FROM factory f FULL JOIN  batch b ON (b.factory_id = f.id)" +
            " FULL JOIN production p ON (b.production_id = p.id)";

    private static final String JOIN_FOR_PERIOD = "SELECT b.id AS b_id, batch_number,batch_value,batch_date,production_id,factory_id," +
            " p.id as p_id,name, code, volume, created_at, updated_at," +
            " f.id as id,full_name, short_name, city, workers_amount" +
            " FROM factory f  JOIN  batch b ON (b.factory_id = f.id)" +
            " JOIN production p ON (b.production_id = p.id) " +
            "WHERE  batch_date >= ?  and batch_date <=  ?  ";


    public static List<FullInfo> getJoinForPeriod(Timestamp ts1, Timestamp ts2) throws SQLException {
        List<FullInfo> list = new ArrayList<>();
        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(JOIN_FOR_PERIOD)) {

            statement.setTimestamp(1, ts1);
            statement.setTimestamp(2, ts2);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FullInfo fullInfo = FullInfoUtil.ToObject(resultSet);

                list.add(fullInfo);
            }
            resultSet.close();
        }
        return list;

    }

    public static List<FullInfo> getFullJoin() throws SQLException {

        List<FullInfo> list = new ArrayList<>();
        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FULL_JOIN)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FullInfo fullInfo = FullInfoUtil.ToObject(resultSet);
                list.add(fullInfo);
            }
            resultSet.close();
        }
        return list;

    }


    public static List<FullInfo> getFullInfoByID(int factoryId) throws SQLException {

        List<FullInfo> list = new ArrayList<>();
        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(JOIN_BY_FACTORY_ID)) {
            statement.setInt(1, factoryId);
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
