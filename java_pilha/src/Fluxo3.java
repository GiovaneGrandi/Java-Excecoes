public class Fluxo3 {

	public static void main(String[] args) {
        System.out.println("Ini do main");
        try { 
        	metodo1();
        } catch(ArithmeticException | NullPointerException ex) { //Por as exceções erem classes é possível usar o "ctrl" e ao pousar o mouse por cima delas abri o código fonte daquela classe, ou no caso, exceção
        	String msg = ex.getMessage(); 
        	System.out.println("Exception " + msg); 
        	ex.printStackTrace(); 
        } 
        System.out.println("Fim do main");
    }
	
    private static void metodo1() {
        System.out.println("Ini do metodo1"); 
        metodo2(); 
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
    	System.out.println("Ini do metodo2"); 
    	
    	throw new ArithmeticException("Deu errado!!"); //Criando um objeto do tipo "ArithmeticException", se a ArithmeticException consegue ter uma referencia é porque elá é um tipo de classe, então tem um construtor para criar um objeto da mesma /O construtor da exceção pode receber uma string que será mostrada no lugar da mensagem default
    	//throw ex; //A palavra chave "throw" serve para "lançar" uma exceção no código, por meio da variavel "ex" que guardamos um objeto do tipo ArithmeticException nós lançamos essa exceção no código através do comando throw /O comando "throw" só aceita variaveis do tipo de uma exceção
    	//É possível resumir esse código em apenas uma linha, sem ter que guardar o objeto em uma variavel, apenas utilizando o "throw" diretamente
    	
        //System.out.println("Fim do metodo2"); //Assim que é jogada uma exceção no código o restante do metodo2 é o chamado de "código inalcançavel" então o programa nem compila, por isso comentei essa parte posterior a jogada da exceção
    }
    
}

//No mundo Java o lugar da memória que se guarda os objetos é conhecido como "HEAP"
