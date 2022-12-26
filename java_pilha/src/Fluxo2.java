public class Fluxo2 {

	public static void main(String[] args) {
        System.out.println("Ini do main");
        try { 
        	metodo1();
        } catch(ArithmeticException | NullPointerException ex) { //Ao usar o "|" que significa "ou" você consegue fazer um catch que captura mais de um tipo de exceções sem ter que ficar repetindo catchs a todo momento porém ele só pega uma exceção por vez, não consegue pegar várias exceções simultaneamente
        	String msg = ex.getMessage(); //Como o "ArithmeticException" é uma classe é possível chamar seus métodos através de uma referencia /O método "getMessage" serve para chamar a mensagem que aponta o erro junto da mensagem default da exceção com o rastro da pilha quando não se tem o "try catch"
        	System.out.println("Exception " + msg); //Ao executar um "catch" o código retoma o seu funcionamento normalmente, nesse caso ele irá seguir normalmente com o laço do for e então sempre que chegar na parte do erro ele irá exibir o sysout e então seguirá normalmente, assim impedindo que o código quebre no meio da execução
        	
        	ex.printStackTrace(); //Esse método serve para mostrar a mensagem de exception default do compilador e também mostrar o rastro da pilha
        } //É recomendavel que o "catch" esteja no mesmo trecho de código da exceção, afinal ele poderia estar na chamada do metodo2 no meio do metodo1 já que o metodo2 tem um código perigoso, porém ao executar o metodo2 e encontrar a exceção o compilador irá jogar a "bomba" no método e como não terá nenhuma solução ali ele retornará para o metodo1 onde estará o "catch", então a partir desta parte do código ele será executado normalmente /Isso muda o fluxo do código, por isso é importante o "catch" estar ligado diretamente a exceção
        System.out.println("Fim do main");
        
    }
	
    private static void metodo1() {
        System.out.println("Ini do metodo1"); 
        metodo2(); 
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
    	System.out.println("Ini do metodo2"); 
        for(int i = 1; i <= 5; i++) { 
        System.out.println(i);
        int a = i / 0; //O java não é capaz de dividir por zero então esse código dá um erro e retorna uma "ArithmeticException", uma exceção nada mais é que um erro, "esse código funcionaria, exceto por isso" /Quando aparece uma exceção no código ele para e então o compilador procura alguém capaz de solucionar a exceção, nesse caso a exceção aparece no meio do metodo2 que é abortado assim que ela aparece, a solução é procurada no metodo2 e não é encontrada então o compilador vai e joga uma "bomba" no metodo2 o tirando assim da pilha e voltando para o metodo1, como ele também não acha nada ali ele joga outra "bomba" e volta para o main que também não tem a solução, fazendo com que a "bomba" estoure no console em forma de erro
        //Conta c = null; //Criando uma referencia que não aponta pra objeto nenhum
        //c.depoista(); //Invocando um método em uma referencia que não aponta pra nenhum objeto assim resultando em um erro (NullPointerException)
        }
        System.out.println("Fim do metodo2"); 
    }
    
}
