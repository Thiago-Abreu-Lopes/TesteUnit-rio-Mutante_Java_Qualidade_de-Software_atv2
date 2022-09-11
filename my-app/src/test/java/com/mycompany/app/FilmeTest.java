package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilmeTest {

	Filme filme;
	Filme filme2;
	@Before
	public void setUp() throws Exception {
		System.out.println("Antes");
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void testFilme() {
		filme= new Filme("Java", Genero.DRAMA);
		assertEquals("Java", filme.nome);
	}
	@Test
	public void testHashCode() {
		filme= new Filme("Java", Genero.DRAMA);
		filme2= new Filme("Java", Genero.DRAMA);
		assertTrue(filme.hashCode() == filme2.hashCode());
	}
	@Test
	public void testEquals() {
		filme= new Filme("Java", Genero.DRAMA);
		filme2= new Filme("Java", Genero.DRAMA);
		assertTrue(filme.equals(filme2) && filme2.equals(filme));
	}
	@Test
	public void testNotEquals() {
		filme= new Filme("Java", Genero.DRAMA);
		filme2= new Filme("JavaScript", Genero.COMEDIA);
		assertFalse(filme.equals(filme2) && filme2.equals(filme));
	}

}

