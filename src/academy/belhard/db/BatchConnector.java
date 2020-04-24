package academy.belhard.db;

import academy.belhard.entity.Batch;
import academy.belhard.util.BatchUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchConnector {
    private static final String SELECT_ALL = "SELECT * FROM batch ORDER BY id ASC";
    public static final String SELECT_BY_ID = "SELECT * FROM batch WHERE id = ?";
    private static final String ADD = "INSERT INTO batch (batch_number, batch_value, batch_date, production_id, factory_id) VALUES (?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM batch WHERE id = ?";
    private static final String UPDATE = "UPDATE batch SET batch_number = ?, batch_value= ?, batch_date =?, production_id=?, factory_id =?  WHERE id = ?";


    public static List<Batch> getAll() throws SQLException {
        List<Batch> list = new ArrayList<>();

        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Batch batch = BatchUtil.toObject(resultSet);
                list.add(batch);
            }
        }
        return list;
    }


    public static Batch getById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();
        Batch batch;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            batch = BatchUtil.toObject(resultSet);
            resultSet.close();
            return batch;
        }
    }


    public static void add(Batch batch) throws SQLException {
        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(ADD);
        ) {
            statement.setInt(1, batch.getBatchNumber());
            statement.setInt(2, batch.getBatchValue());
            statement.setTimestamp(3, batch.getBatchDate());
            statement.setInt(4, batch.getProductionId());
            statement.setInt(5, batch.getFactoryId());

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

    public static void update(Batch batch) throws SQLException {

        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE);
        ) {
            statement.setInt(1, batch.getBatchNumber());
            statement.setInt(2, batch.getBatchValue());
            statement.setTimestamp(3, batch.getBatchDate() );
            statement.setInt(4,batch.getProductionId());
            statement.setInt(5,batch.getFactoryId());
            statement.setInt(6, batch.getId());

            statement.executeUpdate();
        }

    }


}
