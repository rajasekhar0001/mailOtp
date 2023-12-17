package com.example.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SendOtpApplication {

	@Autowired
	private EmeilSenderService senderService;
	
	public static void main(String[] args) {
		SpringApplication.run(SendOtpApplication.class, args);
	}
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		
		// Create a Random object
        Random random = new Random();

        // Generate a random 6-digit number
        int randomNumber = 100000 + random.nextInt(900000);
        
        for (int i=0;i<10;i++)
		senderService.sendEmail("skmahammadhussain2002@gmail.com","This is subject", "This is  Body of Email\n OTP is "+randomNumber);
		
	}
}
