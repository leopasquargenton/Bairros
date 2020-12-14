package com.pasqual;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.pasqual.geometria.Area;
import com.pasqual.geometria.Ponto;
import com.pasqual.geometria.Reta;
import com.pasqual.geometria.SituacaoReta;

public class AreaTest {
	private Ponto p = null;
	private Ponto q = null;
	private Area a = null;
	
	@BeforeEach
	void setUp(){ 
    	p = new Ponto(0,8);
    	q = new Ponto(4,0);
    	a = new Area(p,q);
    }
	
	@Test
    public void pontoCentral() {
		Ponto pc = new Ponto(2,4);
    Assertions.assertEquals(a.pontoCentral(),pc);
    }
	//
	@ParameterizedTest
	@CsvSource({
	"1,1,9","2,1,-3","4,5,4","8,-1,4", //Over (Up, Down, Left, Right) 
	"0,2,4", //Inside
	"0,0,4", "0,4,4", "0,2,8", "0,2,0", //Limits (Up, Down, Left, Right)
	"0,0,8", "0,4,8", "0,0,0", "0,4,0", //Corner (Up Left, Up Right, Down Left, Down Right)
	"9,-1,9", "5,5,9", "10,-1,-1", "6,5,-1", //Over Corners (Up Left, Up Right, Down Left, Down Right)
		
	})
    void codifica(byte cod, int x,int y) {
		Ponto pt = new Ponto(x,y);
		assertEquals(cod,a.codificaPonto(pt));
    }
	@ParameterizedTest
	@CsvSource({
		"INTERSECTA,-1,2,6,7",
		"TODA_FORA,9,6,9,4"
	})
	
	void classificaReta(SituacaoReta s,int x1, int y1, int x2, int y2) {
		Ponto pont = new Ponto(x1,y1);
		Ponto pont2 = new Ponto(x2,y2);
		Reta reta = new Reta(pont,pont2);
		assertEquals(s,a.classifica(reta));

	}
	@Test
    public void areaIgual() {
		
    Assertions.assertEquals(true,a.equals(a));
    }
	@Test
    public void areaDesigual() {
	Ponto p = new Ponto(2,3);
	Ponto q = new Ponto(3,2);
	Area desigual = new Area(p,q);
    Assertions.assertEquals(false,desigual.equals(a));
    }
	@Test
    public void construtorErrado() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->  new Area(q,p));	
	}
	
}
