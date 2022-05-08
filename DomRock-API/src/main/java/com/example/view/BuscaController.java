package com.example.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import DAO.ConexaoDAO;
import DTO.ClienteDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BuscaController {

	@FXML
	private TextField razaosocialconsulta;

	@FXML
	private TextField cnpjconsulta;
	@FXML
	private ListView<String> listaBusca;

	public ObservableList<ClienteDTO> data;

	@FXML
	private void btnBuscaconsulta(ActionEvent event) throws ClassNotFoundException, SQLException {

		ObservableList<String> nomes = FXCollections.observableArrayList();
		ObservableList<String> cnpjs = FXCollections.observableArrayList();

		if ((Objects.equals(cnpjconsulta.getText(), "")) && (Objects.equals(razaosocialconsulta.getText(), ""))) {
			Alerts.display("Erro", "Insira pelo menos um dos parâmetros");
		}

		if ((Objects.equals(cnpjconsulta.getText(), "")) && (!Objects.equals(razaosocialconsulta.getText(), ""))) {
			String sql = "select * from Cliente where razao_social like '%" + razaosocialconsulta.getText() + "%'";

			Connection conn = new ConexaoDAO().conectaBD();
			Statement stm = conn.createStatement();

			ResultSet resultado = stm.executeQuery(sql);

			if (!resultado.isBeforeFirst()) {
				Alerts.display("Info", "Nenhum resultado encontrado");
			} else {
				while (resultado.next()) {
					nomes.add(resultado.getString("razao_social"));
				}
				listaBusca.setItems(nomes);
				System.out.println("Lista: " + nomes);
			}

		}
		if ((Objects.equals(razaosocialconsulta.getText(), "")) && (!Objects.equals(cnpjconsulta.getText(), ""))) {
			String sql = "select * from Cliente where cnpj like '%" + cnpjconsulta.getText() + "%'";

			Connection conn = new ConexaoDAO().conectaBD();
			Statement stm = conn.createStatement();

			ResultSet resultado = stm.executeQuery(sql);

			if (!resultado.isBeforeFirst()) {
				Alerts.display("Info", "Nenhum resultado encontrado");
			} else {
				while (resultado.next()) {
					nomes.add(resultado.getString("razao_social"));
				}
				listaBusca.setItems(nomes);
				System.out.println("Lista: " + nomes);
			}

		}
		if ((!Objects.equals(razaosocialconsulta.getText(), "")) && (!Objects.equals(cnpjconsulta.getText(), ""))) {
			String sql = "select * from Cliente where razao_social like '%" + razaosocialconsulta.getText()
					+ "%' and cnpj like '%" + cnpjconsulta.getText() + "%'";

			Connection conn = new ConexaoDAO().conectaBD();
			Statement stm = conn.createStatement();

			ResultSet resultado = stm.executeQuery(sql);

			if (!resultado.isBeforeFirst()) {
				Alerts.display("Info", "Nenhum resultado encontrado");
			} else {
				while (resultado.next()) {
					nomes.add(resultado.getString("razao_social"));
				}
				listaBusca.setItems(nomes);
				System.out.println("Lista: " + nomes);
			}
		}

	}

	@FXML
	void btnLimparconsulta(ActionEvent event) {

		razaosocialconsulta.setText(null);
		cnpjconsulta.setText(null);

	}
}
