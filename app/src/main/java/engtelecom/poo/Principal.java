package engtelecom.poo;

import java.time.LocalTime;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Principal {
    public static void main(String[] args) {
        Draw d = new Draw();
        // dimensão da área de tela (canvas)
        d.setXscale(0, 800);
        d.setYscale(0, 800);
        d.enableDoubleBuffering();

        d.clear(Color.BLACK);

        int hora = LocalTime.now().getHour();
        int minuto = LocalTime.now().getMinute();
        int segundo = LocalTime.now().getSecond();
        Cronometro cro = new Cronometro(d, new double[]{400,200}, 100, Color.GREEN, hora, minuto, segundo);

        ContadorRegressivo cr = new ContadorRegressivo(d, new double[]{400,600}, 100, d.PINK, 1,30,00);

        while (! cro.fim()){
            cro.conta();
            cr.conta();
            d.show();
            d.clear(Color.BLACK);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}