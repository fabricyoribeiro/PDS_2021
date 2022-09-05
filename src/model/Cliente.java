package model;

import java.util.Calendar;

public class Cliente {
	private String nome;
	private String cpf;
	private String rg;
	private Endereco endereco;
	private String email;
	private String telefone;
	private Calendar dataDeCadastro;
	private boolean possuiDesconto;
	
	
	public Cliente(String nome, String cpf, String rg, Endereco endereco, String email, String telefone, Calendar dataDeCadastro) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.dataDeCadastro = dataDeCadastro;
		this.possuiDesconto = false;
	}

	public String isPossuiDesconto() {
		if(this.possuiDesconto==false)
			return "Não";
		else
			return  "Sim";
					
	}


	public void setPossuiDesconto(boolean possuiDesconto) {
		this.possuiDesconto = possuiDesconto;
	}

	public Cliente(Calendar dataDeCadastro) {
		super();
		this.dataDeCadastro = dataDeCadastro;
	}



	public Calendar getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Calendar dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getRg() {
		return rg;
	}	
	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", endereco=" + endereco + ", email=" + email
				+ ", telefone=" + telefone + ", dataDeCadastro=" + dataDeCadastro + ", possuiDesconto=" + possuiDesconto
				+ "]";
	}


}
