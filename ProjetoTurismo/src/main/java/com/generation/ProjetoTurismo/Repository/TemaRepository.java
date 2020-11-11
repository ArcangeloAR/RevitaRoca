package com.generation.ProjetoTurismo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.ProjetoTurismo.model.TemaModel;

public interface TemaRepository extends JpaRepository<TemaModel,Long> {

	public List<TemaModel>findAllByLocalContainsIgnoreCase(String local);
	
	public List<TemaModel>findAllByDescricaoContainsIgnoreCase(String descricao);


}
	


