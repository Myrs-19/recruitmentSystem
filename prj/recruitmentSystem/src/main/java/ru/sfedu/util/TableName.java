/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.util;

import ru.sfedu.Constants;
import ru.sfedu.model.TypePerson;

/**
 *
 * @author mike
 */
public class TableName {
    public static String getTableNamePerson(TypePerson typePerson){
        return switch (typePerson) {
            case ClientType -> Constants.TITLE_TABLE_CLIENT;
            case EmployeeType -> Constants.TITLE_TABLE_EMPLOYEE;
            default -> null;
        };
    }
}
