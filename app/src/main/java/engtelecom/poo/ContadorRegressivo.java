package engtelecom.poo;

import java.awt.Color;
import edu.princeton.cs.algs4.Draw;

public class ContadorRegressivo {
    /**
     * Objeto visor que representará o contador regressivo
     */
    private Visor visor;

    /**
     * Objeto onde o contador regressivo será desenhado
     */
    private Draw tela;

    /**
     * Coordenadas centrais do visor do contador regressivo
     */
    private double[] coordenadas;

    /**
     * Tamanho relativo do visor do contador regressivo
     */
    private int escala;

    /**
     * Cor dos segmentos acesos do visor do contador regressivo
     */
    private Color corAceso;

    /**
     * Cor dos segmentos apagados do visor do contador regressivo
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
     * Cria um contador regressivo especificando todos os atributos do mesmo
     * 
     * @param tela objeto onde o visor do contador regressivo será desenhado
     * @param coordenadas coordenadas centrais do visor do contador regressivo
     * @param escala escala relativa do visor do contador regressivo
     * @param corAceso cor dos segmentos acesos
     * @param corApagado cor dos segmentos apagados
     * @param horaInicial hora inicial de partida
     * @param minutoInicial minuto inicial de partida
     * @param segundoInicial segundo inicial de partida
     */
    public ContadorRegressivo(Draw tela, double[] coordenadas, int escala, Color corAceso, Color corApagado, int horaInicial, int minutoInicial, int segundoInicial) {
        this.tela = tela;
        this.coordenadas = coordenadas;
        this.escala = escala;
        this.corAceso = corAceso;
        this.corApagado = corApagado;
        this.horaAtual = horaInicial;
        this.minutoAtual = minutoInicial;
        this.segundoAtual = segundoInicial;
    }

    /**
     * Construtor da classe
     * 
     * Cria um contador regressivo omitindo a cor dos segmentos apagados.
     * A cor dos segmentos apagados será calculada a partir da
     * cor dos segmentos acesos.
     * 
     * @param tela objeto onde o visor do contador regressivo será desenhado
     * @param coordenadas coordenadas centrais do visor do contador regressivo
     * @param escala escala relativa do visor do contador regressivo
     * @param corAceso cor dos segmentos acesos
     * @param horaInicial hora inicial de partida
     * @param minutoInicial minuto inicial de partida
     * @param segundoInicial segundo inicial de partida
     */
    public ContadorRegressivo(Draw tela, double[] coordenadas, int escala, Color corAceso, int horaInicial, int minutoInicial, int segundoInicial) {
        this(tela, coordenadas, escala, corAceso, null, horaInicial, minutoInicial, segundoInicial);
    }
  
    /**
     * Realiza a contagem de forma regressiva, iniciando na hora,
     * minuto e segundo informados no construtor.
     */
    public void contar(){
        if (this.visor == null){
            if (corApagado == null) this.visor = new Visor(tela, coordenadas, escala, corAceso);
            else this.visor = new Visor(tela, coordenadas, escala, corAceso, corApagado);
        }

        if (horaAtual == 0 && minutoAtual == 0 && segundoAtual == 0){
            horaAtual = 99;
            minutoAtual = 59;
            segundoAtual = 59;
        } else if (minutoAtual == 0 && segundoAtual == 0){
            minutoAtual = 59;
            segundoAtual = 59;
            horaAtual--;
        } else if (segundoAtual == 0){
            segundoAtual = 59;
            minutoAtual--;
        }

        this.visor.ver(horaAtual, minutoAtual, segundoAtual);
        segundoAtual--;
    }
}