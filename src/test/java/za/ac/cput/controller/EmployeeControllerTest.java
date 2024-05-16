package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_URL = "http://localhost:8080/classtest/employee";
    private static Employee employee;
    private static Contact contact;
    @BeforeAll
    static void setup() {
        contact = ContactFactory.buildContact("ramorokaob@mycput.ac.za","0813798635", "0812345678");
        employee = EmployeeFactory.buildEmployee(1, "Brian", "ramoroka",contact);
        System.out.println(employee);

    }
    @Test
    void a_create() {
        String url = Base_URL+"/create";
        System.out.println(url);
        ResponseEntity<Employee> postResponse =restTemplate.postForEntity(url,employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Employee studentSaved = postResponse.getBody();
        assertEquals(employee.getEmployeeNumber(),studentSaved.getEmployeeNumber());
        System.out.println("Successful");
    }

    @Test
    void b_read() {
        String url = Base_URL+"/read";
        System.out.println(url);
        ResponseEntity<Employee> responseRead = restTemplate.getForEntity(url,Employee.class);
        assertNotNull(responseRead);
        assertNotNull(responseRead.getBody());
        System.out.println("Read "+responseRead.getBody());
    }

    @Test
    void c_update() {
        String url = Base_URL+"/update";
        Employee newEmployee = new Employee.Builder().copy(employee)
                .setFirstName("Smith").build();
        ResponseEntity<Employee> updateResponse = restTemplate.postForEntity(url, newEmployee, Employee.class);
        assertNotNull(updateResponse);
        assertNotNull(updateResponse.getBody());
//        assertEquals(student.getCourse(),updateResponse.getBody().getCourse());
        System.out.println("Update: "+updateResponse.getBody());
    }

    @Test
    void d_getAll() {
        String url = Base_URL+"/getall";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseAll = restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
        System.out.println("Show All: "+"\n"

                +responseAll.getBody());
    }
}