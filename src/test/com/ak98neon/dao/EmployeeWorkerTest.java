package com.ak98neon.dao;

import com.ak98neon.model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EmployeeWorkerTest {
    private static Long id = 1L;
    private static Employee employee = new Employee(id, "test", "test", 20, "test@mail.ru", id);


    @Before
    public void initAndInsertEmployee() {
        EmployeeWorker.createTable();
        EmployeeWorker.insertEmployee(employee.getFirstName(), employee.getLastName(), employee.getAge(),
                employee.getMail(), employee.getDepartmentId());
    }

    @Test
    public void create_RequestToCreate_True() {
        assertTrue(EmployeeWorker.createTable());
    }

    @Test
    public void insert_Employee_True() {
        final boolean res = EmployeeWorker.insertEmployee(employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getMail(),
                employee.getDepartmentId());
        assertTrue(res);
    }

    @Test
    public void delete_RequestToDeleteEmployee_True() {
        List<Employee> list = EmployeeWorker.selectAllEmployees();
        assert list != null;
        assertTrue(EmployeeWorker.deleteEmployee(list.get(0).getId()));
    }

    @Test
    public void update_NameAndLNameAndAgeAndMail_True() {
        List<Employee> list = EmployeeWorker.selectAllEmployees();
        assert list != null;
        assertTrue(EmployeeWorker.updateEmployee(list.get(0).getId(), employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getMail()));
    }

    @Test
    public void select_EpmployeeName_ObjectEmployee() {
        List<Employee> list = EmployeeWorker.selectAllEmployees();
        assert list != null;
        Employee s = EmployeeWorker.selectByIdEmployee(list.get(0).getId());
        assert s != null;
        assertNotNull(s.getFirstName());
    }

    @Test
    public void select_RequestToSelectAll_True() {
        List<Employee> list = EmployeeWorker.selectAllEmployees();
        assert list != null;
        assertTrue(!list.isEmpty());
    }

    @Test
    public void drop_RequestToDropTable_True() {
        assertTrue(EmployeeWorker.dropTable());
    }
}