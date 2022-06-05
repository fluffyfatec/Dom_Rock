package modal;

public class BronzeDTO {
	private String formato;
	private String frequencia;
	private String origenDado;
	private String sistema;
	private String volume;
	private String nomeProduto;
	private String idCliente;
	private String idFonteDado;
	
	public String getIdFonteDado() {
		return idFonteDado;
	}

	public void setIdFonteDado(String idFonteDado) {
		this.idFonteDado = idFonteDado;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public BronzeDTO() {

	}

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

	public BronzeDTO(String formato, String frequencia, String origenDado, String sistema, String volume,
			String nomeProduto) {
		this.formato = formato;
		this.frequencia = frequencia;
		this.origenDado = origenDado;
		this.sistema = sistema;
		this.volume = volume;
		this.nomeProduto = nomeProduto;

	}

}
