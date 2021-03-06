package com.ak98neon.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class DBWorkerTest {

    @Test
    public void connection_GetConnection_Connection() throws SQLException {
        Connection connection = DBWorker.getConnection();
        assertNotNull(connection);
    }
}