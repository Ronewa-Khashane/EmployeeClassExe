package za.ac.cput.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.repository.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeServiceTest {
    @Autowired
private EmployeeService employeeService;
    private static Employee emp1;
    private static Contact con1;
    private static Employee emp2;
    private static Contact con2;

    @BeforeAll

    static void setup() {
        con1 = ContactFactory.buildContact("ramorokaob@mycput.ac.za","0813798635", "0812345678");
        emp1 = EmployeeFactory.buildEmployee(1, "Brian", "ramoroka",con1);
        assertNotNull(con1);
        assertNotNull(emp1);
        System.out.println(con1);
        System.out.println(emp1);
        con2 = ContactFactory.buildContact("williams@mycput.ac.za","0783012347", "0217892350");
        emp2 = EmployeeFactory.buildEmployee(2, "Dave", "williams",con2);
        assertNotNull(con2);
        assertNotNull(emp2);
        System.out.println(con2);
        System.out.println(emp2);


    }

    @Test
    void a_create() {
        Employee empCreated1 = employeeService.create(emp1);
        assertNotNull(empCreated1);
        System.out.println(empCreated1);
        Employee empCreated2 = employeeService.create(emp2);
        assertNotNull(empCreated2);
        System.out.println(empCreated2);

    }

    @Test
    void b_read() {
        Long read = employeeService.read(emp1.getEmployeeNumber());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Employee newEmp = new Employee.Builder().copy(emp2).setFirstName("Dan").build();
        Employee update = employeeService.update(newEmp);
        assertNotNull(update);
        System.out.println(update);
    }

    @Test
    void d_getAll() {
        System.out.println(employeeService.getAll());
    }
}