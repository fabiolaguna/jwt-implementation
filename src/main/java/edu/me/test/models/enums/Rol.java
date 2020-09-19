package edu.me.test.models.enums;

import edu.me.test.exceptions.NotValidRolException;

public enum Rol {

    client, employee, administrator;

    public static Rol getRol(String rol) {

        switch (rol) {
            case "client":
                return client;

            case "employee":
                return employee;

            case "administrator":
                return administrator;

            default:
                throw new NotValidRolException("Invalid rol");
        }
    }
}
