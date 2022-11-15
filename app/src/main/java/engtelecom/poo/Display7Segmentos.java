package engtelecom.poo;

import java.awt.Color;
import edu.princeton.cs.algs4.Draw;

public class Display7Segmentos {
    /**
     * Multiplicador dos valores de Y.
     * Para alinhar à grade, o valor deve ser 1.1
     */
    private final double MULTIPLICADOR_Y = 0.86;

    /**
     * Multiplicador do valor Y inicial.
     * Para alinhar à grade, o valor deve ser 0.1
     */
    private final double MULTIPLICADOR_Y_INICIAL = 0.03;

    /**
     * Valor de escala padrão
     */
    private static final int ESCALA_PADRAO = 200;

    /**
     * Valor de cor padrão para segmentos acesos
     */
    private static final Color COR_ACESO_PADRAO = Color.RED;

    /**
     * Valor de cor padrão para segmentos apagados
     */
    private static final Color COR_APAGADO_PADRAO = Color.LIGHT_GRAY;

    /**
     * Arranjo dos sete segmentos que compões um dígito
     */
    private Segmento[] segmento = new Segmento[7];

    /**
     * Objeto onde os segmentos serão desenhados
     */
    private Draw tela;

    /**
     * Coordenada central do dígito
     */
    private double[] coordenadas;

    /**
     * Cor de cada segmento
     */
    private Color[] corSegmento = new Color[7];

    /**
     * Cor dos segmentos apagados
     */
    private Color corApagado;

    /**
     * Cor dos segmentos acesos
     */
    private Color corAceso;

    /**
     * Tamanho proporcional do dígito
     */
    private int escala;


    /**
     * Construtor da classe
     * @param tela objeto do tipo Draw onde o display será desenhado
     * @param coordenadas posição central onde o display será desenhado
     * @param corAceso cor representando os segmentos acesos
     * @param corApagado cor representando os segmentos apagados
     * @param escala tamanho do display na tela como um todo
     */
    public Display7Segmentos(Draw tela, double[] coordenadas, Color corAceso, Color corApagado, int escala) {
        this.tela = tela;
        this.coordenadas = coordenadas;
        this.corApagado = corApagado;
        this.corAceso = corAceso;
        this.escala = escala;
    }

    /**
     * Construtor da classe
     * @param tela objeto do tipo Draw onde o display será desenhado
     * @param coordenadas posição central onde o display será desenhado
     * @param corAceso cor representando os segmentos acesos
     * @param corApagado cor representando os segmentos apagados
     */
    public Display7Segmentos(Draw tela, double[] coordenadas, Color corAceso, Color corApagado) {
        this(tela, coordenadas, corAceso, corApagado, ESCALA_PADRAO);
    }

    /**
     * Construtor da classe
     * @param tela objeto do tipo Draw onde o display será desenhado
     * @param coordenadas posição central onde o display será desenhado
     * @param escala tamanho do display na tela como um todo
     */
    public Display7Segmentos(Draw tela, double[] coordenadas, int escala) {
        this(tela, coordenadas, COR_ACESO_PADRAO, COR_APAGADO_PADRAO, escala);
    }

    /**
     * Construtor da classe
     * @param tela objeto do tipo Draw onde o display será desenhado
     * @param coordenadas posição central onde o display será desenhado
     */
    public Display7Segmentos(Draw tela, double[] coordenadas) {
        this(tela, coordenadas, COR_ACESO_PADRAO, COR_APAGADO_PADRAO);
    }

    /**
     * Desenha um display de 7 segmentos de acordo
     * com o dígito informado
     * @param digito valor inteiro de 0 a 9. Caso maior que 9, a letra "E" é desenhada
     */
    public void desenhar(int digito){
        // Definindo as cores iniciais de cada segmento
        for (int i = 0; i < corSegmento.length; i++) this.corSegmento[i] = corAceso;

        // Pintando cada segmento de acordo com o dígito
        if (digito == 0){
            this.corSegmento[6] = corApagado;

        } else if (digito == 1){
            this.corSegmento[0] = corApagado;
            for (int i = 3; i < corSegmento.length; i++) this.corSegmento[i] = corApagado;

        } else if (digito == 2){
            this.corSegmento[2] = corApagado;
            this.corSegmento[5] = corApagado;

        } else if (digito == 3){
            for (int i = 4; i < 6; i++) this.corSegmento[i] = corApagado;
            
        } else if (digito == 4){
            this.corSegmento[0] = corApagado;
            for (int i = 3; i < 5; i++) this.corSegmento[i] = corApagado;
            
        } else if (digito == 5){
            this.corSegmento[1] = corApagado;
            this.corSegmento[4] = corApagado;            
            
        } else if (digito == 6){
            this.corSegmento[1] = corApagado;
            
        } else if (digito == 7){
            for (int i = 3; i < corSegmento.length; i++) this.corSegmento[i] = corApagado;
            
        } else if (digito == 8){
            // Por padrão o display já exibe o número 8
        } else if (digito == 9){
            this.corSegmento[4] = corApagado;

        } else {
            // Caso o dígito seja maior que 9, exibe "E"
            // no display, indicando erro
            for (int i = 1; i < 3; i++) this.corSegmento[i] = corApagado;
        }

        desenhar(this.corSegmento);
    }

    /**
     * Desenha um display com 7 segmentos
     * @param corSegmento define a cor de cada segmento
     */
    public void desenhar(Color[] corSegmento){
        // dimensão da área de tela (canvas)
        // int dimensao = 800;

        // Desenhando grade quadriculada
        // int grade = (int) escala/10;
        // tela.setPenColor(Color.DARK_GRAY);
        // for (int i = 0; i <= dimensao; i+=grade) tela.line(i, 0, i, dimensao);
        // for (int j = 0; j <= dimensao; j+=grade) tela.line(0, j, dimensao, j);

        // Coordenadas iniciais
        double xInicial = coordenadas[0] - (0.5*escala);
        double yInicial = coordenadas[1] - (1.05*escala);


        // -------------------------------------- //
        double xHorizontal = xInicial;
        double yHorizontal = yInicial;
        // Criando os pontos para desenhar o segmento horizontal D
        // double[] xHorizontal = {0.1*this.escala+xInicial, 0.2*this.escala+xInicial, 1.0*this.escala+xInicial, 1.1*this.escala+xInicial, 1.0*this.escala+xInicial, 0.2*this.escala+xInicial};
        // double[] yHorizontal = {0.2*this.escala+yInicial, 0.3*this.escala+yInicial, 0.3*this.escala+yInicial, 0.2*this.escala+yInicial, 0.1*this.escala+yInicial, 0.1*this.escala+yInicial};

        // tela.setPenColor(corSegmento[3]);
        // tela.filledPolygon(xHorizontal, yHorizontal);
        // segmento.horizontal(corSegmento[3], xHorizontal, yHorizontal);
        this.segmento[3] = new Segmento(tela, xHorizontal, yHorizontal, escala, corSegmento[3]);
        // -------------------------------------- //

        // -------------------------------------- //
        // Desenhando o segmento horizontal G
        // for (int i = 0; i < yHorizontal.length; i++) {
        //     // Multiplicador padrão para alinhar a grade: 1.1
        //     yHorizontal[i] += MULTIPLICADOR_Y*escala;
        // }

        // tela.setPenColor(corSegmento[6]);
        // tela.filledPolygon(xHorizontal, yHorizontal);
        yHorizontal += MULTIPLICADOR_Y*escala;
        this.segmento[6] = new Segmento(tela, xHorizontal, yHorizontal, escala, corSegmento[6]);
        // -------------------------------------- //

        // -------------------------------------- //
        // Desenhando o segmento horizontal A
        // for (int i = 0; i < yHorizontal.length; i++) {
        //     // Multiplicador padrão para alinhar a grade: 1.1
        //     yHorizontal[i] += MULTIPLICADOR_Y*escala; 
        // }

        // tela.setPenColor(corSegmento[0]);
        // tela.filledPolygon(xHorizontal, yHorizontal);
        yHorizontal += MULTIPLICADOR_Y*escala;
        this.segmento[0] = new Segmento(tela, xHorizontal, yHorizontal, escala, corSegmento[0]);
        // -------------------------------------- //
        
        // -------------------------------------- //
        double xVertical = xInicial;
        double yVertical = yInicial;

        // Motando os pontos para desenhar o segmento vertical E

        // Multiplicador padrão para alinhar à grade: 0.1
        yVertical += MULTIPLICADOR_Y_INICIAL*escala;

        // double[] xVertical = {0.1*escala+xInicial, 0.2*escala+xInicial, 0.2*escala+xInicial, 0.1*escala+xInicial, 0*escala+xInicial, 0*escala+xInicial};
        // double[] yVertical = {0.2*escala+yInicial, 0.3*escala+yInicial, 1.0*escala+yInicial, 1.1*escala+yInicial, 1.0*escala+yInicial, 0.3*escala+yInicial};

        // tela.setPenColor(corSegmento[4]);
        // tela.filledPolygon(xVertical, yVertical);
        this.segmento[4] = new Segmento(tela, xVertical, yVertical, escala, corSegmento[4], true);
        // -------------------------------------- //

        // -------------------------------------- //
        // Desenhando o segmento vertical C
        // for (int i = 0; i < xVertical.length; i++) {
        //     // Multiplicador padrão para alinhar à grade: 1.0
        //     xVertical[i] += 1.0*escala;
        // }

        // tela.setPenColor(corSegmento[2]);
        // tela.filledPolygon(xVertical, yVertical);
        xVertical += 0.8*escala;
        this.segmento[2] = new Segmento(tela, xVertical, yVertical, escala, corSegmento[2], true);
        // -------------------------------------- //

        // -------------------------------------- //
        // Desenhando o segmento vertical F
        // for (int i = 0; i < xVertical.length; i++) {
        //     xVertical[i] -= 1.0*escala;

        //     // Multiplicador padrão para alinhar à grade: 1.1
        //     yVertical[i] += MULTIPLICADOR_Y*escala;
        // }

        // tela.setPenColor(corSegmento[5]);
        // tela.filledPolygon(xVertical, yVertical);
        xVertical -= 0.8*escala;
        yVertical += MULTIPLICADOR_Y*escala;
        this.segmento[5] = new Segmento(tela, xVertical, yVertical, escala, corSegmento[5],true);
        // -------------------------------------- //

        // -------------------------------------- //
        // Desenhando o segmento vertical B
        // for (int i = 0; i < xVertical.length; i++) {
        //     xVertical[i] += 1.0*escala;
        // }

        // tela.setPenColor(corSegmento[1]);
        // tela.filledPolygon(xVertical, yVertical);
        xVertical += 0.8*escala;
        this.segmento[1] = new Segmento(tela, xVertical, yVertical, escala, corSegmento[1],true);
        // -------------------------------------- //

        for (int i = 0; i < segmento.length; i++) {
            this.segmento[i].desenhar();
        }
    }

    /**
     * Define as coordenadas centrais do display
     * @param coordenadas vertor do tipo double com as coordenadas x e y
     */
    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    
}
