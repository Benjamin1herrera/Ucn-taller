import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;

public class facturas {

    public static void main(String[] args) {

        int numFactMayor = 0;
        int mayorKg = 0;
        int numFactMenor = 0; //Corresponde al numero de la factura que tiene menos kg
        int menorKg = 999;
        int montoTotalVenta = 0;
        int contkilos = 0;
        int contFrascosVendidos = 0;
        int montoTotal = 0;
        int contKilosTotal = 0;
        int numFactura = 0;
        int opcion = 0;

        while (opcion != 4) {



            StdOut.println("Ingrese el tipo de frasco que va a comprar: ");

            StdOut.println("[1] Frasco de 3 Kg");
            StdOut.println("[2] Frasco de 5 Kg");
            StdOut.println("[3] Frasco de 9 Kg");
            StdOut.println("[4] Fin de Datos");
            opcion = StdIn.readInt();

            switch (opcion) {
                case 1 -> {

                    // leer cantidad de frascos y n° factura
                    StdOut.println("Cuantos frascos de 3kg se vendieron: ");
                    contFrascosVendidos = StdIn.readInt();
                    numFactura++;

                    //calcular total de kilos vendidos y monto monto de la factura

                    contkilos = contFrascosVendidos * 3;
                    montoTotalVenta = contkilos * 1800;


                    // leer a
                    StdOut.println("Su numero de factura es " + numFactura);
                    StdOut.println("Cantidad de frascos vendidos: [" + contFrascosVendidos + "]");
                    StdOut.println("Total de kilos vendidos: " + contkilos + "kg");
                    StdOut.println("El monto total es de " + montoTotalVenta + "$");
                    StdOut.println("------------------------");

                    // acumular kilos vendidos en el dia
                    contKilosTotal += contkilos;

                    // acumular venta del dia
                    montoTotal += montoTotalVenta;

                    //obtener la mayor cantidad de kilos vendidos
                    if (contkilos > mayorKg) {
                        mayorKg = contkilos;
                        numFactMayor = numFactura;
                    }

                    //obtener la menor cantidad de kilos vendidos
                    if (contkilos < menorKg) {
                        menorKg = contkilos;
                        numFactMenor = numFactura;
                    }
                }
                case 2 -> {

                    // leer cantidad de frascos y n° factura
                    StdOut.println("Cuantos frascos de 5kg se vendieron: ");
                    contFrascosVendidos = StdIn.readInt();
                    numFactura++;

                    //calcular total de kilos vendidos y monto monto de la factura

                    contkilos = contFrascosVendidos * 5;
                    montoTotalVenta = contkilos * 1500;


                    // leer a
                    StdOut.println("Su numero de factura es " + numFactura);
                    StdOut.println("Cantidad de frascos vendidos: [" + contFrascosVendidos + "]");
                    StdOut.println("Total de kilos vendidos: " + contkilos + "kg");
                    StdOut.println("El monto total es de " + montoTotalVenta + "$");
                    StdOut.println("------------------------");

                    // acumular kilos vendidos en el dia
                    contKilosTotal += contkilos;

                    // acumular venta del dia
                    montoTotal += montoTotalVenta;

                    //obtener la mayor cantidad de kilos vendidos
                    if (contkilos > mayorKg) {
                        mayorKg = contkilos;
                        numFactMayor = numFactura;
                    }

                    //obtener la menor cantidad de kilos vendidos
                    if (contkilos < menorKg) {
                        menorKg = contkilos;
                        numFactMenor = numFactura;
                    }
                }
                case 3 -> {

                    // leer cantidad de frascos y n° factura
                    StdOut.println("Cuantos frascos de 9kg se vendieron: ");
                    contFrascosVendidos = StdIn.readInt();
                    numFactura++;

                    //calcular total de kilos vendidos y monto monto de la factura

                    contkilos = contFrascosVendidos * 9;
                    montoTotalVenta = contkilos * 1200;


                    // leer a
                    StdOut.println("Su numero de factura es " + numFactura);
                    StdOut.println("Cantidad de frascos vendidos: [" + contFrascosVendidos + "]");
                    StdOut.println("Total de kilos vendidos: " + contkilos + "kg");
                    StdOut.println("El monto total es de " + montoTotalVenta + "$");
                    StdOut.println("------------------------");

                    // acumular kilos vendidos en el dia
                    contKilosTotal += contkilos;

                    // acumular venta del dia
                    montoTotal += montoTotalVenta;

                    //obtener la mayor cantidad de kilos vendidos
                    if (contkilos > mayorKg) {
                        mayorKg = contkilos;
                        numFactMayor = numFactura;
                    }

                    //obtener la menor cantidad de kilos vendidos
                    if (contkilos < menorKg) {
                        menorKg = contkilos;
                        numFactMenor = numFactura;
                    }
                }
                case 4 -> {

                    // Cantidad total de Kg vendidos en el día

                    StdOut.println("La cantidad de kg vendidos en el dia fue: " + contKilosTotal);
                    StdOut.println("");

                    // Monto total de ingresos diarios

                    StdOut.println("El monto total de ingresos en el dia fue: " + montoTotal);
                    StdOut.println("");

                    // ¿Cuál fue la cantidad mayor de Kg vendidos y a que número de factura pertenece

                    StdOut.println("La mayor cantidad de kilos vendidos fue: " + mayorKg + "kg");
                    StdOut.println("y le pertenece a la factura n°: " + numFactMayor);
                    StdOut.println("");

                    // Cuál fue la cantidad menor de Kg vendidos y a qué número de factura pertenece

                    StdOut.println("La menor cantidad de kilos vendidos fue: " + menorKg + "kg");
                    StdOut.println("y le pertenece a la factura n°: " + numFactMenor);
                    StdOut.println("");
                }
            }

        }

    }
}

