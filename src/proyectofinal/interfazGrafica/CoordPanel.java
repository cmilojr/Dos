/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import proyectofinal.modelo.Coordenada;

/**
 *
 * @author jcjimenezr
 */
public class CoordPanel extends JPanel {

    private int x;
    private int y;

    /**
     * Generamos coordenadas para JPanel
     *
     * @return
     */
    public Coordenada generarCoordenada() {
        return new Coordenada(x, y);
    }

    /**
     * Setteamos las coordenadas
     *
     * @param x
     * @param y
     */
    public void setCoordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Pos si, getters y setters de coordenadas x & y
     *
     * @return
     */
    public int getXc() {
        return x;
    }

    public int getYc() {
        return y;
    }

    /**
     * Acá se pueden imprimir las coordenadas donde el usuario dió click
     *
     * public void imprimirCoordenadas(){ System.out.println(x);
     * System.out.println(y); }
     *
     */
    /**
     * Constructor que no se usó
     */
    public CoordPanel() {

    }

    /**
     * Cuadricula
     *
     * @param gridlayout
     */
    public CoordPanel(GridLayout gridlayout) {
        super(gridlayout);
    }

    /**
     * Los bordes de la cuadricula
     *
     * @param borderlayout
     */
    public CoordPanel(BorderLayout borderlayout) {
        super(borderlayout);
    }
}
