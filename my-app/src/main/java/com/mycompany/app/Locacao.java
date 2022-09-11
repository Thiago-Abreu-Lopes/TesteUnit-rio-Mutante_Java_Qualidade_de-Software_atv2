package com.mycompany.app;

import java.util.Calendar;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	protected double valorAluguel;
	protected Calendar dataEmprestimo;
	//Constructor
	public void alugar(Cliente c, Filme f) throws Exception {
		if(!c.sutuacao)throw new Exception("Cliente precisa estar ativo!");
		this.cliente = c;
		this.filme = f;
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel=valorAluguel;
	}
	public double getValorAluguel() {
		return this.valorAluguel;
	}
	//Set and get instances of date
	public void setDataDeEmprestimo() {
		Calendar c = Calendar.getInstance();
		this.dataEmprestimo = c;
	}
	public int getHora() {
		return this.dataEmprestimo.get(Calendar.HOUR_OF_DAY);
	}
	public int getMinuto() {
		return this.dataEmprestimo.get(Calendar.MINUTE);
	}
	public int getAno() {
		return this.dataEmprestimo.get(Calendar.YEAR);
	}
	public int getMes() {
		return this.dataEmprestimo.get(Calendar.MONTH);
	}
	public int getDia() {
		return this.dataEmprestimo.get(Calendar.DATE);
	}
	
	
}

