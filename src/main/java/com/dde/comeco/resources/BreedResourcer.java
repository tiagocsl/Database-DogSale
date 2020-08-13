package com.dde.comeco.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dde.comeco.DTO.BreedDTO;
import com.dde.comeco.domain.Breed;
import com.dde.comeco.resources.utils.URL;
import com.dde.comeco.services.BreedService;


@RestController
@RequestMapping(value="/breed")
public class BreedResourcer {

	@Autowired
	private BreedService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Breed> find(@PathVariable Integer id) {
		Breed obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<BreedDTO>> findPage(
			@RequestParam(value="nome", defaultValue="") String name, 
			@RequestParam(value="categorias", defaultValue="") String clazz, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		String nameDecoded = URL.decodeParam(name);
		List<Integer> ids = URL.decodeIntList(clazz);
		Page<Breed> list = service.search(nameDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<BreedDTO> listDto = list.map(obj -> new BreedDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}

}