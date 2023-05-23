package com.example.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojooverflow.models.nuevaPregunta;
import com.example.dojooverflow.repositories.PreguntasRepo;
import com.example.dojooverflow.repositories.TagsRepo;

@Service
public class MainService {

	//Inyeccion Dependencias
//	@Autowired
//	private PreguntasRepo preguntasRepo;
//	@Autowired
//	private TagsRepo tagRepo;
	
	
	//Servicios PREGUNTAS
	public void crearPregunta(nuevaPregunta nuevapregunta) {
		
		System.out.println(" hola mundo");
		
	 System.out.println(nuevapregunta.getTags() );
	}
	
	
	

}
