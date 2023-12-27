/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.model;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.bean.AbstractBeanField;

import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;

/**
 *
 * @author mike
 */
public class CompanyCsvConverter extends AbstractBeanField<Company, Integer>{

    private static final Logger log = LogManager.getLogger(CompanyCsvConverter.class.getName());

    @Override
    protected Object convert(String string) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        Company company = new Company();
        
        String[] fields = string.split("#");
        
        company.setId(Integer.valueOf(fields[0]));
        company.setTitle(fields[1]);
        company.setDescription(fields[2]);

        return company;
    }
    
    @Override
    protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Company company = (Company) value;
        return "" + company.getId() + Constants.SEPARATOR_CSV_RECURSE
                + company.getTitle() + Constants.SEPARATOR_CSV_RECURSE
                + company.getDescription();
    }
}
    