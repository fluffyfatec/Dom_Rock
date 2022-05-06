package DTO;

public class ProdutoAtivacaoDTO {
	
	private String nomeProduto;
	private BronzeDTO bronzeDTO;
	private ProdutoDTO produtoDTO;
	private int idOrigem;	
	private int idFormato;
	private int idSistema;

	public ProdutoAtivacaoDTO(String nomeProduto, BronzeDTO bronzeDTO) {
		this.nomeProduto = nomeProduto;
		this.bronzeDTO = bronzeDTO;
	}
	public ProdutoAtivacaoDTO() {
		// TODO Auto-generated constructor stub
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
	public int getIdOrigem() {
		return idOrigem;
	}
	public void setIdOrigem(int idOrigem) {
		this.idOrigem = idOrigem;
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
	public String getVox() {
		return produtoDTO.getVox();
	}
	public String getMarketingPlanning() {
		return produtoDTO.getMarketingPlanning();
	}
	public String getSalesDistribution() {
		return produtoDTO.getSalesDistribution();
	}
	public String getPricing() {
		return produtoDTO.getPricing();
	}
	public String getOptimization() {
		return produtoDTO.getOptimization();
	}
	public String getMatchingRisk() {
		return produtoDTO.getMatchingRisk();
	}
	public int getCheckoptimization() {
		return produtoDTO.getCheckoptimization();
	}
	public int getCheckmatching() {
		return produtoDTO.getCheckmatching();
	}
	public int getCheckmarketing() {
		return produtoDTO.getCheckmarketing();
	}
	public int getCheckpricing() {
		return produtoDTO.getCheckpricing();
	}
	public int getChecksales() {
		return produtoDTO.getChecksales();
	}
	public int getCheckvox() {
		return produtoDTO.getCheckvox();
	}

}
