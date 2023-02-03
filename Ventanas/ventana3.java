package Ventanas;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ventana3 extends JFrame implements ActionListener { //clase para la ventana3
    //Declaramos los componentes de la ventana(botones,area de texto,texto,array)
    private JLabel Texto3;
    private JTextField NCuenta, CEuros;
    private JButton Ingresar, Cargo, Atras;
    ArrayList<datosusers> user = new ArrayList<datosusers>();
    public ventana3(){ //construimos la ventana añadiendole los componentes
        setLayout(null);
        Texto3 = new JLabel("Ventana de Operación");
        Texto3.setBounds(200,20,200,100);
        Texto3.setVisible(true);
        add(Texto3);

        NCuenta = new JTextField("Número de Cuenta");
        NCuenta.setBounds(10,175,200,50);
        NCuenta.setVisible(true);
        add(NCuenta);

        CEuros = new JTextField("Cantidad en Euros");
        CEuros.setBounds(10,350,200,50);
        CEuros.setVisible(true);
        add(CEuros);

        Ingresar = new JButton("Ingresar");
        Ingresar.setBounds(350,150,150,50);
        Ingresar.setVisible(true);
        add(Ingresar);
        Ingresar.addActionListener(this);

        Cargo = new JButton("Cargo");
        Cargo.setBounds(350,275,150,50);
        Cargo.setVisible(true);
        add(Cargo);
        Cargo.addActionListener(this);

        Atras = new JButton("Atras");
        Atras.setBounds(350,400,150,50);
        Atras.setVisible(true);
        add(Atras);
        Atras.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == Atras){ //nos lleva a la ventana1 y nos oculta la ventana3
            ventana1 ventana1 = new ventana1();
            ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana1.setVisible(true);
            ventana1.setBounds(0,0,600,600);
            ventana1.setResizable (false);
            ventana1.setLocationRelativeTo(null);
        }
        if (e.getSource()==Ingresar){ //realizamos el ingreso
            ventana1 ventana1 = new ventana1();
            String ncuenta = NCuenta.getText();
            Double ingreso = Double.parseDouble(CEuros.getText());

            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            FileWriter fichero = null;
            PrintWriter pw = null;
            FileWriter fichero2 = null;
            PrintWriter pw2;
            
            //leeremos el archivo con todas las cuentas y hacemos el ingreso en la cuenta(debe de estar creada si no nos saltará error)
            try {
    
        
                archivo = new File ("C:/Users/Alumno-DAW1/Documents/Supuesto Practico/DUsuarios.txt"); 
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);
            
                String linea;
    
                String spliteado[];
                Double aux2;
                while((linea=br.readLine())!=null){
        
                    spliteado=linea.split(",");                                          
                    
                    aux2 = Double.parseDouble(spliteado[4]);

                    if(spliteado[1].trim().equals(ncuenta) ){
                        aux2 = aux2 + ingreso;
                        spliteado[4] = Double.toString(aux2);
                    } 
                    
                    user.add(new datosusers(spliteado[0],spliteado[1], spliteado[2], spliteado[3], spliteado[4]));


                    fichero2 = new FileWriter ("C:/Users/Alumno-DAW1/Documents/Supuesto Practico/Movimiento.txt", true);
                    pw2 = new PrintWriter(fichero2);

                    //escribimos en el fichero2 los movimientos de ingresos con su fecha y hora
                    DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    String time = DTF.format(LocalDateTime.now());
                    pw2.println("Número de cuenta: " + ncuenta + ", Movimiento: +" + ingreso + ", Hora: " + time);

            }
            //reescribimos el archivo cuentas con el saldo cambiado de la cuenta en la que se hizo el ingreso
            fichero = new FileWriter ("C:/Users/Alumno-DAW1/Documents/Supuesto Practico/DUsuarios.txt");
            pw = new PrintWriter(fichero);
            for(int i = 0; i <user.size(); i++){
                pw.print(user.get(i).getDni().trim()+", ");
                pw.print(user.get(i).getNcuenta().trim()+", ");
                pw.print(user.get(i).getNombre().trim()+", ");
                pw.print(user.get(i).getApellidos().trim()+", ");
                pw.println(user.get(i).getSaldoincial().trim());
            }
                
            } catch(Exception err)
            {
                err.printStackTrace();
            } finally {
    
                try {                    
                    if( null != fr )  
                        fr.close();
                    fichero.close();
                    fichero2.close();

                } catch (Exception err2) { 
                    err2.printStackTrace();
                }  
            }

            setVisible(false);
            ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana1.setVisible(true);
            ventana1.setBounds(0, 0, 600, 600);
            ventana1.setResizable(false);
            ventana1.setLocationRelativeTo(null);
        }
        if (e.getSource()==Cargo){ //realizamos un cargo
            ventana1 ventana1 = new ventana1();
            String ncuenta = NCuenta.getText();
            Double ingreso = Double.parseDouble(CEuros.getText());

            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            FileWriter fichero = null;
            PrintWriter pw = null;
            FileWriter fichero2 = null;
            PrintWriter pw2;
            
            //leeremos el archivo con todas las cuentas y hacemos el cargo en la cuenta que indiquemos(debe estar creada la cuenta) 
            try {
    
        
                archivo = new File ("C:/Users/Alumno-DAW1/Documents/Supuesto Practico/DUsuarios.txt"); 
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);
            
                String linea;
    
                String spliteado[];
                Double aux2;
                while((linea=br.readLine())!=null){
        
                    spliteado=linea.split(",");                                          
                    
                    aux2 = Double.parseDouble(spliteado[4]);

                    if(spliteado[1].trim().equals(ncuenta) ){
                        aux2 = aux2 - ingreso;
                        spliteado[4] = Double.toString(aux2);
                    } 
                    
                    user.add(new datosusers(spliteado[0],spliteado[1], spliteado[2], spliteado[3], spliteado[4]));


                    fichero2 = new FileWriter ("C:/Users/Alumno-DAW1/Documents/Supuesto Practico/Movimiento.txt", true);
                    pw2 = new PrintWriter(fichero2);

                    //escribimos en el fichero2 los movimientos de cargo con su fecha y hora
                    DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    String time = DTF.format(LocalDateTime.now());
                    pw2.println("Número de cuenta: " + ncuenta + ", Movimiento: +" + ingreso + ", Hora: " + time);

            }
            //reescribimos el archivo cuentas con el saldo cambiado de la cuenta en la que se hizo el cargo
            fichero = new FileWriter ("C:/Users/Alumno-DAW1/Documents/Supuesto Practico/DUsuarios.txt");
            pw = new PrintWriter(fichero);
            for(int i = 0; i <user.size(); i++){
                pw.print(user.get(i).getDni().trim()+", ");
                pw.print(user.get(i).getNcuenta().trim()+", ");
                pw.print(user.get(i).getNombre().trim()+", ");
                pw.print(user.get(i).getApellidos().trim()+", ");
                pw.println(user.get(i).getSaldoincial().trim());
            }
                
            } catch(Exception err)
            {
                err.printStackTrace();
            } finally {
    
                try {                    
                    if( null != fr )  
                        fr.close();
                    fichero.close();
                    fichero2.close();

                } catch (Exception err2) { 
                    err2.printStackTrace();
                }  
            }

            setVisible(false);
            ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana1.setVisible(true);
            ventana1.setBounds(0, 0, 600, 600);
            ventana1.setResizable(false);
            ventana1.setLocationRelativeTo(null);
        }
    }
    
}
