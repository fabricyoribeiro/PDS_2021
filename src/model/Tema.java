package model;

public class Tema {
	private String nome;
	private float valorAluguel;
	private String corToalha;
	
	public Tema(String nome, float valorAluguel, String corToalha) {
		this.nome = nome;
		this.valorAluguel = valorAluguel;
		this.corToalha = corToalha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(float valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public String getCorToalha() {
		return corToalha;
	}
	public void setCorToalha(String corToalha) {
		this.corToalha = corToalha;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
}
