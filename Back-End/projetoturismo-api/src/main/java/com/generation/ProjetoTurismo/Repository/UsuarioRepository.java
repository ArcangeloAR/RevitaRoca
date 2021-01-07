package com.generation.ProjetoTurismo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.ProjetoTurismo.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	
	public Optional<UsuarioModel> findByUsuario(String Usuario);

}
