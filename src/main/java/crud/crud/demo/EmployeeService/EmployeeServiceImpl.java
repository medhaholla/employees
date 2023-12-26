package crud.crud.demo.EmployeeService;

import crud.crud.demo.Entity.Employee;
import crud.crud.demo.repository.employeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private employeeRepository repository;

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }


}
