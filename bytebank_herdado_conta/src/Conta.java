public abstract class Conta { //Transformando a classe Conta em algo abstrato, que apenas pode ser herdada pelas outras contas e nunca pode ser instânciada 
	private double saldo; 
	private int agencia;			
	private int numero;
	private Cliente titular; //Privando todos os atributos da classe pois eles só devem ser mexidos dentro da classe
	private static int total; //Criando um atributo para medir a quantidade de contas criadas no banco /Usando a palavra chave "static" para definir que aquele atributo não é exclusivo de cada conta, até agora todas as contas tinham um saldo, um numero, uma agencia... Mas com o static o total passa a ser um atributo de todas as contas e não de uma só, agora todas as contas compartilham um único atributo total
	
	public Conta() { //Criando um construtor generico para poder usalo nas classes filhas
		
	}
	
	public Conta(int agencia, int numero) { //Criando um construtor para a Conta, assim quando for criada uma new Conta será obrigatório passar os parâmetros desejados e então será executado tudo o que está dentro das chaves junto com a inicialização desse novo objeto
		Conta.total++; //Assim que o construtor rodar ele irá aumentar a contagem de contas criadas /No momento que se tem um atributo estático o "this." não funciona pra ele por não ser um atributo daquela conta específica, agora como o "total" é um atributo da classe Conta ele pode ser referenciado usando o "NomeDaClasse." no caso sendo "Conta."
		
		this.agencia = agencia; //Informando que os atributos da Conta vão receber os parâmetros informados no construtor
		this.numero = numero;
		
		System.out.println("Estou criando a conta " + this.numero + " da agência " + this.agencia); //Toda vez que uma Conta nova for criada essa mensagem será inicializada
		System.out.println("O total de contas criadas agora é " + Conta.total);
	}
	//O Java automaticamente te dá um construtor padrão até você definir um você mesmo, porém depois de definir um construtor o Java não aplicará mais o default, caso você precise dele terá que adiciona-lo por conta própria
	
	
	public void deposita(double valor) { 
		this.saldo += valor; 
	}
	
	public void saca(double valor) throws SaldoInsuficienteException { //Ao mudar a exceção para checked é necessário avisar o compilador que aqui será jogada uma exceção 
		if(this.saldo < valor) { //É mais comum quando se trabalha com a aplicação de exceções que os if que detectam se tem algo de errado na execução estejam no topo e que depois venha as condições para o código funcionar, assim as exceções são jogadas logo de cara caso algo dê errado 
			throw new SaldoInsuficienteException("O seu saldo é: " + this.saldo + " e o valor tentado retirar foi de: " + valor); //Criando uma exceção e a jogando na mesma linha sem variaveis intermediarias e também adicionando uma mensagem para auxiliar no entendimento do erro
		}
		this.saldo -= valor;
	}
	
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException { //Mesmo ele recebendo um objeto do tipo generico Conta é possível fazer transferencias entre contas de tipos diferentes
			this.saca(valor); //Não é mais preciso fazer uma verificação nesse método pois o método "saca" acima já faz a verificação, se ele não funcionar a exceção será disparada, se funcionar ele irá para a próxima linha do código desse método e irá executar corretamente a trasnferencia
			destino.deposita(valor);
	}
	
	public double getSaldo() { 
		return this.saldo; 
	}
	
	public int getNumero() { //Criando um método que irá pegar o número da conta e retorna-lo para quem o invoca
		return this.numero;
	}
	
	public void setNumero(int numero) { //Criando um método que servirá para criar um novo número para a conta caso precise no futuro adicionar novos parâmetros para o numero da conta
		if(numero <= 0) {
			System.out.println("Não é permitido números menores ou iguais a 0");
			return;
		}
		this.numero = numero; //Pode usar uma variavel temporária com o mesmo nome do atributo pois ele está sendo apoiado pelo this, então é o número "dessa conta que está chamando" que receberá o numero passado pelo programador
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("Não é permitido números menores ou iguais a 0");
			return; //Como esse método é um void e não retorna nada eu apenas uso o return para encerrar a execução do método ao concluir o if
		}
		this.agencia = agencia;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public static int getTotal() { //Usando o "static" pra definir um método para a classe Conta ao invés de suas intâncias, agora ao invés de ter que chamar uma conta qualquer para saber o total de contas podemos ir direto para a classe pedir
		return total;
	}
	//Um método estático só consegue acessar atributos estáticos daquela classe, o getTotal não conseguiria acessar o saldo de alguma conta por exemplo
}

//No atalho "Window" e "Show View" pode ser acessado o "Outline" que serve para listar todos os atributos e métodos de um objeto resumidamente para melhor navegação, também é possível acessar ele pelo atalho no teclado "Ctrl + O" ele irá abrir uma janelinha do Outline para navegar dentro dos objetos com mais facilidade




