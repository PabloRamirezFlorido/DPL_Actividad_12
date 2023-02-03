package Ventanas;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class ventana1 extends JFrame implements ActionListener { //clase para la ventana1
    //Declaramos los componentes de la ventana(botones,area de texto,texto)
    private JLabel Texto;
    private JButton Crear,Operar,Listar;
    private JTextArea Rectangulo;
    public ventana1(){ //construimos la ventana añadiendole los componentes
        setLayout(null);
        Texto = new JLabel("Ventana de Inicio");
        Texto.setBounds(240,20,100,100);
        Texto.setVisible(true);
        add(Texto);
    
        Crear = new JButton("Crear Usuario");
        Crear.setBounds(75, 125, 150,100);
        Crear.setVisible(true);
        add(Crear);
        Crear.addActionListener(this); 

        Operar = new JButton("Operar Cuenta");
        Operar.setBounds(365, 125, 150,100);
        Operar.setVisible(true);  
        add(Operar);
        Operar.addActionListener(this);

        Listar = new JButton("Listar Usuarios");
        Listar.setBounds(215, 275, 150,100);
        Listar.setVisible(true); 
        add(Listar);
        Listar.addActionListener(this);

        Rectangulo= new JTextArea();
        Rectangulo.setBounds(10,400,565,125);
        Rectangulo.setVisible(true);
        add(Rectangulo);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == Crear){ //nos lleva a la ventana2 y se nos oculta la ventana1
            ventana2 ventana2 = new ventana2();
            ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana2.setVisible(true);
            ventana2.setBounds(0,0,600,600);
            ventana2.setResizable (false);
            ventana2.setLocationRelativeTo(null);
        }
        if(e.getSource() == Operar){ //nos lleva a la ventana3 y se nos oculta la ventana1
            ventana3 ventana3 = new ventana3();
            ventana3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana3.setVisible(true);
            ventana3.setBounds(0,0,600,600);
            ventana3.setResizable (false);
            ventana3.setLocationRelativeTo(null);
        }
        //Lee el archivo para listar los datos de los usuarios 
        if (e.getSource() == Listar){
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            
                
            try {
    
                //asignamos archivo en mi caso DUsuarios.txt
                archivo = new File ("C:/Users/Alumno-DAW1/Documents/Supuesto Practico/DUsuarios.txt"); 
                if (archivo.exists()){
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);
        
                String linea;
                String spliteado[]; 
                String mostrar = "";
                while((linea=br.readLine())!=null){
        
                    spliteado=linea.split(",");                                          
                    //añadimos los datos del usuario en una string 
                    mostrar += ("DNI: " + spliteado[0] + ", Ncuenta: " + spliteado[1] + ", Nombre: " + spliteado[2] + ", Apellidos: " + spliteado[3] + ", Saldo: " + spliteado[4] + "€" + "\n");
                    //mostramos los datos del usuario en el área de texto
                    Rectangulo.setText(mostrar); 
                }   
            }
                
            } catch(Exception err)
            {
                err.printStackTrace();
            } finally {
    
                try {                    
                    if( null != fr )  
                        fr.close();     
                                    
                } catch (Exception err2) { 
                    err2.printStackTrace();
                }  
            }
            }
        }
    }
