
package com.springboot.disney.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author Cortinez Juan José
 */
@Service
public class SendMailService {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    public void sendMail(String from, String to, String subject, String body){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        
        javaMailSender.send(mailMessage);
    }

}
