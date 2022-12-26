public class Conexao implements AutoCloseable { //Criando uma classe que simula uma conexão com um servidor /A interface "AutoCloseable" serve para objetos que necessitam encerrar alguma conexão por já virem com um método adequado para o fechamento automatico do objeto

    public Conexao() { //O construtor que ao ser chamado ele "inicia" a conexão com o server
        System.out.println("Abrindo conexao");
        throw new IllegalStateException(); //Ao jogar uma exceção no construtor do objeto ele não conseguirá ser criado, acarretando em mais erros na execução do "finally"
    }

    public void leDados() { //O método que ao ser invocado começa a pegar os dados do servidor
        System.out.println("Recebendo dados");
        throw new IllegalStateException();
    }

//    public void fecha() { //E o método que encerra a comunicação entre o código e o server
//    	System.out.println("Fechando conexao");
//    }

	@Override
	public void close() { //Substituindo o método "fecha" pelo "close" por ser um padrão sintático
		System.out.println("Fechando conexao");		
	}
    
}

//Toda conexão com um servidor que for aberta também deve ser fechada, por isso que com as exceções as vezes é um desafio conseguir encerrar as comunicações de maneira adequada por conta das mudanças de fluxo do código, é aí que entra a palavra chave "finally"
