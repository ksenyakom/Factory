package academy.belhard.util;

import academy.belhard.db.FactoryConnector;
import academy.belhard.entity.Factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FactoryUtil {
    public static Factory toObject(ResultSet resultSet) throws SQLException {

        int id =  resultSet.getInt("id");
        String fullName = resultSet.getString("full_name");
        String shortName = resultSet.getString("short_name");
        String city = resultSet.getString("city");
        int workersAmount = resultSet.getInt("workers_amount");

        return new Factory(id, fullName,shortName, city, workersAmount);

    }
    public static void showAllFactory () throws SQLException {
        List<Factory> list = FactoryConnector.getAll();
        for (Factory item : list) {
            System.out.println(item);
        }
    }
}
