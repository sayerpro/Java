package unidad2.actividad3;

import java.util.Date;

public class Factura {

    private String identificador;
    private String tipo;
    private String producto;
    private Integer valor;
    private Date fecha;

    public Factura(String identificador, String tipo, String producto, Integer valor, Date fecha) {
        this.setIdentificador(identificador);
        this.setTipo(tipo);
        this.setProducto(producto);
        this.setValor(valor);
        this.setFecha(fecha);
    }

    public Factura() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
