import Ventanas.*;
import javax.swing.*;
public class main {
    public static void main (String [] args) {
        ventana1 inicio = new ventana1(); //iniciamos la ventana1 

        //Ajustes de la ventana1
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
        inicio.setBounds(0,0,600,600);
        inicio.setResizable (false);
        inicio.setLocationRelativeTo(null);
    }
}
