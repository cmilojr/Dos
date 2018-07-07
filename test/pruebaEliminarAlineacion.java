/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectofinal.modelo.Coordenada;
import proyectofinal.modelo.Punto;
import proyectofinal.modelo.Tablero;

/**
 *
 * @author jcjimenezr
 */
public class pruebaEliminarAlineacion {
            private Punto vacio = new Punto(0);
            private Punto amarillo = new Punto(1);
        private Punto verde = new Punto(2);
        private Punto azul = new Punto(3);
        private Punto rojo = new Punto(4);
        private Punto morado = new Punto(5);
        private Punto [][] mat = new Punto [][]{{amarillo,amarillo,amarillo,amarillo,amarillo,amarillo},
                                        {verde,verde,verde,verde,verde,verde},
                                        {morado,morado,morado,morado,morado,morado},
                                        {rojo,rojo,rojo,rojo,rojo,rojo},
                                        {azul,azul,azul,azul,azul,azul},
                                        {amarillo,amarillo,amarillo,amarillo,amarillo,amarillo}};
        private Tablero tablero = new Tablero(mat,"");
        
        private ArrayList<Coordenada> coordenada = new ArrayList<Coordenada>();

    @Test
    public void testVerificarAlineacion() {
        Coordenada coord1 = new Coordenada(5,0);
        Coordenada coord2 = new Coordenada(4,0);
        Coordenada coord3 = new Coordenada(4,1);
        Coordenada coord4 = new Coordenada(3,1);
        Coordenada coord5 = new Coordenada(3,2);
        Coordenada coord6 = new Coordenada(2,2);
        Coordenada coord7 = new Coordenada(1,2);
        Coordenada coord8 = new Coordenada(1,3);
        Coordenada coord9 = new Coordenada(1,4);
        Coordenada coord10 = new Coordenada(1,5);
                Punto [][] mat1 = new Punto [][]{{amarillo,amarillo,amarillo,amarillo,amarillo,amarillo},
                                            {verde,verde,vacio,vacio,vacio,vacio},
                                            {morado,morado,vacio,morado,morado,morado},
                                            {rojo,vacio,vacio,rojo,rojo,rojo},
                                            {vacio,vacio,azul,azul,azul,azul},
                                            {vacio,amarillo,amarillo,amarillo,rojo,rojo}};
        coordenada.add(coord1);
        coordenada.add(coord2);
        coordenada.add(coord3);
        coordenada.add(coord4);
        coordenada.add(coord5);
        coordenada.add(coord6);
        coordenada.add(coord7);
        coordenada.add(coord8);
        coordenada.add(coord9);
        coordenada.add(coord10);
        tablero.setCoordenada(coordenada);
        tablero.eliminarAlineacion();
        assertEquals(tablero.getTablero()[5][0].getColor(),mat1[5][0].getColor());
        assertEquals(tablero.getTablero()[4][0].getColor(),mat1[4][0].getColor());
        assertEquals(tablero.getTablero()[4][1].getColor(),mat1[4][1].getColor());
        assertEquals(tablero.getTablero()[3][1].getColor(),mat1[3][1].getColor());
        assertEquals(tablero.getTablero()[3][2].getColor(),mat1[3][2].getColor());
        assertEquals(tablero.getTablero()[2][2].getColor(),mat1[2][2].getColor());
        assertEquals(tablero.getTablero()[1][2].getColor(),mat1[1][2].getColor());
        assertEquals(tablero.getTablero()[1][3].getColor(),mat1[1][3].getColor());
        assertEquals(tablero.getTablero()[1][4].getColor(),mat1[1][4].getColor());
        assertEquals(tablero.getTablero()[1][5].getColor(),mat1[1][5].getColor());
        coordenada.clear();
        tablero.setTablero(mat);
    }

        @Test
    public void testVerificarAlineacion2() {
        Coordenada coord1 = new Coordenada(0,0);
        Coordenada coord2 = new Coordenada(0,1);
                Punto [][] mat1 = new Punto [][]{{vacio,vacio,amarillo,amarillo,amarillo,amarillo},
                                        {verde,verde,verde,verde,verde,verde},
                                        {morado,morado,morado,morado,morado,morado},
                                        {rojo,rojo,rojo,rojo,rojo,rojo},
                                        {azul,azul,azul,azul,azul,azul},
                                        {amarillo,amarillo,amarillo,amarillo,vacio,vacio}};
        
        coordenada.add(coord1);
        coordenada.add(coord2);
        tablero.setCoordenada(coordenada);
        tablero.eliminarAlineacion();
        assertEquals(tablero.getTablero()[0][0].getColor(),mat1[0][0].getColor());
        assertEquals(tablero.getTablero()[0][1].getColor(),mat1[0][1].getColor());
        coordenada.clear();
        tablero.setTablero(mat);
    }
        @Test
    public void testVerificarAlineacion3(){
        Coordenada coord1 = new Coordenada(1,0);
        Coordenada coord2 = new Coordenada(1,1);
                Punto [][] mat1 = new Punto [][]{{amarillo,amarillo,amarillo,amarillo,amarillo,amarillo},
                                        {vacio,vacio,verde,verde,verde,verde},
                                        {morado,morado,morado,morado,morado,morado},
                                        {rojo,rojo,rojo,rojo,rojo,rojo},
                                        {azul,azul,azul,azul,azul,azul},
                                        {amarillo,amarillo,amarillo,amarillo,vacio,vacio}};
        
        coordenada.add(coord1);
        coordenada.add(coord2);
        tablero.setCoordenada(coordenada);
        tablero.eliminarAlineacion();
        assertEquals(tablero.getTablero()[1][0].getColor(),mat1[1][0].getColor());
        assertEquals(tablero.getTablero()[1][1].getColor(),mat1[1][1].getColor());
        coordenada.clear();
        tablero.setTablero(mat);
    }
        @Test
    public void testVerificarAlineacion4() {
        Coordenada coord1 = new Coordenada(4,5);
        Coordenada coord2 = new Coordenada(3,5);
                Punto [][] mat1 = new Punto [][]{{amarillo,amarillo,amarillo,amarillo,amarillo,amarillo},
                                        {verde,verde,verde,verde,verde,verde},
                                        {morado,morado,morado,morado,morado,morado},
                                        {rojo,rojo,rojo,rojo,rojo,vacio},
                                        {azul,azul,azul,azul,azul,vacio},
                                        {amarillo,amarillo,amarillo,amarillo,vacio,vacio}};
        
        coordenada.add(coord1);
        coordenada.add(coord2);
        tablero.setCoordenada(coordenada);
        tablero.eliminarAlineacion();
        assertEquals(tablero.getTablero()[4][5].getColor(),mat1[4][5].getColor());
        assertEquals(tablero.getTablero()[3][5].getColor(),mat1[3][5].getColor());
        coordenada.clear();
        tablero.setTablero(mat);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
