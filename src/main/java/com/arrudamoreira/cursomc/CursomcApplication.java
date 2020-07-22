package com.arrudamoreira.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arrudamoreira.cursomc.domain.Categoria;
import com.arrudamoreira.cursomc.domain.Cidade;
import com.arrudamoreira.cursomc.domain.Cliente;
import com.arrudamoreira.cursomc.domain.Endereco;
import com.arrudamoreira.cursomc.domain.Estado;
import com.arrudamoreira.cursomc.domain.Produto;
import com.arrudamoreira.cursomc.domain.enums.TipoCliente;
import com.arrudamoreira.cursomc.repositories.CategoriaRepository;
import com.arrudamoreira.cursomc.repositories.CidadeRepository;
import com.arrudamoreira.cursomc.repositories.ClienteRepository;
import com.arrudamoreira.cursomc.repositories.EnderecoRepository;
import com.arrudamoreira.cursomc.repositories.EstadoRepository;
import com.arrudamoreira.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository EnderecoRepository;
	
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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Mato Grosso do Sul");
		Estado est4 = new Estado(null, "Mato Grosso");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Porto Velho", est4);
		Cidade c5 = new Cidade(null, "Campo Grande", est3);
		Cidade c6 = new Cidade(null, "Ponta Porã", est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		est3.getCidades().addAll(Arrays.asList(c5,c6));
		est4.getCidades().addAll(Arrays.asList(c5,c6));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36789878788", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(cli1);
		EnderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
