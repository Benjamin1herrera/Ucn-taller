import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;


public class taller1 {
    public static void main(String[] args) {

        //rango de dibujo
        double min = -1.0;
        double max = 1.0;

        //rango del lienzo
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        //evita parpadeo en el lienzo
        StdDraw.enableDoubleBuffering();

        //variable de velocidad aleatoria
        double velocidad = min + (max - min) * Math.random();

        //vector de colores
        Color[] colores = {Color.RED, Color.yellow, Color.GREEN, Color.cyan, Color.BLUE,};


        double x0 = min + (max - min) * Math.random();
        double y0 = min + (max - min) * Math.random();

        double x1 = min + (max - min) * Math.random();
        double y1 = min + (max - min) * Math.random();

        double velocidadY0 = velocidad/10;
        double velocidadx0 = velocidad/20;

        double velocidadY1 = velocidad/30;
        double velocidadx1 = velocidad/40;

        //ciclo de dibujo de lineas
        while (true) {

            StdDraw.clear(Color.black);

            for (int i = 0; i < 6; i++) {


                if (Math.abs(x0 + velocidadx0) > 1.0) {
                    velocidadx0 = -velocidadx0;

                }
                if (Math.abs(y0 + velocidadY0) > 1.0) {
                    velocidadY0 = -velocidadY0;

                }
                if (Math.abs(x1 + velocidadx1) > 1.0) {
                    velocidadx1 = -velocidadx1;

                }
                if (Math.abs(y1 + velocidadY1) > 1.0) {
                    velocidadY1 = -velocidadY1;

                }

                x0 += velocidadx0;
                y0 += velocidadY0;
                x1 += velocidadx1;
                y1 += velocidadY1;


                int random = (int) (Math.random() * colores.length);
                Color color = colores[random];
                StdDraw.setPenColor(color);


                StdDraw.line(x0, y0, x1, y1);

                StdDraw.show();


            }

            StdDraw.clear(Color.black);
            StdDraw.pause(20);


        }

    }

}

