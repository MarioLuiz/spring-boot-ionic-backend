package com.arrudamoreira.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arrudamoreira.cursomc.domain.Categoria;
import com.arrudamoreira.cursomc.domain.Produto;
import com.arrudamoreira.cursomc.repositories.CategoriaRepository;
import com.arrudamoreira.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cozinha");
		Categoria cat4 = new Categoria(null, "Mesa e Banho");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Colher", 1.25);
		Produto p5 = new Produto(null, "Toalha", 15.80);
		Produto p6 = new Produto(null, "Pano de limpeza trelado", 5.99);
		Produto p7 = new Produto(null, "Edredom", 47.50);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p4,p6));
		cat4.getProdutos().addAll(Arrays.asList(p5,p6,p7));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat3));
		p5.getCategorias().addAll(Arrays.asList(cat4));
		p6.getCategorias().addAll(Arrays.asList(cat3,cat4));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
	}

}
