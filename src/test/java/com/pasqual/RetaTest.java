package com.pasqual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pasqual.geometria.Ponto;
import com.pasqual.geometria.Reta;

public class RetaTest {
	private Reta r;
	private Ponto p;
	private Ponto q;

    @BeforeEach
    void setUp(){ 
    	p = new Ponto(0,0);
    	q = new Ponto(3,4);
    	r = new Reta(p,q);
    }

    @Test
    public void tamanhoReta() {
    	Assertions.assertEquals(r.tamanho(),5);
    }
    
    @Test
    public void retaIgual() {
    	Assertions.assertEquals(true,r.equals(r));
    }
    @Test
    public void retaDesigual() {
    	Ponto pdes = new Ponto(2,3);
    	Ponto qdes = new Ponto(3,4);
    	Reta des = new Reta(pdes, qdes);
    	Assertions.assertEquals(false,des.equals(r));
    }
}
