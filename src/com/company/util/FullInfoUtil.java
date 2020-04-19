package com.company.util;

import com.company.entity.Batch;
import com.company.entity.Factory;
import com.company.entity.FullInfo;
import com.company.entity.Production;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FullInfoUtil {

    public static FullInfo ToObject(ResultSet resultSet) throws SQLException {
        Factory factory = FactoryUtil.toObject(resultSet);
        factory.setId(resultSet.getInt("id"));

        Batch batch = BatchUtil.toObject(resultSet);
        batch.setId(resultSet.getInt("b_id"));

        Production production = ProductionUtil.toObject(resultSet);
        production.setId(resultSet.getInt("p_id"));

        return new FullInfo(batch, production, factory);
    }

    public static void showFullInfo(List<FullInfo> fullInfo) {
        fullInfo.forEach(System.out::println);
    }
}
