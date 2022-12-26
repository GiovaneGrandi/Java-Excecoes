public class FluxoComError {

	public static void main(String[] args) {
        System.out.println("Ini do main");
        try { 
        	metodo1();
        } catch(ArithmeticException | NullPointerException ex) { //Como a exceção "MinhaExcecao" é do tipo "checked" se nenhum método tiver o "throw" avisando dela na assinatura o código não compila se ela estiver no escopo do "catch" afinal essa exceção nunca vai acontecer já que ela é checked e o compilador sempre vai saber quando tiver o perigo de uma checked aparecer já que ele te obriga a avisar, por isso uma exceção checked não pode ser usada em vão em um bloco "catch"  
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
        metodo2(); //Forçando um "Error" do Java ao chamar o metodo2 infinitamente por ele se auto invocar e então iniciar novamente e se auto invocar repetidas vezes resulta no erro "StackOverflowError" que acontece quando a pilha do Java é sobrecarregada, existe um limite de métodos que a pilha consegue comportar
        System.out.println("Fim do metodo2");
    }
    
}
