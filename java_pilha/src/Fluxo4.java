public class Fluxo4 {

	public static void main(String[] args) { //Não é necessário usar o aviso na assinatura do método main por ele ter um bloco try catch que captura aquela determinada exceção (no caso a "MinhaExcecao"), as duas maneiras de resolver uma exceção checked é ou inserir o aviso nas assinaturas dos métodos ou usar um try catch para resolver as exceções
        System.out.println("Ini do main");
        try { 
        	metodo1();
        } catch(Exception ex) { //Para não ter que ficar adicionando infinitamente mais exceções dentro do "catch" utilizando o pipe ("|") tem como criar um catch genérico qu7e pega qualquer exceção, é só passar como parametro a clase "Exception" já que toda exceção ou herda dessa classe, ou herda da classe "RuntimeException" que por sua vez herda da "Exception", ou seja, toda exceção é da classe "Exception" direta ou indiretamente, por isso passando ela como parametro o polimorfismo age e consegue pegar qualquer exceção dentro do código
        	String msg = ex.getMessage(); //Porém não é muito sintático usar esse catch genérico, por isso é sempre bom ser o mais específico possível ao utilizar o catch informando os tipos de exceções possíveis
        	System.out.println("Exception " + msg); 
        	ex.printStackTrace(); 
        } 
        System.out.println("Fim do main");
    }
	
    private static void metodo1() throws MinhaExcecao { //Também é necessário botar o aviso na assinatura do metodo1 por ser ele o responsavel por chamar o metodo2, temos que deixar o Java avisado que será chamada um exceção em sequencia senão o código sequer compila
        System.out.println("Ini do metodo1"); 
        metodo2(); 
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() throws MinhaExcecao { //Quando uma exceção herda a classe "Exception" o "throw" não funciona normalmente, para que ele funcione é necessário avisar que a exceção será jogada na própria assinatura do método em que ela é jogada utilizando a palavra chave "throws (exceção desejada)"
    	System.out.println("Ini do metodo2"); 

    	throw new MinhaExcecao("Deu muito errado!!!"); //Lançando a exceção criada por mim
    	
        //System.out.println("Fim do metodo2"); 
    }
    
}
