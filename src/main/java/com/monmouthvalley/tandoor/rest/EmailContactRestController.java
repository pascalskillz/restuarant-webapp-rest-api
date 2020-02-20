package com.monmouthvalley.tandoor.rest;

import com.monmouthvalley.tandoor.entity.Email;
import com.monmouthvalley.tandoor.entity.User;
import com.monmouthvalley.tandoor.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000", "https://tandoor.netlify.com", "http://tandoor.s3-website-us-east-1.amazonaws.com"})
public class EmailContactRestController {

    @Autowired
    private MailService mailService;

    @Autowired
    private User user;

    @RequestMapping("/contact")
    public String send(@RequestBody Email email) {

        /*
         * Creating a User with the help of User class that we have declared and setting
         * Email address of the sender.
         */
        user.setEmailAddress("mu.tandoori@gmail.com");  //Receiver's email address

        /*
         * Here we will call sendEmail() for Sending mail to the sender.
         */
        try {
            mailService.sendEmail(user, email);

        } catch (MailException | MessagingException mailException) {

            mailException.printStackTrace();
        }
        return "Congratulations! Your mail has been send to the user.";
    }

}
