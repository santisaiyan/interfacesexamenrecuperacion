package org.example.santiexameninterfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {

    static private final Connection con;

    static{
        try {
            con =  DriverManager.getConnection("jdbc:mysql://localhost/mi_bd_alumnos","root","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        return con;
    }
}