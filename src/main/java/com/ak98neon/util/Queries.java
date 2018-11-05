package com.ak98neon.util;

import com.ak98neon.model.Department;

public final class Queries {
    private Queries() {
    }

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + Department.TABLE_NAME + " (" + Department.ID_COLUMN + " INT NOT NULL AUTO_INCREMENT UNIQUE, "
            + Department.NAME_COLUMN + " VARCHAR(45) NOT NULL, "
            + "PRIMARY KEY(ID))";
    public static final String SELECT_DEPARTMENT = "SELECT id, name FROM " + Department.TABLE_NAME + " WHERE ID = ?";
    public static final String INSERT_DEPARTMENT = "INSERT INTO " + Department.TABLE_NAME + " (NAME) VALUES (?);";
    public static final String DELETE_DEPARTMENT = "DELETE FROM " + Department.TABLE_NAME + " WHERE " + Department.ID_COLUMN + " = ?;";
    public static final String SELECT_ALL_DEPARTMENT = "SELECT " +  Department.ID_COLUMN + ", "+ Department.NAME_COLUMN + " FROM " + Department.TABLE_NAME + ";";
    public static final String DROP_TABLE = "DROP TABLE " + Department.TABLE_NAME +";";
    public static final String UPDATE_DEPARTMENT = "UPDATE " + Department.TABLE_NAME + " SET " + Department.NAME_COLUMN + "= ? WHERE " + Department.ID_COLUMN + " = ?";
}
