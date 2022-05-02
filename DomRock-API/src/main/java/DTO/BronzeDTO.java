package DTO;

import javafx.beans.property.SimpleStringProperty;

public class BronzeDTO {
	
	public BronzeDTO() {
		
	}
	
	public BronzeDTO(String formato, String frequencia, String origenDado, String sistema, String volume) {
		this.formato = formato;
		this.frequencia = frequencia;
		this.origenDado = origenDado;
		this.sistema = sistema;
		this.volume = volume;
	}

	private String formato;
	private String frequencia;
	private String origenDado;
	private String sistema;
	private String volume;

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
