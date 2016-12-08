package com.br.pb.sisbus.system.util;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
@ComponentScan({"com.br.pb.sisbus"})
public class SystemSisbusRecoverPasswordConfigUtil {
	
	@Bean
	public JavaMailSenderImpl getMailSender(){
	
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost("stmp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("b3rros@gmail.com");
		mailSender.setPassword("sabris159");
		
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");
		
		mailSender.setJavaMailProperties(javaMailProperties);	
        
		return mailSender;
	}
}
