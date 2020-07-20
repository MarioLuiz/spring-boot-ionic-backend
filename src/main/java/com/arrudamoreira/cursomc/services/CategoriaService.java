package com.arrudamoreira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrudamoreira.cursomc.domain.Categoria;
import com.arrudamoreira.cursomc.repositories.CategoriaRepository;
import com.arrudamoreira.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

//	Maneira Antiga de usar método Find, usada nas versões Spring 1.x.x com Java 8	
//	public Categoria find(Integer id) {
//		Categoria obj = repo.findOne(id);
//		return obj;
//	}

	// Atualização do método para Spring 2.x.x com Java 11
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
