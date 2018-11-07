package com.ak98neon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    public static final String TABLE_NAME = "EMPLOYEE";
    public static final String ID_COLUMN = "ID";
    public static final String NAME_COLUMN = "FIRSTNAME";
    public static final String LAST_NAME_COLUMN = "LASTNAME";
    public static final String AGE_COLUMN = "AGE";
    public static final String MAIL_COLUMN = "MAIL";
    public static final String DATE_OF_CREATE_COLUMN = "DATEOFCREATE";
    public static final String DEPARTMENT_ID = "DEPARTMENTID";

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String mail;
    private Date dateOfCreation;
    private Long departmentId;

    public Employee(Long id, String firstName, String lastName, int age, String mail, Long departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
        this.departmentId = departmentId;
    }
}