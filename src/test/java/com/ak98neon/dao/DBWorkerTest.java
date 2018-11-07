package com.ak98neon.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DBWorkerTest {

    @Test
    public void connection_GetConnection_Connection() throws SQLException {
        Connection connection = DBWorker.getConnection();
        assertNotNull(connection);
    }
}