package com.mycompany.app;
import java.util.ArrayList;

public class Transacao {

	protected  ArrayList<Locacao> alugueis;
	
	public Transacao() {
		
		alugueis= new ArrayList<Locacao>();
	}
	
	public double valorLocacaoTotal() {
	    double valor=0;
		for (Locacao locacao : alugueis) {
			valor +=locacao.valorAluguel;
		}
		return valor;
	}
	
	public Cliente buscaCliente(int id) {
		for (Locacao locacao : alugueis) {
			if(locacao.cliente.id==id) {
				return locacao.cliente;
			}
			
		}
		return null;
	}
	
	public double calculoLucro(int filmeId) {
		double valor=0;
		Filme aux = null;
		for (Locacao locacao : alugueis) {
			if(locacao.filme.id==filmeId) {
				valor += locacao.valorAluguel;
				aux = locacao.filme;
			}
			
		}
		return (valor*100)/aux.valorCompra;
	}
	
	//Counting Movie Genre 
	public Genero generoPreferido() {
		int qtdDoPreferido = 0;
		int auxDeContagem = 0;
		Genero resultado = null;
		for(Genero genero : Genero.values()) {
			for(Locacao locacao:alugueis) {
				if(locacao.filme.genero==genero) {
					auxDeContagem++;
				}
			}
			if(auxDeContagem > qtdDoPreferido) {
				qtdDoPreferido = auxDeContagem;
				resultado = genero;
			}
			auxDeContagem = 0;
		}
		return resultado;
	}
	
	//rent discount(Genre chosen, discount percentage in decimal system)
	public void descontoPorGenero(Genero genero,double desconto) {
		double tax = 0;
		for (Locacao locacao : alugueis) {
			if(locacao.filme.genero == genero) {
				tax = locacao.valorAluguel*desconto;
				locacao.valorAluguel-=tax;
			}
		}
	}
	//rent from preferences
	
	
}
