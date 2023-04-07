import edu.princeton.cs.stdlib.StdDraw;
public class pelotita {

    public static void main(String[] args) {

        double min = -1.0;
        double max = 1.0;

        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        StdDraw.enableDoubleBuffering();

        double x = min + (max-min) * Math.random();
        double y = min + (max-min) * Math.random();

        double velocidadY = 0.012;
        double velocidadx = 0.032;

        double radio = 0.05;

        while (true){
            if (Math.abs(x+velocidadx) > 1.0 - radio){
                velocidadx = -velocidadx;

            }
            if (Math.abs(y+velocidadY) > 1.0 - radio){
                velocidadY = -velocidadY;

            }

            x+=velocidadx;
            y+=velocidadY;

            StdDraw.clear();

            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.filledCircle(x,y,radio);

            StdDraw.show();
        }
    }
}