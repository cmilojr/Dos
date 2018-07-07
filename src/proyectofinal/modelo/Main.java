package proyectofinal.modelo;

import java.io.FileNotFoundException;
import proyectofinal.interfazGrafica.MenuPrincipal;

public class Main {

    private static Menu menu;

    /**
     * ACÁ ES DONDE COMIENZA LA MAGIA!! ACÁ ES EL MAIN, ACÁ ES DONDE INICA
     * TODO!!!!
     *
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        menu = new Menu();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
    }

    /**
     * Getter del menú
     *
     * @return
     */
    public static Menu getMenu() {
        return menu;
    }

}
