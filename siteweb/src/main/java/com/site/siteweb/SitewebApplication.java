package com.site.siteweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.site.siteweb.service.MailSenderService;

@SpringBootApplication
public class SitewebApplication {

  @Autowired
  private MailSenderService mailService;
	public static void main(String[] args) { 
		SpringApplication.run(SitewebApplication.class, args); 
	}

	// @EventListener(ApplicationReadyEvent.class)
	// public void sandmessage()
	// {
	// 	mailService.sendNewMail();
	// }

}
