package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.Draw;

public class TestDisplay7Segmentos {
    @Test
    // Validando os construtores que definem valores padrões
    public void valoresPadrao(){
        Draw tela = new Draw();

        // Construtor que define as coordenadas, cor aceso e cor apagado padrões
        Display7Segmentos d = new Display7Segmentos(tela, new double[]{0,0});

        // Validando se a escala recebeu o valor padrão
        assertEquals(100, d.getEscala());

        // Validando a cor acesa padrão
        assertEquals(Color.RED, d.getCorAceso());

        // Validando a cor apagada padrão
        assertEquals(Color.LIGHT_GRAY, d.getCorApagado());


        // Construtor que define a escala padrão
        Display7Segmentos d2 = new Display7Segmentos(tela, new double[]{0,0}, Color.RED, Color.GREEN);

        assertEquals(100, d2.getEscala());


        // Construtor que define as cores aceso e apagada padrão
        Display7Segmentos d3 = new Display7Segmentos(tela, new double[]{0,0}, 100);

        // Validando a cor acesa padrão
        assertEquals(Color.RED, d3.getCorAceso());

        // Validando a cor apagada padrão
        assertEquals(Color.LIGHT_GRAY, d3.getCorApagado());
    }

    @Test
    // Validando o método de desenho
    public void desenharDisplay(){
        Draw tela = new Draw();
        Display7Segmentos d = new Display7Segmentos(tela, new double[]{0,0});

        // Desehnando em condições válidas
        // Dígito 0
        assertTrue(d.desenhar(0));

        // Dígito 1
        assertTrue(d.desenhar(1));

        // Dígito 2
        assertTrue(d.desenhar(2));

        // Dígito 3
        assertTrue(d.desenhar(3));

        // Dígito 4
        assertTrue(d.desenhar(4));

        // Dígito 5
        assertTrue(d.desenhar(5));

        // Dígito 6
        assertTrue(d.desenhar(6));

        // Dígito 7
        assertTrue(d.desenhar(7));

        // Dígito 8
        assertTrue(d.desenhar(8));

        // Dígito 9
        assertTrue(d.desenhar(9));

        // Desenhando dígito inválido, ou seja, fora da faixa de zero a 9
        // Dígito 10
        assertFalse(d.desenhar(10));

        // Dígito 11
        assertFalse(d.desenhar(11));

        // Dígito 12
        assertFalse(d.desenhar(12));


        // Testando desenho em uma tela inválida
        d.setTela(null);
        assertFalse(d.desenhar(0));

        // Testando desenho com a escala 0
        d.setTela(tela);
        d.setEscala(0);
        assertFalse(d.desenhar(0));

        // Testando desenho com a escala negativa
        d.setEscala(-1);
        assertFalse(d.desenhar(0));
    }
}