package crud.crud.demo.EmployeeService;

import org.springframework.stereotype.Service;


import crud.crud.demo.Entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getEmployees();
    void deleteEmployee(UUID id);
}
