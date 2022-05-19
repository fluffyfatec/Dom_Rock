package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.ProdutoDTO;
public class ProdutoDAO {

	  Connection conn;
	  PreparedStatement pstm;
	  
public void cadastrarproduto (ProdutoDTO objProdutoDTO) {
	
	String sql = "inserir into Produto (id_produto, nm_produto, ) valeus (?,?)";
	

	
	 try(Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){


		 
		 pstm.execute();
		 pstm.close();
		 
	  }catch (SQLException e) {
			throw new RuntimeException(e);
		}
	 }
}
	     

