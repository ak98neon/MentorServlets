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

    public static synchronized boolean createTable() {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.CREATE_TABLE)) {
            final int resStatement = statement.executeUpdate();
            if (resStatement == 0) {
                log.info("table department has been is created");
                return true;
            }
        } catch (SQLException e) {
            log.info("Table department is not created, error: {}", e.getSQLState());
        }
        return false;
    }

    public static synchronized boolean insertDepartment(final String name) {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.INSERT_DEPARTMENT)) {
            statement.setString(1, name);
            final int resStatement = statement.executeUpdate();
            if (resStatement > 0) {
                log.info("Department is inserted into table!");
                return true;
            }
        } catch (SQLException e) {
            log.info("Insert Department, Error: {}", e);
        }
        return false;
    }

    public static synchronized boolean updateDepartment(final Long id, final String newName) {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.UPDATE_DEPARTMENT)) {
            statement.setString(1, newName);
            statement.setLong(2, id);
            statement.executeUpdate();
            final int resStatement = statement.executeUpdate();
            if (resStatement == 0) {
                log.info("Record department is updated to table!");
                return true;
            }
        } catch (SQLException e) {
            log.info("Update Department error: {}", e);
        }
        return false;
    }

    public static synchronized boolean deleteDepartment(final long id) {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.DELETE_DEPARTMENT)) {
            statement.setLong(1, id);
            final int resStatement = statement.executeUpdate();
            if (resStatement > 0) {
                log.info("Record department is delete to table");
                return true;
            }
        } catch (SQLException e) {
            log.info("Delete department error: {}", e);
        }
        return false;
    }

    public static synchronized Department selectById(final long id) {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.SELECT_DEPARTMENT)) {
            statement.setLong(1, id);
            try (ResultSet set = statement.executeQuery()) {
                Department dep = new Department();
                while (set.next()) {
                    dep.setId(set.getLong(Department.ID_COLUMN));
                    dep.setName(set.getString(Department.NAME_COLUMN));
                }
                log.info("Department is select for id");
                return dep;
            }
        } catch (SQLException e) {
            log.info("department select by id, error: {}", e);
        }
        return null;
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

    public static synchronized boolean dropTable() {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.DROP_TABLE)) {
            statement.executeUpdate();
            log.info("table department is drop");
            return true;
        } catch (SQLException e) {
            log.info("table department drop error: {}", e);
        }
        return false;
    }
}