
package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EscopoDAO {

	Connection con;
	PreparedStatement stm;
	ResultSet rs;

	public EscopoDTO consultaId(String cnpj) {
		try (Connection con = new ConnectionFactory().conectaBD()) {
			EscopoDTO objescopoDTO = new EscopoDTO();
			stm = con.prepareStatement("Select * from Cliente where cnpj = ?");
			stm.setString(1, cnpj);
			rs = stm.executeQuery();

			if (rs.next()) {
				objescopoDTO.setCnpj(rs.getString("cnpj"));
				objescopoDTO.setRazaoSocial(rs.getString("razao_social"));
				objescopoDTO.setIdCliente(rs.getString("id_cliente"));
				return objescopoDTO;
			} else {
				return null;
			}

		} catch (SQLException ex) {
			return null;
		}

	}
	public void cadastrarDescritivo(EscopoDTO escopo) {
		
		String sql = "INSERT INTO Descritivo (objetivo_negocio," 
				+ "entregavel_min,"
				+ "entregavel_possivel, id_cliente)" 
				+ "values (?,?,?,?)";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			//PreparedStatement stm = connection.prepareStatement(sql);
			
			
			stm.setString(1, escopo.getEntregaveisMinimos());
			stm.setString(2, escopo.getObjNegocios());
			stm.setString(3, escopo.getEntregaveisPossiveis());
			stm.setString(4, escopo.getIdCliente());
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
public EscopoDTO consultaProduto(String idProduto) {
	try (Connection con = new ConnectionFactory().conectaBD()) {
		EscopoDTO objidProduto = new EscopoDTO();
		stm = con.prepareStatement("Select * from Produto where id_produto = ?");
		stm.setString(1, idProduto);
		rs = stm.executeQuery();

		if (rs.next()) {
			objidProduto.setOptimization(rs.getString("optimization"));
			objidProduto.setMatchingRisk(rs.getString("matchingRisk"));
			objidProduto.setVox(rs.getString("vox"));
			objidProduto.setPricing(rs.getString("pricing"));
			objidProduto.setMarketingPlanning(rs.getString("marketingPlanning"));
			objidProduto.setSalesDistribution(rs.getString("salesDistribution"));

			
			return objidProduto;
		} else {
			return null;
		}

	} catch (SQLException ex) {
		return null;
	}

}

public EscopoDTO cadastroproduto(ArrayList<String> listprodutos, String IdCliente) {
	try (Connection con = new ConnectionFactory().conectaBD()) {
		stm = con.prepareStatement("INSERT INTO Cliente_Produto (id_cliente,id_produto) VALUES (?,?)");
		for(String list : listprodutos) {
			stm.setString(1,IdCliente);
			stm.setString(2,list);
			stm.executeUpdate();
		}
	} catch (SQLException ex) {
		return null;
	}
	return null;
}

public EscopoDTO consultaboxproduto(ObservableList<String> boxprodutocliente, String IdCliente) {
	try (Connection con = new ConnectionFactory().conectaBD()) {
		stm = con.prepareStatement("SELECT prod.nm_produto FROM Cliente_Produto font INNER JOIN Produto prod ON prod.id_produto = font.id_produto WHERE font.id_cliente = ?");
		stm.setString(1, IdCliente);
		rs = stm.executeQuery();
		EscopoDTO objescopoDTO = new EscopoDTO();
		ArrayList<String> gambiarralist = new ArrayList<String>();
		if(rs!=null){
			while (rs.next()) {
			//PERIGO NAO APAGAR A GAMBIARRALIST PELO AMOR DE DEUS
			gambiarralist.add(rs.getString("nm_produto"));
		}
		objescopoDTO.boxprodutocliente = FXCollections.observableArrayList(gambiarralist);
		objescopoDTO.boxprodutoclientedois = FXCollections.observableArrayList(gambiarralist);
		objescopoDTO.boxprodutobronze = FXCollections.observableArrayList(gambiarralist);

		return objescopoDTO;
		}
	} catch (SQLException ex) {
		return null;
	}
	return null;
}

public EscopoDTO consultacrudproduto(ArrayList<String> crudprodutolist, String IdCliente) {
	try (Connection con = new ConnectionFactory().conectaBD()) {
		stm = con.prepareStatement("SELECT nm_produto FROM Cliente_Produto cp INNER JOIN Produto prod ON prod.id_produto = cp.id_produto WHERE id_cliente = ?");
		stm.setString(1, IdCliente);
		rs = stm.executeQuery();
		EscopoDTO objescopoDTO = new EscopoDTO();
		//ArrayList<String> gambiarralist2 = new ArrayList<String>();
		if(rs!=null){
			while (rs.next()) {
			//PERIGO NAO APAGAR A GAMBIARRALIST PELO AMOR DE DEUS
			crudprodutolist.add(rs.getString("nm_produto"));
		}
		//objescopoDTO.crudprodutolist = (gambiarralist2);

		return objescopoDTO;
		}
	} catch (SQLException ex) {
		return null;
	}
	return null;
}
	
	public EscopoDTO cadastrocore(String nmproduto,String core,String IdCliente) {
		EscopoDTO objescopoDTO = new EscopoDTO();
		try (Connection con = new ConnectionFactory().conectaBD()) {
			stm = con.prepareStatement("INSERT INTO ClienteProduto_Core (id_cliente_produto, id_core) VALUES (("+
					"SELECT id_cliente_produto FROM Cliente_Produto fd INNER JOIN Produto prod "+
					"ON prod.id_produto = fd.id_produto WHERE fd.id_cliente = ? AND prod.nm_produto = ?), "+
					"(SELECT cc.id_core FROM Core cc WHERE cc.recurso = ?))");
			stm.setString(1, IdCliente);
			stm.setString(2, nmproduto);
			stm.setString(3, core);
			stm.execute();
			stm.close();
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	return objescopoDTO;
	}
	
	public EscopoDTO cadastrofuncionalidade(String nmproduto,String funcionalidades,String IdCliente) {
		EscopoDTO objescopoDTO = new EscopoDTO();
		try (Connection con = new ConnectionFactory().conectaBD()) {
			stm = con.prepareStatement("INSERT INTO ClienteProduto_Funcionalidade (id_cliente_produto, id_funcionalidade) VALUES (("+
					"SELECT id_cliente_produto FROM Cliente_Produto fd INNER JOIN Produto prod "+
					"ON prod.id_produto = fd.id_produto WHERE fd.id_cliente = ? AND prod.nm_produto = ?), "+
					"(SELECT func.id_funcionalidade FROM Funcionalidade func WHERE func.nm_funcionalidade = ?))");
			stm.setString(1, IdCliente);
			stm.setString(2, nmproduto);
			stm.setString(3, funcionalidades);
			stm.execute();
			stm.close();
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	return objescopoDTO;
	}
	
	public EscopoDTO consultadescritivo(String IdCliente) {
		String sql = "SELECT d.objetivo_negocio, d.entregavel_min, d.entregavel_possivel FROM Descritivo d WHERE d.id_cliente = ?";
		EscopoDTO objescopoDTO = new EscopoDTO();
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){	
			stm.setString(1, IdCliente); rs = stm.executeQuery();
			if(rs.next())
			objescopoDTO.setEntregaveisMinimos(rs.getString("objetivo_negocio"));
			objescopoDTO.setObjNegocios(rs.getString("entregavel_min"));	
			objescopoDTO.setEntregaveisPossiveis(rs.getString("entregavel_possivel"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return objescopoDTO;
	}
	
	public EscopoDTO atualizardescritivo(String IdCliente, String entregavelminimos, String entregavelpossivel, String objetivonegocio) {
		String sql = "UPDATE Descritivo SET objetivo_negocio = ?, entregavel_min = ?, entregavel_possivel = ? WHERE id_cliente = ?";
		EscopoDTO objescopoDTO = new EscopoDTO();
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){		
			stm.setString(1, objetivonegocio);
			stm.setString(2, entregavelminimos);
			stm.setString(3, entregavelpossivel);
			stm.setString(4, IdCliente);
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return objescopoDTO;
	}
	
	public List<EscopoTabelaCore> consultarCore(String id_cliente) throws SQLException {
			
			List<EscopoTabelaCore> core = new ArrayList<>();
			
			String sql = "SELECT id_clienteproduto_core, id_cliente_produto, nm_produto, recurso FROM view_cliente_core WHERE id_cliente = ?";
		
	
			try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
				stm.setString(1, id_cliente); ResultSet resultSet = stm.executeQuery();
				
				while (resultSet.next()){
				
					EscopoTabelaCore objCore = new EscopoTabelaCore();
					objCore.setIdcoreproduto(resultSet.getInt("id_clienteproduto_core"));
					objCore.setIdclienteproduto(resultSet.getInt("id_cliente_produto"));
					objCore.setNmproduto(resultSet.getString("nm_produto"));
					objCore.setCore(resultSet.getString("recurso"));
					
					core.add(objCore);
			
				}
				
				resultSet.close();
				stm.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return core;
	}
	
	public List<EscopoTabelaFuncionalidades> consultarFuncionalidades(String id_cliente) throws SQLException {
		
		List<EscopoTabelaFuncionalidades> funcionalidade = new ArrayList<>();
		String sql = "SELECT id_clienteproduto_funcionalidade, id_cliente_produto, nm_produto, nm_funcionalidade FROM view_cliente_funcionalidade WHERE id_cliente = ?";
	
	
	
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			stm.setString(1, id_cliente); ResultSet resultSet = stm.executeQuery();
			
			while (resultSet.next()){
			
				EscopoTabelaFuncionalidades objFuncionalidade = new EscopoTabelaFuncionalidades();
				
				objFuncionalidade.setIdprodutofuncionalidade(resultSet.getString("id_clienteproduto_funcionalidade"));
				objFuncionalidade.setId(resultSet.getString("id_cliente_produto"));
				objFuncionalidade.setNmproduto(resultSet.getString("nm_produto"));
				objFuncionalidade.setFuncionalidades(resultSet.getString("nm_funcionalidade"));
				
				funcionalidade.add(objFuncionalidade);
		
			}
			
			resultSet.close();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return funcionalidade;
	}
	
	public EscopoDTO select(ObservableList<String> boxfuncionalidade) {
		try (Connection con = new ConnectionFactory().conectaBD()) {
			stm = con.prepareStatement("Select nm_funcionalidade from funcionalidade");
			rs = stm.executeQuery();
			EscopoDTO objescopoDTO = new EscopoDTO();
			ArrayList<String> funcionalidadelist = new ArrayList<String>();
			if(rs!=null){
				while (rs.next()) {
					funcionalidadelist.add(rs.getString("nm_funcionalidade"));
			}
			objescopoDTO.boxfuncionalidade = FXCollections.observableArrayList(funcionalidadelist);
			
	
			return objescopoDTO;
			}
		} catch (SQLException ex) {
			return null;
		}
		return null;
	}
	
	public EscopoDTO selectcore(ObservableList<String> boxcores) {
		try (Connection con = new ConnectionFactory().conectaBD()) {
			stm = con.prepareStatement("Select Recurso from Core");
			rs = stm.executeQuery();
			EscopoDTO objescopoDTO = new EscopoDTO();
			ArrayList<String> corelist = new ArrayList<String>();
			if(rs!=null){
				while (rs.next()) {
					corelist.add(rs.getString("recurso"));
			}
			objescopoDTO.boxcores = FXCollections.observableArrayList(corelist);
			
	
			return objescopoDTO;
			}
		} catch (SQLException ex) {
			return null;
		}
		return null;
	
	}
	
	public void deletarcore(Integer id_clienteproduto_core) {
		String sql = "DELETE ClienteProduto_Core WHERE id_clienteproduto_core = ?";
	
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setInt(1, id_clienteproduto_core);
			
			stm.execute();	
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void deletarfuncionalidade(String id_clienteproduto_funcionalidade) {
		String sql = "DELETE ClienteProduto_Funcionalidade WHERE id_clienteproduto_funcionalidade = ?";
	
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setString(1, id_clienteproduto_funcionalidade);
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
			
	
