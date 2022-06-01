package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.ClienteDTO;
import DTO.ProdutoDTO;

public class IdClienteProduto {
	ClienteDTO objclienteDTO = new ClienteDTO();
	ProdutoDTO objProdutoDTO = new ProdutoDTO();

	Connection conn;
	PreparedStatement stm;
	ResultSet rs;

	String id = objclienteDTO.getIdCliente();


	public ClienteDTO consultarid (String id, String id_PRODUTO){ 
		
		if(objProdutoDTO.getCheckvox()==1)
		{
			
		}if(objProdutoDTO.getCheckmarketing()==2)
		{

		}if(objProdutoDTO.getChecksales()==3)
		{

		}if(objProdutoDTO.getCheckpricing()==4)
		{

		}if(objProdutoDTO.getCheckoptimization()==5)
		{

		}if(objProdutoDTO.getCheckmatching()==6)
		{

		}
		 try (Connection  conn = new ConexaoDAO().conectaBD(); ){ 
			 ClienteDTO objclienteDTO = new ClienteDTO();
			 stm = conn.prepareStatement("Select id_cliente_produto from Cliente_Produto Where id_cliente = ? and id_produto = ?");
	         stm.setString(1, id); 
	         stm.setString(2, id_PRODUTO);
	         rs = stm.executeQuery(); 
	            if(rs.next()){
	      objclienteDTO.setCnpj(rs.getString("cnpj"));
	   
	      return objclienteDTO; 
	            } else {
	                return null;
	            }
	        } catch (SQLException ex) {
	            return null;
	        }
	}

}
