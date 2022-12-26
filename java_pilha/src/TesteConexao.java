public class TesteConexao {
	
	public static void main(String[] args) {
		
		//Versão do código abreviado:
		
		
		try (Conexao conexao1 = new Conexao()) { //Para usar esse tipo de try especial "onde o objeto é inicializado dentro dos parenteses com se estivesse recebendo um parametro de um método ao invés de cria-lo antes e inicializa-lo depois, é necessário que esse objeto tenha um contrato com a interface "AutoCloseable" 
			conexao1.leDados(); //Esse try resume todo o bloco try e finally do outro código em 2 linhas, pois esse código irá fechar automaticamente a conexão (com ou sem exceção), o finally está sub-entendido nessa nova versão do bloco try
		} catch(IllegalStateException ex) { //Como esse bloco try já vem com o finally imbutido ele não necessita obrigatoriamente de um catch, por já ter o finally
			System.out.println("Erro de conexão!");
		} //Caso haja uma exceção na construção do objeto esse try também não irá conseguir fechar o objeto por ele sequer ter sido iniciado 
		
		
		//Versão do código original:
		
//		Conexao conexao = null; //Criando uma variavel global (Que funcionará em todo o código e não só dentro de um método)
//		
//		try {
//			conexao = new Conexao(); //Pegando aquela variavel feita previamente e agora armazenando a referencia de um objeto do tipo "Conexao" /Por ter sido jogada uma exceção no construtor do código ele não é inicializado aqui, ele tenta, consegue executar o sysout porém não consegue ser inicializada devidamente, por isso ela volta a ser "null" como no inicio do código
//			conexao.leDados();
//		} catch(IllegalStateException ex) { //Fazendo o catch para pegar a exceção desejada
//			System.out.println("Erro de conexão!"); //Mostrando uma mensagem caso esse erro seja pego
//		} finally { //O comando "finally" é um bloco opcional do try catch onde tudo o que estiver dentro dele será executado com exceção ou sem, caso a gente tivesse deixado o comando "fecha" no try e uma exceção fosse localizada ele não seria executado por causa da mudança de fluxo do código, com o finally podemos executarmos oque quisermos independente do que aconteça no código, assim conseguindo fechar a conexão com o nosso servidor
//			System.out.println("finally"); //Mostrando que o finally continua sendo executado porém o problema está no método não conseguir ser invocado
//			if(conexao != null) { //Tratando o método para evitar a NullPointerException, assim com esse if ele irá executar o método só quando a referencia "conexao" for diferente de "null", portanto nesse caso ela não é nem chamada por isso a exceção é evitada
//			conexao.close(); //Já que o objeto do tipo "Conexao" não conseguiu ser inicializado devidamente a invocação do método não funciona por ser uma referencia que não aponta pra nada, por isso sem tratamento nenhum o console retorna uma "NullPointerException"
//			}
//		}
		
	}

}

//Um "try" não compila sozinho, para ele funcionar precisa estar acompanhado de um "catch" como já visto várias vezes ou então estar acompanhado só do "finally", dessa forma ele não captura a exceção, ele apenas tenta executar e se encontrar uma exceção ele irá executar o finally e então a "bomba" da exceção irá cair no console
