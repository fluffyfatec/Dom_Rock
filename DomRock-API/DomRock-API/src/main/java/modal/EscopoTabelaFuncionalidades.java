package modal;

public class EscopoTabelaFuncionalidades {
	String nmproduto;
	String funcionalidades;
	String Id;

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getNmproduto() {
		return nmproduto;
	}
	public void setNmproduto(String nmproduto) {
		this.nmproduto = nmproduto;
	}
	public String getFuncionalidades() {
		return funcionalidades;
	}
	public void setFuncionalidades(String funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
	public EscopoTabelaFuncionalidades(String nmproduto, String funcionalidades) {
		this.nmproduto = nmproduto;
		this.funcionalidades = funcionalidades;
	}

	public EscopoTabelaFuncionalidades() {
		// TODO Auto-generated constructor stub
	}
}
