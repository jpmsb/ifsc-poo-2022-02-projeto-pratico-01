package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.awt.Color;
import org.junit.jupiter.api.Test;
import edu.princeton.cs.algs4.Draw;
public class TestSegmento {
    @Test
    // Testando os construtores que definem valores padrões
    public void testaValorPadrao(){
        Draw tela = new Draw();

        // Construtor que define coordenadas, cor e escala padrão
        Segmento s = new Segmento(tela);

        // Testando se coordenada X recebeu o valor padrão
        assertEquals(0, s.getCoordenadaX());

        // Testando se coordenada Y recebeu o valor padrão
        assertEquals(0, s.getCoordenadaY());

        // Testando se a cor recebeu o valor padrão
        assertEquals(Color.RED, s.getCor());

        // Testando se escala recebeu o valor padrão
        assertEquals(100, s.getEscala());


        // Construtor que define a escala padrão
        Segmento s2 = new Segmento(tela, 50, 50);
        assertEquals(100, s2.getEscala());


        // Construtor que define a cor padrão
        Segmento s3 = new Segmento(tela, 100, 100, 50);
        assertEquals(Color.RED, s3.getCor());


        // Construtor que cria um segmento horizontal
        Segmento s4 = new Segmento(tela, 100, 0, 100, Color.GRAY);
        assertFalse(s4.isTipoVertical());

        
        // Construtor que define coordenadas e cor padrão
        Segmento s5 = new Segmento(tela, 50);

        // Testando se coordenada X recebeu o valor padrão
        assertEquals(0, s5.getCoordenadaX());

        // Testando se coordenada Y recebeu o valor padrão
        assertEquals(0, s5.getCoordenadaY());

        // Testando se a cor recebeu o valor padrão
        assertEquals(Color.RED, s5.getCor());
    }

    @Test
    // Testando o método desenhar em diferentes condições
    public void desenharSegmento(){
        Segmento s = new Segmento(null);

        // Validando o desenho quando a tela é inválida
        assertEquals("Inválido",s.desenhar());

        // Validando o desenho quando a escala é igual a zero
        Draw tela = new Draw();
        s.setTela(tela);
        s.setEscala(0);
        assertEquals("Inválido",s.desenhar());

        // Validando o desenho quando a escala é negativa
        s.setEscala(-1);
        assertEquals("Inválido",s.desenhar());

        // Validando o desenho horizontal em condições válidas
        s.setEscala(50);
        assertEquals("Horizontal",s.desenhar());

        // Validando o desenho vertical em condições válidas
        s.setTipoVertical(true);
        assertEquals("Vertical",s.desenhar());
    }
}
