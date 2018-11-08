package com.ak98neon.util;

import com.ak98neon.model.Department;
import com.ak98neon.model.Employee;

public final class Queries {
    private static final String FROM = " FROM ";
    private static final String ADAPT_PARAM = " = ?;";
    private static final String SELECT = "SELECT ";
    private static final String WHERE = " WHERE ";

    private Queries() {
    }

    /**
     * DEPARTMENT QUERIES
     */
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + Department.TABLE_NAME + " (" + Department.ID_COLUMN + " INT NOT NULL AUTO_INCREMENT UNIQUE, "
            + Department.NAME_COLUMN + " VARCHAR(45) NOT NULL, "
            + "PRIMARY KEY(ID))";
    public static final String SELECT_DEPARTMENT = SELECT + Department.ID_COLUMN + ", " + Department.NAME_COLUMN + FROM + Department.TABLE_NAME
            + WHERE + Department.ID_COLUMN + " = ?";
    public static final String INSERT_DEPARTMENT = "INSERT INTO " + Department.TABLE_NAME + " (" + Department.NAME_COLUMN + ") " + "VALUES (?);";
    public static final String DELETE_DEPARTMENT = "DELETE FROM " + Department.TABLE_NAME + WHERE + Department.ID_COLUMN + ADAPT_PARAM;
    public static final String SELECT_ALL_DEPARTMENT = SELECT + Department.ID_COLUMN + ", " + Department.NAME_COLUMN + FROM + Department.TABLE_NAME + ";";
    public static final String DROP_TABLE = "DROP TABLE " + Department.TABLE_NAME + ";";
    public static final String UPDATE_DEPARTMENT = "UPDATE " + Department.TABLE_NAME + " SET " + Department.NAME_COLUMN + "= ? WHERE " + Department.ID_COLUMN + " = ?";

    /**
     * EMPLOYEE QUERIES
     */
    public static final String CREATE_TABLE_EMPLOYEE = "CREATE TABLE IF NOT EXISTS "
            + Employee.TABLE_NAME + " (" + Employee.ID_COLUMN + " INT NOT NULL AUTO_INCREMENT UNIQUE, "
            + Employee.NAME_COLUMN + " VARCHAR(45) NOT NULL, "
            + Employee.LAST_NAME_COLUMN + " VARCHAR(45), "
            + Employee.AGE_COLUMN + " INT, "
            + Employee.MAIL_COLUMN + " VARCHAR(45), "
            + Employee.DATE_OF_CREATE_COLUMN + " DATE, "
            + Employee.DEPARTMENT_ID + " INT NOT NULL, "
            + "PRIMARY KEY(ID))";
    public static final String SELECT_EMPLOYEE = SELECT + Employee.ID_COLUMN + ", " + Employee.NAME_COLUMN + ", " + Employee.LAST_NAME_COLUMN + ", "
            + Employee.AGE_COLUMN + ", "
            + Employee.MAIL_COLUMN + ", "
            + Employee.DATE_OF_CREATE_COLUMN + ", "
            + Employee.DEPARTMENT_ID
            + FROM + Employee.TABLE_NAME + WHERE + Employee.ID_COLUMN + " = ?";
    public static final String INSERT_EMPLOYEE = "INSERT INTO " + Employee.TABLE_NAME + " (" + Employee.NAME_COLUMN
            + ", " + Employee.LAST_NAME_COLUMN
            + ", " + Employee.AGE_COLUMN
            + ", " + Employee.MAIL_COLUMN
            + ", " + Employee.DATE_OF_CREATE_COLUMN
            + ", " + Employee.DEPARTMENT_ID
            + ") " + "VALUES (?, ?, ?, ?, ?, ?);";
    public static final String DELETE_EMPLOYEE = "DELETE FROM " + Employee.TABLE_NAME + WHERE + Employee.ID_COLUMN + ADAPT_PARAM;
    public static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM " + Employee.TABLE_NAME + ";";
    public static final String SELECT_ALL_EMPLOYEE_BY_DEPARTMENTS = "SELECT * FROM " + Employee.TABLE_NAME + WHERE + Employee.DEPARTMENT_ID + ADAPT_PARAM;
    public static final String DROP_TABLE_EMPLOYEE = "DROP TABLE " + Employee.TABLE_NAME + ";";
    public static final String UPDATE_EMPLOYEE = "UPDATE " + Employee.TABLE_NAME + " SET " + Employee.NAME_COLUMN + " = ?"
            + ", " + Employee.LAST_NAME_COLUMN + " = ?"
            + ", " + Employee.AGE_COLUMN + " = ?"
            + ", " + Employee.MAIL_COLUMN + " = ?"
            + WHERE + Employee.ID_COLUMN + " = ?";
}