package com.site.siteweb.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.site.siteweb.service.MailSenderService;

import jakarta.mail.MessagingException;

@RestController
@CrossOrigin(origins = "*")
public class SandmailController { 
	
  @Autowired
  private MailSenderService mailService;

  @GetMapping("/send-email")
  public void sendEmail() throws IOException, MessagingException {
   // mailService.sendNewMail("swediroben@gmail.com", "Subject right here", "Body right there!");
  }
}
