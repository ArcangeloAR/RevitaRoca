package com.generation.ProjetoTurismo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.ProjetoTurismo.model.PostagemModel;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {	
	public List<PostagemModel> findAllByTituloContainingIgnoreCase (String titulo); 
}
