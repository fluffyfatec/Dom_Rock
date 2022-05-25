package modal;

import javafx.collections.ObservableList;

public class UsuarioDTO {

	private Integer id_usuario;
	private String nome;
	private String funcao;	
	private String usuario;
	private String senha;
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static void setItems1(ObservableList<ClienteDTO> observableArrayList) {
		// TODO Auto-generated method stub
		
	}

	public static void setItems(ObservableList<ClienteDTO> observableArrayList) {
		// TODO Auto-generated method stub
		
	}
	
}
