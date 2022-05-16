package generics;

public class Par<C, V> {
	
	private C chave;
	private V valor;
	
	public Par () {
		 
	}
	
	public Par( C chave, V valor) {
		super();
		this.chave = chave;
		this.valor = valor;
	}
	
	public C getChave() {
		return chave;
	}
	
	public void setChave(C chave) {
		this.chave = chave;
	}
	
	public V getValor() {
		return valor; 
	}
	
	public void setValor(V valor) {
		this.valor = valor;
	}
	
	
	
}
