package com.dde.comeco.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dde.comeco.domain.BankSlipPayment;
import com.dde.comeco.domain.CardPayment;
import com.dde.comeco.domain.Client;
import com.dde.comeco.domain.OrderedItem;
import com.dde.comeco.domain.Payment;
import com.dde.comeco.domain.PurchaseOrder;
import com.dde.comeco.domain.enums.BankSlipStatus;
import com.dde.comeco.domain.enums.CardStatus;
import com.dde.comeco.domain.enums.PaymentStatus;
import com.dde.comeco.domain.enums.PaymentType;
import com.dde.comeco.repositories.OrderRepository;
import com.dde.comeco.repositories.OrderedItemRepository;
import com.dde.comeco.repositories.PaymentRepository;
import com.dde.comeco.security.UserSS;
import com.dde.comeco.services.exceptions.AuthorizationException;
import com.dde.comeco.services.exceptions.ObjectNotFoundException;

@Service
public class PurchaseOrderService {

	@Autowired
	private OrderRepository OrderReposit;

	@Autowired
	private PaymentRepository paymentReposit;

	@Autowired
	private OrderedItemRepository orderedItemReposit;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ClientService clientService;

	@Autowired
	private BreedService bService;

	
	public PurchaseOrder find(Integer id) {
		Optional<PurchaseOrder> obj = OrderReposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + PurchaseOrder.class.getName()));

	}

	public PurchaseOrder insert(PurchaseOrder obj) {
		obj.setId(null);
		obj.setMomment(new Date());
		obj.setClient(clientService.find(obj.getClient().getId()));
		
		
		CardPayment ptype1 = null;
		BankSlipPayment ptype2 = null;
		if (obj.getType() == PaymentType.toEnum(1)) {
			ptype1 = new CardPayment(null, CardStatus.ATIVO, null);
		}
		if (obj.getType() == PaymentType.toEnum(2)) {
			ptype2 = new BankSlipPayment(null, BankSlipStatus.PENDENTE, null);
		}
		
		Payment pay = new Payment();
		
		pay.setId(null);
		pay.setStatus(PaymentStatus.PENDENTE);
		pay.setPayday(null);
		pay.setOrder(obj);
		pay.setCpayment(ptype1);
		pay.setBkpayment(ptype2);		
			
		obj = OrderReposit.save(obj);
		paymentReposit.save(pay);	

		for (OrderedItem ip : obj.getItens()) {
			ip.setId(null);
			ip.setDiscount(0.0);
			ip.setBreed(bService.find(ip.getBreed().getId()));			
			ip.setPrice(ip.getBreed().getPrice());
			ip.setOrsitens(obj);
		}
		orderedItemReposit.saveAll(obj.getItens());
		emailService.sendOrderConfirmationEmail(obj);
		return obj;

	}
	
	public Page<PurchaseOrder> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Client client =  clientService.find(user.getId());
		return OrderReposit.findByClient(client, pageRequest);
	}

}
