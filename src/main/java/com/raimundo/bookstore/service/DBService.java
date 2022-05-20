package com.raimundo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.raimundo.bookstore.domain.Categoria;
import com.raimundo.bookstore.domain.ERole;
import com.raimundo.bookstore.domain.Livro;
import com.raimundo.bookstore.domain.Role;
import com.raimundo.bookstore.repositories.CategoriaRepository;
import com.raimundo.bookstore.repositories.LivroRepository;
import com.raimundo.bookstore.repositories.RoleRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Matemática", "Livros de Matemática");
		Categoria cat3 = new Categoria(null, "Português", "Livros de Português");
		Categoria cat4 = new Categoria(null, "Categoria 4", "Livros de Categoria 4");
		Categoria cat5 = new Categoria(null, "Categoria 5", "Livros de Categoria 5");
		Categoria cat6 = new Categoria(null, "Categoria 6", "Livros de Categoria 6");
		Categoria cat7 = new Categoria(null, "Categoria 7", "Livros de Categoria 7");
		Categoria cat8 = new Categoria(null, "Categoria 8", "Livros de Categoria 8");
		Categoria cat9 = new Categoria(null, "Categoria 9", "Livros de Categoria 9");
		
		Role r1 = new Role(ERole.ROLE_USER);
		Role r2 = new Role(ERole.ROLE_MODERATOR);
		Role r3 = new Role(ERole.ROLE_ADMIN);
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Padrão de Projetos", "Robert Martin", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "Portugues para todos", "Fernando Almeida", "Lorem ipsum", cat3);
		Livro l4 = new Livro(null, "Gramática Completa", "Maria Silva", "Lorem ipsum", cat3);
		Livro l5 = new Livro(null, "Cálculo Numérico", "Carlos Dias", "Lorem ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l5));
		cat3.getLivros().addAll(Arrays.asList(l3, l4));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
		
		this.roleRepository.saveAll(Arrays.asList(r1, r2, r3));
	}
	

}
