package com.generation.ProjetoTurismo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tema")
public class TemaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 10, max = 255)
	private String descricao;
	
	@NotNull
	private boolean parceria;
	
	@NotNull
	@Size(min = 2, max = 255)
	private String local;
	
	@NotNull
	private boolean alimentacao;
	
	@NotNull
	private boolean pernoite;
	
	//getters e setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isParceria() {
		return parceria;
	}
	public void setParceria(boolean parceria) {
		this.parceria = parceria;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public boolean isAlimentacao() {
		return alimentacao;
	}
	public void setAlimentacao(boolean alimentacao) {
		this.alimentacao = alimentacao;
	}
	public boolean isPernoite() {
		return pernoite;
	}
	public void setPernoite(boolean pernoite) {
		this.pernoite = pernoite;
	}
	
	
}
