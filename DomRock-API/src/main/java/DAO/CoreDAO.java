package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import DTO.CoreDTO;

public class CoreDAO {
	
	  Connection conn;
	  PreparedStatement pstm;
	  
	  
public void cadastrarCore(CoreDTO objCoreDTO) {
	 String sql = "inserir into Core(recursos) valeus (?)";
		
		 try(Connection conn= new ConexaoDAO().conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql);) {
			 
			
			pstm.setString(1, objCoreDTO.getRecursos());
		
		    
			 
			pstm.execute();
			pstm.close();
			
			 
		 }catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}


