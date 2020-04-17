package com.company.db;

import com.company.entity.Factory;
import com.company.entity.Production;
import com.company.util.FactoryUtil;
import com.company.util.ProductionUtil;
import com.company.util.TimestampUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductionConnector {

    private static final String SELECT_ALL = "SELECT * FROM production ORDER BY id ASC";
    public static final String SELECT_BY_ID = "SELECT * FROM production WHERE id = ?";
    private static final String ADD = "INSERT INTO production (name, code, volume) VALUES (?,?,?)";
    private static final String DELETE = "DELETE FROM production WHERE id = ?";
    private static final String UPDATE = "UPDATE production SET name = ?, code= ?, volume =?, updated_at=?  WHERE id = ?";


    public static List<Production> getAll() throws SQLException {
        List<Production> list = new ArrayList<>();

        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Production production = ProductionUtil.toObject(resultSet);
                list.add(production);
            }
        }
        return list;
    }


    public static Production getById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();
        Production production;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            production = ProductionUtil.toObject(resultSet);
            resultSet.close();
            return production;
        }
    }


    public static void add(Production production) throws SQLException {
        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(ADD);
        ) {
            statement.setString(1, production.getName());
            statement.setString(2, production.getCode());
            statement.setInt(3, production.getVolume());
            statement.executeUpdate();
        }
    }

    public static boolean deleteById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {

            statement.setInt(1, id);
            if (statement.executeUpdate() ==0) return false;
            else  return true;

        }
    }

    public static void update(Production production) throws SQLException {

        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE);
        ) {

            // Обновление времени
//            java.util.Date utilDate = new  java.util.Date();
//            java.sql.Timestamp sqlTs = new java.sql.Timestamp(utilDate.getTime());
            java.sql.Timestamp sqlTs = TimestampUtil.getNowSqlTimestamp();

            statement.setString(1, production.getName());
            statement.setString(2, production.getCode());
            statement.setInt(3, production.getVolume());
            statement.setTimestamp(4, sqlTs );
            statement.setInt(5, production.getId());

            statement.executeUpdate();
        }

    }

}
