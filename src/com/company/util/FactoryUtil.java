package com.company.util;

import com.company.entity.Factory;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class FactoryUtil {
    public static Factory toObject(ResultSet resultSet) throws SQLException {
//        ResultSetMetaData metadata =  resultSet.getMetaData();
//        for(int i =1; i<= metadata.getColumnCount();i++) {
//            System.out.println(metadata.getColumnName(i));
//        }

        int id =  resultSet.getInt("id");
        String fullName = resultSet.getString("full_name");
        String shortName = resultSet.getString("short_name");
        String city = resultSet.getString("city");
        int workersAmount = resultSet.getInt("workers_amount");


        return new Factory(id, fullName,shortName, city, workersAmount);



    }



}
