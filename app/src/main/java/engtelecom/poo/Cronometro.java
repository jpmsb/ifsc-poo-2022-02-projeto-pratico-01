package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class Cronometro {
    /**
     * Objeto visor que representará o cronômetro
     */
    private Visor visor;

    /**
     * Objeto onde o cronômetro será desenhado
     */
    private Draw tela;

    /**
     * Coordenadas centrais do visor do cronômetro
     */
    private double[] coordenadas;

    /**
     * Tamanho relativo do visor do cronômetro
     */
    private int escala;

    /**
     * Cor dos segmentos acesos do visor do cronômetro
     */
    private Color corAceso;

    /**
     * Cor dos segmentos apagados do visor do cronômetro
     */
    private Color corApagado;

    /**
     * Hora atual sendo computada
     */
    private int horaAtual;

    /**
     * Minuto atual sendo computado
     */
    private int minutoAtual;

    /**
     * Segundo atual sendo computado
     */
    private int segundoAtual;

    /**
     * Construtor da classe
     * 
     * Cria um cronômetro especificando todos os atributos do mesmo
     * 
     * @param tela objeto onde o visor do cronômetro será desenhado
     * @param coordenadas coordenadas centrais do visor do cronômetro
     * @param escala escala relativa do visor do cronômetro
     * @param corAceso cor dos segmentos acesos
     * @param corApagado cor dos segmentos apagados
     */
    public Cronometro(Draw tela, double[] coordenadas, int escala, Color corAceso, Color corApagado){
        this.tela = tela;
        this.coordenadas = coordenadas;
        this.escala = escala;
        this.corAceso = corAceso;
        this.corApagado = corApagado;
    }

    /**
     * Construtor da classe
     * 
     * Cria um cronômetro omitindo a cor dos segmentos apagados.
     * A cor dos segmentos apagados será calculada a partir da
     * cor dos segmentos acesos.
     * 
     * @param tela objeto onde o visor do cronômetro será desenhado
     * @param coordenadas coordenadas centrais do visor do cronômetro
     * @param escala escala relativa do visor do cronômetro
     * @param corAceso cor dos segmentos acesos
     */
    public Cronometro(Draw tela, double[] coordenadas, int escala, Color corAceso){
        this(tela, coordenadas, escala, corAceso, null);
    }

    /**
     * Realiza a contagem de forma progressiva, iniciando em 00:00:00
     */
    public void contar(){
        if (this.visor == null){
            if (corApagado == null) this.visor = new Visor(tela, coordenadas, escala, corAceso);
            else this.visor = new Visor(tela, coordenadas, escala, corAceso, corApagado);
        }
        if (segundoAtual >= 59){
            segundoAtual = 0;
            minutoAtual++;
        } else if (minutoAtual >= 59){
            minutoAtual = 0;
            horaAtual++;
        } else if (horaAtual >= 99){
            horaAtual = 0;
            minutoAtual = 0;
            segundoAtual = 0;
        }

        this.visor.ver(horaAtual, minutoAtual, segundoAtual);
        segundoAtual++;
    }
}
