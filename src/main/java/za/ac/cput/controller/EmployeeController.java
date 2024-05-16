package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeService;

import java.util.Set;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee student){
        return employeeService.create(student);
    }

    @GetMapping("/read/{employeeNumber}")
    public Long read(@PathVariable String employeeNumber){
        return employeeService.read(Long.valueOf(employeeNumber));
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee student){
        return employeeService.update(student);
    }

    @GetMapping("/getAll")
    public Set<Employee> getAll(){
        return employeeService.getAll();
    }
}
