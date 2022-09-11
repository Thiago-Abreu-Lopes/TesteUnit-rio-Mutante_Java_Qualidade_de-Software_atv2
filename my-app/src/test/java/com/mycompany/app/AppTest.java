package com.mycompany.app;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private final ByteArrayOutputStream saidaHello = new ByteArrayOutputStream();
	private final PrintStream helloOriginal = System.out;
    @Before
    public void  setUp() throws Exception {
    	System.setOut(new PrintStream(saidaHello));
    }
    
    @After
    public void tearDown() throws Exception {
    	System.setOut(helloOriginal);
    }
    
    @Test
    public void testeSystemOut()
    {
    	System.out.print("hello");
        assertEquals("hello", saidaHello.toString());
    }
}
