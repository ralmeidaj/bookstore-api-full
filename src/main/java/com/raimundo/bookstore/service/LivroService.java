package com.raimundo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.raimundo.bookstore.domain.Categoria;
import com.raimundo.bookstore.domain.Livro;
import com.raimundo.bookstore.repositories.LivroRepository;
import com.raimundo.bookstore.service.exceptions.DataIntegrityViolationException;
import com.raimundo.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	public Livro findById(Integer id) {
		
		Optional<Livro>obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + "Tipo: " + Livro.class.getName()));
		
	}


	public Long findAllCount(Integer id_cat){
		return repository.findByIdCategoriaCount(id_cat); 

	}
	
	public Page<Livro> findAll(Pageable pageable, Integer id_cat) {
		categoriaService.findById(id_cat);
		
		return repository.findByIdCategoria(id_cat, pageable);
	}


	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
		
	}


	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
	
	}


	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}


	public void delete(Integer id) {
		Livro obj = findById(id);
		repository.delete(obj);
		
	}
}
