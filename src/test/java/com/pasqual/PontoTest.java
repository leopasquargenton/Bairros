package com.pasqual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pasqual.geometria.Ponto;

public class PontoTest {
	private Ponto p = null;

    @BeforeEach
    void setUp(){
    	p = new Ponto(3,5);
    }

    @Test
    public void equalPoint() {
    	Assertions.assertEquals(true,p.equals(p));
    }
    @Test
    public void unEqualPoin() {
    	Ponto q = new Ponto(2,2);
    	Assertions.assertEquals(false,q.equals(p));
    }


}
