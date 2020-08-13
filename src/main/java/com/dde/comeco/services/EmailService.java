package com.dde.comeco.services;

import org.springframework.mail.SimpleMailMessage;

import com.dde.comeco.domain.PurchaseOrder;
import com.dde.comeco.domain.Client;

public interface EmailService {

	void sendOrderConfirmationEmail(PurchaseOrder obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Client client, String newPass);
}
