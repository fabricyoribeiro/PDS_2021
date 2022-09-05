package model;

import java.time.YearMonth;
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
		this.possuiDesconto = possuiDesconto();
	}
	
	private boolean possuiDesconto() {
		Calendar c1 = this.dataDeCadastro;
		Calendar c2 = Calendar.getInstance();

		if( c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR) >= 1) {
			return true;			
		}
		if(c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH) >= 1) {
			int anoC1 = c1.get(Calendar.YEAR);
			int mesC1 = c1.get(Calendar.MONTH);

			int anoC2 = c1.get(Calendar.YEAR);
			int mesC2 = c1.get(Calendar.MONTH);
			
			YearMonth d1 = YearMonth.of(anoC1, mesC1);
			int quantC1 = d1.lengthOfMonth();
			
			YearMonth d2 = YearMonth.of(anoC2, mesC2);
			int quantC2 = d2.lengthOfMonth();
			
			int diferenca = (quantC1 - c1.get(Calendar.DAY_OF_MONTH)) + c2.get(Calendar.DAY_OF_MONTH);
			
			if(diferenca>=30)
				return true;
		}else {
			return false;
		}
		return false;
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
