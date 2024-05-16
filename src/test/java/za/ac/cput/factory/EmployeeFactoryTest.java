package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    void buildEmployee() {
        Contact contact = ContactFactory.buildContact("ramorokaob@gmail.com", "0813798635");
        Employee emp = EmployeeFactory.buildEmployee(2,"Brian", "ramoroka",contact);
        assertNotNull(emp);
        System.out.println(emp);
    }

    @Test
    void testBuildEmployee() {
        Contact contact = ContactFactory.buildContact("ramorokaob@m.az.za", "0813798635");
        Employee emp = EmployeeFactory.buildEmployee(2,"Brian", "ramoroka",contact);
        assertNotNull(emp);
        System.out.println(emp);
    }

    @Test
    void testBuildEmployeeF() {
        Contact contact = ContactFactory.buildContact("ramorokaob@m.az.za", "0813798635");
        Employee emp = EmployeeFactory.buildEmployee(2,"Brian", "",contact);
        assertNotNull(emp);
        System.out.println(emp);
    }

    @Test
    void testBuildEmployeeP() {
        Contact contact = ContactFactory.buildContact("ramorokaob@m.az.za", "0813798635","0112233445");
        Employee emp = EmployeeFactory.buildEmployee(2,"Brian", "ramoroka",contact);
        assertNotNull(emp);
        System.out.println(emp);
    }
}