package DTO;

public class ProdutoAtivacaoDTO {
	
	private String nomeProduto;
	private BronzeDTO bronzeDTO;
	
	public ProdutoAtivacaoDTO(String nomeProduto, BronzeDTO bronzeDTO) {
		this.nomeProduto = nomeProduto;
		this.bronzeDTO = bronzeDTO;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public String getFormato() {
		return bronzeDTO.getFormato();
	}
	public String getFrequencia() {
		return bronzeDTO.getFrequencia();
	}
	public String getOrigenDado() {
		return bronzeDTO.getOrigenDado();
	}
	public String getSistema() {
		return bronzeDTO.getSistema();
	}
	public String getVolume() {
		return bronzeDTO.getVolume();
	}

}
