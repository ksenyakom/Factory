package com.company.db;

import com.company.entity.Batch;
import com.company.entity.Factory;
import com.company.entity.FullInfo;
import com.company.entity.Production;
import com.company.util.BatchUtil;
import com.company.util.FactoryUtil;
import com.company.util.ProductionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FullInfoConnector {

    private static final String JOIN_YEAR = "SELECT * " +
            "FROM factory f JOIN  batch b ON (b.factory_id = f.id) JOIN production p ON (b.production_id = p.id)" +
            "WHERE  EXTRACT(YEAR FROM b.batch_date) = ? ";
    private static final String JOIN_MONTH = "SELECT * " +
            "FROM factory f JOIN  batch b ON (b.factory_id = f.id) JOIN production p ON (b.production_id = p.id)" +
            "WHERE  EXTRACT(YEAR FROM b.batch_date) = ? AND EXTRACT(MONTH FROM b.batch_date) = ?";

    public static List<FullInfo> getFullInfoYear(int year) throws SQLException {
        List<FullInfo> list = new ArrayList<>();

        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(JOIN_YEAR)) {
            statement.setInt(1, year);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // посмотреть список столбцов
//                ResultSetMetaData metadata = resultSet.getMetaData();
//                for (int i = 1; i <= metadata.getColumnCount(); i++) {
//                    System.out.println(metadata.getColumnName(i));
//                }
                Factory factory = FactoryUtil.toObject(resultSet);
                Batch batch = BatchUtil.toObject(resultSet);
                batch.setId(resultSet.getInt(6)); // ай некрасиво(( Как красиво сделать чтобы id выгребать из resultset?

                Production production = ProductionUtil.toObject(resultSet);
                production.setId(resultSet.getInt(12)); //  и это тоже некрасиво

                FullInfo fullInfo = new FullInfo(batch, production, factory);
                list.add(fullInfo);
            }
            resultSet.close();
        }
        return list;
    }


}
