package unidad2.actividad1;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        String identificador = "";
        String tipo = "Venta";
        String producto = "Juguete de acción";
        Integer valor = 20000;
        Date fecha = new Date();
        boolean facturaLista = llenarFactura(identificador, tipo, producto, valor, fecha);
        if (facturaLista) {
            Factura factura = new Factura();
            factura.setIdentificador(identificador);
            factura.setTipo(tipo);
            factura.setProducto(producto);
            factura.setValor(valor);
            factura.setFecha(fecha);

            imprimirMensaje("Factura Generada \nIdentificador: " + factura.getIdentificador() + "\n" + "Tipo: "
                    + factura.getTipo() + "\n" + "Producto: " + factura.getProducto() + "\n" + "Valor: "
                    + factura.getValor() + "\n" + "Fecha: " + factura.getFecha());
        }
    }

    public static boolean llenarFactura(String identificador, String tipo, String producto, Integer valor, Date fecha) {
        boolean facturaLlena = false;
        if (!validarCampoLleno(identificador) || !validarCampoLleno(tipo) || !validarCampoLleno(producto)
                || !validarCampoLleno(valor.toString()) || !validarCampoLleno(fecha.toString())) {
            imprimirMensaje(
                    "No se puede generar Factura ... \nPorfavor verifique que todos los campos requeridos esten correctamente diligenciados:");
            imprimirMensaje("identificador: " + identificador + "\n" + "tipo: " + tipo + "\n" + "producto: " + producto
                    + "\n" + "valor: " + valor + "\n" + "fecha: " + fecha);
        } else {
            facturaLlena = true;
        }
        return facturaLlena;
    }

    private static boolean validarCampoLleno(String campo) {
        boolean campoLleno = false;
        if (!campo.equals("") && !campo.equals(null)) {
            campoLleno = true;
        }
        return campoLleno;
    }

    private static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
