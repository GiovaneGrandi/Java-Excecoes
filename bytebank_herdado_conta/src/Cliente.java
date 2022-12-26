public class Cliente {
	private String nome;
	private String cpf;
	private String profissao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}

//Ao ir no menu "source" e em "generate getters and setter" é possível selecionar todos os atributos dos quais você quer criar um get e set e eles serão criados automaticamente
