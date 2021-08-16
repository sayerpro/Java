package unidad2.actividad3;

public class Cliente {

    private String cedula;
    private String nombre;
    private String telefono;
    private String ciudad;

    public Cliente(String cedula, String nombre, String teleono, String ciudad) {
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setTelefono(telefono);
        this.setCiudad(ciudad);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
