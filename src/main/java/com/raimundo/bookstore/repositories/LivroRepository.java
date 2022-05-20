package com.raimundo.bookstore.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raimundo.bookstore.domain.Livro;

@Repository
public interface LivroRepository  extends PagingAndSortingRepository<Livro, Integer>{

	
	
	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
	Page<Livro> findByIdCategoria(@Param(value = "id_cat") Integer id_cat, Pageable pageable);
	
	@Query("SELECT COUNT(*) FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
	Long findByIdCategoriaCount(@Param(value = "id_cat") Integer id_cat);

	
	
}
