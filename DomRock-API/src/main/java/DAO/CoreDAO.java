package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.CoreDTO;

public class CoreDAO {
	
	  Connection conn;
	  PreparedStatement pstm;
	  
	  
public void cadastrarCore(CoreDTO objCoreDTO) throws SQLException {

	String sql_id_cliente = "SELECT TOP 1 * FROM Cliente ORDER BY id_cliente DESC;";
	Connection conn1 = new ConexaoDAO().conectaBD();
	Statement stm1 = conn1.createStatement();
	ResultSet result_id_cliente = stm1.executeQuery(sql_id_cliente);

	while (result_id_cliente.next()) {
		int id_cliente = result_id_cliente.getInt("id_cliente");

		String sql = "insert into Cliente_Core (cc_id_cliente, cc_id_core) values ("+id_cliente+", ?)";

		try(Connection conn= new ConexaoDAO().conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql);) {

			if (objCoreDTO.getWeb() == 1) {
				pstm.setInt(1, objCoreDTO.getWeb());
				pstm.execute();
			}
			if (objCoreDTO.getGateway() == 2) {
				pstm.setInt(1, objCoreDTO.getGateway());
				pstm.execute();
			}
			if (objCoreDTO.getFilas() == 3) {
				pstm.setInt(1, objCoreDTO.getFilas());
				pstm.execute();
			}
			if (objCoreDTO.getStepfunction() == 4) {
				pstm.setInt(1, objCoreDTO.getStepfunction());
				pstm.execute();
			}
			if (objCoreDTO.getLambda() == 5) {
				pstm.setInt(1, objCoreDTO.getLambda());
				pstm.execute();
			}
			if (objCoreDTO.getFargate() == 6) {
				pstm.setInt(1, objCoreDTO.getFargate());
				pstm.execute();
			}
			if (objCoreDTO.getContainers() == 7) {
				pstm.setInt(1, objCoreDTO.getContainers());
				pstm.execute();
			}
			if (objCoreDTO.getS3() == 8) {
				pstm.setInt(1, objCoreDTO.getS3());
				pstm.execute();
			}
			if (objCoreDTO.getMongodb() == 9) {
				pstm.setInt(1, objCoreDTO.getMongodb());
				pstm.execute();
			}
			if (objCoreDTO.getParquet() == 10) {
				pstm.setInt(1, objCoreDTO.getParquet());
				pstm.execute();
			}
			if (objCoreDTO.getQuicksight() == 11) {
				pstm.setInt(1, objCoreDTO.getQuicksight());
				pstm.execute();
			}
			if (objCoreDTO.getCloudwatch() == 12) {
				pstm.setInt(1, objCoreDTO.getCloudwatch());
				pstm.execute();
			}

			pstm.close();


		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	}

}


