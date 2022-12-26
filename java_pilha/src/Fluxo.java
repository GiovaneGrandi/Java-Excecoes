public class Fluxo { //Montando um código para entender como funciona o fluxo da lnguagem Java e como funciona as pilhas (stacks)

	public static void main(String[] args) {
        System.out.println("Ini do main"); //O Java sempre começa a leitura pelo método main, então ele executa o sysout
        metodo1(); //Aqui ele inicia o metodo1 e deixa o restante do método main em espera porque só o método que está no topo da pilha é processado, nesse caso é o metodo1 agora
        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1"); //Então deixando o restante do main de lado ele executa o metodo1 começando obviamente pelo sysout
        metodo2(); //Aqui ele invoca o metodo2 e tudo se repete, o metodo1 fica em modo de espera em quanto agora o objeto do topo da pilha (metodo2) está sendo executado
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Ini do metodo2"); //Aqui ele inicia o metodo2
        for(int i = 1; i <= 5; i++) { //Então executa o laço do metodo2
            System.out.println(i);
            
            try { //O "try" serve para sinalizar o compilador que o código aqui dentro é perigoso, por isso é preciso tentar executa-lo com cautela
            	int a = i / 0; 
            } catch(ArithmeticException ex) { //Já o "catch" significa que "no caso da seguinte exceção ocorrer (nesse caso é a "ArithmeticException") execute o que está dentro desse bloco /Esse bloco só será executado se realmente houver uma "ArithmeticException" /A parte do "ex" é uma varíavel dada para armazenar esse erro dentro do bloco
            	String msg = ex.getMessage(); 
            	System.out.println("ArithmeticException " + msg); 
            	ex.printStackTrace(); 
            } 
        }
        
        System.out.println("Fim do metodo2"); //Aqui ele executa a última instrução do metodo2
        
        
    } //Ao chegar nas chaves finais do metodo 2 ele irá retornar ao metodo1 para finaliza-lo e assim que ele chegar em suas chaves finais ele irá voltar mais uma vez e finalizar o método main
	//Junto da mensagem de erro da exceção vem um "rastro da pilha" mostrando por onde que a "bomba" passou até chegar no console
}





//A pilha funciona dessa maneira: quem está no topo será executado, assim que entrar outro objeto no topo ele parará a execução do anterior e será executado e assim que finalizado o objeto é descartado para então o objeto anterior retomar a sua execução, segue-se esse fluxo até o Java não ter mais nada para executar e encerrar a leitura de código
//Clicar 2 vezes no lado esquerdo do número da linha cria um ponto de depuração, que serve basicamente para encerrar a execução do código nesse ponto para poder acompanhar a execução de maneira mais lenta passo a passo do código /Para executar o código com esse ponto de depuração não se pode iniciar ele da maneira convencional, se inicia ele através do botão de debug

//Ao entrar na perspectiva de depuração (debug) é possível retornar para a perspectiva normal ao clicar nos icones do canto superior direito da janela