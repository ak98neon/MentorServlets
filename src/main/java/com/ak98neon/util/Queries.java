package com.ak98neon.util;

import com.ak98neon.model.Department;

public final class Queries {
    private Queries() {
    }

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXIST "
            + Department.TABLE_NAME + " ( " + Department.ID_COLUMN + " INT NOT NULL AUTO_INCREMENT UNIQUE, "
            + Department.NAME_COLUMN + " VARCHAR(45) NOT NULL, "
            + "PRIMARY KEY(ID))";
}
