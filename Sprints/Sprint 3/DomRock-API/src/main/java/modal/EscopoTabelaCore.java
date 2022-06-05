package modal;

public class EscopoTabelaCore {
String core;
String nmproduto;
Integer idclienteproduto;
Integer idcoreproduto;


public Integer getIdcoreproduto() {
	return idcoreproduto;
}
public void setIdcoreproduto(Integer idcoreproduto) {
	this.idcoreproduto = idcoreproduto;
}
public Integer getIdclienteproduto() {
	return idclienteproduto;
}
public void setIdclienteproduto(Integer idclienteproduto) {
	this.idclienteproduto = idclienteproduto;
}
public String getCore() {
	return core;
}
public void setCore(String core) {
	this.core = core;
}
public String getNmproduto() {
	return nmproduto;
}
public void setNmproduto(String nmproduto) {
	this.nmproduto = nmproduto;
}
public EscopoTabelaCore(String core, String nmproduto) {
	this.core = core;
	this.nmproduto = nmproduto;
}
public EscopoTabelaCore() {
	// TODO Auto-generated constructor stub
}



}
