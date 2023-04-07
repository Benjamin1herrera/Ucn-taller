import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;

public class factorial {
    public static void main(String[] args) {

        int numAux = 1;
        double resultado = 0;

        StdOut.println("Ingrese numero: ");
        double numX = StdIn.readDouble();

        double termino = Math.pow(numX, numAux) / numAux;

        while (termino > 0.00001) {
            
            numAux += 2;

           termino = Math.pow(numX,numAux)/numAux;

           StdOut.println(resultado);
        }

    }
}