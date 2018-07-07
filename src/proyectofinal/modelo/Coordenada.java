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
public class Coordenada {

    private int x;
    private int y;

    /**
     * Objeto coordenadas para que el usuario ingrese
     *
     * @param x
     * @param y
     */
    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
