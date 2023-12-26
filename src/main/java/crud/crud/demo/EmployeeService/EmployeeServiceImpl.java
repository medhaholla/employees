package crud.crud.demo.EmployeeService;

import crud.crud.demo.Entity.Employee;
import crud.crud.demo.repository.employeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private employeeRepository repository;

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    public void deleteEmployee(UUID id) {
        Employee e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));


    }


}
