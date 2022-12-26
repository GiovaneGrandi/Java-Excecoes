public interface Tributavel {
	
	double getValorImposto(); //Criando a assinatura do método que irá ser responsavel por pegar os valores do imposto e terá seus comportamentos adicionados por aquelas classes que fecharem o contrato
	//Não é necessário colocar o "public abstract" em um método de uma interface pois ele já vem como default, afinal tudo em uma interface é abstrato
	
}
