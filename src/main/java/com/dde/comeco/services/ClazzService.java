package com.dde.comeco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dde.comeco.DTO.ClazzDTO;
import com.dde.comeco.domain.Clazz;
import com.dde.comeco.repositories.ClazzRepository;
import com.dde.comeco.services.exceptions.DataIntegrityException;
import com.dde.comeco.services.exceptions.ObjectNotFoundException;

@Service
public class ClazzService {

	@Autowired
	private ClazzRepository ClazzReposit;

	public Clazz find(Integer id) {
		Optional<Clazz> obj = ClazzReposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Clazz.class.getName()));
		
	}

	public Clazz insert(Clazz obj) {
		obj.setId(null);
		return ClazzReposit.save(obj);
	}

	public Clazz update(Clazz obj) {
		Clazz newObj = find(obj.getId());
		updateData(newObj, obj);
		return ClazzReposit.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		ClazzReposit.deleteById(id);
	}
		catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possivel excluir uma classe que possui raça");
		}
	}
	
	public List<Clazz> findAll(){
		return ClazzReposit.findAll();
	}
	
	public Page<Clazz> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return ClazzReposit.findAll(pageRequest);
	}
	
	public Clazz fromDTO(ClazzDTO objDTO) {
		return new Clazz(objDTO.getId(), objDTO.getName());
	}
	
	private void updateData(Clazz newObj, Clazz obj) {
		newObj.setName(obj.getName());
	}
}
