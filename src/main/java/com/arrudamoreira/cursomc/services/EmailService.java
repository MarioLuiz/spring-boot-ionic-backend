package com.arrudamoreira.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.arrudamoreira.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendMail(SimpleMailMessage msg);
}
