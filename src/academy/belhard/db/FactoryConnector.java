package academy.belhard.db;

import academy.belhard.entity.Factory;
import academy.belhard.util.FactoryUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FactoryConnector {
    private static final String SELECT_ALL = "SELECT * FROM factory ORDER BY id ASC";
    public static final String SELECT_BY_ID = "SELECT * FROM factory WHERE id = ?";
    private static final String ADD = "INSERT INTO factory (full_name, short_name, city, workers_amount) VALUES (?,?,?,?)";
    private static final String DELETE = "DELETE FROM factory WHERE id = ?";
    private static final String UPDATE = "UPDATE factory SET full_name = ?, short_name= ?, city =?, workers_amount=?  WHERE id = ?";


    public static List<Factory> getAll() throws SQLException {
        List<Factory> list = new ArrayList<>();

        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Factory factory = FactoryUtil.toObject(resultSet);
                list.add(factory);
            }
        }
        return list;
    }


    public static Factory getById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();
        Factory factory;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            factory = FactoryUtil.toObject(resultSet);
            resultSet.close();
            return factory;
        }
    }


    public static void add(Factory factory) throws SQLException {
        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(ADD);
        ) {
            statement.setString(1, factory.getFullName());
            statement.setString(2, factory.getShortName());
            statement.setString(3, factory.getCity());
            statement.setInt(4, factory.getWorkersAmount());
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

    public static void update(Factory factory) throws SQLException {

        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE);
        ) {
            statement.setString(1, factory.getFullName());
            statement.setString(2, factory.getShortName());
            statement.setString(3, factory.getCity());
            statement.setInt(4, factory.getWorkersAmount());
            statement.setInt(5, factory.getId());
            statement.executeUpdate();
        }

    }


}