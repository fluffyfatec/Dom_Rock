package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DTO.FuncionalidadeDTO;

public class FuncionalidadeDAO {
	
	  Connection conn;
	  PreparedStatement pstm;
	  
 public void cadastrarFuncionalidade (FuncionalidadeDTO objFuncionalidadeDTO) {
	 
	 
	 String sql = "inserir into Funcionalidade(nome_Funcionalidade) valeus (?)";
		conn= new ConexaoDAO().conectaBD();
		
		 try {
			 
			pstm= conn.prepareStatement(sql);
			pstm.setString(1, objFuncionalidadeDTO.getNomeFuncionalidade());
		    
			 
			pstm.execute();
			pstm.close();
			
			 
		  }catch (Exception erro) {
				 JOptionPane.showMessageDialog(null,"FuncionalidadeDAO" + erro);
			 }
		}
 }
	  
