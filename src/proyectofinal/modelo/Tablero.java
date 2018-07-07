/*
 * @author Camilo Windows
 */
package proyectofinal.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import proyectofinal.manejoDeDatos.ColeccionTablero;

public class Tablero {

 //   private ArrayList<Punto> alineacion = new ArrayList<>();
    private int puntaje;
    private int movimientos;
    private Punto[][] tablero;
    private String nombre;
    private List<Coordenada> coordenadas = new ArrayList<Coordenada>();

    public void setCoordenada(ArrayList<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Tablero(Punto[][] tablero, String nombre) {
        this.nombre = nombre;
        this.tablero = tablero;
        this.puntaje = 0;
        this.movimientos = 30;
    }

    public Tablero(Punto[][] tablero, int puntaje, int movimientos, String nombre) {
        this.movimientos = movimientos;
        this.puntaje = puntaje;
        this.tablero = tablero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    /*
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
     */
    public int getMovimientos() {
        return movimientos;
    }

    /*
    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }
     */
    public Punto[][] getTablero() {
        return tablero;
    }

    public void setTablero(Punto[][] tablero) {
        this.tablero = tablero;
    }

    /**
     * Acá se verifica el color, si el color anterior de el AL es igual a la
     * nueva
     *
     * @return
     */
    public boolean verificarColor() {
        for (int i = 0; i < coordenadas.size(); i++) {
            if (!coordenadas.isEmpty()) {
                if ((tablero[coordenadas.get(0).getX()][coordenadas.get(0).getY()].getColor()
                        != tablero[coordenadas.get(i).getX()][coordenadas.get(i).getY()].getColor())) {
                    System.out.println("No son del mismo color");
                    return false;
                 
                }
            }
        }
        return true;
    }

    //Para ser usado en la parte grafica
    /**
     * Acá se hacen las jugadas en la parte grafica mediante las coordenadas
     * ingresadaas por el usuario
     *
     * @param coords
     * @throws FileNotFoundException
     */
    public void jugada(ArrayList<Coordenada> coords) throws FileNotFoundException {
        boolean valida = false;
        while (!valida) {
            imprimirTablero();
            System.out.println("Puntaje: " + puntaje);
            System.out.println("Movimientos: " + movimientos);
            for (int i = 0; i < coords.size(); i++) {
                System.out.println(coords.get(i).getX() + " " + coords.get(i).getY());
            }
            recibirPos(coords);
            if (verificarAlineacion() && verificarColor()) {
                int puntosSumar = coordenadas.size();
                int cuadrado = verificarCuadrado();
                if (cuadrado != 0) {
                    puntosSumar = explotarCuadrado(cuadrado) * 2;
                    llenarEspacio();
                }
                
                eliminarAlineacion();
                sumarPuntaje(puntosSumar);
                restarMovimiento();
                coordenadas.clear();
                valida = true;
            }
            coordenadas.clear();
            imprimirTablero();
            System.out.println("-------------------------------");
        }
    }

    //Para ser jugado por consola
    public void jugada() throws FileNotFoundException {
        boolean valida = false;
        while (!valida) {
            imprimirTablero();
            System.out.println("Puntaje: " + puntaje);
            System.out.println("Movimientos: " + movimientos);

            recibirPos();
            if (verificarAlineacion() && verificarColor()) {
                int puntosSumar = coordenadas.size();
                int cuadrado = verificarCuadrado();
                System.out.println(cuadrado);
                if (cuadrado != 0) {
                    puntosSumar = explotarCuadrado(cuadrado) * 2;
                    llenarEspacio();
                }
                eliminarAlineacion();
                sumarPuntaje(puntosSumar);
                restarMovimiento();
                coordenadas.clear();
                valida = true;
            }
            coordenadas.clear();
        }
    }

    /**
     * Acá el usuario guarda la partida, puntajes, movimientos, movimientos y
     * posicion de las fichas
     *
     * @throws FileNotFoundException
     */
    public void guardarPartida() throws
            FileNotFoundException {
        ColeccionTablero coleccion = new ColeccionTablero();
        coleccion.escribirPartida(this);
    }

    //Para ser usado en la parte grafica
    /**
     * Acá se reciben las coordenadas que ha ingresado el usuario mediante el
     * click
     *
     * @param coords
     * @throws FileNotFoundException
     */
    public void recibirPos(ArrayList<Coordenada> coords) throws FileNotFoundException {
        coordenadas = coords;
    }

    //Por Consola
    public void recibirPos() throws FileNotFoundException {
        Scanner entrada = new Scanner(System.in);
        int veces = 0;
        int contador = 1;
        
        System.out.println("Ingrese cantidad de coordenadas === Si desea salir precione 9 === Si desea guardar presione 8");
        System.out.print("--->");
        int in = entrada.nextInt();
        switch (in) {
            case 8:
                guardarPartida();
                System.out.println("Partida Guardada, puede continuar ingresando la cantidad de coordenadas.");
                break;
            case 9:
                System.exit(0);
            default:
                veces = in;
                break;
        }
        System.out.println("veces" + veces);
        for (int i = 0; i < veces; i++) {
            System.out.println("Posicion en X " + contador);
            System.out.print("--->");
            int x = entrada.nextInt();
            System.out.println("Posicion en Y " + contador);
            System.out.print("--->");
            int y = entrada.nextInt();
            System.out.println();
            Coordenada c = new Coordenada(x, y);
            coordenadas.add(c);
            contador++;
            
        }
    }

    /**
     * Verificar horizonal y vetical. Coordenadas ingresadas.
     *
     * @return
     */
    public boolean verificarAlineacion() {
        for (int i = 0; i < coordenadas.size() - 1; i++) {
            int x1 = coordenadas.get(i).getX();
            int y1 = coordenadas.get(i).getY();

            if (coordenadas.isEmpty()) {
                System.out.println("No se ingresaron coordenadas.");
                return false;
            } else if (Math.abs(x1 - y1) == Math.abs(coordenadas.get(i + 1).getX() - coordenadas.get(i + 1).getY())) {
                System.out.println("Coordenadas invalidas.");
                return false;
            } else if (x1 + y1 == coordenadas.get(i + 1).getX() + coordenadas.get(i + 1).getY()) {
                System.out.println("Coordenadas invalidas.");
                return false;
            }
        }
        return true;
    }

    /**
     * Acá se suma el puntaje
     *
     * @param puntos
     */
    public void sumarPuntaje(int puntos) {
        this.puntaje += puntos * 10;
    }

    /**
     * Restamos movmientos
     */
    public void restarMovimiento() {
        this.movimientos--;
    }

    /**
     * Acá las coordenadas que usuari seleccionó les asinga cero.
     */
    public void eliminarAlineacion() { // asinga 0 en las coordenadas
        Punto n = new Punto();
        for (int i = 0; i < coordenadas.size(); i++) {
            tablero[coordenadas.get(i).getX()][coordenadas.get(i).getY()] = n;
        }
        
        llenarEspacio();
    }

    /**
     * Imprmirmos un tablero con el espacio bien lindo para que no se vea feito
     * Seee con el for each poderoso, eso la verdad me lo recomendó net. estaba
     * con for normal.
     */
    public void imprimirTablero() {
        for (Punto[] tablero1 : tablero) {
            for (Punto tablero11 : tablero1) {
                System.out.print(tablero11.getColor() + " ");
            }
            System.out.println();
        }
    }

    /**
     * acá subimos los ceros arriba, asingamos a una nueva matriz donde no es
     * cero, donde es 0 asinga el nuevo valor
     *
     */
    public void llenarEspacio() {
        System.out.println("------");
        imprimirTablero();
        System.out.println("LLENAR");
        Punto[][] nuevoTablero = generarVacia();
        int col = tablero.length - 1; //5
        while (col >= 0) {
            int nI = tablero.length - 1; // se vuelve a asingar
            for (int i = tablero.length - 1; i >= 0; i--) {
                if (tablero[i][col].getColor() != 0) { // si la posicion es != de 0 se aginira al tablero nuevo
                    nuevoTablero[nI][col] = tablero[i][col];
                    nI--;
                } else {
                    nI = i;
                    int cont = 0;
                    while (tablero[i][col].getColor() == 0 && i != 0) {
                        cont++; // si hay ceros que los cuente antes de salir de la I
                        i--;
                    }
                    while (cont != 0 && i != 0) {
                        nuevoTablero[nI][col] = tablero[i][col];
                        cont--; // al tener la cantidad de 0 comenzar a bajar los nums sig
                        nI--;
                        if (cont != 0) {
                            i--;
                        }
                    }
                }

            }
            col--;
        }
        this.tablero = nuevoTablero;// le asingo al tablero el nuevo tablero
        System.out.println("------2");
        imprimirTablero();
        System.out.println("LLENAR2");
        for (Punto[] tablero1 : tablero) {
            for (Punto tablero11 : tablero1) {
                if (tablero11.getColor() == 0) {
                    tablero11.generarAleatorio();
                }
            }
        }
    }

    // generar vacia para poder comenzar a pasar los que no son 0 despues
    /**
     * matriz vacia
     *
     * @return
     */
    public Punto[][] generarVacia() {
        Punto[][] mat = new Punto[6][6];
        for (Punto[] mat1 : mat) {
            for (int j = 0; j < mat1.length; j++) {
                Punto punto = new Punto();
                punto.setColor(0);
                mat1[j] = punto;
            }
        }
        return mat;
    }

    //buen nombre, eh?
    public int explotarCuadrado(int color) {
        int cont = 0;
        for (Punto[] tablero1 : tablero) {
            for (Punto tablero11 : tablero1) {
                if (tablero11.getColor() == color) {
                    cont++;
                    tablero11.setColor(0);
                }
            }
        }
        return cont;
    }

    /**
     * Verifiamos en si en el AL hay una coordenada valida repetida lo cual
     * signica que se ha generado un cuadrado
     *
     * @return
     */
    public int verificarCuadrado() {
        Coordenada temp = new Coordenada(0, 0);
        for (int i = 0; i < coordenadas.size(); i++) {
            List<Coordenada> copia = new ArrayList<Coordenada>(coordenadas);
            temp = copia.get(i);
            copia.remove(i);
            for (int j = 0; j < copia.size(); j++) {
                if (temp.getX() == copia.get(j).getX() && temp.getY() == copia.get(j).getY()) {
                    return tablero[temp.getX()][temp.getY()].getColor();
                }
            }
        }
        return 0;
    }

}
