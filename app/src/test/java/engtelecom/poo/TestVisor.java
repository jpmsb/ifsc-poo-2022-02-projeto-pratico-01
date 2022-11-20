package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.Draw;

public class TestVisor {
    @Test
    // Testa se foi possível desenhar o visor
    public void desenhaVisor(){
        Draw tela = new Draw();
        Visor v = new Visor(tela, new double[]{0,0}, 100, Color.GREEN);

        // Testando desenho em condições válidas
        assertTrue(v.ver(0, 0, 0));

        // Testando desenho em com uma tela inválida
        v.setTela(null);
        assertFalse(v.ver(0, 0, 0));

        // Testando desenho com hora negativa
        v.setTela(tela);
        assertFalse(v.ver(-1, 0, 0));

        // Testando desenho com hora acima de 99
        v.setTela(tela);
        assertFalse(v.ver(100, 0, 0));

        // Testando desenho com minuto negativo
        v.setTela(tela);
        assertFalse(v.ver(0, -1, 0));

        // Testando desenho com minuto acima de 99
        v.setTela(tela);
        assertFalse(v.ver(0, 100, 0));

        // Testando desenho com segundo negativo
        v.setTela(tela);
        assertFalse(v.ver(0, 0, -1));

        // Testando desenho com segundo acima de 99
        v.setTela(tela);
        assertFalse(v.ver(0, 0, 100));
    }
}
