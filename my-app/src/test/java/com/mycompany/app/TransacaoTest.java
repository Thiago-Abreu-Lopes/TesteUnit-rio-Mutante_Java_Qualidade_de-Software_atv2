package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TransacaoTest {

	Transacao transacao;
	Locacao locacao1;
	Locacao locacao2;
	Locacao locacao3;
	Locacao locacao4;
	Locacao locacao5;
	Locacao locacao6;
	Filme filme1;
	Filme filme2;
	Filme filme3;
	Filme filme4;
	Filme filme5;
	Filme filme6;
	Cliente cliente1;
	Cliente cliente2;

	@Before
	public void setUp() throws Exception {
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		locacao3 = new Locacao();
		locacao4 = new Locacao();
		locacao5 = new Locacao();
		locacao6 = new Locacao();
		
		cliente1 = new Cliente("Izaias", 2);
		cliente2 = new Cliente("Thiago", 3);
		cliente1.setSituacao(true);
		cliente2.setSituacao(true);
		cliente1.preferencia(filme3);
		cliente1.preferencia(filme2);
		
		filme1 = new Filme("Java", Genero.ROMANCE);
		filme1.valorCompra = 100;
		filme1.id=40;

		filme2 = new Filme("JavaScript", Genero.ROMANCE);
		filme2.valorCompra = 50;
		filme2.id=20;

		filme3 = new Filme("Cobol", Genero.DRAMA);
		filme3.valorCompra = 190;
		filme3.id=10;
		
		filme4 = new Filme("Java", Genero.COMEDIA);
		filme4.valorCompra = 100;
		filme4.id=60;

		filme5 = new Filme("JavaScript", Genero.COMEDIA);
		filme5.valorCompra = 50;
		filme5.id=30;

		filme6 = new Filme("Cobol", Genero.ROMANCE);
		filme6.valorCompra = 190;
		filme6.id=90;
		
		
		locacao1.alugar(cliente1, filme1);
		locacao1.valorAluguel = 10;
		locacao2.alugar(cliente2, filme2);
		locacao2.valorAluguel = 50;
		locacao3.alugar(cliente1, filme3);
		locacao3.valorAluguel = 30;
		
		locacao4.alugar(cliente1, filme4);
		locacao4.valorAluguel = 10;
		locacao5.alugar(cliente2, filme5);
		locacao5.valorAluguel = 50;
		locacao6.alugar(cliente1, filme6);
		locacao6.valorAluguel = 30;
		

		transacao = new Transacao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void valorLocacaoTotalTest() {

		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		assertEquals(transacao.alugueis.get(0).cliente.nome, "Izaias");
		assertTrue("Filme deveria ser selecionado corretamente",transacao.alugueis.get(1).filme.id==20);
		assertEquals(60, transacao.valorLocacaoTotal(), 0.1);
	}

	
	@Test 
	public void buscaClienteIdTest() {
		
		transacao.alugueis.add(locacao2);
		assertEquals("Thiago",transacao.buscaCliente(3).nome);
	}
	@Test 
	public void buscaClienteIdTestNull() {
		
		transacao.alugueis.add(locacao2);
		assertTrue(transacao.buscaCliente(89)==null);
	}
	
	@Test 
	public void calculoLucroTest() {
		
		transacao.alugueis.add(locacao2);
		
		assertEquals(100,transacao.calculoLucro(20),0.01);
	}
	
	@Test
	public void testeDeContagemDoGeneroMaisAlugado() {
		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		transacao.alugueis.add(locacao3);
		assertEquals(transacao.generoPreferido(),Genero.ROMANCE);
	}
	@Test
	public void testeDeContagemDoGeneroMaisAlugado2() {
		
		transacao.alugueis.add(locacao4);
		transacao.alugueis.add(locacao5);
		transacao.alugueis.add(locacao6);
		assertTrue(transacao.generoPreferido()==Genero.COMEDIA);
	}
	
	@Test
	public void testeDeDescontoPorGenero() {
		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		transacao.alugueis.add(locacao3);
		transacao.descontoPorGenero(Genero.ROMANCE, 0.5);
		
		assertTrue(locacao1.valorAluguel== 5.0);
		assertTrue(locacao2.valorAluguel== 25.0);
		assertTrue(locacao3.valorAluguel== 30.0);
	}
	
	
	

}
