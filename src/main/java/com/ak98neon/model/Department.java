package com.ak98neon.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Artem Kudria
 */
@Data
@AllArgsConstructor
public class Department {
    public static final String TABLE_NAME = "DEPARTMENT";
    public static final String ID_COLUMN = "ID";
    public static final String NAME_COLUMN = "NAME_DEPARTMENT";

    private Long id;
    private String name;

    public Department() {
    }
}
