package com.raimundo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raimundo.bookstore.domain.Categoria;
import com.raimundo.bookstore.dtos.CategoriaDTO;
import com.raimundo.bookstore.repositories.CategoriaRepository;
import com.raimundo.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + " Tipo:" + Categoria.class.getName()));
	}
	
	public Page<Categoria> findAll(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public Long findAllCount(){
		return repository.count();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		return repository.save(obj);
		
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.raimundo.bookstore.service.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada, pois possui livros associados");
			
		}
		
	}
	
}
