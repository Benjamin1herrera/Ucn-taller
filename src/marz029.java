import edu.princeton.cs.stdlib.StdDraw;

public class marz029 {

    public static void main(String[] args) {

        double min = -1.0;
        double max = 1.0;

        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        StdDraw.enableDoubleBuffering();

        for (int i = 0; i < 1000000; i++) {
            double x = min + (max-min) * Math.random();
            double y = min + (max-min) * Math.random();

            StdDraw.point(x,y);
            StdDraw.show();
        }
    }
}
