package com.br.pb.sisbus.system.dao.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.br.pb.sisbus.system.dao.services.impl.SystemSisBusMailMail;

/**
 * @author root
 *
 */

public class SystemSisBusSendMail {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

		SystemSisBusMailMail mm = (SystemSisBusMailMail) context.getBean("systemSisBusMailMail");
		mm.sendMail("b3rros@gmail.com", "ferreira.obarros@gmail.com", "Luciano Barros", "Teste de envio de email!!!");

	}

}