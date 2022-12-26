public class TestaContaComExcecaoChecked {

	public static void main(String[] args) {
		
		Conta c = new Conta();
		
		try {
			c.depoista(); //O método "deposita" não compila no código por ele ter em sua assinatura uma possível exceção, então é necessário que eu faça um try catch ou então que insira a exceção na assinatura do main
		} catch(MinhaExcecao ex) {
			System.out.println("Tratamento...");
		}
		
	}
	
}
