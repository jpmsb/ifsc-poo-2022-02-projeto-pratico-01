package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.Draw;

public class TestCronometro {
    @Test
    // Testando criar um cronômetro com valores de partida inválidos
    public void criaCronometro(){
        Draw tela = new Draw();

        // Criando cronômetro com segundo negativo
        Cronometro c = new Cronometro(tela, new double[]{400,200}, 100, Color.GREEN, 99, 59, -1);

        assertEquals(0, c.getSegundoInicial());


        // Criando cronômetro com segundo acima de 59
        Cronometro c2 = new Cronometro(tela, new double[]{400,200}, 100, Color.GREEN, 99, 59, 60);

        assertEquals(0, c2.getSegundoInicial());


        // Criando cronômetro com minuto negativo
        Cronometro c3 = new Cronometro(tela, new double[]{400,200}, 100, Color.GREEN, 99, -1, 55);

        assertEquals(0, c3.getMinutoInicial());


        // Criando cronômetro com minuto acima de 59
        Cronometro c4 = new Cronometro(tela, new double[]{400,200}, 100, Color.GREEN, 99, 60, 55);

        assertEquals(0, c4.getMinutoInicial());


        // Criando cronômetro com hora negativa
        Cronometro c5 = new Cronometro(tela, new double[]{400,200}, 100, Color.GREEN, -1, 55, 55);

        assertEquals(0, c5.getHoraInicial());


        // Criando cronômetro com hora acima de 99
        Cronometro c6 = new Cronometro(tela, new double[]{400,200}, 100, Color.GREEN, 100, 55, 55);

        assertEquals(0, c6.getHoraInicial());
    }

    @Test
    // Testando se o cronômetro para de contar quando atinge os valores
    // máximos de hora, minuto e segundo permitidos
    public void validaContagem(){
        Draw tela = new Draw();
        Cronometro c = new Cronometro(tela, new double[]{400,200}, 100, Color.GREEN, 99, 59, 57);

        // Testando contagem válida
        assertEquals(57, c.getSegundoAtual());
        assertTrue(c.conta());
        assertEquals(58, c.getSegundoAtual());
        assertTrue(c.conta());
        assertEquals(59, c.getSegundoAtual());
        assertFalse(c.conta());
        assertEquals(59, c.getSegundoAtual());
    }

    @Test
    // Testando reinício do cronômetro para o valor de partida
    public void validaReinicio(){
        Draw tela = new Draw();
        Cronometro c = new Cronometro(tela, new double[]{400,200}, 100, Color.GREEN, 99, 59, 54);

        c.conta();
        assertEquals(55, c.getSegundoAtual());
        c.conta();
        assertEquals(56, c.getSegundoAtual());
        c.conta();
        assertEquals(57, c.getSegundoAtual());
        c.conta();
        assertEquals(58, c.getSegundoAtual());
        c.reinicia();
        assertEquals(54, c.getSegundoAtual());
    }

    @Test
    // Valida zerar o cronômetro
    public void zerarCronometro(){
        Draw tela = new Draw();
        Cronometro c = new Cronometro(tela, new double[]{400,200}, 100, Color.GREEN, 99, 59, 54);

        assertEquals(54, c.getSegundoAtual());
        c.zera();
        assertEquals(0, c.getSegundoAtual());
    }
}