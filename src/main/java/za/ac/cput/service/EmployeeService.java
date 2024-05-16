package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.ContactRepository;
import za.ac.cput.repository.EmployeeRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService{

    private ContactRepository contactRepository;
    private EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService(ContactRepository contactRepository, EmployeeRepository employeeRepository){
        this.contactRepository = contactRepository;
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee create(Employee employee) {
        contactRepository.save(employee.getContact());
        return employeeRepository.save(employee);
    }

    @Override
    public Long read(Long id) {
        return this.employeeRepository.findById(id).orElse(null).getEmployeeNumber();
    }

    @Override
    public Employee update(Employee employee) {
        contactRepository.save(employee.getContact());
        return employeeRepository.save(employee);
    }


    @Override
    public Set<Employee> getAll() {
        return employeeRepository.findAll().stream().collect(Collectors.toSet());
    }
}
