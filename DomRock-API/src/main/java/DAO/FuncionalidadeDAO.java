package DAO;

import java.sql.*;


import DTO.ClienteDTO;
import DTO.FuncionalidadeDTO;


public class FuncionalidadeDAO {

	Connection conn;
	PreparedStatement pstm;
	ClienteDTO idCliente;

	public void cadastrarFuncionalidade(FuncionalidadeDTO objFuncionalidadeDTO) throws SQLException {
				
		
			String sql = "insert into Cliente_Funcionalidade (id_funcionalidade, id_cliente) values (?, ?)";

			try (Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql);) {

				if (objFuncionalidadeDTO.getGeradorRelat() == 1) {
					pstm.setInt(1, objFuncionalidadeDTO.getGeradorRelat());
					pstm.setString(2, objFuncionalidadeDTO.getIdCliente());
					
					
					pstm.execute();
				}
				if (objFuncionalidadeDTO.getPaineis() == 2) {
					pstm.setInt(1, objFuncionalidadeDTO.getPaineis());
					pstm.setString(2, objFuncionalidadeDTO.getIdCliente());
					
					
					pstm.execute();
				}
				if (objFuncionalidadeDTO.getBuscaNlp() == 3) {
					pstm.setInt(1, objFuncionalidadeDTO.getBuscaNlp());
					pstm.setString(2, objFuncionalidadeDTO.getIdCliente());
					
					pstm.execute();
				}
				if (objFuncionalidadeDTO.getGeradorData() == 4) {
					pstm.setInt(1, objFuncionalidadeDTO.getGeradorData());
					pstm.setString(2, objFuncionalidadeDTO.getIdCliente());
					
					pstm.execute();
				}

				pstm.close();


			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}


	}

	  

