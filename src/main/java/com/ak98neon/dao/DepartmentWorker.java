package com.ak98neon.dao;

import com.ak98neon.model.Department;
import com.ak98neon.util.Queries;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public final class DepartmentWorker {
    private DepartmentWorker() {
    }

    public static synchronized void createTable() {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.CREATE_TABLE)) {
            final int resStatement = statement.executeUpdate();
            if (resStatement == 0) {
                log.info("table has been is created");
            }
        } catch (SQLException e) {
            log.info("Table is not created, error: {}", e.getSQLState());
        }
    }

    public static synchronized void insertDepartment(final String name) {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.INSERT_DEPARTMENT)) {
            statement.setString(1, name);
            final int resStatement = statement.executeUpdate();
            if (resStatement > 0) {
                log.info("Department is inserted into table!");
            }
        } catch (SQLException e) {
            log.info("Insert Department, Error: {}", e);
        }
    }

    public static synchronized List<Department> selectAllDepartments() {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.SELECT_ALL_DEPARTMENT)) {
            List<Department> list = new ArrayList<>();
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    Department dep = new Department();
                    dep.setId(set.getLong(Department.ID_COLUMN));
                    dep.setName(set.getString(Department.NAME_COLUMN));
                    list.add(dep);
                }
                log.info("Select all Departments");
                return list;
            }
        } catch (SQLException e) {
            log.info("Select all departments, Error: {}", e);
        }
        return new ArrayList<>();
    }
}