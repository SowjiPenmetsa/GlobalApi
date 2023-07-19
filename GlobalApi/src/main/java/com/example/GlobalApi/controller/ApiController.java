
package com.example.GlobalApi.controller;

 
import org.springframework.http.HttpStatus;
import com.example.GlobalApi.dto.MailApiDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

 

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ApiController {


    private final JavaMailSender mailSender;
   public ApiController(JavaMailSender mailSender) {
       this.mailSender = mailSender;
   }

 

    @GetMapping("/success")
    public ResponseEntity<String> successRequest() {
        return ResponseEntity.ok("Request successful");
    }

 

    @GetMapping("/error")
    public ResponseEntity<String> errorRequest() {
        throw new RuntimeException("Error from backend");
    }

 

    @PostMapping("/mail-api")
    public ResponseEntity<String> sendMail(@RequestParam("file") MultipartFile file,
                                           @RequestParam("apiEndPoint") String apiEndPoint,
                                           @RequestParam("browserName") String browserName,
                                           @RequestParam("currentLoggedInUser") String currentLoggedInUser,
                                           @RequestParam("screenName") String screenName,
                                           @RequestParam("errorMessage") String errorMessage,
                                           @RequestParam("requestPayload") String requestPayload,
                                           @RequestParam("apiResponse") String apiResponse,
                                           @RequestParam("currentTimeStamp") String currentTimeStamp,
                                           @RequestParam("comments") String comments)
    
    {
        // Create a MailApiDTO object to hold the email details
        MailApiDTO mailApiDTO = new MailApiDTO();
        mailApiDTO.setApiEndPoint(apiEndPoint);
        mailApiDTO.setBrowserName(browserName);
        mailApiDTO.setCurrentLoggedInUser(currentLoggedInUser);
        mailApiDTO.setScreenName(screenName);
        mailApiDTO.setErrorMessage(errorMessage);
        mailApiDTO.setRequestPayload(requestPayload);
        mailApiDTO.setApiResponse(apiResponse);
        mailApiDTO.setCurrentTimeStamp(currentTimeStamp);
        mailApiDTO.setComments(comments);
        mailApiDTO.setScreenPrint(file); // Assuming the file is a screen print attachment

        // Send email
        sendEmail(mailApiDTO);

        return ResponseEntity.ok("Request successful");
    }

    private void sendEmail(MailApiDTO mailApiDTO) {

    	EmailService emailService=new EmailService(mailSender);
    	emailService.sendEmail(mailApiDTO);
        System.out.println("mail sent successfully");
    }
}