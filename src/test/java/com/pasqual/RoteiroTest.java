package com.pasqual;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import com.pasqual.geometria.Ponto;
import com.pasqual.geometria.Area;
import com.pasqual.Bairro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RoteiroTest {
    private Collection <Bairro> bairrosPercorridos;
    private Bairro bairroInicial;
    private Bairro bairroFinal;
    private Bairro bairros;
    private Collection <Bairro> todos;
	
	@BeforeEach
	void setUp(){ 
        todos = new LinkedList <Bairro> ();
        bairroInicial = bairros.novoBairroRetangular("Petropolis", new Ponto(0,10), 6, 4, 10); todos.add(bairroInicial);
        Bairro it = bairros.novoBairroQuadrado("Ita", new Ponto(0,6), 4, 12); todos.add(it);
        bairroFinal = bairros.novoBairroRetangular("Menino Deus", new Ponto(2,2), 7, 2, 9); todos.add(bairroFinal);
        Bairro bf = bairros.novoBairroRetangular("Bom Fim", new Ponto(4,6), 8, 4, 8); todos.add(bf);
        Bairro tr = bairros.novoBairroQuadrado("Tristeza", new Ponto(12,6), 3, 10); todos.add(tr);
        Bairro me = bairros.novoBairroRetangular("Medianeira", new Ponto(10,4), 5, 4, 15); todos.add(me);
    }
	
	@Test
    public void bairrosPercorridos() {
        Roteiro r = new Roteiro(bairroInicial, bairroFinal, todos);
        Collection <Bairro> percorridos = new LinkedList<Bairro>();
        Bairro pe = bairros.novoBairroRetangular("Petropolis", new Ponto(0,10), 6, 4, 10); percorridos.add(pe);
        Bairro it = bairros.novoBairroQuadrado("Ita", new Ponto(0,6), 4, 12); percorridos.add(it);
        Bairro md = bairros.novoBairroRetangular("Menino Deus", new Ponto(2,2), 7, 2, 9); percorridos.add(md);
        Bairro bf = bairros.novoBairroRetangular("Bom Fim", new Ponto(4,6), 8, 4, 8); percorridos.add(bf);
        
        Assertions.assertEquals(r.bairrosPercoridos(),percorridos);
    }
}