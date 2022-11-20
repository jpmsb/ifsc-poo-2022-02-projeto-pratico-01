package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class Visor {
    /**
     * Constante para representar os valores de cor
     * vermelho, verde e azul mínimos para compor uma cor clara
     */
    private final int LIMIAR_DE_CORES = 70;

    /**
     * Vetor para alocar os 6 displays de 7 segmentos
     */
    private Display7Segmentos[] digitos;

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
        this.digitos = new Display7Segmentos[6];

        for (int i = 0; i < this.digitos.length; i++){
            this.digitos[i] = new Display7Segmentos(tela, coordenadas, corAceso, corApagado, escala);
        }
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
        this.tela = tela;
        this.coordenadas = coordenadas;
        this.escala = escala;
        this.corAceso = corAceso;
        this.corApagado = obtemCorApagada(corAceso);
        this.digitos = new Display7Segmentos[6];

        for (int i = 0; i < this.digitos.length; i++){
            this.digitos[i] = new Display7Segmentos(tela, coordenadas, corAceso, corApagado, escala);
        }
    }

    /**
     * Desenha os dígitos das horas já na posição relativa correta
     * @param hora inteiro representando a hora
     */
    private void desenharHora(int hora){
        // Dígito da unidade das horas
        double[] coordenadaHorUnidade = {coordenadas[0] - (2.0*escala), coordenadas[1]};
        this.digitos[0].setCoordenadas(coordenadaHorUnidade);
        this.digitos[0].desenhar(obtemUnidade(hora));

        // Dígito da dezena das horas
        double[] coordenadaHorDezena = {coordenadas[0] - (3.1*escala), coordenadas[1]};
        this.digitos[1].setCoordenadas(coordenadaHorDezena);
        this.digitos[1].desenhar(obtemDezena(hora));
    }

    /**
     * Desenha os dígitos dos minutos já na posição relativa correta
     * @param minuto inteiro representando o minuto
     */
    private void desenharMinuto(int minuto){
        // Dígito da unidade dos minutos
        double[] coordenadaMinUnidade = {coordenadas[0] + (0.5*escala), coordenadas[1]};
        this.digitos[2].setCoordenadas(coordenadaMinUnidade);
        this.digitos[2].desenhar(obtemUnidade(minuto));

        // Dígito da dezena dos minutos
        double[] coordenadaMinDezena = {coordenadas[0] - (0.6*escala), coordenadas[1]};
        this.digitos[3].setCoordenadas(coordenadaMinDezena);
        this.digitos[3].desenhar(obtemDezena(minuto));
    }

    /**
     * Desenha os dígitos dos segundos já na posição relativa correta
     * @param segundo inteiro representando o segundo
     */
    private void desenharSegundo(int segundo){
        // Dígito da unidade dos segundos
        double[] coordenadaSegUnidade = {coordenadas[0] + (3.0*escala), coordenadas[1]};
        this.digitos[4].setCoordenadas(coordenadaSegUnidade);
        this.digitos[4].desenhar(obtemUnidade(segundo));

        // Dígito da dezena dos segundos
        double[] coordenadaSegDezena = {coordenadas[0] + (1.9*escala), coordenadas[1]};
        this.digitos[5].setCoordenadas(coordenadaSegDezena);
        this.digitos[5].desenhar(obtemDezena(segundo));
    }

    /**
     * Desehna o visor com os 6 dígitos e os dois pontos entre as horas e minutos e minutos e segundos
     * @param hora valor inteiro representando a hora
     * @param minuto valor inteiro representando os minutos
     * @param segundo valor inteiro representando os segundos
     * @return verdadeiro se foi possível realizar o desenho do visor e falso, caso contrário.
     */
    public boolean ver(int hora, int minuto, int segundo){
        if (tela == null | escala <= 0 | hora < 0 | minuto < 0 | segundo < 0 | hora > 99 | minuto > 99 | segundo > 99) return false;
        else {
            // Desenha os dígitos que representam a hora
            desenharHora(hora);

            // Dois pontos
            tela.setPenColor(corAceso);
            tela.filledCircle(coordenadas[0] - (1.3*escala), coordenadas[1] + (0.2*escala), 10);
            tela.filledCircle(coordenadas[0] - (1.3*escala), coordenadas[1] - (0.2*escala), 10);

            // Desenha os dígitos que representam o minuto
            desenharMinuto(minuto);

            // Dois pontos
            tela.setPenColor(corAceso);
            tela.filledCircle(coordenadas[0] + (1.2*escala), coordenadas[1] + (0.2*escala), 10);
            tela.filledCircle(coordenadas[0] + (1.2*escala), coordenadas[1] - (0.2*escala), 10);

            // Desenha os dígitos que representam o segundo
            desenharSegundo(segundo);
            return true;
        }
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
        return numero%10;
    }

    /**
     * Gera uma versão oposta da cor informada
     * @param cor cor a ser versionada
     * @return versão aproximadamente oposta à cor informada.
     * Se a cor informada for clara, retorna uma cor escura e vice-versa.
     */
    private Color obtemCorApagada(Color cor){
        int vermelho = cor.getRed();
        int verde = cor.getGreen();
        int azul = cor.getBlue();

        int vermelhoApagado;
        int verdeApagado;
        int azulApagado;

        if (vermelho <= LIMIAR_DE_CORES && verde <= LIMIAR_DE_CORES && azul <= LIMIAR_DE_CORES) {
            vermelhoApagado = 250 - (int) Math.round(cor.getRed() * 0.5);
            verdeApagado = 250 - (int) Math.round(cor.getGreen() * 0.5);
            azulApagado = 250 - (int) Math.round(cor.getBlue() * 0.5);
        } else {
            vermelhoApagado = (int) Math.round(cor.getRed() * 0.2);
            verdeApagado = (int) Math.round(cor.getGreen() * 0.2);
            azulApagado = (int) Math.round(cor.getBlue() * 0.2);
        }
        return new Color(vermelhoApagado, verdeApagado, azulApagado);
    }

    /**
     * Obtém as coordenadas atuais do visor
     * @return vetor de double com as coordenadas X e Y do visor
     */
    public double[] getCoordenadas() {
        return coordenadas;
    }

    /**
     * Obtém a cor para os segmentos apagados
     * @return cor dos segmentos apagados
     */
    public Color getCorApagado() {
        return corApagado;
    }

    /**
     * Obtém a cor para os segmentos acesos
     * @return cor dos segmentos acesos
     */
    public Color getCorAceso() {
        return corAceso;
    }

    /**
     * Obtém a escala relativa atual
     * @return escala relativa atual
     */
    public int getEscala() {
        return escala;
    }

    /**
     * Obtém onde o visor será desenhado
     * @return objeto do tipo Draw
     */
    public Draw getTela() {
        return tela;
    }

    /**
     * Define as coordenadas do visor
     * @param coordenadas vetor de double contendo as coordenadas X e Y
     */
    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    /**
     * Define a cor dos segmentos apagados
     * @param corApagado objeto Color
     */
    public void setCorApagado(Color corApagado) {
        this.corApagado = corApagado;
    }

    /**
     * Define a cor dos segmentos acesos
     * @param corApagado objeto Color
     */
    public void setCorAceso(Color corAceso) {
        this.corAceso = corAceso;
    }

    /**
     * Define a escala relativa do visor
     */
    public void setEscala(int escala) {
        this.escala = escala;
    }

    /**
     * Define onde o visor será desenhado
     * @param tela objeto do tipo Draw
     */
    public void setTela(Draw tela) {
        this.tela = tela;
    }
}