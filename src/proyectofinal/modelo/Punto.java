/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.modelo;

/**
 *
 * @author Camilo Windows
 */
public class Punto {

    private int color;

    /**
     * Objeto color, consiste en que genera numeros ramdom del 1 al 5.
     */
    /**
     * El punto 0 en el tablero es un vacio
     */
    public Punto() {
        this.color = 0;
    }

    public Punto(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    /**
     * Acá se generan los aleatorios
     */
    public void generarAleatorio() {
        int aleatorio;
        aleatorio = 0 + (int) (Math.random() * (5 - 0) + 1);
        setColor(aleatorio);
    }
}
