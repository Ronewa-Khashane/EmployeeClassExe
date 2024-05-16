package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
