package com.generation.ProjetoTurismo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema")
public class TemaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 255)
	private String descricao;
	
	@Size(min = 2, max = 255)
	private String parceria;
	
	@NotNull
	@Size(min = 2, max = 255)
	private String local;
	
	@NotNull
	private boolean alimentacao;
	
	@NotNull
	private boolean pernoite;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<PostagemModel> postagem;
	
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
	
	public String getParceria() {
		return parceria;
	}
	public void setParceria(String parceria) {
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
	public List<PostagemModel> getPostagem() {
		return postagem;
	}
	public void setPostagem(List<PostagemModel> postagem) {
		this.postagem = postagem;
	}
	
	
}
