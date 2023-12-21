/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.util;

import ru.sfedu.Constants;
import ru.sfedu.model.TypePerson;


public class TableName {
    
    /** Method for returning title of table in dependes of type of person
    * @param typePerson  - type of person
    * @return string - title table person
    */
    public static String getTableNamePerson(TypePerson typePerson){
        return switch (typePerson) {
            case ClientType -> Constants.TITLE_TABLE_CLIENT;
            case EmployeeType -> Constants.TITLE_TABLE_EMPLOYEE;
            default -> null;
        };
    }
}
