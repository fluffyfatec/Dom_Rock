package DTO;

public class SilverDTO {
	private String validador;
	private String obrigatorio;
	
	
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
public SilverDTO(String validador, String obrigatorio) {
	this.validador = validador;
	this.obrigatorio = obrigatorio;
}
}