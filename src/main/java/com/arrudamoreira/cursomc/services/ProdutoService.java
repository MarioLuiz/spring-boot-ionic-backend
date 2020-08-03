package com.arrudamoreira.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.arrudamoreira.cursomc.domain.Categoria;
import com.arrudamoreira.cursomc.domain.Produto;
import com.arrudamoreira.cursomc.repositories.CategoriaRepository;
import com.arrudamoreira.cursomc.repositories.ProdutoRepository;
import com.arrudamoreira.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

//	Maneira Antiga de usar método Find, usada nas versões Spring 1.x.x com Java 8	
//	public Produto find(Integer id) {
//		Produto obj = repo.findOne(id);
//		return obj;
//	}

	// Atualização do método para Spring 2.x.x com Java 11
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContaingAndCategoriasIn(nome, categorias, pageRequest);
	}
}
