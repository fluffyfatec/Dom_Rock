package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.ProdutoDTO;
public class ProdutoDAO {

	  Connection conn;
	  PreparedStatement pstm;
	  
public void cadastrarproduto (ProdutoDTO objProdutoDTO) {
	
	String sql = "inserir into Produto ( nm_produto, dado_min) valeus (?,?)";
	

	
	 try(Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){

	     pstm.setString(1, objProdutoDTO.getNomeProduto());
		 pstm.setString(2, objProdutoDTO.getDadoMinimo());
		 
		 pstm.execute();
		 pstm.close();
		 
	  }catch (SQLException e) {
			throw new RuntimeException(e);
		}
	 }
}
	     

