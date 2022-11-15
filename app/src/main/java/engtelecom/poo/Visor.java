package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class Visor {
    /**
     * Constante para representar os valores de cor
     * vermelho, verde e azul mínimos para compor uma cor clara
     */
    private static final int LIMIAR_DE_CORES = 15;

    /**
     * Vetor para alocar os 6 displays de 7 segmentos
     */
    private Display7Segmentos[] digitos = new Display7Segmentos[6];

    /**
     * Vetor com as coordenadas centrais do visor
     */
    private double[] coordenadas;

    /**
     * Cor dos segmentos apagados do visor
     */
    private Color corApagado;

    /**
     * Cor dos segmentos acesos do visor
     */
    private Color corAceso;

    /**
     * Tamanho proporcional do visor
     */
    private int escala;

    /**
     * Objeto onde o visor será desenhado
     */
    private Draw tela;

    /**
     * Construtor da classe
     * 
     * Cria um visor com todos os atributos 
     * 
     * @param tela objeto onde o visor será desenhado
     * @param coordenadas coordenadas x e y centrais onde o visor deverá ser desenhado
     * @param escala tamanho proporcional do visor
     * @param corAceso cor dos segmentos acesos
     * @param corApagado cor dos segmentos apagados
     */
    public Visor(Draw tela, double[] coordenadas, int escala, Color corAceso, Color corApagado) {
        this.coordenadas = coordenadas;
        this.corApagado = corApagado;
        this.corAceso = corAceso;
        this.escala = escala;
        this.tela = tela;

    }

    /**
     * Construtor da classe
     * 
     * Cria um visor, calculando a cor dos segmentos apagados com base na cor
     * dos segmentos acesos.
     * 
     * @param tela objeto onde o visor será desenhado
     * @param coordenadas coordenadas x e y centrais onde o visor deverá ser desenhado
     * @param escala tamanho proporcional do visor
     * @param corAceso cor dos segmentos acesos
     */
    public Visor(Draw tela, double[] coordenadas, int escala, Color corAceso){
        this(tela, coordenadas, escala, corAceso, obtemCorApagada(corAceso));
    }

    /**
     * Desenha os dígitos das horas já na posição relativa correta
     * @param hora
     */
    public void desenharHora(int hora){
        // Dígito da unidade das horas
        double[] coordenadaHorUnidade = {coordenadas[0] - (2.0*escala), coordenadas[1]};
        if (this.digitos[0] == null) this.digitos[0] = new Display7Segmentos(tela, coordenadaHorUnidade, corAceso, corApagado, escala);
        this.digitos[0].desenhar(obtemUnidade(hora));

        // Dígito da dezena das horas
        double[] coordenadaHorDezena = {coordenadas[0] - (3.1*escala), coordenadas[1]};
        if (this.digitos[1] == null) this.digitos[1] = new Display7Segmentos(tela, coordenadaHorDezena, corAceso, corApagado, escala);
        this.digitos[1].desenhar(obtemDezena(hora));
    }

    /**
     * Desenha os dígitos dos minutos já na posição relativa correta
     * @param minuto
     */
    public void desenharMinuto(int minuto){
        // Dígito da unidade dos minutos
        double[] coordenadaMinUnidade = {coordenadas[0] + (0.5*escala), coordenadas[1]};
        if (this.digitos[2] == null) this.digitos[2] = new Display7Segmentos(tela, coordenadaMinUnidade, corAceso, corApagado, escala);
        this.digitos[2].desenhar(obtemUnidade(minuto));

        // Dígito da dezena dos minutos
        double[] coordenadaMinDezena = {coordenadas[0] - (0.6*escala), coordenadas[1]};
        if (this.digitos[3] == null) this.digitos[3] = new Display7Segmentos(tela, coordenadaMinDezena, corAceso, corApagado, escala);
        this.digitos[3].desenhar(obtemDezena(minuto));
    }

    /**
     * Desenha os dígitos dos segundos já na posição relativa correta
     * @param segundo
     */
    public void desenharSegundo(int segundo){
        // Dígito da unidade dos segundos
        double[] coordenadaSegUnidade = {coordenadas[0] + (3.0*escala), coordenadas[1]};
        if (this.digitos[4] == null) this.digitos[4] = new Display7Segmentos(tela, coordenadaSegUnidade, corAceso, corApagado, escala);
        this.digitos[4].desenhar(obtemUnidade(segundo));

        // Dígito da dezena dos segundos
        double[] coordenadaSegDezena = {coordenadas[0] + (1.9*escala), coordenadas[1]};
        if (this.digitos[5] == null) this.digitos[5] = new Display7Segmentos(tela, coordenadaSegDezena, corAceso, corApagado, escala);
        this.digitos[5].desenhar(obtemDezena(segundo));

    }

    /**
     * Desehna o visor com os 6 dígitos e os dois pontos entre as horas e minutos e minutos e segundos
     * @param hora valor inteiro representando a hora
     * @param minuto valor inteiro representando os minutos
     * @param segundo valor inteiro representando os segundos
     */
    public void ver(int hora, int minuto, int segundo){
        desenharHora(hora);

        // Dois pontos
        tela.setPenColor(corAceso);
        tela.filledCircle(coordenadas[0] - (1.3*escala), coordenadas[1] + (0.2*escala), 10);
        tela.filledCircle(coordenadas[0] - (1.3*escala), coordenadas[1] - (0.2*escala), 10);

        desenharMinuto(minuto);

        // Dois pontos
        tela.setPenColor(corAceso);
        tela.filledCircle(coordenadas[0] + (1.2*escala), coordenadas[1] + (0.2*escala), 10);
        tela.filledCircle(coordenadas[0] + (1.2*escala), coordenadas[1] - (0.2*escala), 10);

        desenharSegundo(segundo); 
    }

    /**
     * Obtém a parte da dezena de um número
     * @param numero número o qual será extraído a dezena
     * @return apenas o dígito da dezena do número informado
     */
    private int obtemDezena(int numero){
        return numero/10;
    }

    /**
     * Obtém a parte da unidade de um número
     * @param numero número o qual será extraído a unidade
     * @return apenas o dígito da unidade do número informado
     */
    private int obtemUnidade(int numero){
        return numero - ((numero/10)*10);
    }

    /**
     * Gera uma versão mais escura da cor informada
     * @param cor cor a ser versionada
     * @return versão escura da cor informada. Caso a cor informada
     * já seja escura, a mesma é retornada sem ajustes.
     */
    private static Color obtemCorApagada(Color cor){
        int vermelho = cor.getRed();
        int verde = cor.getGreen();
        int azul = cor.getBlue();

        if (vermelho < LIMIAR_DE_CORES && verde < LIMIAR_DE_CORES && azul < LIMIAR_DE_CORES) return cor;
        else {
            int vermelhoApagado = (int) Math.round(cor.getRed()*0.2);
            int verdeApagado = (int) Math.round(cor.getGreen()*0.2);
            int azulApagado = (int) Math.round(cor.getBlue() * 0.2);
            Color personalizada = new Color(vermelhoApagado, verdeApagado, azulApagado);
            return personalizada;
        }
    }
}
