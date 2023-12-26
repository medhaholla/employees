package crud.crud.demo.repository;

import crud.crud.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface employeeRepository extends JpaRepository<Employee, UUID> {
}
