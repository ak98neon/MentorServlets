package com.ak98neon.dao;

import com.ak98neon.model.Employee;
import com.ak98neon.util.Queries;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public final class EmployeeWorker {
    private EmployeeWorker() {
    }

    public static synchronized boolean createTable() {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.CREATE_TABLE_EMPLOYEE)) {
            final int resStatement = statement.executeUpdate();
            if (resStatement == 0) {
                log.info("table employee has been is created");
                return true;
            }
        } catch (SQLException e) {
            log.info("Table employee is not created, error: {}", e.getSQLState());
        }
        return false;
    }

    public static synchronized boolean insertEmployee(final String firstName, final String lastName, final int age, final String mail,
                                                      final long departmentId) {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.INSERT_EMPLOYEE)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setString(4, mail);
            java.util.Date d = new java.util.Date();
            statement.setDate(5, (new Date(d.getTime())));
            statement.setLong(6, departmentId);
            final int resStatement = statement.executeUpdate();
            if (resStatement > 0) {
                log.info("Employee is inserted into table!");
                return true;
            }
        } catch (SQLException e) {
            log.info("Insert Employee, Error: {}", e);
        }
        return false;
    }

    public static synchronized boolean updateEmployee(final Long id, final String firstName, final String lastName, final int age, final String mail) {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.UPDATE_EMPLOYEE)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setString(4, mail);
            statement.setLong(5, id);
            statement.executeUpdate();
            final int resStatement = statement.executeUpdate();
            if (resStatement > 0) {
                log.info("Record employee is updated to table!");
                return true;
            }
        } catch (SQLException e) {
            log.info("Update employee error: {}", e);
        }
        return false;
    }

    public static synchronized boolean deleteEmployee(final long id) {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.DELETE_EMPLOYEE)) {
            statement.setLong(1, id);
            final int resStatement = statement.executeUpdate();
            if (resStatement > 0) {
                log.info("Record employee is delete to table");
                return true;
            }
        } catch (SQLException e) {
            log.info("Delete employee error: {}", e);
        }
        return false;
    }

    public static synchronized Employee selectByIdEmployee(final long id) {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.SELECT_EMPLOYEE)) {
            statement.setLong(1, id);
            try (ResultSet set = statement.executeQuery()) {
                Employee employee = new Employee();
                while (set.next()) {
                    employee.setId(set.getLong(Employee.ID_COLUMN));
                    employee.setFirstName(set.getString(Employee.NAME_COLUMN));
                    employee.setLastName(set.getString(Employee.LAST_NAME_COLUMN));
                    employee.setAge(set.getInt(Employee.AGE_COLUMN));
                    employee.setMail(set.getString(Employee.MAIL_COLUMN));
                    employee.setDateOfCreation(set.getDate(Employee.DATE_OF_CREATE_COLUMN));
                    employee.setDepartmentId(set.getLong(Employee.DEPARTMENT_ID));
                }
                log.info("employee is select for id");
                return employee;
            }
        } catch (SQLException e) {
            log.info("select employee by id, error: {}", e);
        }
        return null;
    }

    public static synchronized List<Employee> selectAllEmployees() {
        return selectAll(Queries.SELECT_ALL_EMPLOYEE, -1);
    }

    public static synchronized List<Employee> selectAllEmployeesByDepartment(final long idDepartment) {
        return selectAll(Queries.SELECT_ALL_EMPLOYEE_BY_DEPARTMENTS, idDepartment);
    }

    private static synchronized List<Employee> selectAll(final String query, final long idDepartment) {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(query)) {
            if (idDepartment > 0) {
                statement.setLong(1, idDepartment);
            }
            List<Employee> list = new ArrayList<>();
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    Employee employee = new Employee();
                    employee.setId(set.getLong(Employee.ID_COLUMN));
                    employee.setFirstName(set.getString(Employee.NAME_COLUMN));
                    employee.setLastName(set.getString(Employee.LAST_NAME_COLUMN));
                    employee.setAge(set.getInt(Employee.AGE_COLUMN));
                    employee.setMail(set.getString(Employee.MAIL_COLUMN));
                    employee.setDateOfCreation(set.getDate(Employee.DATE_OF_CREATE_COLUMN));
                    employee.setDepartmentId(set.getLong(Employee.DEPARTMENT_ID));
                    list.add(employee);
                }
                log.info("Select all employee");
                return list;
            }
        } catch (SQLException e) {
            log.info("Select all employee, Error: {}", e);
        }
        return new ArrayList<>();
    }

    public static synchronized boolean dropTable() {
        try (PreparedStatement statement = DBWorker.getConnection().prepareStatement(Queries.DROP_TABLE_EMPLOYEE)) {
            statement.executeUpdate();
            log.info("table employee is drop");
            return true;
        } catch (SQLException e) {
            log.info("table employee drop error: {}", e);
        }
        return false;
    }
}