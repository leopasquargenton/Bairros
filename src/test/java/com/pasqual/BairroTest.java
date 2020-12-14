package com.pasqual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.pasqual.geometria.Ponto;

public class BairroTest {
	private Bairro bairro;
	private Bairro bQuadrado;
	private Bairro bRetangul;
	private Ponto pQuadrada;
	private Ponto pRetangul;
	@BeforeEach
	void setUp(){ 

		pQuadrada = new Ponto(3,5);
		pRetangul = new Ponto(8,9);
		bQuadrado = bairro.novoBairroQuadrado("Azenha", pQuadrada, 7, 320.45);
		bRetangul = bairro.novoBairroRetangular("Partenon", pRetangul, 10, 3, 450.60);
    }
	
	@Test
    public void alteraCusto() {
		bQuadrado.alteraCustoTransporte(200.5);
		Assertions.assertEquals(200.5,bQuadrado.getCustoTransporte());
    }
	@Test
    public void alteraCustoNegativo() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> bQuadrado.alteraCustoTransporte(-300.5));
    }
	@Test
    public void BairroIgual() {
		Assertions.assertEquals(true,bQuadrado.equals(bQuadrado));
    }
	@Test
    public void BairroDesigual() {
		Assertions.assertEquals(false,bQuadrado.equals(bRetangul));
    }
}
