package reto3;

public class Persona {

    private String Cedula;
    private int Edad;
    private String Nombre;

    public Persona(String cedula, int edad, String nombre) {
        setCedula(cedula);
        setEdad(edad);
        setNombre(nombre);
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
