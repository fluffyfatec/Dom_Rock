package DTO;

import javafx.beans.property.SimpleStringProperty;

public class BronzeDTO {
	
	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public int getIdOrigem() {
		return idOrigem;
	}

	public void setIdOrigem(int idOrigem) {
		this.idOrigem = idOrigem;
	}

	public int getIdFormato() {
		return idFormato;
	}

	public void setIdFormato(int idFormato) {
		this.idFormato = idFormato;
	}

	public int getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(int idSistema) {
		this.idSistema = idSistema;
	}

	public BronzeDTO() {
		
	}
	
	public BronzeDTO(String formato, String frequencia, String origenDado, String sistema, String volume, String nomeProduto, ProdutoDTO produto) {
		this.formato = formato;
		this.frequencia = frequencia;
		this.origenDado = origenDado;
		this.sistema = sistema;
		this.volume = volume;
		this.nomeProduto = nomeProduto;
		this.produto = produto;
	}

	private String formato;
	private String frequencia;
	private String origenDado;
	private String sistema;
	private String volume;
	private String nomeProduto;
	private int idOrigem;	
	private int idFormato;
	private int idSistema;
	private ProdutoDTO produto;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}

	public String getOrigenDado() {
		return origenDado;
	}

	public void setOrigenDado(String origenDado) {
		this.origenDado = origenDado;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	
		

}