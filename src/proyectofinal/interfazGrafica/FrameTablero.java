/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.interfazGrafica;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import proyectofinal.manejoDeDatos.ColeccionTablero;
import proyectofinal.modelo.Coordenada;
import proyectofinal.modelo.Partida;

/**
 *
 * @author jcjimenezr
 */
public class FrameTablero extends JFrame implements MouseListener, ActionListener {

    /**
     * El lienzo del juego
     */
    private final Container c; //<---

    private final Partida partida;

    private final CoordPanel[][] panelTablero = new CoordPanel[6][6];

    private final CoordPanel pnlMain = new CoordPanel(new GridLayout(6, 6));

    private CoordPanel anterior = new CoordPanel();

    private ArrayList<Coordenada> cords = new ArrayList<>();

    private ImageIcon amarillo = new ImageIcon("Iconos Dots/amarillo.png");
    private ImageIcon azul = new ImageIcon("Iconos Dots/azul.png");
    private ImageIcon naranja = new ImageIcon("Iconos Dots/naranja.png");
    private ImageIcon rojo = new ImageIcon("Iconos Dots/rojo.png");
    private ImageIcon verde = new ImageIcon("Iconos Dots/verde.png");
    private ImageIcon morado = new ImageIcon("Iconos Dots/morado.png");
    //botones
    private JButton gYs;
    private JButton salir;
    private JLabel puntaje;
    private JLabel movimientos;
    private JLabel nombre;
    private JButton ingresar;

    /**
     * En este metodo busca la imagen dependiendo el numero que este en la
     * matriz y se la asinga a la matriz panelTablero
     *
     * @param color
     * @return
     */
    private JLabel obtenerIcono(int color) {
        switch (color) {
            case 4:
                return new JLabel(amarillo);
            case 1:
                return new JLabel(azul);
            case 5:
                return new JLabel(naranja);
            case 2:
                return new JLabel(rojo);
            case 3:
                return new JLabel(verde);
            case 6:
                return new JLabel(morado);
        }
        return new JLabel();
    }

    /**
     * Asignamos la imagen a cada punto de la matriz
     */
    private void dibujarPuntos() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                panelTablero[x][y].add(obtenerIcono(partida.getTablero()
                        .getTablero()[x][y].getColor()));
            }
        }
    }

    /**
     * Coloca mouse listeners en cada casilla de la matriz
     */

    private void dibujarCasillas() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                panelTablero[x][y] = new CoordPanel();
                panelTablero[x][y].addMouseListener(this);
                panelTablero[x][y].setCoordenadas(x, y);
                pnlMain.add(panelTablero[x][y]);
            }
        }
    }

    /**
     *
     * Verifica que la coordenada posterior sea diferente a la anterior y si es
     * así la guarda en el AL. Cuando el usuario da click en una imagen se
     * genera un fondo gris para mostrar la selección
     */
    public void crearCoordenada(CoordPanel panel) {
        if (anterior != panel) {
            panel.setBackground(Color.GRAY);
            cords.add(panel.generarCoordenada());
            anterior = panel;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        CoordPanel actual = (CoordPanel) me.getSource();
        crearCoordenada(actual);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    /**
     * Constructor de el Frame para generar la partida grafica
     *
     */
    public FrameTablero(Partida partida) {

        this.partida = partida;
        c = getContentPane();
        setBounds(450, 150, 820, 630);
        setBackground(new Color(204, 204, 204));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Dots");
        setResizable(false);
        c.setLayout(null);
        pnlMain.setBounds(0, 0, 600, 600);
        pnlMain.setBackground(new Color(255, 255, 255));
        c.add(pnlMain);
        dibujarCasillas();
        dibujarPuntos();
        int punt = partida.getTablero().getPuntaje();
        int mov = partida.getTablero().getMovimientos();
        String name = partida.getNombre();
        gYs = new JButton("GUARDAR Y SALIR");
        ingresar = new JButton("INGRESAR");
        salir = new JButton("SALIR");
        puntaje = new JLabel("PUNTAJE: " + punt);
        movimientos = new JLabel("MOVIMIENTOS: " + mov);
        nombre = new JLabel("NOMBRE: " + name);
        //botones
        gYs.setBounds(650, 510, 150, 30);
        gYs.setBackground(Color.ORANGE);
        gYs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColeccionTablero coleccion = new ColeccionTablero();
                try {
                    coleccion.escribirPartida(partida.getTablero());
                    dispose();
                } catch (FileNotFoundException ex) {
                    ex.getMessage();
                }

            }
        });
        ingresar.setBounds(650, 270, 150, 90);
        ingresar.setBackground(Color.CYAN);
        ingresar.setSize(100, 80);
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    partida.getTablero().recibirPos(cords);
                    partida.getTablero().jugada(cords);
                    refrescarTablero();

                } catch (FileNotFoundException ex) {
                    ex.getMessage();
                }
            }
        });
        salir.setBounds(650, 550, 80, 30);
        salir.setBackground(Color.ORANGE);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        //
        puntaje.setBounds(650, 50, 100, 50);
        movimientos.setBounds(650, 70, 120, 50);
        nombre.setBounds(650, 10, 100, 50);
        //agregar al tablero
        c.add(gYs);
        c.add(salir);
        c.add(ingresar);
        c.add(puntaje);
        c.add(movimientos);
        c.add(nombre);
    }

    /**
     *
     * Acá se puede jugar
     */
    public void jugarPartida() throws FileNotFoundException {
        while (partida.getTablero().getMovimientos() > 0) {
            ArrayList<Coordenada> coords = new ArrayList<>();
            partida.getTablero().jugada(coords);
            anterior = new CoordPanel();
            cords.clear();
        }
        ColeccionTablero coleccion = new ColeccionTablero();
        coleccion.escribirPuntajes(partida.getTablero());
    }

    /**
     *
     * Acá se genera una nueva pantalla con los cambios generados por el usuario
     */
    public void refrescarTablero() {
        pnlMain.setVisible(false);
        pnlMain.removeAll();
        c.setVisible(false);
        c.removeAll();

        setBounds(450, 150, 820, 630);
        setBackground(new Color(204, 204, 204));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Dots");
        setResizable(false);
        c.setLayout(null);
        pnlMain.setBounds(0, 0, 600, 600);
        pnlMain.setBackground(new Color(255, 255, 255));
        c.add(pnlMain);
        dibujarCasillas();
        dibujarPuntos();
        int punt = partida.getTablero().getPuntaje();
        int mov = partida.getTablero().getMovimientos();
        String name = partida.getNombre();
        gYs = new JButton("GUARDAR Y SALIR");
        ingresar = new JButton("INGRESAR");
        salir = new JButton("SALIR");
        puntaje = new JLabel("PUNTAJE: " + punt);
        movimientos = new JLabel("MOVIMIENTOS: " + mov);
        nombre = new JLabel("NOMBRE: " + name);
        //botones
        gYs.setBounds(650, 510, 150, 30);
        gYs.setBackground(Color.ORANGE);
        gYs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColeccionTablero coleccion = new ColeccionTablero();
                try {
                    coleccion.escribirPartida(partida.getTablero());
                    dispose();
                } catch (FileNotFoundException ex) {
                    ex.getMessage();
                }

            }
        });
        ingresar.setBounds(650, 270, 150, 90);
        ingresar.setBackground(Color.CYAN);
        ingresar.setSize(100, 80);
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    partida.getTablero().recibirPos(cords);
                    partida.getTablero().jugada(cords);
                    refrescarTablero();

                } catch (FileNotFoundException ex) {
                    ex.getMessage();
                }
            }
        });
        salir.setBounds(650, 550, 80, 30);
        salir.setBackground(Color.ORANGE);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        //
        puntaje.setBounds(650, 50, 100, 50);
        movimientos.setBounds(650, 70, 120, 50);
        nombre.setBounds(650, 10, 100, 50);
        //agregar
        c.add(gYs);
        c.add(salir);
        c.add(ingresar);
        c.add(puntaje);
        c.add(movimientos);
        c.add(nombre);
        c.setVisible(true);
        pnlMain.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
