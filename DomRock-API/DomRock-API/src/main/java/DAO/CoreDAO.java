package DAO;

import java.sql.*;

import javax.swing.JOptionPane;
import DTO.CoreDTO;

public class CoreDAO {
	
	  Connection conn;
	  PreparedStatement pstm;
	  
	  
public void cadastrarCore(CoreDTO objCoreDTO) throws SQLException {

		String sql = "insert into Cliente_Core (id_core, id_cliente) values (?, ?)";

		try(Connection conn= new ConexaoDAO().conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql);) {

			if (objCoreDTO.getWeb() == 1) {
				pstm.setInt(1, objCoreDTO.getWeb());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}
			if (objCoreDTO.getGateway() == 2) {
				pstm.setInt(1, objCoreDTO.getGateway());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}
			if (objCoreDTO.getFilas() == 3) {
				pstm.setInt(1, objCoreDTO.getFilas());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}
			if (objCoreDTO.getStepfunction() == 4) {
				pstm.setInt(1, objCoreDTO.getStepfunction());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}
			if (objCoreDTO.getLambda() == 5) {
				pstm.setInt(1, objCoreDTO.getLambda());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}
			if (objCoreDTO.getFargate() == 6) {
				pstm.setInt(1, objCoreDTO.getFargate());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}
			if (objCoreDTO.getContainers() == 7) {
				pstm.setInt(1, objCoreDTO.getContainers());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}
			if (objCoreDTO.getS3() == 8) {
				pstm.setInt(1, objCoreDTO.getS3());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}
			if (objCoreDTO.getMongodb() == 9) {
				pstm.setInt(1, objCoreDTO.getMongodb());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}
			if (objCoreDTO.getParquet() == 10) {
				pstm.setInt(1, objCoreDTO.getParquet());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}
			if (objCoreDTO.getQuicksight() == 11) {
				pstm.setInt(1, objCoreDTO.getQuicksight());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}
			if (objCoreDTO.getCloudwatch() == 12) {
				pstm.setInt(1, objCoreDTO.getCloudwatch());
				pstm.setString(2, objCoreDTO.getIdCliente());
				pstm.execute();
			}

			pstm.close();


		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	}





