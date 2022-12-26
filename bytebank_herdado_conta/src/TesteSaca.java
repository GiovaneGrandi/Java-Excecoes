public class TesteSaca {
	
	public static void main(String[] args) {
		Conta conta = new ContaCorrente(123, 123);
		
		conta.deposita(200);
		
		try {
			conta.saca(210);
		} catch (SaldoInsuficienteException ex) { //Criando um tratamento para a exceção no código, mesmo que a exceção seja do tipo "Runtime" e não exija tratamento é possível trata-la para que o fluxo do código não mude
			System.out.println(ex.getMessage()); //Com a exceção sendo do tipo "Exception" é origatório um tratamento para o código compilar, seja um aviso de perigo na assinatura do método através do "throws" ou de um bloco try catch para pegar a exceção e manter o fluxo original do código
		}
		
		System.out.println(conta.getSaldo());
	}

}
