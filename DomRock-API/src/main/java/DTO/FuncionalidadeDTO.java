package DTO;

public class FuncionalidadeDTO {
	
	private int paineis;
	private int buscaNlp;
	private int geradorRelat;
	private int geradorData;
	private String idCliente;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}



	public int getPaineis() {
		return paineis;
	}

	public void setPaineis(int paineis) {
		this.paineis = paineis;
	}

	public int getBuscaNlp() {
		return buscaNlp;
	}

	public void setBuscaNlp(int buscaNlp) {
		this.buscaNlp = buscaNlp;
	}

	public int getGeradorRelat() {
		return geradorRelat;
	}

	public void setGeradorRelat(int geradorRelat) {
		this.geradorRelat = geradorRelat;
	}

	public int getGeradorData() {
		return geradorData;
	}

	public void setGeradorData(int geradorData) {
		this.geradorData = geradorData;
	}
}
