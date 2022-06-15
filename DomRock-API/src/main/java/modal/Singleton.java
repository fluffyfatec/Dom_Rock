package modal;

public class Singleton {
	
	public String IdCliente;

	public String etapa;
	
	public String teste;
	
	static private Singleton instance;
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}