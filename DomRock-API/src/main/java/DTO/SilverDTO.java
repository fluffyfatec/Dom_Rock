package DTO;

public class SilverDTO {
	private String idfontedados;
	private String validador;
	private String obrigatorio;
	
	public String getIdfontedados() {
		return idfontedados;
	}
	public void setIdfontedados(String idfontedados) {
		this.idfontedados = idfontedados;
	}
	
	public String getValidador() {
		return validador;
	}
	public void setValidador(String validador) {
		this.validador = validador;
	}
	
	public String getObrigatorio() {
		return obrigatorio;
	}
	public void setObrigatorio(String obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	
public SilverDTO() {
	
}

public SilverDTO(String idfontedados, String validador, String obrigatorio) {
	this.idfontedados = idfontedados;
	this.validador = validador;
	this.obrigatorio = obrigatorio;
}

}