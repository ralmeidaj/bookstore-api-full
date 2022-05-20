package com.raimundo.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.raimundo.bookstore.domain.Categoria;

@Repository
public interface CategoriaRepository  extends PagingAndSortingRepository<Categoria, Integer>{
	

}
