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
    private Employee employee;

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

    @Override
    public Employee updateEmployee(UUID id, Employee employee) {
          Employee e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id not found for id " + id));

          employee.setId(id);
          return repository.save(employee);

    }


}
