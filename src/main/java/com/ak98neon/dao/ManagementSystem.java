package com.ak98neon.dao;

import lombok.extern.slf4j.Slf4j;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class ManagementSystem {
    private static Connection con;
    private static ManagementSystem instance;
    private static DataSource dataSource;

    private ManagementSystem() {
    }

    public static synchronized ManagementSystem getInstance() {
        if (instance == null) {
            try {
                instance = new ManagementSystem();
                Context ctx = new InitialContext();
                dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/Company");
                con = dataSource.getConnection();
            } catch (NamingException | SQLException e) {
                log.info("{}", e);
            }
        }
        return instance;
    }

    public static void createTable() {

    }
}
