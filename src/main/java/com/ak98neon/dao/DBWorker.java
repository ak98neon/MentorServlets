package com.ak98neon.dao;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public final class DBWorker {
    private static Connection connection = null;
    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASS = "";

    private DBWorker() {
    }

    /**
     * The method creates a connection if it does not exist.
     *
     * @return Connection
     * @throws SQLException if connection is null
     */
    public synchronized static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException e) {
                log.info("{}", e);
            }
            connection = DriverManager.getConnection(URL, USER, PASS);
            return connection;
        } else {
            return connection;
        }
    }
}
