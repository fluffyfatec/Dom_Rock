package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DTO.ProdutoDTO;
public class ProdutoDAO {

	  Connection conn;
	  PreparedStatement pstm;
	  
public void cadastrarproduto (ProdutoDTO objProdutoDTO) {
	
	String sql = "inserir into Produto ( nm_produto, dado_min) valeus (?,?)";
	
	conn= new ConexaoDAO().conectaBD();
	
	 try {
		 
		 pstm= conn.prepareStatement(sql);
		 
	     pstm.setString(1, objProdutoDTO.getNomeProduto());
		 pstm.setString(2, objProdutoDTO.getDadoMinimo());
		 
		 pstm.execute();
		 pstm.close();
		 
	  }catch (Exception erro) {
			 JOptionPane.showMessageDialog(null,"ProdutoDAO" + erro);
		 }
	 }
}
	     

