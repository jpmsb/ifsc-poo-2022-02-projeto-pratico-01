package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class Segmento {
    /**
     * Constante que define o tamanho padrão do desenho do segmento
     */
    private final double ESCALA_PADRAO = 100;

    /**
     * Constante que define a cor padrão para vermelho
     */
    private final Color COR_PADRAO = Color.RED;

    /**
     * Constante que define as coordenadas padrões
     */
    private final double[] COORDENADAS_PADRAO = {0,0};

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
    private double escala;

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
     * Cria um segmento definindo todos os seus atributos. Todos os atributos passados
     * devem ser válidos.
     * 
     * @param tela objeto onde o segmento será desenhado
     * @param coordenadaX coordenada inferior esquerda X de onde o segmento será desenhado
     * @param coordenadaY coordenada inferior esquerda Y de onde o segmento será desenhado
     * @param escala tamanho proporcional do segmento
     * @param cor cor do segmento
     * @param tipoVertical tipo de orientação do segmento. Verdadeiro para ser vertical e falso para horizontal
     */
    public Segmento(Draw tela, double coordenadaX, double coordenadaY, double escala, Color cor, boolean tipoVertical) {
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
     * Cria um segmento horizontal
     * 
     * @param tela objeto onde o segmento será desenhado
     * @param coordenadaX coordenada inferior esquerda X de onde o segmento será desenhado
     * @param coordenadaY coordenada inferior esquerda Y de onde o segmento será desenhado
     * @param escala tamanho proporcional do segmento
     * @param cor cor do segmento
     */
    public Segmento(Draw tela, double coordenadaX, double coordenadaY, double escala, Color cor){
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
    public Segmento(Draw tela, double coordenadaX, double coordenadaY, double escala) {
        this.tela = tela;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.escala = escala;
        this.cor = COR_PADRAO;
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
        this.tela = tela;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.escala = ESCALA_PADRAO;
        this.cor = COR_PADRAO;

    }

    /**
     * Construtor da classe
     * 
     * Cria um segmento definindo o objeto de desenho e a escala
     * 
     * @param tela objeto onde o segmento será desenhado
     * @param escala tamanho proporcional do segmento
     */
    public Segmento(Draw tela, double escala) {
        this.tela = tela;
        this.escala = escala;
        this.coordenadaX = COORDENADAS_PADRAO[0];
        this.coordenadaY = COORDENADAS_PADRAO[1];
        this.cor = COR_PADRAO;
    }

    /**
     * Construtor da classe
     * 
     * Cria um segmento definindo apenas o objeto de desenho
     * 
     * @param tela objeto onde o segmento será desenhado
     */
    public Segmento(Draw tela){
        this.tela = tela;
        this.escala = ESCALA_PADRAO;
        this.coordenadaX = COORDENADAS_PADRAO[0];
        this.coordenadaY = COORDENADAS_PADRAO[1];
        this.cor = COR_PADRAO;
    }

    /**
     * Cria e desenha um segmento horizontal com cor e coordenadas
     * definas no construtor
     * @return verdadeiro caso seja possível desenhar e falso, caso contrário.
     */
    public boolean horizontal(){
        if (this.tela == null | escala <= 0) return false;
        else {
            double[] xSegmento = {0.1*escala+coordenadaX, 0.2*escala+coordenadaX, 0.8*escala+coordenadaX, 0.9*escala+coordenadaX, 0.8*escala+coordenadaX, 0.2*escala+coordenadaX};
            double[] ySegmento = {0.2*escala+coordenadaY, 0.3*escala+coordenadaY, 0.3*escala+coordenadaY, 0.2*escala+coordenadaY, 0.1*escala+coordenadaY, 0.1*escala+coordenadaY};

            this.tela.setPenColor(cor);
            this.tela.filledPolygon(xSegmento, ySegmento);
            return true;
        }
    }

    /**
     * Cria e desenha um segmento vertical com cor e coordenadas
     * definas no construtor
     * @return verdadeiro caso seja possível desenhar e falso, caso contrário.
     */
    public boolean vertical(){
        if (this.tela == null | escala <= 0) return false;
        else {
            double[] xSegmento = {0.1*escala+coordenadaX, 0.2*escala+coordenadaX, 0.2*escala+coordenadaX, 0.1*escala+coordenadaX, 0*escala+coordenadaX, 0*escala+coordenadaX};
            double[] ySegmento = {0.2*escala+coordenadaY, 0.3*escala+coordenadaY, 0.9*escala+coordenadaY, 1.0*escala+coordenadaY, 0.9*escala+coordenadaY, 0.3*escala+coordenadaY};

            this.tela.setPenColor(cor);
            this.tela.filledPolygon(xSegmento, ySegmento);
            return true;
        }
    }

    /**
     * Desenha o segmento de acordo com o tipo definido no construtor
     * @return string contendo a orientação atual
     */
    public String desenhar(){
        if (tipoVertical && vertical()) {
            return "Vertical";
        } else if ((! tipoVertical) && horizontal()) {
            return "Horizontal";
        } else return "Inválido";
    }

    /**
     * Define o objeto onde o segmento será desenhado
     * @param tela objeto onde o segmento será desenhado
     */    
    public void setTela(Draw tela) {
        this.tela = tela;
    }

    /**
     * Define a cor do segmento
     * @param cor cor do segmento
     */
    public void setCor(Color cor) {
        this.cor = cor;
    }

    /**
     * Define o tamanho proporcional do segmento
     * @param escala tamanho do segmento
     */
    public void setEscala(double escala) {
        this.escala = escala;
    }

    /**
     * Define a coordenada X
     * @param coordenadaX valor representando a posição horizontal
     */
    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    /**
     * Define a coordenada Y
     * @param coordenadaY valor representando a posição vertical
     */
    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    /**
     * Define se o segmento é horizontal ou vertical.
     * Se for vertical, deve ser definido "true".
     * @param tipoVertical verdadeiro ou falso para ser vertical
     */
    public void setTipoVertical(boolean tipoVertical) {
        this.tipoVertical = tipoVertical;
    }

    /**
     * Obtém o objeto onde o segmento será desenhado
     * @return objeto do tipo Draw
     */
    public Draw getTela() {
        return tela;
    }

    /**
     * Obtém a cor atual do segmento
     * @return cor atual
     */
    public Color getCor() {
        return cor;
    }

    /**
     * Obtém a escala atual do segmento
     * @return escala 
     */
    public double getEscala() {
        return escala;
    }

    /**
     * Obtém a coordenada X do segmento
     * @return double com o valor da coordenada X
     */
    public double getCoordenadaX() {
        return coordenadaX;
    }

    /**
     * Obtém a coordenada Y do segmento
     * @return double com o valor da coordenada Y
     */
    public double getCoordenadaY() {
        return coordenadaY;
    }

    /**
     * Obtém o tipo da orientação do segmento.
     * @return verdadeiro caso a orientação seja vertical e falso, caso contrário.
     */
    public boolean isTipoVertical() {
        return tipoVertical;
    }
}