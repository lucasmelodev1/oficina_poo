package model.entity;

public class Cliente {
	private Long id;

	private String nome;

	private Endereco endereco;

	private String cpf;
	
	 public Cliente(String nome, Endereco endereco, String cpf) {
	        setNome(nome);
	        setEndereco(endereco);
	        setCPF(cpf);
	    }
	 
	 public Cliente() {
		 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.length() < 1) {
			System.out.println("Nome nao pode ser vazio");
			return;
		}
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		// Endereco ja possui validacao
		this.endereco = endereco;
	}

	public String getCPF() {
		return this.cpf;
	}

	public void setCPF(String cpf) {
		if (cpf == null || cpf.length() != 11) {
			System.out.println("CPF invalido");
			return;
		}
		this.cpf = cpf;
	}
}
