package com.utils.database.factory;

import com.utils.database.interfaces.IDatabase;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Data
public class ConexionPG implements IDatabase {

    private String DATABASE_DRIVER;
    private String DATABASE_URL;
    private String USERNAME;
    private String PASSWORD;
    private String MAX_POOL;

    private Connection connection;
    Properties properties;

    public ConexionPG() {
        this.DATABASE_DRIVER = "org.postgresql.Driver";
        this.DATABASE_URL = "jdbc:postgresql://localhost:5432/Athena";
        this.USERNAME = "admin_db";
        this.PASSWORD = "admin_12345678";
        this.MAX_POOL = "250";
    }

    public ConexionPG(Properties properties) {
        this.properties = new Properties();
       
        this.DATABASE_DRIVER = properties.getProperty("DATABASE_DRIVER");
        this.DATABASE_URL = properties.getProperty("DATABASE_URL");
        this.MAX_POOL = properties.getProperty("MAX_POOL");

        this.properties.setProperty("user", properties.getProperty("user"));
        this.properties.setProperty("password", properties.getProperty("password"));
    }

    @Override
    public Connection Connect() {
        System.out.println("Conectando con PG");

        if (this.connection == null) {
            try {
                Class.forName(this.getDATABASE_DRIVER());
                this.connection = (Connection) DriverManager.getConnection(this.getDATABASE_URL(), this.properties);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return this.connection;
    }

    @Override
    public void Disconnect() {
        System.out.println("Desconectando de PG");

        if (this.connection != null) {
            try {
                this.connection.close();
                this.connection = null;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
