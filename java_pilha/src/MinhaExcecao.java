public class MinhaExcecao extends Exception { //Existe uma hierarquia de exceções, para criar uma exceção própria é necessário entrar nessa hierarquia composta pelas classes: "RuntimeException" que herda da classe "Exception" que por sua vez herda da classe "Throwable", as duas primeiras classe são compostas apenas por construtores, a classe "Throwable" que guarda os métodos usados pelas exceções /Toda classe que herdar os comportamentos da classe "Throwable" é capaz de ser lançada através do comando "throw"
	//Existe diferenças na exceção que herda da classe "RuntimeException" e da exceção que herda diretamente da classe "Exception"
	//As exceções que herdam da "RuntimeException" são chamadas de "unchecked", ou seja, "não é checada pelo compilador" o compilador não se importa se você vai chamar aquela exceção ou não
	//Já as que herdam diretamente do "Exception" são "checked", ou seja, o compilador checa se elas vão ser chamadas ou não, tanto que na assinatura do método que a exceção for chamada é necessário adicionar o aviso de que uma exceção será chamada ali
	//Na hora de rodar a exceção funciona do mesmo jeito em ambos os casos, o que muda é apenas o comportamento do compilador, com "unchecked" ele não está nem aí para aquela exceção se você adiciona-la porém no "checked" ele te obriga a resolver aquela exceção, seja com um try catch ou com um aviso de perigo na assinatura do método
	
	public MinhaExcecao(String msg) { //Criando um construtor que recebe uma "String" como parâmetro, afinal o conbstrutor default não recebe nada
		super(msg); //Repassando a mensagem para a classe mãe atravcés do "super"
	}
	
}

//Por que a "MinhaExceção" herda o "RuntimeException" que só tem construtores ao invés de herdar direto do "Throwable" que tem todos os métodos? porque nem todo "Throwable" é uma exceção, existe um lado da hierarquia do "Throwable" que são os "Errors" mas eles não são criados por nós devs mas sim pela JVM(Java Virtual Machine) que ao não conseguir executar o código retorna um erro como por exemplo "falta de memória"