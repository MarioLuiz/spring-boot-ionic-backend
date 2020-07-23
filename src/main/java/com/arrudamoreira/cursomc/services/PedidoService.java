package com.arrudamoreira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrudamoreira.cursomc.domain.Pedido;
import com.arrudamoreira.cursomc.repositories.PedidoRepository;
import com.arrudamoreira.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

//	Maneira Antiga de usar método Find, usada nas versões Spring 1.x.x com Java 8	
//	public Pedido find(Integer id) {
//		Pedido obj = repo.findOne(id);
//		return obj;
//	}

	// Atualização do método para Spring 2.x.x com Java 11
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
