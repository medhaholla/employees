package crud.crud.demo.EmployeeService;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
      super(s);
    }
}
