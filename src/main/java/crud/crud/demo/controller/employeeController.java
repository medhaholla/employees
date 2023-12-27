package crud.crud.demo.controller;

import crud.crud.demo.EmailService;
import crud.crud.demo.EmployeeService.EmployeeService;
import crud.crud.demo.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController

@AllArgsConstructor

public class employeeController {
  private EmployeeService employeeService;
  private EmailService emailService;

    @PostMapping("api/addEmployee")
   public ResponseEntity<UUID> createEmployee(@RequestBody Employee employee){
       Employee savedEmployee = employeeService.createEmployee(employee);
       String to = emailService.getManager(savedEmployee);
       String from = "testexample280@gmail.com";
        String subject = "Manager Assign";
        String text = savedEmployee.getEmployeeName() +
                "will now work under you. Mobile number is "+ savedEmployee.getPhoneNumber() +"and email is " + savedEmployee.getEmail();
        System.out.println(from);
        System.out.println(to);

       emailService.sendEmail(to, from, text, subject);


       return new ResponseEntity<>(savedEmployee.getId(), HttpStatus.CREATED);
   }

   @GetMapping("api/employees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeList = employeeService.getEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
   }

    @DeleteMapping("api/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable UUID employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>( "Employee Deleted", HttpStatus.OK);

    }

    @PostMapping("api/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@PathVariable UUID id, @RequestBody Employee employee){
       Employee updatedEmployee = employeeService.updateEmployee(id, employee);

       return new ResponseEntity<>(updatedEmployee , HttpStatus.OK);
    }
}
