import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

public class lineas {

    public static void main(String[] args) {

        double min = -1.0;
        double max = 1.0;

        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        StdDraw.enableDoubleBuffering();

        Color[] colores = {Color.RED,Color.yellow,Color.GREEN,Color.cyan,Color.BLUE,};

        while (true){

            double x0 = min + (max-min) * Math.random();
            double y0 = min + (max-min) * Math.random();

            double x1 = min + (max-min) * Math.random();
            double y1 = min + (max-min) * Math.random();

            int random = (int) (Math.random() * colores.length);

            Color color = colores[random];
            StdDraw.setPenColor(color);

            StdDraw.line(x0,y0,x1,y1);
            StdDraw.show();
            StdDraw.pause(100);
        }
    }
}

