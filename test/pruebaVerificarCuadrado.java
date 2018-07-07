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
public class pruebaVerificarCuadrado {
    
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
        
        private final ArrayList<Coordenada> coordenada = new ArrayList<>();

    public pruebaVerificarCuadrado() {
    }
    
    @Test
    public void testVerificarCuadrado() {
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
        assertEquals(tablero.verificarCuadrado(), 1);
        coordenada.clear();
    }
    
    @Test
    public void testVerificarCuadrado2() {
        Coordenada coord1 = new Coordenada(0,0);
        Coordenada coord2 = new Coordenada(0,1);
        coordenada.add(coord1);
        coordenada.add(coord2);
        tablero.setCoordenada(coordenada);
        assertEquals(tablero.verificarCuadrado(), 0);
        coordenada.clear();
    }
    
    @Test
    public void testVerificarCuadrado3() {
        Coordenada coord4 = new Coordenada(5,4);
        Coordenada coord5 = new Coordenada(5,5);
        Coordenada coord6 = new Coordenada(4,4);
        Coordenada coord7 = new Coordenada(4,5);
        Coordenada coord8 = new Coordenada(5,4);
        coordenada.add(coord4);
        coordenada.add(coord5);
        coordenada.add(coord5);
        coordenada.add(coord6);
        coordenada.add(coord7);
        coordenada.add(coord8);
        
        tablero.setCoordenada(coordenada);
        assertEquals(tablero.verificarCuadrado(), 3);
        coordenada.clear();
    }
    
    @Test
    public void testVerificarCuadrado4() {
        Coordenada coord1 = new Coordenada(0,0);
        Coordenada coord3 = new Coordenada(1,1);
        coordenada.add(coord1);
        coordenada.add(coord3);
        tablero.setCoordenada(coordenada);
        assertEquals(tablero.verificarCuadrado(), 0);
        coordenada.clear();
    }    
}
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
