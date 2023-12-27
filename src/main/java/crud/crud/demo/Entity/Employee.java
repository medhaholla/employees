package crud.crud.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String employeeName;
    private String phoneNumber;
    private String email;
    private UUID reportsTo;
    private String profileImage;
}
