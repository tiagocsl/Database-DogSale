package com.dde.comeco.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dde.comeco.DTO.NewClientDTO;
import com.dde.comeco.domain.Client;
import com.dde.comeco.domain.enums.ClientType;
import com.dde.comeco.repositories.ClientRepository;
import com.dde.comeco.resources.exeptions.FieldMessage;
import com.dde.comeco.services.validation.utils.CpfCnpjValidator;

public class InsertClientValidator implements ConstraintValidator<InsertClient, NewClientDTO> {

	@Autowired
	private ClientRepository clientReposit;

	@Override
	public void initialize(InsertClient ann) {
	}

	@Override
	public boolean isValid(NewClientDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getType().equals(ClientType.PESSOAFISICA.getCod())
				&& !CpfCnpjValidator.isValidCPF(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("CpfOrCnpj", "CPF inválido"));
		}

		if (objDto.getType().equals(ClientType.PESSOAJURIDICA.getCod())
				&& !CpfCnpjValidator.isValidCNPJ(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("CpfOrCnpj", "CNPJ inválido"));
		}

		Client aux = clientReposit.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já cadastro"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}