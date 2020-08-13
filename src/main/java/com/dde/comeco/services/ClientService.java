package com.dde.comeco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dde.comeco.DTO.ClientDTO;
import com.dde.comeco.DTO.NewClientDTO;
import com.dde.comeco.domain.Address;
import com.dde.comeco.domain.City;
import com.dde.comeco.domain.Client;
import com.dde.comeco.domain.enums.ClientType;
import com.dde.comeco.domain.enums.Perfil;
import com.dde.comeco.repositories.AddressRepository;
import com.dde.comeco.repositories.ClientRepository;
import com.dde.comeco.security.UserSS;
import com.dde.comeco.services.exceptions.AuthorizationException;
import com.dde.comeco.services.exceptions.DataIntegrityException;
import com.dde.comeco.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private BCryptPasswordEncoder passwordEnconder;

	@Autowired
	private ClientRepository ClientReposit;

	@Autowired
	private AddressRepository AddressReposit;

	public Client find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Client> obj = ClientReposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Client.class.getName()));

	}

	@Transactional
	public Client insert(Client obj) {
		obj.setId(null);
		obj = ClientReposit.save(obj);
		AddressReposit.saveAll(obj.getAddress());
		return obj;
	}

	public Client update(Client obj) {
		Client newObj = find(obj.getId());
		updateData(newObj, obj);
		return ClientReposit.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			ClientReposit.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<Client> findAll() {
		return ClientReposit.findAll();
	}

	public Client findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
	
		Cliente obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}

	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return ClientReposit.findAll(pageRequest);
	}

	public Client fromDTO(ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null, null);
	}

	public Client fromDTO(NewClientDTO objDto) {
		Client client = new Client(null, objDto.getName(), objDto.getEmail(), objDto.getCpfOrCnpj(),
				ClientType.toEnum(objDto.getType()), passwordEnconder.encode(objDto.getPassword()));
		City city = new City(objDto.getCityID(), null, null);
		Address address = new Address(null, objDto.getStreet(), objDto.getNumber(), objDto.getComplement(),
				objDto.getNeighborhood(), objDto.getZipcode(), client, city);
		client.getAddress().add(address);
		client.getTellPhones().add(objDto.getTellphone1());
		if (objDto.getTellphone2() != null) {
			client.getTellPhones().add(objDto.getTellphone2());
		}
		if (objDto.getTellphone3() != null) {
			client.getTellPhones().add(objDto.getTellphone3());
		}
		return client;
	}

	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public URI uploadProfilePicture(MultipartFile multipartFile) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, size);
		
		String fileName = prefix + user.getId() + ".jpg";
		
		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
	}
}