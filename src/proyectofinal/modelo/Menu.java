/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.modelo;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import proyectofinal.manejoDeDatos.ColeccionTablero;

/**
 *
 * @author Camilo Windows
 */
public class Menu {
    
    public Menu(){
        /**
         * mediante este codigo podremos jugar en la consola ya que no inicia la grafica
         * 
        try {
            Scanner entrada = new Scanner(System.in);
            this.iniciar(entrada);
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }*/
    }
    /**
     * Menú de la consola, acá se recibe lo que el usuario desea hacer en el juego.
     * @param entrada
     * @throws FileNotFoundException 
     */
    public void iniciar(Scanner entrada) throws FileNotFoundException{        
        int opcion;
        boolean salir = false;
        Partida nueva;
        Partida continuar;
        ArrayList<Integer> puntaje;
        System.out.println("1. PLAY");
        System.out.println("2. CONTINUE");
        System.out.println("3. ABOUT");
        System.out.println("4. CONTROLS");
        System.out.println("5. EXIT");
        System.out.println("6. SCORES");
        System.out.print("--->");
        while(salir == false){
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    
                    nueva = empezarPartida("");
                    nueva.jugar();
                case 2:
                    continuar = continuarPartida();
                    continuar.jugar();
                case 3:
                    about();
             
                    break;
                case 4:
                    controls();
                    break;
                case 5:
                    System.out.println("Chao!");        
                    salir = true;
                    break;
                case 6:
                    puntaje = mostrarPuntajes();
                    for(int i = 0; i<puntaje.size();i++){
                        System.out.println(puntaje.get(i));
                    }
                    System.out.print("--->");
                    break;
                default:
                    System.out.println("Valor invalido");
                    System.out.print("--->");
                    break;
            }
        }     
    }
    /**
     * Acá el usuario genera una nueva partida con el nombre ingresado
     * @param nombre
     * @return 
     */
    public Partida empezarPartida(String nombre){
        
        Partida nuevaPartida = new Partida(nombre);
        return nuevaPartida;
    }
     
    /**
     * datos del creador, mios, por consola.
     */
    public void about(){
        System.out.println("VERSIÓN DE DOTS PARA FUNDAMENTOS DE PROGRAMACIÓN\nCAMILO JIMENEZ ROJAS\n1r SEMESTRE 2018");
        System.out.print("--->");
    }
    /**
     * constroles o intrucciones del juego mediante la consola.
     */
    public void controls(){
        System.out.println("EL JUEGO CONSISTE EN PODER UNIR LO PUNTOS DEL MISMO VALOR\n"
                + "EL JUEGO LE PEDIRÁ LA CANTIDAD DE COORDENADAS Y MEDIANTE LA POSICIÓN X y Y\n"
                + "PARA PODER CONSEGUIR FINALMENTE LA MAYOR CANTIDAD DE PUTOS POSIBLES!.");
        System.out.print("--->");
    }
    /**
     * Acá mostramos los puntajes que se guardaron en un AL porque no sabemos cuantos puntajes son
     * @return
     * @throws FileNotFoundException 
     */
    public ArrayList<Integer> mostrarPuntajes()throws FileNotFoundException{
        ColeccionTablero puntajes = new ColeccionTablero();
        return puntajes.leerPuntaje();
    }
    /**
     * Acá volvemos a la ultima partida guardada
     * @return
     * @throws FileNotFoundException 
     */
    public Partida continuarPartida() throws FileNotFoundException{
        ColeccionTablero coleccion = new ColeccionTablero();
        Partida nuevaPartida = coleccion.leerPartida();
        return nuevaPartida;
    }
}