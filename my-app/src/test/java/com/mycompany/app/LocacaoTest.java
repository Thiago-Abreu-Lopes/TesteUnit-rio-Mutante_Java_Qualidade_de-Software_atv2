package com.mycompany.app;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocacaoTest {
	Locacao locacao;
	Filme filme1;
	Filme filme2;
	Cliente cliente1;
	Cliente cliente2;
	Calendar cal;
	
	@Before
	public void setUp() throws Exception {
		filme1=new Filme("titulo muito criativo", Genero.DRAMA);
		filme2=new Filme("titulo muito criativo vol.II", Genero.COMEDIA);
		cliente1 = new Cliente("Fulano de Tal",123);
		cliente2 = new Cliente("Beltrano de Tal",553);
		cliente1.setSituacao(true);
		cliente2.setSituacao(false);
		
		locacao = new Locacao();
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testData() throws Exception {
		cal = Calendar.getInstance();
		locacao.alugar(cliente1, filme1);
		locacao.setDataDeEmprestimo();
		assertEquals(locacao.getHora(), cal.get(Calendar.HOUR_OF_DAY));
		assertEquals(locacao.getMinuto(), cal.get(Calendar.MINUTE));
		assertEquals(locacao.getAno(), cal.get(Calendar.YEAR));
		assertEquals(locacao.getMes(), cal.get(Calendar.MONTH));
		assertEquals(locacao.getDia(), cal.get(Calendar.DATE));
		
	}
	@Test
	public void testSituacaoCliente() throws Exception{
		boolean teste = false;
		 try {
			 locacao.alugar(cliente2, filme2);
		 }catch(Exception e) {
			 teste = true;
		 }
		assertTrue(teste);
		
	}
	@Test
	public void testSetarValorAluguel() throws Exception{
		locacao.setValorAluguel(30.0);
		assertTrue(locacao.getValorAluguel()==30.0);

		
	}

}
