package Ventanas;

public class datosusers { //clase datosusers
    //atributos privados del datousers
    private String Dni;
    private String Ncuenta;
    private String Nombre;
    private String Apellidos;
    private String Saldoi;
    
    //constructor del datosusers
    public datosusers(String Dni, String Ncuenta,String Nombre, String Apellidos, String Saldoi) {
         this.Dni=Dni;
         this.Ncuenta = Ncuenta;
         this.Nombre = Nombre;
         this.Apellidos=Apellidos;
         this.Saldoi=Saldoi;
     }
 
    //metodos getter y setter para obtener y modificar datos.
    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNcuenta(){
        return Ncuenta;
    }
    public void setNcuenta(String Ncuenta){
        this.Ncuenta = Ncuenta;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    public String getApellidos(){
        return Apellidos;
    }
    public void setApellidos(String Apellidos){
        this.Apellidos = Apellidos;
    }
    public String getSaldoincial(){
        return Saldoi;
    }
    public void setSaldoinicial(String Saldoi){
        this.Saldoi = Saldoi;
    }
}
