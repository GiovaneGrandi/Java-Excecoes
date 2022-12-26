public class TesteContas {
	public static void main(String[] args) throws SaldoInsuficienteException {
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100);
		
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200);
		
		cc.transfere(10, cp); //Na hora da transferencia é pedido um objeto do tipo "Conta" mas ele funciona mesmo mandando objetos filhos da conta, como a contapoupança, de novo o polimorfismo está funcionando
		//Ao fazer a transeferencia o método "saca" executado dentro do transfere é o método de quem o está chamando, no caso a contacorrente, por isso a taxa foi aplicada com sucesso, ele poderia chamar o saca generico da conta mas decidiu por chamar do objeto correto
		System.out.println("CC: " + cc.getSaldo());
		System.out.println("CP: " + cp.getSaldo());
	}
}
