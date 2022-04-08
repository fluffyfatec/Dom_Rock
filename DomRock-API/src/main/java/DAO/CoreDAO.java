package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import DTO.CoreDTO;

public class CoreDAO {
	
	  Connection conn;
	  PreparedStatement pstm;
	  
	  
public void cadastrarCore(CoreDTO objCoreDTO) {
	 String sql = "inserir into Core(recursos) valeus (?)";
		//conn= new ConexaoDAO().conectaBD();
		
		try(Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			 
			pstm= conn.prepareStatement(sql);
			pstm.setString(1, objCoreDTO.getRecursos());
		
		    
			 
			pstm.execute();
			pstm.close();
			
			 
		  }catch (Exception erro) {
				 JOptionPane.showMessageDialog(null,"CoreDAO" + erro);
			 }
		}
}


