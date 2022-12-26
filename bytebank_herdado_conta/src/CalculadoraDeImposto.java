public class CalculadoraDeImposto {
	
	private double totalImposto;
	
	public void registra(Tributavel tributavel) { //Método que recebe qualquer objeto que seja um Tributavel
		double valor = tributavel.getValorImposto(); //Percorrendo pela classe desse tributavel e invocando o método "getValorImposto"
		this.totalImposto += valor;
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}
	
}
