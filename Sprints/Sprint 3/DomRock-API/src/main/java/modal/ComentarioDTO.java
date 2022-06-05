package modal;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class ComentarioDTO {
	private String comentario;
	private String idcliente;
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}
}
