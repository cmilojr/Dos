/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectofinal.modelo.Coordenada;
import proyectofinal.modelo.Punto;
import proyectofinal.modelo.Tablero;

/**
 *
 * @author jcjimenezr
 */
public class pruebaExplotarCuadrado {
    private final ArrayList<Coordenada> coordenada = new ArrayList<>();
        private final Punto amarillo = new Punto(1);
        private final Punto verde = new Punto(2);
        private final Punto azul = new Punto(3);
        private final Punto rojo = new Punto(4);
        private final Punto morado = new Punto(5);
        private final Punto [][] mat = new Punto [][]{{amarillo,amarillo,amarillo,amarillo,amarillo,amarillo},
                                        {amarillo,amarillo,verde,verde,verde,verde},
                                        {morado,morado,morado,morado,morado,morado},
                                        {rojo,rojo,rojo,rojo,rojo,rojo},
                                        {azul,azul,azul,azul,azul,azul},
                                        {amarillo,amarillo,amarillo,amarillo,azul,azul}};
        private final Tablero tablero = new Tablero(mat,"");

    public pruebaExplotarCuadrado() {
    }
    
    @Test
    public void testExplotarCuadrado() {
        Coordenada coord1 = new Coordenada(0,0);
        Coordenada coord2 = new Coordenada(0,1);
        Coordenada coord3 = new Coordenada(1,1);
        Coordenada coord4 = new Coordenada(1,0);
        Coordenada coord5 = new Coordenada(0,0);
        coordenada.add(coord1);
        coordenada.add(coord2);
        coordenada.add(coord3);
        coordenada.add(coord4);
        coordenada.add(coord5);
        tablero.setCoordenada(coordenada);
        int cuadrado = tablero.verificarCuadrado();
        assertEquals(tablero.explotarCuadrado(cuadrado), 12);
        tablero.setTablero(mat);
    }
    /*
    @Test
    public void testExplotarCuadrado2() {
        assertEquals(tablero.explotarCuadrado(5), 6);
        tablero.setTablero(mat);
    }
    
    @Test
    public void testExplotarCuadrado3() {
        assertEquals(tablero.explotarCuadrado(2), 4);
        tablero.setTablero(mat);
    }
    
    @Test
    public void testExplotarCuadrado4() {
        assertEquals(tablero.explotarCuadrado(4), 5);
        tablero.setTablero(mat);
    }    */
}
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

