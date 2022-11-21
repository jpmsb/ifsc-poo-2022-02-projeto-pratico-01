package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class ContadorRegressivo {
    /**
     * Constante de tamanho relativo padrão
     */
    private final double ESCALA_PADRAO = 40;

    /**
     * Constante representando a hora padrão
     */
    private final int HORA_PADRAO = 0;

    /**
     * Constante representando o minuto padrão
     */
    private final int MINUTO_PADRAO = 0;

    /**
     * Constante representando o segundo padrão
     */
    private final int SEGUNDO_PADRAO = 0;

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
    private double escala;

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
     * Hora de partida
     */
    private int horaInicial;

    /**
     * Minuto de partida
     */
    private int minutoInicial;

    /**
     * Segundo de partida
     */
    private int segundoInicial;

    /**
     * Indica quando o contador regressivo chegou à contagem máxima
     */
    private boolean fim;

    /**
     * Construtor da classe
     * 
     * Cria um contador regressivo especificando todos os atributos do mesmo.
     * Além disso, são especificados hora, minuto e segundo de partida.
     * Útil para ser usado como um relógio digital.
     * 
     * @param tela objeto onde o visor do contador regressivo será desenhado
     * @param coordenadas coordenadas centrais do visor do contador regressivo
     * @param escala escala relativa do visor do contador regressivo
     * @param corAceso cor dos segmentos acesos
     * @param corApagado cor dos segmentos apagados
     * @param horaInicial hora de partida
     * @param minutoInicial minuto de partida
     * @param segundoInicial segundo de partida
     */
    public ContadorRegressivo(Draw tela, double[] coordenadas, double escala, Color corAceso, Color corApagado, int horaInicial, int minutoInicial, int segundoInicial){
        this.tela = tela;
        this.coordenadas = coordenadas;
        this.escala = escala;
        this.corAceso = corAceso;
        this.corApagado = corApagado;
        setHoraInicial(horaInicial);
        this.horaAtual = this.horaInicial;
        setMinutoInicial(minutoInicial);
        this.minutoAtual = this.minutoInicial;
        setSegundoInicial(segundoInicial);
        this.segundoAtual = this.segundoInicial;
        this.visor = new Visor(tela, coordenadas, escala, corAceso, corApagado);
    }

    /**
     * Construtor da classe
     * 
     * Cria um contador regressivo omitindo a cor do segmento apagado especificando hora,
     * minuto e segundo de partida. Útil para usar como um relógio digital.
     * 
     * @param tela objeto onde o visor do contador regressivo será desenhado
     * @param coordenadas coordenadas centrais do visor do contador regressivo
     * @param escala escala relativa do visor do contador regressivo
     * @param corAceso cor dos segmentos acesos
     * @param horaInicial hora de partida
     * @param minutoInicial minuto de partida
     * @param segundoInicial segundo de partida
     */
    public ContadorRegressivo(Draw tela, double[] coordenadas, double escala, Color corAceso, int horaInicial, int minutoInicial, int segundoInicial){
        this.tela = tela;
        this.coordenadas = coordenadas;
        this.escala = escala;
        this.corAceso = corAceso;
        setHoraInicial(horaInicial);
        this.horaAtual = this.horaInicial;
        setMinutoInicial(minutoInicial);
        this.minutoAtual = this.minutoInicial;
        setSegundoInicial(segundoInicial);
        this.segundoAtual = this.segundoInicial;
        this.visor = new Visor(tela, coordenadas, escala, corAceso);
    }

    public boolean fim(){
        return this.fim;
    }

    /**
     * Realiza a contagem de forma progressiva, incrementando o campo
     * dos segundo de um em um.
     */
    public boolean conta(){
        if (tela == null) return false;

        this.visor.ver(horaAtual, minutoAtual, segundoAtual);

        if (horaAtual == 0 && minutoAtual == 0 && segundoAtual == 0){
            this.fim = true;
        } else if (minutoAtual == 0 && segundoAtual == 0){
            minutoAtual = 59;
            segundoAtual = 59;
            horaAtual--;
        } else if (segundoAtual == 0){
            segundoAtual = 59;
            minutoAtual--;
        } else {
            this.fim = false;
            segundoAtual--;
        }

        return ! this.fim;
    }

    /**
     * Reinicia o contador regressivo para os valores de 
     * hora, minuto e segundos iniciais
     */
    public void reinicia(){
        this.horaAtual = this.horaInicial;
        this.minutoAtual = this.minutoInicial;
        this.segundoAtual = this.segundoInicial;
    }

    /**
     * Define o objeto onde o contador regressivo será desenhado
     * @param tela objeto Draw onde o contador regressivo será desenhado
     */
    public void setTela(Draw tela) {
        this.tela = tela;
        this.visor.setTela(this.tela);
    }

    /**
     * Define as coordenadas do contador regressivo
     * @param coordenadas vetor de double com as coordenadas X e Y
     */
    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
        this.visor.setCoordenadas(this.coordenadas);
    }

    /**
     * Define a escala relativa do contador regressivo. O valor deve estar entre 20 e 100.
     * Padrão: 40.
     * @param escala double contendo a escala relativa
     */
    public void setEscala(double escala) {
        if (escala < 20 | escala > 100) this.escala = ESCALA_PADRAO;
        else this.escala = escala;
        this.visor.setEscala(this.escala);
    }

    /**
     * Define a cor dos segmentos acesos
     * @param corAceso objeto Color representando a cor dos segmentos acesos
     */
    public void setCorAceso(Color corAceso) {
        this.corAceso = corAceso;
        this.visor.setCorAceso(this.corAceso);
    }

    /**
     * Define a cor dos segmentos apagados
     * @param corAceso objeto Color representando a cor dos segmentos apagados
     */
    public void setCorApagado(Color corApagado) {
        this.corApagado = corApagado;
        this.visor.setCorApagado(this.corApagado);
    }

    /**
     * Define a hora de partida
     * @param horaInicial inteiro contendo a hora de partida
     */
    public void setHoraInicial(int horaInicial) {
        if (horaInicial < 0 | horaInicial > 99) this.horaInicial = HORA_PADRAO;
        else this.horaInicial = horaInicial;
    }

    /**
     * Define o minuto de partida
     * @param minutoInicial inteiro contendo o minuto de partida
     */
    public void setMinutoInicial(int minutoInicial) {
        if (minutoInicial < 0 | minutoInicial > 59) this.minutoInicial = MINUTO_PADRAO;
        else this.minutoInicial = minutoInicial;
    }

    /**
     * Define o segundo de partida
     * @param segundoInicial inteiro contendo o segundo de partida
     */
    public void setSegundoInicial(int segundoInicial) {
        if (segundoInicial < 0 | segundoInicial > 59) this.segundoInicial = SEGUNDO_PADRAO;
        else this.segundoInicial = segundoInicial;
    }

    /**
     * Obtém o objeto onde o contador regressivo está sendo desenhado
     * @return objeto do tipo Draw
     */
    public Draw getTela() {
        return tela;
    }

    /**
     * Obtém as coordenadas do contador regressivo
     * @return vetor double com as coordenadas X e Y
     */
    public double[] getCoordenadas() {
        return coordenadas;
    }

    /**
     * Obtém a escala relativa atual
     * @return double contendo a escala relativa atual
     */
    public double getEscala() {
        return escala;
    }

    /**
     * Obtém a cor dos segmentos acesos
     * @return objeto Color representando os segmentos acesos
     */
    public Color getCorAceso() {
        return corAceso;
    }

    /**
     * Obtém a cor dos segmentos apagados
     * @return objeto Color representando os segmentos apagados
     */
    public Color getCorApagado() {
        return corApagado;
    }

    /**
     * Obtém o valor de hora atual em processamento
     * @return inteiro representando a hora
     */
    public int getHoraAtual() {
        return horaAtual;
    }

    /**
     * Obtém o valor de minuto atual em processamento
     * @return inteiro representando o minuto
     */
    public int getMinutoAtual() {
        return minutoAtual;
    }

    /**
     * Obtém o valor de segundo atual em processamento
     * @return inteiro representando o segundo
     */
    public int getSegundoAtual() {
        return segundoAtual;
    }

    /**
     * Obtém a hora de partida
     * @return inteiro representando a hora
     */
    public int getHoraInicial() {
        return horaInicial;
    }

    /**
     * Obtém o minuto de partida
     * @return inteiro representando o minuto
     */
    public int getMinutoInicial() {
        return minutoInicial;
    }

    /**
     * Obtém o segundo de partida
     * @return inteiro representando o segundo
     */
    public int getSegundoInicial() {
        return segundoInicial;
    }
}