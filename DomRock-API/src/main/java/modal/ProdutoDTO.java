package modal;

import javafx.collections.ObservableList;

public class ProdutoDTO {
	private Integer id_produto;
	private String nome_produto;
	private String nome_solucao;
	private String dado_minimo;
	
	public Integer getIdProduto() {
		return id_produto;
	}
	public void setIdProduto(Integer id_produto) {
		this.id_produto = id_produto;
	}
	
	public String getNomeProduto() {
		return nome_produto;
	}
	public void setNomeProduto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	
	public String getNomeSolucao() {
		return nome_solucao;
	}
	public void setNomeSolucao(String nome_solucao) {
		this.nome_solucao = nome_solucao;
	}
	
	public String getDadoMinimo() {
		return dado_minimo;
	}
	public void setDadoMinimo(String dado_minimo) {
		this.dado_minimo = dado_minimo;
	}
	
	public static void setItems(ObservableList<ProdutoDTO> observableArrayList) {
		// TODO Auto-generated method stub
		
	}
}
