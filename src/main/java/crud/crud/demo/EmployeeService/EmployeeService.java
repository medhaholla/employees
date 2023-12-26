package crud.crud.demo.EmployeeService;

import org.springframework.stereotype.Service;


import crud.crud.demo.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    
}
