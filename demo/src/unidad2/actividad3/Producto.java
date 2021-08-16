package unidad2.actividad3;

public class Producto {

    private String id;
    private String nombre;
    private String descripcion;
    private Integer costo;

    public Producto(String id, String nombre, String descripcion, Integer costo) {
        this.setId(id);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCosto(costo);
    }

    public Producto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
}
