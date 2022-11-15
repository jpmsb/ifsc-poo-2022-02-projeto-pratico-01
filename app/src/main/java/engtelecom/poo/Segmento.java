package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class Segmento {
    /**
     * Constante que define o tamanho padrão do desenho do segmento
     */
    private static final int ESCALA_PADRAO = 200;

    /**
     * Constante que define a cor padrão para vermelho
     */
    private static final Color COR_PADRAO = Color.RED;

    /**
     * Constante que define as coordenadas padrões
     */
    private static final double[] COORDENADAS_PADRAO = {0,0};

    /**
     * Objeto onde será desenhado o segmento
     */
    private Draw tela;

    /**
     * Cor do segmento
     */
    private Color cor;

    /**
     * Tamanho do segmento
     */
    private int escala;

    /**
     * Coordenada inferior esquerda X do segmento
     */
    private double coordenadaX;

    /**
     * Coordenada inferior esquerda Y do segmento
     */
    private double coordenadaY;

    /**
     * Booleana indicativa se o segmento é vertical
     */
    private boolean tipoVertical;


    /**
     * Construtor da classe
     * 
     * Cria um segmento definindo todos os seus atributos
     * 
     * @param tela objeto onde o segmento será desenhado
     * @param coordenadaX coordenada inferior esquerda X de onde o segmento será desenhado
     * @param coordenadaY coordenada inferior esquerda Y de onde o segmento será desenhado
     * @param escala tamanho proporcional do segmento
     * @param cor cor do segmento
     * @param tipoVertical tipo de orientação do segmento. Verdadeiro para ser vertical e falso para horizontal
     */
    public Segmento(Draw tela, double coordenadaX, double coordenadaY, int escala, Color cor, boolean tipoVertical) {
        this.tela = tela;
        this.escala = escala;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.cor = cor;
        this.tipoVertical = tipoVertical;
    }

    /**
     * Construtor da classe
     * 
     * Cria um segmento definindo o tipo como horizontal
     * 
     * @param tela objeto onde o segmento será desenhado
     * @param coordenadaX coordenada inferior esquerda X de onde o segmento será desenhado
     * @param coordenadaY coordenada inferior esquerda Y de onde o segmento será desenhado
     * @param escala tamanho proporcional do segmento
     * @param cor cor do segmento
     */
    public Segmento(Draw tela, double coordenadaX, double coordenadaY, int escala, Color cor){
        this(tela, coordenadaX, coordenadaY, escala, cor, false);
    }

    /**
     * Construtor da classe
     * 
     * Cria um segmento definindo o objeto de desenho, coordenadas e a escala
     * 
     * @param tela objeto onde o segmento será desenhado
     * @param coordenadaX coordenada inferior esquerda X de onde o segmento será desenhado
     * @param coordenadaY coordenada inferior esquerda Y de onde o segmento será desenhado
     * @param escala tamanho proporcional do segmento
     */
    public Segmento(Draw tela, double coordenadaX, double coordenadaY, int escala) {
        this(tela, coordenadaX, coordenadaY, escala, COR_PADRAO);
    }

    /**
     * Construtor da classe
     * 
     * Cria um segmento definindo o objeto de desenho e coordenadas
     * 
     * @param tela objeto onde o segmento será desenhado
     * @param coordenadaX coordenada inferior esquerda X de onde o segmento será desenhado
     * @param coordenadaY coordenada inferior esquerda Y de onde o segmento será desenhado
     */
    public Segmento(Draw tela, double coordenadaX, double coordenadaY) {
        this(tela, coordenadaX, coordenadaY, ESCALA_PADRAO);
    }

    /**
     * Construtor da classe
     * 
     * Cria um segmento definindo o objeto de desenho e a escala
     * 
     * @param tela objeto onde o segmento será desenhado
     * @param escala tamanho proporcional do segmento
     */
    public Segmento(Draw tela, int escala) {
        this(tela, COORDENADAS_PADRAO[0], COORDENADAS_PADRAO[1], escala);
    }

    /**
     * Construtor da classe
     * 
     * Cria um segmento definindo apenas o objeto de desenho
     * 
     * @param tela objeto onde o segmento será desenhado
     */
    public Segmento(Draw tela){
        this(tela, COORDENADAS_PADRAO[0], COORDENADAS_PADRAO[1]);
    }

    /**
     * Cria e desenha um segmento horizontal com cor e coordenadas
     * definas no construtor
     */
    public void horizontal(){
        horizontal(this.cor, this.coordenadaX, this.coordenadaY);
    }

    /**
     * Cria e desenha um segmento horizontal especificando uma cor
     * @param cor cor do segmento
     */
    public void horizontal(Color cor){
        horizontal(cor, this.coordenadaX, this.coordenadaY);
    }

    /**
     * Cria e desenha um segmento horizontal especificando as coordenadas
     * @param coordenadaX coordenada inferior esquerda X
     * @param coordenadaY coordenada inferior esquerda Y
     */
    public void horizontal(double coordenadaX, double coordenadaY){
        horizontal(this.cor, coordenadaX, coordenadaY);
    }

    /**
     * Cria e desenha um segmento horizontal especificando cor e coordenadas
     * @param cor cor do segmento
     * @param coordenadaX coordenada inferior esquerda X
     * @param coordenadaY coordenada inferior esquerda Y
     */
    public void horizontal(Color cor, double coordenadaX, double coordenadaY){
        double[] xSegmento = {0.1*this.escala+coordenadaX, 0.2*this.escala+coordenadaX, 0.8*this.escala+coordenadaX, 0.9*this.escala+coordenadaX, 0.8*this.escala+coordenadaX, 0.2*this.escala+coordenadaX};
        double[] ySegmento = {0.2*this.escala+coordenadaY, 0.3*this.escala+coordenadaY, 0.3*this.escala+coordenadaY, 0.2*this.escala+coordenadaY, 0.1*this.escala+coordenadaY, 0.1*this.escala+coordenadaY};

        this.tela.setPenColor(cor);
        this.tela.filledPolygon(xSegmento, ySegmento);    
    }

    /**
     * Cria e desenha um segmento vertical com cor e coordenadas
     * definas no construtor
     */
    public void vertical(){
        vertical(this.cor, this.coordenadaX, this.coordenadaY);
    }

    /**
     * Cria e desenha um segmento vertical especificando uma cor
     * @param cor cor do segmento
     */
    public void vertical(Color cor){
        horizontal(cor, this.coordenadaX, this.coordenadaY);
    }

    /**
     * Cria e desenha um segmento vertical especificando as coordenadas
     * @param coordenadaX coordenada inferior esquerda X
     * @param coordenadaY coordenada inferior esquerda Y
     */
    public void vertical(double coordenadaX, double coordenadaY){
        vertical(this.cor, coordenadaX, coordenadaY);
    }

    /**
     * Cria e desenha um segmento vertical especificando cor e coordenadas
     * @param cor cor do segmento
     * @param coordenadaX coordenada inferior esquerda X
     * @param coordenadaY coordenada inferior esquerda Y
     */
    public void vertical(Color cor, double coordenadaX, double coordenadaY){
        double[] xSegmento = {0.1*escala+coordenadaX, 0.2*escala+coordenadaX, 0.2*escala+coordenadaX, 0.1*escala+coordenadaX, 0*escala+coordenadaX, 0*escala+coordenadaX};
        double[] ySegmento = {0.2*escala+coordenadaY, 0.3*escala+coordenadaY, 0.9*escala+coordenadaY, 1.0*escala+coordenadaY, 0.9*escala+coordenadaY, 0.3*escala+coordenadaY};

        this.tela.setPenColor(cor);
        this.tela.filledPolygon(xSegmento, ySegmento);
    }

    /**
     * Desenha o segmento de acordo com o tipo definido no construtor
     */
    public void desenhar(){
        if (tipoVertical) vertical();
        else horizontal();
    }
}