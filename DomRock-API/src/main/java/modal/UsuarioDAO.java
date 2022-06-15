package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import modal.UsuarioDTO;

public class UsuarioDAO {

	//Connection connection;
	ConnectionFactory conn = new ConnectionFactory();
	PreparedStatement stm;
	
	public void cadastrarUsuario(UsuarioDTO objusuarioDTO){
		String sql = "INSERT INTO Usuario (nome, funcao, usuario, senha) values (?,?,?,?)";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){

			stm.setString(1, objusuarioDTO.getNome());
			stm.setString(2, objusuarioDTO.getFuncao());
			stm.setString(3, objusuarioDTO.getUsuario());
			stm.setString(4, objusuarioDTO.getSenha());
	   	 	
			stm.execute();	
			stm.close();
			
		}catch (SQLException e) {
		}
	
	}
	
	void exibiDialogoERRO(String erro) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Informação");
    	alert.setHeaderText(null);
    	alert.setContentText(erro);
    	alert.showAndWait();
    	
    }
	
	public void atualizar(UsuarioDTO cadastroUsuarioDTO) {
		String sql = "UPDATE Usuario SET nome = ?, funcao = ?, usuario = ?, senha = ? WHERE id_usuario = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setString(1, cadastroUsuarioDTO.getNome());
			stm.setString(2, cadastroUsuarioDTO.getFuncao());
			stm.setString(3, cadastroUsuarioDTO.getUsuario());
			stm.setString(4, cadastroUsuarioDTO.getSenha());
			stm.setInt(5, cadastroUsuarioDTO.getId_usuario());

			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Integer id_usuario) {
		String sql = "DELETE FROM Usuario WHERE id_usuario = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setInt(1, id_usuario);
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<UsuarioDTO> consultar(String usuario) {
			
		List<UsuarioDTO> usuarios = new ArrayList<>();
		
		String sql = "SELECT * FROM view_usuario WHERE usuario LIKE '%" + usuario + "%'";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()){
			
				UsuarioDTO cadastroUsuarioDTO = new UsuarioDTO();
				
				cadastroUsuarioDTO.setId_usuario(resultSet.getInt("id_usuario"));
				cadastroUsuarioDTO.setNome(resultSet.getString("nome"));
				cadastroUsuarioDTO.setFuncao(resultSet.getString("funcao"));
				cadastroUsuarioDTO.setUsuario(resultSet.getString("usuario"));
				cadastroUsuarioDTO.setSenha(resultSet.getString("senha"));
				usuarios.add(cadastroUsuarioDTO);
			}
			
			resultSet.close();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return usuarios;
	}
	
}
