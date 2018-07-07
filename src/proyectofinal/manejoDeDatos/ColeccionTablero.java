/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.manejoDeDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import proyectofinal.modelo.Partida;
import proyectofinal.modelo.Punto;
import proyectofinal.modelo.Tablero;

/**
 *
 * @author jcjimenezr
 */
public class ColeccionTablero {

    /**
     * Acá leemos la partida guardada en un archivo .txt. y nos retorna una
     * partida.
     *
     * @return
     * @throws FileNotFoundException
     */
    public Partida leerPartida() throws FileNotFoundException {
        Scanner input = new Scanner(new File("juego.txt"));
        Punto[][] matriz = new Punto[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int color = input.nextInt();
                Punto punto = new Punto(color);
                matriz[i][j] = punto;
            }
        }
        int puntaje = input.nextInt();
        int movimientos = input.nextInt();
        String nombre = input.next();
        Tablero tablero = new Tablero(matriz, puntaje, movimientos, nombre);
        Partida partida = new Partida(tablero, nombre);
        return partida;
    }

    /**
     * Acá recibimos una partida para poder generar la persistencia y guardarla
     * en el un archivo .txt.
     *
     * @param tablero
     * @throws FileNotFoundException
     */
    public void escribirPartida(Tablero tablero) throws FileNotFoundException {
        PrintStream salida = new PrintStream(new File("juego.txt"));
        Punto[][] impM = tablero.getTablero();
        for (Punto[] impM1 : impM) {
            for (int j = 0; j < impM.length; j++) {
                salida.print(impM1[j].getColor() + " ");
            }
            salida.println();
        }
        salida.println(tablero.getPuntaje());
        salida.println(tablero.getMovimientos());
        salida.println(tablero.getNombre());
    }

    /**
     * En este metodo recibimos el tablero, ya que ahi es donde se van generando
     * los puntajes estos puntajes se guardarán eun un archivo .txt para ser
     * despues mostrados.
     *
     * @param puntaje
     * @throws FileNotFoundException
     */
    public void escribirPuntajes(Tablero puntaje) throws FileNotFoundException {
        PrintStream salidaP = new PrintStream(new File("puntaje.txt"));
        salidaP.println(puntaje.getPuntaje());
    }

    /**
     * Este metodo nos retorna los puntajes guardados en el archivo .txt.
     *
     * @return
     * @throws FileNotFoundException
     */
    public ArrayList<Integer> leerPuntaje() throws FileNotFoundException {
        ArrayList<Integer> puntos = new ArrayList<>();
        Scanner input = new Scanner(new File("puntaje.txt"));
        while (input.hasNextInt()) {
            int punto = input.nextInt();
            puntos.add(punto);
        }
        return puntos;
    }
}
