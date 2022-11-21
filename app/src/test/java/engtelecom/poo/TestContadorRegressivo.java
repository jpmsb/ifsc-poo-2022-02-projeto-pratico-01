package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.Draw;

public class TestContadorRegressivo {
    @Test
    // Testando criar um contador regressivo com valores de partida inválidos
    public void criaContadorRegressivo(){
        Draw tela = new Draw();

        // Criando contador regressivo com segundo negativo
        ContadorRegressivo c = new ContadorRegressivo(tela, new double[]{400,200}, 100, Color.GREEN, 99, 59, -1);

        assertEquals(0, c.getSegundoInicial());


        // Criando contador regressivo com segundo acima de 59
        ContadorRegressivo c2 = new ContadorRegressivo(tela, new double[]{400,200}, 100, Color.GREEN, 99, 59, 60);

        assertEquals(0, c2.getSegundoInicial());


        // Criando contador regressivo com minuto negativo
        ContadorRegressivo c3 = new ContadorRegressivo(tela, new double[]{400,200}, 100, Color.GREEN, 99, -1, 55);

        assertEquals(0, c3.getMinutoInicial());


        // Criando contador regressivo com minuto acima de 59
        ContadorRegressivo c4 = new ContadorRegressivo(tela, new double[]{400,200}, 100, Color.GREEN, 99, 60, 55);

        assertEquals(0, c4.getMinutoInicial());


        // Criando contador regressivo com hora negativa
        ContadorRegressivo c5 = new ContadorRegressivo(tela, new double[]{400,200}, 100, Color.GREEN, -1, 55, 55);

        assertEquals(0, c5.getHoraInicial());


        // Criando contador regressivo com hora acima de 99
        ContadorRegressivo c6 = new ContadorRegressivo(tela, new double[]{400,200}, 100, Color.GREEN, 100, 55, 55);

        assertEquals(0, c6.getHoraInicial());
    }

    @Test
    // Testando se o contador regressivo para de contar quando atinge os valores
    // mínimos de hora, minuto e segundo permitidos
    public void validaContagem(){
        Draw tela = new Draw();
        ContadorRegressivo c = new ContadorRegressivo(tela, new double[]{400,200}, 100, Color.GREEN, 00, 00, 2);

        // Testando contagem válida
        assertEquals(2, c.getSegundoAtual());
        assertTrue(c.conta());
        assertEquals(1, c.getSegundoAtual());
        assertTrue(c.conta());
        assertEquals(0, c.getSegundoAtual());
        assertFalse(c.conta());
        assertEquals(0, c.getSegundoAtual());
    }

    @Test
    // Testando reinício do contador regressivo para o valor de partida
    public void validaReinicio(){
        Draw tela = new Draw();
        ContadorRegressivo c = new ContadorRegressivo(tela, new double[]{400,200}, 100, Color.GREEN, 1, 00, 00);

        c.conta();
        assertEquals(59, c.getSegundoAtual());
        assertEquals(59, c.getMinutoAtual());
        assertEquals(0, c.getHoraAtual());
        c.conta();
        assertEquals(58, c.getSegundoAtual());
        c.conta();
        assertEquals(57, c.getSegundoAtual());
        c.conta();
        assertEquals(56, c.getSegundoAtual());
        c.reinicia();
        assertEquals(0, c.getSegundoAtual());
        assertEquals(0, c.getMinutoAtual());
        assertEquals(1, c.getHoraAtual());
    }
}