package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.SolucaoDTO;


public class SolucaoDAO {
	 
	  Connection conn;
	  PreparedStatement pstm;
	  
	  
	public void cadastrarmodulo(SolucaoDTO objSolucaoDTO) {
	
	
	String sql = "inserir into Solucao(nm_solucao) valeus (?)";

	

	 try(Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);) {
		 
	    pstm.setString(1,objSolucaoDTO.getNomeSolucao());
		 
		pstm.execute();
		pstm.close();
		 
	  }catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
}
