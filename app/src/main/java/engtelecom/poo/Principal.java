package engtelecom.poo;

import java.awt.Color;
import java.time.LocalTime;

import edu.princeton.cs.algs4.Draw;

public class Principal {
    public static void main(String[] args) {
        Draw d = new Draw();
        // dimensão da área de tela (canvas)
        d.setXscale(0, 800);
        d.setYscale(0, 800);
        d.enableDoubleBuffering();

        d.clear(d.BLACK);

        int hora = LocalTime.now().getHour();
        int minuto = LocalTime.now().getMinute();
        int segundo = LocalTime.now().getSecond();
        Cronometro cro = new Cronometro(d, new double[]{400,200}, 100, d.PINK, hora, minuto, segundo);

        // while (true){
        //     d.clear(d.BLACK);
        //     cro.contar();
        //     d.show();
        //     try {
        //         Thread.sleep(1000);
        //     } catch (InterruptedException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
        // }

        ContadorRegressivo cr = new ContadorRegressivo(d, new double[]{400,600}, 100, d.PINK, 99,59,59);

        while (true){
            d.clear(d.BLACK);
            cro.contar();
            cr.contar();
            d.show();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // Display7Segmentos s = new Display7Segmentos(d, new double[]{400,400}, Color.RED, Color.BLACK,100);
        // s.desenhar(8);


        // Animação para testar o posicionamento do display
        // int i = 1;
        // while(true) {
        //     d.clear();
        //     s.desenhar(8);
        //     s.setCoordenadas(new int[]{(i*10)%800,(i*10)%800});
        //     try {
        //         Thread.sleep(20);
        //     } catch (InterruptedException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
        //     i++;
        // }


        // int i = 0;
        // while (true) {
        //     d.clear(Color.LIGHT_GRAY);
        //     // s.desenhar(i%11);
        //     cr.mostrar(i%11);
                // d.show();
        //     try {
        //         Thread.sleep(1000);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        //     i++;
        // }
    }
}
