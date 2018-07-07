/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.modelo;

import java.io.FileNotFoundException;
import proyectofinal.manejoDeDatos.ColeccionTablero;

/**
 *
 * @author Camilo Windows
 */
public class Partida {

    private Tablero tablero;
    private String nombre;

    public Partida(String nombre) {
        generarTablero();
        this.nombre = nombre;
    }

    /**
     * Acá se puede obtener el nombre del jugador
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Contructor de una partida la cual esta conformada de un tablero y nombre
     * del jugador
     *
     * @param tablero
     * @param nombre
     */
    public Partida(Tablero tablero, String nombre) {
        this.tablero = tablero;
        this.nombre = nombre;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    /**
     * Acá el usuario podrá jugar hasta que los movimientos sean cero.
     *
     * @throws FileNotFoundException
     */
    public void jugar() throws FileNotFoundException {
        while (tablero.getMovimientos() > 0) {
            this.tablero.jugada();
        }
        ColeccionTablero coleccion = new ColeccionTablero();
        coleccion.escribirPuntajes(tablero);
    }

    /**
     * Acá se genera un tablero de 6x6.
     */
    public void generarTablero() {
        Punto[][] mat = new Punto[6][6];
        for (Punto[] mat1 : mat) {
            for (int j = 0; j < mat1.length; j++) {
                Punto punto = new Punto();
                punto.generarAleatorio();
                mat1[j] = punto;
            }
        }
        //Cuadrado Generado
        /* 
        mat[0][0].setColor(1);
        mat[1][0].setColor(1);
        mat[0][1].setColor(1);
        mat[1][1].setColor(1);
         */
        Tablero tablero = new Tablero(mat, nombre);
        setTablero(tablero);

    }

}
