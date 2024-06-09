package ru.sfedu.lab4.list.model;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.bean.AbstractBeanField;

import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;

public class ClientCsvConverter extends AbstractBeanField<Company, Integer>{

    private static final Logger log = LogManager.getLogger(CompanyCsvConverter.class.getName());

    @Override
    protected Object convert(String string) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        Client client = new Client();
        client.setTypePerson(TypePerson.ClientType);
        
        String[] fields = string.split("#");
        
        client.setId(Integer.parseInt(fields[0]));
        client.setName(fields[1]);
        client.setSurname(fields[2]);
        client.setMiddleName(fields[3]);
        client.setAge(Integer.parseInt(fields[4]));
        client.setBirthday(fields[5]);
        client.setPhone(fields[6]);
        client.setEmail(fields[7]);
        client.setPassword(fields[8]);
        client.setAddress(fields[9]);

        return client;
    }
    
    @Override
    protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Client client = (Client) value;
        return "" + client.getId() + Constants.SEPARATOR_CSV_RECURSE
                + client.getName() + Constants.SEPARATOR_CSV_RECURSE
                + client.getSurname() + Constants.SEPARATOR_CSV_RECURSE
                + client.getMiddleName()+ Constants.SEPARATOR_CSV_RECURSE
                + client.getAge()+ Constants.SEPARATOR_CSV_RECURSE
                + client.getBirthday()+ Constants.SEPARATOR_CSV_RECURSE
                + client.getPhone()+ Constants.SEPARATOR_CSV_RECURSE
                + client.getEmail()+ Constants.SEPARATOR_CSV_RECURSE
                + client.getPassword()+ Constants.SEPARATOR_CSV_RECURSE
                + client.getAddress();
    }
}
    