package crud.crud.demo;

import crud.crud.demo.EmployeeService.EmployeeService;
import crud.crud.demo.Entity.Employee;
import crud.crud.demo.repository.employeeRepository;
import jakarta.mail.Message;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Properties;
import java.util.UUID;
import jakarta.mail.*;


@Service
@AllArgsConstructor
public class EmailService {
    private EmployeeService employeeService;

    private employeeRepository employeeRepository;




    public String getManager(Employee employee){
        UUID reportsTo = employee.getReportsTo();
         while(reportsTo != null){
             Employee manager = employeeRepository.findById(reportsTo).orElse(null);
             if(manager != null){
                if(isLevelOneManager(manager)){
                    return manager.getEmail();
                }
                 reportsTo = manager.getReportsTo();
             }

         }
         return "fetavo5622@usoplay.com";
    }
   public boolean isLevelOneManager(Employee employee){
        return employee.getReportsTo() == null;
   }

   public boolean sendEmail(String receiver, String sender, String body, String subject){
        boolean flag = false;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port" , "587");
        properties.put("mail.smtp.host" , "smtp.gmail.com");

        String userName = sender;
        String password = "jaqs hlas vtva kadp";

      Session session = Session.getInstance(properties, new Authenticator() {
          @Override
          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(sender, password);
          }
      });

      try {

          Message message = new MimeMessage(session);
          if(receiver!= null) {
              message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
          }else{
              System.out.println("reciever is null");
          }
          message.setFrom(new InternetAddress(userName));
          message.setSubject(subject);
          message.setText(body);
          Transport.send(message);
          flag = true;
      } catch (Exception e) {
          e.printStackTrace();
      }



      return flag;

  }



}
