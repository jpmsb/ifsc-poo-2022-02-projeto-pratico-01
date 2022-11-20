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
    private final int ESCALA_PADRAO = 100;

    /**
     * Valor de cor padrão para segmentos acesos
     */
    private final Color COR_ACESO_PADRAO = Color.RED;

    /**
     * Valor de cor padrão para segmentos apagados
     */
    private final Color COR_APAGADO_PADRAO = Color.LIGHT_GRAY;

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
    private Color[] corSegmento;

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
    private double escala;


    /**
     * Construtor da classe
     * @param tela objeto do tipo Draw onde o display será desenhado
     * @param coordenadas posição central onde o display será desenhado
     * @param corAceso cor representando os segmentos acesos
     * @param corApagado cor representando os segmentos apagados
     * @param escala tamanho do display na tela como um todo
     */
    public Display7Segmentos(Draw tela, double[] coordenadas, Color corAceso, Color corApagado, double escala) {
        this.tela = tela;
        this.coordenadas = coordenadas;
        this.corApagado = corApagado;
        this.corAceso = corAceso;
        this.escala = escala;
        this.corSegmento = new Color[7];

    }

    /**
     * Construtor da classe
     * @param tela objeto do tipo Draw onde o display será desenhado
     * @param coordenadas posição central onde o display será desenhado
     * @param corAceso cor representando os segmentos acesos
     * @param corApagado cor representando os segmentos apagados
     */
    public Display7Segmentos(Draw tela, double[] coordenadas, Color corAceso, Color corApagado) {
        this.tela = tela;
        this.coordenadas = coordenadas;
        this.corAceso = corAceso;
        this.corApagado = corApagado;
        this.escala = ESCALA_PADRAO;
        this.corSegmento = new Color[7];
    }

    /**
     * Construtor da classe
     * @param tela objeto do tipo Draw onde o display será desenhado
     * @param coordenadas posição central onde o display será desenhado
     * @param escala tamanho do display na tela como um todo
     */
    public Display7Segmentos(Draw tela, double[] coordenadas, int escala) {
        this.tela = tela;
        this.coordenadas = coordenadas;
        this.corAceso = COR_ACESO_PADRAO;
        this.corApagado = COR_APAGADO_PADRAO;
        this.escala = escala;
        this.corSegmento = new Color[7];
    }

    /**
     * Construtor da classe
     * @param tela objeto do tipo Draw onde o display será desenhado
     * @param coordenadas posição central onde o display será desenhado
     */
    public Display7Segmentos(Draw tela, double[] coordenadas) {
        this.tela = tela;
        this.coordenadas = coordenadas;
        this.corAceso = COR_ACESO_PADRAO;
        this.corApagado = COR_APAGADO_PADRAO;
        this.escala = ESCALA_PADRAO;
        this.corSegmento = new Color[7];
    }

    /**
     * Desenha um display de 7 segmentos de acordo
     * com o dígito informado
     * @param digito valor inteiro de 0 a 9. Caso maior que 9, a letra "E" é desenhada
     */
    public boolean desenhar(int digito){
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
            return ! desenhar(this.corSegmento);
        }

        return desenhar(this.corSegmento);
    }

    /**
     * Desenha um display com 7 segmentos
     * @param corSegmento define a cor de cada segmento
     */
    private boolean desenhar(Color[] corSegmento){
        if (this.tela == null | escala <= 0) return false;
        else {
            // Coordenadas iniciais
            double xInicial = coordenadas[0] - (0.5*escala);
            double yInicial = coordenadas[1] - (1.05*escala);

            // Segmentos horizontais ---------------- //
            double xHorizontal = xInicial;
            double yHorizontal = yInicial;

            // Desenhando o segmento horizontal D
            this.segmento[3] = new Segmento(tela, xHorizontal, yHorizontal, escala, corSegmento[3]);
            // -------------------------------------- //

            // -------------------------------------- //
            // Desenhando o segmento horizontal G
            yHorizontal += MULTIPLICADOR_Y*escala;
            this.segmento[6] = new Segmento(tela, xHorizontal, yHorizontal, escala, corSegmento[6]);
            // -------------------------------------- //

            // -------------------------------------- //
            // Desenhando o segmento horizontal A
            yHorizontal += MULTIPLICADOR_Y*escala;
            this.segmento[0] = new Segmento(tela, xHorizontal, yHorizontal, escala, corSegmento[0]);
            // -------------------------------------- //
            
            // Segmentos verticais ------------------ //
            double xVertical = xInicial;
            double yVertical = yInicial;

            // Motando os pontos para desenhar o segmento vertical E
            // Multiplicador padrão para alinhar à grade: 0.1
            yVertical += MULTIPLICADOR_Y_INICIAL*escala;
            this.segmento[4] = new Segmento(tela, xVertical, yVertical, escala, corSegmento[4], true);
            // -------------------------------------- //

            // -------------------------------------- //
            // Desenhando o segmento vertical C
            xVertical += 0.8*escala;
            this.segmento[2] = new Segmento(tela, xVertical, yVertical, escala, corSegmento[2], true);
            // -------------------------------------- //

            // -------------------------------------- //
            // Desenhando o segmento vertical F
            xVertical -= 0.8*escala;
            yVertical += MULTIPLICADOR_Y*escala;
            this.segmento[5] = new Segmento(tela, xVertical, yVertical, escala, corSegmento[5],true);
            // -------------------------------------- //

            // -------------------------------------- //
            // Desenhando o segmento vertical B
            xVertical += 0.8*escala;
            this.segmento[1] = new Segmento(tela, xVertical, yVertical, escala, corSegmento[1],true);
            // -------------------------------------- //

            for (int i = 0; i < segmento.length; i++) {
                this.segmento[i].desenhar();
            }
            return true;
        }   
    }

    /**
     * Define as coordenadas centrais do display
     * @param coordenadas vertor do tipo double com as coordenadas x e y
     */
    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    /**
     * Define onde o display de 7 segmentos será desenhado
     * @param tela objeto do tipo Draw
     */
    public void setTela(Draw tela) {
        this.tela = tela;
    }

    /**
     * Define a cor dos segmentos apagados
     * @param corApagado
     */
    public void setCorApagado(Color corApagado) {
        this.corApagado = corApagado;
    }

    /**
     * Define a cor dos segmentos acesos
     * @param corAceso
     */
    public void setCorAceso(Color corAceso) {
        this.corAceso = corAceso;
    }

    /**
     * Define o tamanho relativo do display
     * @param escala valor com o novo tamanho
     */
    public void setEscala(double escala) {
        this.escala = escala;
    }

    /**
     * Obtém a cor atual do segmento apagado
     * @return objeto do tipo Color representando a cor do segmento apagado.
     */
    public Color getCorApagado() {
        return corApagado;
    }

    /**
     * Obtém a cor atual do segmento aceso
     * @return objeto do tipo Color representando a cor do segmento aceso.
     */
    public Color getCorAceso() {
        return corAceso;
    }

    /**
     * Obtém a escala atual
     * @return double contendo o valor atual de escala.
     */
    public double getEscala() {
        return escala;
    }
}