package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {
    public static Employee buildEmployee(long employeeNumber, String firstName, String lastName, Contact contact){
        if(employeeNumber <0 || Helper.isNullorEmpty(firstName)
            || Helper.isNullorEmpty(lastName)
            || contact == null)
            return null;

        return new Employee.Builder().setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .build();
    }

    public static Employee buildEmployee( String firstName, String lastName, Contact contact){
        if(Helper.isNullorEmpty(firstName)
                || Helper.isNullorEmpty(lastName)
                || contact == null)
            return null;

        return new Employee.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .build();
    }
}
