/*
import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;

import java.io.IOException;

public class tallerPasado {

    public static void main(String[] args) throws IOException {

        String[] vecConductores = new String[50];
        String[] vecRut = new String[50];
        int[][] km = new int[50][50];
        String[] matriculas = new String[50];

        int[] vecAux = leerArchivo(matriculas, vecConductores, vecRut, km);
        int contConductores = vecAux[0];
        int contCamiones = vecAux[1];
        int contDeViajes = vecAux[2];

        int opcion = 0;

        while (opcion != 6) {

            StdOut.println("Elija la opcion del menu que desea desplegar");
            StdOut.println("");
            StdOut.println("[1] Agregar un nuevo conductor:");
            StdOut.println("[2] Agregar un nuevo camión");
            StdOut.println("[3] Agregar un nuevo viaje");
            StdOut.println("[4] Modificar un viaje");
            StdOut.println("[5] Desplegar estadísticas");
            StdOut.println("[6] Salir");
            opcion = StdIn.readInt();

            switch (opcion) {
                case 1:
                    contConductores = agregarNuevoConductor(vecConductores, contConductores, vecRut);

                    StdOut.println("");

                    break;

                case 2:
                    contCamiones = agregarNuevoCamion(matriculas, contCamiones);

                    StdOut.println("");

                    break;

                case 3:
                    contDeViajes = agregarNuevoViaje(vecRut, matriculas, km, contCamiones, contConductores, contDeViajes);

                    StdOut.println("");

                    break;
                case 4:
                    modificarViaje(vecRut, matriculas, km, contCamiones, contConductores, contDeViajes);

                    StdOut.println("");

                    break;
                case 5:
                    desplegarEstadisticas(vecConductores, vecRut, contConductores, contCamiones, matriculas, km, contDeViajes);

                    StdOut.println("");


                    break;

                case 6:
                    actualizarTxt(vecConductores, vecRut, contConductores, contCamiones, matriculas, km);
                    StdOut.println("gracias por preferirnos, vuelva pronto");
                    StdOut.println("");


                    break;

                default:
                    StdOut.println("la opcion elegida no es correcta");


                    for (int i = 0; i < contConductores; i++) {

                        StdOut.println(vecConductores[i] + " / " + vecRut[i]);

                    }
                    for (int j = 0; j < contCamiones; j++) {

                        StdOut.println(matriculas[j]);

                    }

                    for (int k = 0; k < contConductores; k++) {
                        for (int l = 0; l < contCamiones; l++) {

                            StdOut.print(km[k][l]);
                            StdOut.print(" ");
                        }
                        StdOut.println(" ");
                    }
                    StdOut.println("");


                    break;
            }
        }
    }


    private static int[] leerArchivo(String[] matriculas, String[] vecConductores, String[] vecRut, int[][] km) throws IOException {

        int[] vectAux = new int[3];
        int contConductores = 0;
        int contCamiones = 0;
        int contDeViajes = 0;

        ArchivoEntrada arch1 = new ArchivoEntrada("AntofagastaTrucks.txt");

        while (!arch1.isEndFile()) {

            Registro linea = arch1.getRegistro();
            String nombreConductor = linea.getString();
            String rutConductor = linea.getString();
            String matriculaConducida = linea.getString();
            int kmConducido = linea.getint();

            int fila = 0;
            int i = 0;
            for (i = 0; i < contConductores; i++) {
                if (nombreConductor.equals(vecConductores[i])) {
                    fila = i;
                    break;
                }
            }
            if (i == contConductores) {
                vecConductores[contConductores] = nombreConductor;
                vecRut[contConductores] = rutConductor;
                fila = contConductores;
                contConductores++;
            }


            int columna = 0;
            int j = 0;
            for (j = 0; j < contCamiones; j++) {
                if (matriculaConducida.equals(matriculas[j])) {
                    columna = j;
                    break;
                }
            }
            if (j == contCamiones) {
                matriculas[contCamiones] = matriculaConducida;
                columna = contCamiones;
                contCamiones++;
            }

            km[fila][columna] += kmConducido;
            contDeViajes++;


        }

        vectAux[2] = contDeViajes;
        vectAux[1] = contCamiones;
        vectAux[0] = contConductores;
        return vectAux;

    }

    private static int agregarNuevoConductor(String[] vecConductores, int contConductores, String[] vecRut) {

        StdOut.println("Ingrese el nombre del nuevo conductor: ");
        String nombreConductor = StdIn.readString();

        StdOut.println("Ingrese rut del nuevo conductor: ");
        String rutConductor = StdIn.readString();

        if (contConductores == 50) {

            StdOut.println("ya no hay espacio para otro conductor");
        } else {

            vecConductores[contConductores] = nombreConductor;
            vecRut[contConductores] = rutConductor;
            contConductores++;
            StdOut.println("agregaste nuevo conductor");

        }

        return contConductores;
    }

    private static int agregarNuevoCamion(String[] matriculas, int contCamiones) {

        StdOut.println("Ingrese matricula del nuevo camion: ");
        String matriculaIngresada = StdIn.readString();


        int j = 0;

        if (contCamiones == 50) {

            StdOut.println("no hay espacio para otro camion");

        } else {

            for (j = 0; j < contCamiones; j++) {
                if (matriculaIngresada.equalsIgnoreCase(matriculas[j])) {
                    StdOut.println("matricula ingresada ya existe volviendo al menu");
                    break;
                }
            }
            if (j == contCamiones) {

                matriculas[contCamiones] = matriculaIngresada;
                contCamiones++;
                StdOut.println("agregaste nuevo camion");
            }
        }
        return contCamiones;
    }


    private static int agregarNuevoViaje(String[] vecRut, String[] matriculas, int[][] km, int contCamiones, int contConductores, int contDeViajes) {

        StdOut.println("Ingrese rut del conductor: ");
        String rutConductor = StdIn.readString();

        int fila = 0;
        int columna = 0;
        int i = 0;
        int j = 0;
        int x = 0;
        int y = 0;

        for (i = 0; i < contConductores; i++) {
            if (rutConductor.equalsIgnoreCase(vecRut[i])) {
                fila = i;
                StdOut.println("rut encontrado");

                StdOut.println("Ingrese matricula del camion: ");
                String matriculaIngresada = StdIn.readString();

                for (j = 0; j < contConductores; j++) {
                    if (matriculaIngresada.equalsIgnoreCase(matriculas[j])) {
                        columna = j;
                        StdOut.println("matricula Encontrada");

                        StdOut.println("ingrese los km recorridos: ");
                        int kmRecorridos = StdIn.readInt();

                        km[fila][columna] += kmRecorridos;
                        StdOut.println("agregaste nuevo viaje");
                        contDeViajes++;

                        break;
                    } else {
                        y++;
                    }
                }

            } else {
                x++;
            }
        }
        if (x == contConductores) {
            StdOut.println("rut no encontrado, volviendo al menu...");

        }
        if (y == contCamiones) {
            StdOut.println("matricula no encontrado, volviendo al menu...");
        }
        return contDeViajes;
    }

    private static void modificarViaje(String[] vecRut, String[] matriculas, int[][] km, int contCamiones, int contConductores, int contDeViajes) {

        StdOut.println("Ingrese rut del conductor: ");
        String rutConductor = StdIn.readString();

        int fila = 0;
        int columna = 0;
        int i = 0;
        int j = 0;
        int x = 0;
        int y = 0;

        for (i = 0; i < contConductores; i++) {
            if (rutConductor.equalsIgnoreCase(vecRut[i])) {
                fila = i;
                StdOut.println("rut encontrado");

                StdOut.println("Ingrese matricula del camion: ");
                String matriculaIngresada = StdIn.readString();

                for (j = 0; j < contConductores; j++) {
                    if (matriculaIngresada.equalsIgnoreCase(matriculas[j])) {
                        columna = j;
                        StdOut.println("matricula Encontrada");

                        StdOut.println("ingrese los km recorridos: ");
                        int kmRecorridos = StdIn.readInt();

                        if (kmRecorridos == 0) {
                            contDeViajes--;
                        }

                        km[fila][columna] = kmRecorridos;
                        StdOut.println("modificaste un viaje");

                        break;
                    } else {
                        y++;
                    }
                }
            } else {
                x++;
            }
        }
        if (x == contConductores) {
            StdOut.println("rut no encontrado, volviendo al menu...");

        }
        if (y == contCamiones) {
            StdOut.println("matricula no encontrado, volviendo al menu...");
        }


    }

    private static void desplegarEstadisticas(String[] vecConductores, String[] vecRut, int contConductores, int contCamiones, String[] matriculas, int[][] km, int contDeViajes) {

        //Estadistica 1
        desplegarCamionMayorCantKm(contCamiones, matriculas, km);

        //Estadistica 2
        desplegarConductorMayorCantKm(vecConductores, contCamiones, km);

        //Estadistica 3
        calcularPromedioKm(km, contDeViajes);

        //Estadistica 4
        calcularBonoProductividad(contConductores, contCamiones, km);

        //Estadistica 5
        ordenarConductorMayorMenorSueldo(vecConductores, vecRut, contConductores, contCamiones, matriculas, km);


    }

    private static void desplegarCamionMayorCantKm(int contCamiones, String[] matriculas, int[][] km) {

        int mayorCamionkm = 0;
        int mayorPos = 0;

        for (int i = 0; i < contCamiones; i++) {
            for (int j = 0; j < contCamiones; j++) {
                if (km[i][j] > mayorCamionkm) {
                    mayorCamionkm = km[i][j];
                    mayorPos = j;
                }
            }
        }
        StdOut.println("La matricula del camion con mayor Km recorrido fue: " + matriculas[mayorPos]);
    }

    private static void desplegarConductorMayorCantKm(String[] vecConductores, int contConductores, int[][] km) {

        int mayorConductorKm = 0;
        int mayorPos = 0;

        for (int i = 0; i < contConductores; i++) {
            for (int j = 0; j < contConductores; j++) {
                if (km[i][j] > mayorConductorKm) {
                    mayorConductorKm = km[i][j];
                    mayorPos = j;
                }
            }
        }
        StdOut.println("El conductor con mayor km recorrido fue: " + vecConductores[mayorPos]);

    }

    private static void calcularPromedioKm(int[][] km, int contDeViajes) {

        int sumatotal = 0;

        for (int i = 0; i < contDeViajes; i++) {
            for (int j = 0; j < contDeViajes; j++) {
                sumatotal += km[i][j];
            }
        }
        desplegarPromedioKm(sumatotal, contDeViajes);
    }

    private static void desplegarPromedioKm(int sumatotal, int contDeViajes) {

        StdOut.println("El promedio de viajes fue: " + sumatotal / contDeViajes + " km");
    }

    private static void calcularBonoProductividad(int contConductores, int contCamiones, int[][] km) {

        int contBono = 0;

        for (int i = 0; i < contConductores; i++) {
            for (int j = 0; j < contCamiones; j++) {

                if (km[i][j] >= 250) {

                    contBono++;
                }
            }
        }
        desplegarCantConductoresConBono(contBono);
    }

    private static void desplegarCantConductoresConBono(int contBono) {

        StdOut.println("La cantidad de trabajadores que recibieron su bono de productividad fue: " + contBono);

    }

    private static void ordenarConductorMayorMenorSueldo(String[] vecConductores, String[] vecRut, int contConductores, int contCamiones, String[] matriculas, int[][] km) {

    }

    private static void actualizarTxt(String[] vecConductores, String[] vecRut, int contConductores, int contCamiones, String[] matriculas, int[][] km) throws IOException {

        ArchivoSalida arch2 = new ArchivoSalida("AntofagastaTrucks.txt");

        for (int i = 0; i < contConductores; i++) {
            for (int j = 0; j < contCamiones; j++) {

                if (km[i][j] > 0) {
                    Registro archsal = new Registro(4);
                    archsal.agregarCampo(vecConductores[i]);
                    archsal.agregarCampo(vecRut[i]);
                    archsal.agregarCampo(matriculas[j]);
                    archsal.agregarCampo(km[i][j]);
                    arch2.writeRegistro(archsal);
                }
            }
        }
    }
}
*/