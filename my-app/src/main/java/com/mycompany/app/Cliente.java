package com.mycompany.app;

import java.util.ArrayList;

public class Cliente {

	protected String nome;
	protected int id;
	protected boolean sutuacao; //true==able, false==unable
	protected  ArrayList<Filme> preferidos= new ArrayList<Filme>();
	
	public Cliente(String nome, int id) {
		this.nome= nome;
		this.id= id;
	}
	public void preferencia(Filme filme) {
		preferidos.add(filme);
	}
	public void setSituacao(boolean situacao) {
		this.sutuacao=situacao;
	}
	public boolean getSituacao() {
		return this.sutuacao;
	}
	public Locacao alugarPreferencias(int posicao) throws Exception {
		Locacao loc = new Locacao();
		if(this.preferidos.size()<posicao) throw new Exception("O Cliente não possui esse numero de preferidos");
		loc.alugar(this, this.preferidos.get(posicao));
		return loc;
	}
}
