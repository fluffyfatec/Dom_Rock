package modal;

public class EscopoTabelaFuncionalidades {
	String nmproduto;
	String funcionalidades;
	
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
}
