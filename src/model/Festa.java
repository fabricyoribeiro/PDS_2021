package model;

import java.time.YearMonth;
import java.util.Calendar;

public class Festa {
	private Cliente cliente;
	private Tema tema;
	private Endereco endereco;
	private Calendar dataFesta;
	private String horaInicio;
	private String horaFim;
	private float valorEntrada;
	

	public Festa(Cliente cliente, Tema tema, Endereco endereco, Calendar dataFesta, String horaInicio,
			String horaFim, float valorEntrada) {
		this.cliente = cliente;
		this.tema = tema;
		this.endereco = endereco;
		this.dataFesta = dataFesta;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.valorEntrada = valorEntrada;
	}

//	public boolean darDesconto(Cliente cliente) {
//			Calendar c1 = cliente.getDataDeCadastro();
//			Calendar c2 = Calendar.getInstance();
//			
//			if(c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH) == 1) {
//				int anoC1 = c1.get(Calendar.YEAR);
//				int mesC1 = c1.get(Calendar.MONTH);
//
//				int anoC2 = c1.get(Calendar.YEAR);
//				int mesC2 = c1.get(Calendar.MONTH);
//				
//				YearMonth d1 = YearMonth.of(anoC1, mesC1);
//				int quantC1 = d1.lengthOfMonth();
//				
//				YearMonth d2 = YearMonth.of(anoC2, mesC2);
//				int quantC2 = d2.lengthOfMonth();
//				
//				int diferenca = (quantC1 - c1.get(Calendar.DAY_OF_MONTH)) + c2.get(Calendar.DAY_OF_MONTH);
//				
//				if (diferenca >= 30) {
//					cliente.setPossuiDesconto(true);
//					return true;
//				}
//				
//			}
//			return false;
//	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Calendar getDataFesta() {
		return dataFesta;
	}

	public void setDataFesta(Calendar dataFesta) {
		this.dataFesta = dataFesta;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
	
	public float getValorEntrada() {
		return valorEntrada;
	}
	
	
	public void setValorEntrada(float valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	@Override
	public String toString() {
		return "Festa [cliente=" + cliente + ", tema=" + tema + ", endereco=" + endereco + ", dataFesta=" + dataFesta
				+ ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", valorEntrada=" + valorEntrada + "]";
	}
	
	
}
