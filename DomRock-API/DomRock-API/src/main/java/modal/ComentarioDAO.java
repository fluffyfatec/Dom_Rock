package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ComentarioDAO {
	ConnectionFactory conn = new ConnectionFactory();
	PreparedStatement stm;
	ResultSet rs;

	public ComentarioDTO consultarcomentario (String idcliente, String etapa) {
		String sql = "SELECT comentario FROM Comentario WHERE id_cliente = ? AND etapa = ?";
		ComentarioDTO objcomentariodto = new ComentarioDTO();
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){	
			stm.setString(1, idcliente);
			stm.setString(2, etapa);
			rs = stm.executeQuery();
			if(rs.next())
			objcomentariodto.setComentario(rs.getString("comentario"));		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return objcomentariodto;
	}
	public ComentarioDTO updatecomentario(String comentario, String idcliente, String etapa) {
		String realoficial;
		String sql = "UPDATE Comentario SET comentario = ? WHERE id_cliente = ? AND etapa = ?";
		ComentarioDTO objcomentariodto = new ComentarioDTO();
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){		
			stm.setString(1, comentario);
			stm.setString(2, idcliente);
			stm.setString(3, etapa);
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return objcomentariodto;
	}
	public ComentarioDTO cadastrocomentario(String comentario, String idcliente, String etapa) {
		String realoficial;
		String sql = "INSERT INTO Comentario (comentario, id_cliente, etapa) values (?,?,?)";
		ComentarioDTO objcomentariodto = new ComentarioDTO();
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){		
			stm.setString(1, comentario);
			stm.setString(2, idcliente);
			stm.setString(3, etapa);
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return objcomentariodto;
	}
}
