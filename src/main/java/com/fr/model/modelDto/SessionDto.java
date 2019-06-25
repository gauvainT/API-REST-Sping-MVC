package com.fr.model.modelDto;

import java.util.Date;

import org.modelmapper.ModelMapper;

import com.fr.model.Session;
import com.fr.model.Specialite;


public class SessionDto {
	
	ModelMapper modelMapper = new ModelMapper();
	
	Specialite specialite = new Specialite();
	
	Session session = modelMapper.map(specialite, Session.class);

	public SessionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
