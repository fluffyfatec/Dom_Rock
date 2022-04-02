package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DTO.EntregavelDTO;

public class EntregavelDAO {

	Connection conn;
	PreparedStatement pstm;
	

public void cadastrarEntregavel( EntregavelDTO objEntregavelDTO) {	
	
	
	String sql = "insert into Cliente (objetivo_negocio,entregavel_min,entregavel_posseivel) values (?,?,?)";

	conn = new ConexaoDAO().conectaBD();
	try {

		pstm = conn.prepareStatement(sql);
		pstm.setString(1,objEntregavelDTO.getObjetivoNegocio());
		pstm.setString(2,objEntregavelDTO.getEntregaMin());
		pstm.setString(1,objEntregavelDTO.getEntregaPossivel());
		

		pstm.execute();
		pstm.close();

	} catch (Exception erro) {
		JOptionPane.showMessageDialog(null, "EntregavelDAO" + erro);
	}

}
}
