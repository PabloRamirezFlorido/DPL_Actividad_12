package Ventanas;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class ventana2 extends JFrame implements ActionListener { //clase para la ventana2
    //Declaramos los componentes de la ventana(botones,area de texto,texto)
    private JLabel Texto2;
    private JTextField DNI,NCuenta,Nombre,Apellidos,Saldoi;
    private JButton crear,Atras;
    public ventana2(){ //construimos la ventana añadiendole los componentes
        setLayout(null);
        Texto2 = new JLabel("Creación de Usuarios y Cuentas");
        Texto2.setBounds(200,20,200,100);
        Texto2.setVisible(true);
        add(Texto2);

        DNI = new JTextField("DNI");
        DNI.setBounds(10,125,200,50);
        DNI.setVisible(true);
        add(DNI);

        NCuenta = new JTextField("Número");
        NCuenta.setBounds(10,200,200,50);
        NCuenta.setVisible(true);
        add(NCuenta);

        Nombre = new JTextField("Nombre");
        Nombre.setBounds(10,275,200,50);
        Nombre.setVisible(true);
        add(Nombre);

        Apellidos = new JTextField("Apellidos");
        Apellidos.setBounds(10,350,200,50);
        Apellidos.setVisible(true);
        add(Apellidos);

        Saldoi = new JTextField("Saldo inicial");
        Saldoi.setBounds(10,425,200,50);
        Saldoi.setVisible(true);
        add(Saldoi);

        crear = new JButton("Crear");
        crear.setBounds(350,200,150,50);
        crear.setVisible(true);
        add(crear);
        crear.addActionListener(this);

        Atras = new JButton("Atras");
        Atras.setBounds(350,400,150,50);
        Atras.setVisible(true);
        add(Atras);
        Atras.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == Atras){ //nos lleva a la ventana1 y nos oculta la ventana2
            ventana1 ventana1 = new ventana1();
            ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana1.setVisible(true);
            ventana1.setBounds(0,0,600,600);
            ventana1.setResizable (false);
            ventana1.setLocationRelativeTo(null);
        }
        if (e.getSource() == crear ){ //Crearemos el usuario y lo añadimos al archivo DUsuarios
            //asignamos a variable los datos introducidos en los campos
            String dni = DNI.getText();
            String ncuenta = NCuenta.getText();        
            String nombre = Nombre.getText();
            String apellidos = Apellidos.getText();
            Double saldo = Double.parseDouble(Saldoi.getText());
            ventana1 ventana1 = new ventana1();


            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            FileWriter fichero = null;
            PrintWriter pw = null;

            try {
                //asignamos el archivo a leer DUsuarios
                archivo = new File ("C:/Users/Alumno-DAW1/Documents/Supuesto Practico/DUsuarios.txt"); 
                //si el archivo no existiese se crea y añade los usuario
                fichero = new FileWriter("C:/Users/Alumno-DAW1/Documents/Supuesto Practico/DUsuarios.txt",true);   
                pw = new PrintWriter(fichero);
                
                    pw.print(dni+", ");
                    pw.print(ncuenta+", ");
                    pw.print(nombre+", ");
                    pw.print(apellidos+", ");
                    pw.println(saldo);

                    setVisible(false);
                    ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ventana1.setVisible(true);
                    ventana1.setBounds(0, 0, 600, 600);
                    ventana1.setResizable(false);
                    ventana1.setLocationRelativeTo(null);

                    fichero.close();
            
        }

             catch (Exception err) {
                err.printStackTrace();
            } 
            

        }

    }
}
