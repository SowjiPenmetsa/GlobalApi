package com.example.GlobalApi.controller;



import com.example.GlobalApi.dto.MailApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

 

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

 

@Service
public class EmailService {

 

    private final JavaMailSender mailSender;

 

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

 

    public void sendEmail(MailApiDTO mailApiDTO) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;

 

        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo("sowjipenmetsa@gmail.com"); 
            helper.setSubject("Urgent: System Error in API - Immediate Attention Required");

 

            // Email body with the details from the MailApiDTO
            String emailBody = "Dear Developer,<br><br>"+
            "I am writing to bring to your immediate attention a critical issue regarding the API system." +
            		 "Our monitoring systems have detected a severe error that requires your immediate attention and resolution." +
            		 "This error is affecting the overall functionality and stability of the API, and it is crucial to address it promptly to minimize any potential disruptions to our services.<br><br>" + 
            		"Error Details:<br>" +
            		 "<ul>"+
                     "<li>API Endpoint: " + mailApiDTO.getApiEndPoint() + "<li>"+
                     "Browser Name: " + mailApiDTO.getBrowserName() + "<li>"+
                     "Current Logged-in User: " + mailApiDTO.getCurrentLoggedInUser() + "<li>"+
                     "Screen Name: " + mailApiDTO.getScreenName() +"<li>" +
                     "Error Message: " + mailApiDTO.getErrorMessage() + "<li>" +
                     "Request Payload: " + mailApiDTO.getRequestPayload() +"<li>"+
                     "API Response: " + mailApiDTO.getApiResponse() + "<li>" +
                     "Current Timestamp: " + mailApiDTO.getCurrentTimeStamp() + "<li>"+
                     "Comments: " + mailApiDTO.getComments() +"<br><br>" +
                     "</ul>" +
                     "Time is of the essence in resolving this issue. We greatly appreciate your prompt attention and dedication to resolving this critical error.<br><br><br>" +
                     "Best Regards,<br>" +
                     "Sowjanya"; 

 

            helper.setText(emailBody, true);

 

            //screen print file
            if (mailApiDTO.getScreenPrint() != null) {
                helper.addAttachment("ScreenPrint.png", mailApiDTO.getScreenPrint());
            }

 

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
          
        }
    }
}



