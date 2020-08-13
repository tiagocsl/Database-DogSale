package com.dde.comeco.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dde.comeco.domain.Address;
import com.dde.comeco.domain.BankSlipPayment;
import com.dde.comeco.domain.Breed;
import com.dde.comeco.domain.CardPayment;
import com.dde.comeco.domain.City;
import com.dde.comeco.domain.Clazz;
import com.dde.comeco.domain.Client;
import com.dde.comeco.domain.OrderedItem;
import com.dde.comeco.domain.Payment;
import com.dde.comeco.domain.PurchaseOrder;
import com.dde.comeco.domain.State;
import com.dde.comeco.domain.enums.BankSlipStatus;
import com.dde.comeco.domain.enums.CardStatus;
import com.dde.comeco.domain.enums.ClientType;
import com.dde.comeco.domain.enums.Gender;
import com.dde.comeco.domain.enums.PaymentStatus;
import com.dde.comeco.domain.enums.PaymentType;
import com.dde.comeco.domain.enums.Perfil;
import com.dde.comeco.repositories.AddressRepository;
import com.dde.comeco.repositories.BreedRepository;
import com.dde.comeco.repositories.CityRepository;
import com.dde.comeco.repositories.ClazzRepository;
import com.dde.comeco.repositories.ClientRepository;
import com.dde.comeco.repositories.OrderRepository;
import com.dde.comeco.repositories.OrderedItemRepository;
import com.dde.comeco.repositories.PaymentRepository;
import com.dde.comeco.repositories.StateRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	@Autowired
	private ClazzRepository ClazzReposit;
	@Autowired
	private BreedRepository BreedReposit;
	@Autowired
	private StateRepository StateReposit;
	@Autowired
	private CityRepository CityReposit;
	@Autowired
	private ClientRepository ClientReposit;
	@Autowired
	private AddressRepository AddressReposit;
	@Autowired
	private PaymentRepository PaymentReposit;
	@Autowired
	private OrderRepository OrderReposit;
	
//	@Autowired
//	private BankSlipRepository BankSlipReposit;
//	@Autowired
//	private CardRepository CardReposit;
	
	@Autowired
	private OrderedItemRepository OItemReposit;
	

	public void instantiateTestDatabase() throws ParseException {
	
	Clazz clazz1 = new Clazz(null, "Retriever, Levantador e Cao Dagua");
	Clazz clazz2 = new Clazz(null, "Spitz");
	Clazz clazz3 = new Clazz(null, "Terrier");
	Clazz clazz4 = new Clazz(null, "Cao de Guarda, Trabalho e Utilidade");
	Clazz clazz5 = new Clazz(null, "Pastor e Boiadeiro");
	Clazz clazz6 = new Clazz(null, "Sabujo e Farejador");
	Clazz clazz7 = new Clazz(null, "Apontadores");
	Clazz clazz8 = new Clazz(null, "Companhia");
	Clazz clazz9 = new Clazz(null, "Lebreis ou Galgos");

	Breed breed1 = new Breed(null, "Golden Retriever", 1200.00);
	Breed breed2 = new Breed(null, "Duck Tolling Retriever", 17800.00);
	Breed breed3 = new Breed(null, "Flat Coated Retriever", 5300.00);
	Breed breed4 = new Breed(null, "Labrador Retriever", 1900.00);
	Breed breed5 = new Breed(null, "Chesapeake Bay Retriever", 26280.00);
	Breed breed6 = new Breed(null, "Curly Coated Retriever", 6680.00);

	Breed breed7 = new Breed(null, "Husky Siberiano", 2300.00);
	Breed breed8 = new Breed(null, "Malamute Do Alasca", 2400.00);
	Breed breed9 = new Breed(null, "Chow Chow", 1200.00);
	Breed breed10 = new Breed(null, "Samoieda", 3600.00);
	Breed breed11 = new Breed(null, "Shiba Inu", 5800.00);
	Breed breed12 = new Breed(null, "Eurasier", 3900.00);

	clazz1.getBreeds().addAll(Arrays.asList(breed1, breed2, breed3, breed4, breed5, breed6));
	clazz2.getBreeds().addAll(Arrays.asList(breed7, breed8, breed9, breed10, breed11, breed12));

	breed1.getClazzes().addAll(Arrays.asList(clazz1));
	breed2.getClazzes().addAll(Arrays.asList(clazz1));
	breed3.getClazzes().addAll(Arrays.asList(clazz1));
	breed4.getClazzes().addAll(Arrays.asList(clazz1));
	breed5.getClazzes().addAll(Arrays.asList(clazz1));
	breed6.getClazzes().addAll(Arrays.asList(clazz1));

	breed7.getClazzes().addAll(Arrays.asList(clazz2));
	breed8.getClazzes().addAll(Arrays.asList(clazz2));
	breed9.getClazzes().addAll(Arrays.asList(clazz2));
	breed10.getClazzes().addAll(Arrays.asList(clazz2));
	breed11.getClazzes().addAll(Arrays.asList(clazz2));
	breed12.getClazzes().addAll(Arrays.asList(clazz2));

	ClazzReposit.saveAll(Arrays.asList(clazz1, clazz2, clazz3, clazz4, clazz5, clazz6, clazz7, clazz8, clazz9));
	BreedReposit.saveAll(Arrays.asList(breed1, breed2, breed3, breed4, breed5, breed6, breed7, breed8, breed9, breed10, breed11, breed12));

	State est1 = new State(null, "São Paulo");
	State est2 = new State(null, "Rio de Janeiro");
	State est3 = new State(null, "Espirito Santo");

	City city1 = new City(null, "Piracicaba", est1);
	City city2 = new City(null, "Niterói", est2);
	City city3 = new City(null, "Duque de Caxias", est2);
	City city4 = new City(null, "Guarapari", est3);

	est1.getCities().addAll(Arrays.asList(city1));
	est2.getCities().addAll(Arrays.asList(city2, city3));
	est3.getCities().addAll(Arrays.asList(city4));

	StateReposit.saveAll(Arrays.asList(est1, est2, est3));
	CityReposit.saveAll(Arrays.asList(city1, city2, city3, city4));

	Client client1 = new Client(null, "Tiago Castro de Souza Lima", "teagocastrusl@gmail.com", "16897548535", ClientType.PESSOAFISICA, passwordEnconder.encode("211200Sa"));
	client1.addPerfil(Perfil.ADMIN);
	Client client2 = new Client(null, "Isabelle Mendonça Vieira", "isabellecmvieira@gmail.com", "48625734957", ClientType.PESSOAFISICA, passwordEnconder.encode("20211516"));
	client2.addPerfil(Perfil.ADMIN);
	Client client3 = new Client(null, "Magrelinho", "PartiuMagrelin@live.com", "34897628469", ClientType.PESSOAFISICA, passwordEnconder.encode("123"));
	Client client4 = new Client(null, "Corona Vairus", "VairusTuKu@gmail.com", "56092292000194", ClientType.PESSOAJURIDICA, passwordEnconder.encode("1234"));
	Client client5 = new Client(null, "Coronga Vairus", "CorongaV@outlook.com", "79541055000169", ClientType.PESSOAJURIDICA, passwordEnconder.encode("12345"));

	client1.getTellPhones().addAll(Arrays.asList("36789458", "984753218"));
	client2.getTellPhones().addAll(Arrays.asList("27859845", "978945843"));
	client3.getTellPhones().addAll(Arrays.asList("24984812", "954780469"));
	client4.getTellPhones().addAll(Arrays.asList("27758498", "997584216"));
	client5.getTellPhones().addAll(Arrays.asList("58607945", "997851607"));

	Address address1 = new Address(null, "Rua Luiz Abrahao", "941", "", "Jardim Monumento", "13405186", client1, city1);
	Address address2 = new Address(null, "Rua Presidente Backer", "76", "Apto 59", "Icarai", "24220041", client2, city2);
	Address address3 = new Address(null, "Rua Leopoldina Tome", "39", "", "Vila Centenario", "25030050", client3, city3);
	Address address4 = new Address(null, "Rua Maria da Silva", "70", "", "Vila Santa Cruz", "25260290", client4, city3);			
	Address address5 = new Address(null, "Rua Edson Ramalhete Coutinho", "12", "casa 2", "São Judas Tadeu", "29200570", client5, city4);
	Address address6 = new Address(null, "Rua Ouro Preto", "310", "", "Ipiranga", "29201105", client5, city4);

	client1.getAddress().addAll(Arrays.asList(address1));
	client2.getAddress().addAll(Arrays.asList(address2));
	client3.getAddress().addAll(Arrays.asList(address3));
	client4.getAddress().addAll(Arrays.asList(address4));
	client5.getAddress().addAll(Arrays.asList(address5, address6));

	ClientReposit.saveAll(Arrays.asList(client1, client2, client3, client4, client5));
	AddressReposit.saveAll(Arrays.asList(address1, address2, address3, address4, address5, address6));

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	PurchaseOrder order1 = new PurchaseOrder(null, sdf.parse("30/09/2019 12:48"), client1, address1, PaymentType.CARD);
	PurchaseOrder order2 = new PurchaseOrder(null, sdf.parse("16/10/2019 10:27"), client2, address2, PaymentType.BANKSLIP);
	PurchaseOrder order3 = new PurchaseOrder(null, sdf.parse("21/11/2019 07:31"), client3, address3, PaymentType.CARD);
	PurchaseOrder order4 = new PurchaseOrder(null, sdf.parse("29/11/2019 17:18"), client4, address4, PaymentType.BANKSLIP);
	PurchaseOrder order5 = new PurchaseOrder(null, sdf.parse("06/12/2019 20:04"), client5, address5, PaymentType.CARD);
	PurchaseOrder order6 = new PurchaseOrder(null, sdf.parse("06/12/2019 20:04"), client5, address6, PaymentType.BANKSLIP);

	CardPayment ptype1 = new CardPayment(null, CardStatus.ATIVO, 2);	

	BankSlipPayment ptype2 = new BankSlipPayment(null, BankSlipStatus.PAGO, sdf.parse("19/10/2019 00:00"));
	
	CardPayment ptype3 = new CardPayment(null, CardStatus.SEMSALDO, 1);	

	BankSlipPayment ptype4 = new BankSlipPayment(null, BankSlipStatus.PAGO, sdf.parse("02/12/2019 00:00"));
	
	CardPayment ptype5 = new CardPayment(null, CardStatus.ATIVO, 3);

	BankSlipPayment ptype6 = new BankSlipPayment(null, BankSlipStatus.EXPIRADO, sdf.parse("09/12/2019 00:00"));
	
	Payment pay1 = new Payment(null, PaymentStatus.QUITADO, sdf.parse("30/09/2019 12:49"), order1, ptype1, null);
	Payment pay2 = new Payment(null, PaymentStatus.QUITADO, sdf.parse("17/10/2019 14:27"), order2, null, ptype2);
	Payment pay3 = new Payment(null, PaymentStatus.PENDENTE, null, order3, ptype3, null);
	Payment pay4 = new Payment(null, PaymentStatus.QUITADO, sdf.parse("01/12/2019 18:53"), order4, null, ptype4);
	Payment pay5 = new Payment(null, PaymentStatus.QUITADO, sdf.parse("06/12/2019 20:05"), order5, ptype5, null);
	Payment pay6 = new Payment(null, PaymentStatus.PENDENTE, null, order6, null, ptype6);

	client1.getOrders().addAll(Arrays.asList(order1));
	client2.getOrders().addAll(Arrays.asList(order2));
	client3.getOrders().addAll(Arrays.asList(order3));
	client4.getOrders().addAll(Arrays.asList(order4));
	client5.getOrders().addAll(Arrays.asList(order5, order6));

	pay1.getCpayment().addAll(Arrays.asList(ptype1));
	pay2.getBkpayment().addAll(Arrays.asList(ptype2));
	pay3.getCpayment().addAll(Arrays.asList(ptype3));
	pay4.getBkpayment().addAll(Arrays.asList(ptype4));
	pay5.getCpayment().addAll(Arrays.asList(ptype5));
	pay6.getBkpayment().addAll(Arrays.asList(ptype6));

	OrderReposit.saveAll(Arrays.asList(order1, order2, order3, order4, order5, order6));
//	BankSlipReposit.saveAll(Arrays.asList(ptype2, ptype4, ptype6));
//	CardReposit.saveAll(Arrays.asList(ptype1, ptype3, ptype5));
	PaymentReposit.saveAll(Arrays.asList(pay1, pay2, pay3, pay4, pay5, pay6));

	OrderedItem ordit1 = new OrderedItem(order1, breed3, Gender.FEMALE, 0.00, 1, 5300.00);

	OrderedItem ordit2 = new OrderedItem(order2, breed1, Gender.FEMALE, 0.00, 1, 1200.00);
	OrderedItem ordit3 = new OrderedItem(order2, breed1, Gender.MALE, 0.00, 1, 1200.00);

	OrderedItem ordit4 = new OrderedItem(order3, breed4, Gender.FEMALE, 0.00, 1, 1900.00);

	OrderedItem ordit5 = new OrderedItem(order4, breed2, Gender.FEMALE, 4450.00, 1, 17800.00);
	OrderedItem ordit6 = new OrderedItem(order4, breed2, Gender.MALE, 4450.00, 1, 17800.00);

	OrderedItem ordit7 = new OrderedItem(order5, breed8, Gender.FEMALE, 360.00, 1, 2400.00);
	OrderedItem ordit8 = new OrderedItem(order5, breed8, Gender.MALE, 360.00, 1, 2400.00);

	OrderedItem ordit9 = new OrderedItem(order6, breed9, Gender.MALE, 0.00, 1, 5300.00);

	order1.getItens().addAll(Arrays.asList(ordit1));
	order2.getItens().addAll(Arrays.asList(ordit2, ordit3));
	order3.getItens().addAll(Arrays.asList(ordit4));
	order4.getItens().addAll(Arrays.asList(ordit5, ordit6));
	order5.getItens().addAll(Arrays.asList(ordit7, ordit8));
	order6.getItens().addAll(Arrays.asList(ordit9));
	

	breed3.getItens().addAll(Arrays.asList(ordit1));
	breed1.getItens().addAll(Arrays.asList(ordit2, ordit3));
	breed4.getItens().addAll(Arrays.asList(ordit4));
	breed2.getItens().addAll(Arrays.asList(ordit5, ordit6));
	breed8.getItens().addAll(Arrays.asList(ordit7, ordit8));
	breed9.getItens().addAll(Arrays.asList(ordit9));

	OItemReposit.saveAll(Arrays.asList(ordit1, ordit2, ordit3, ordit4, ordit5, ordit6, ordit7, ordit8, ordit9));
	}	
}