package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.FuncionalidadeDTO;

public class FuncionalidadeDAO {
	
	  Connection conn;
	  PreparedStatement pstm;
	  
 public void cadastrarFuncionalidade (FuncionalidadeDTO objFuncionalidadeDTO) {
	 
	 
	 String sql = "inserir into Funcionalidade(nome_Funcionalidade) valeus (?)";
		
		 try(Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);) {
			 
			
			pstm.setString(1, objFuncionalidadeDTO.getNomeFuncionalidade());
		    
			 
			pstm.execute();
			pstm.close();
			
			 
		 }catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
 }
	  

