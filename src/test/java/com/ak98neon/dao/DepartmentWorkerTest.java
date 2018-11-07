package com.ak98neon.dao;

import com.ak98neon.model.Department;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DepartmentWorkerTest {
    private static String nameTestDep = "test";
    private static long id = 1;

    @Before
    public void initAndInsertDepartment() {
        DepartmentWorker.createTable();
        DepartmentWorker.insertDepartment(nameTestDep);
    }

    @Test
    public void create_RequestToCreate_True() {
        assertTrue(DepartmentWorker.createTable());
    }

    @Test
    public void insert_Department_True() {
        final boolean res = DepartmentWorker.insertDepartment(nameTestDep);
        assertTrue(res);
    }

    @Test
    public void delete_RequestToDeleteDepartment_True() {
        List<Department> list = DepartmentWorker.selectAllDepartments();
        assert list != null;
        assertTrue(DepartmentWorker.deleteDepartment(list.get(0).getId()));
    }

    @Test
    public void update_Name_True() {
        assertTrue(DepartmentWorker.updateDepartment(id, "newTEST"));
    }

    @Test
    public void select_DepartmentName_ObjectDepartment() {
        List<Department> list = DepartmentWorker.selectAllDepartments();
        assert list != null;
        assertNotNull(list.get(0).getId());
    }

    @Test
    public void select_RequestToSelectAll_True() {
        List<Department> list = DepartmentWorker.selectAllDepartments();
        assertTrue(!list.isEmpty());
    }

    @Test
    public void drop_RequestToDropTable_True() {
        assertTrue(DepartmentWorker.dropTable());
    }
}