package com.ak98neon.util;

import com.ak98neon.model.Department;

public final class Queries {
    private Queries() {
    }

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXIST "
            + Department.TABLE_NAME + " ( " + Department.ID_COLUMN + " INT NOT NULL AUTO_INCREMENT UNIQUE, "
            + Department.NAME_COLUMN + " VARCHAR(45) NOT NULL, "
            + "PRIMARY KEY(ID))";
    public static final String CREATE_TABLE2 = "CREATE TABLE IF NOT EXISTS "
            + "DEPARTMENT (ID INT NOT NULL AUTO_INCREMENT UNIQUE, "
            + "NAME VARCHAR(45) NOT NULL, "
            + "PRIMARY KEY(ID))";
    public static final String SELECT_DEPARTMENT = "SELECT id, name FROM " + Department.TABLE_NAME + " WHERE ID = ?";
    public static final String INSERT_DEPARTMENT = "INSERT INTO " + Department.TABLE_NAME + " (NAME) VALUES (?)";
    public static final String SELECT_ALL_DEPARTMENT = "SELECT * FROM " + Department.TABLE_NAME;
}
