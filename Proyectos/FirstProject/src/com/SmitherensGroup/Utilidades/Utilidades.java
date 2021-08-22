package com.SmitherensGroup.Utilidades;

/**
 * Clase que contiene diferentes utilidades funcionales para el manejo de datos
 * en el código
 * 
 * @author TheSrSmith
 * @email sayerpro.op7@gmail.com
 */
public class Utilidades {

    /*
     * Metodo que valida si un campo de tipo String esta lleno o vacío
     * 
     * @params String
     * 
     * @return boolean
     */
    public boolean validarStringLleno(String campo) {
        boolean campoLleno = true;
        if (campo == null || campo.equals("")) {
            campoLleno = false;
        }
        return campoLleno;
    }

    /*
     * Metodo que valida si un campo de tipo String[] esta lleno o vacío
     * 
     * @params String[]
     * 
     * @return boolean
     */
    public boolean validarStringArrayLleno(String[] campo) {
        boolean campoLleno = false;
        if (campo.length > 0) {
            campoLleno = true;
        }
        return campoLleno;
    }

    /*
     * Metodo que convierte las posiciones de un String[] a un String
     * 
     * @params String[]
     * 
     * @return String
     */
    public String convertirStringArrayAString(String[] campo) {
        String campos = "";
        for (int i = 0; i < campo.length; i++) {
            if (!this.validarStringLleno(campos)) {
                campos = campos + campo[i];
            } else {
                campos = campos + ", " + campo[i];
            }
        }
        return campos;
    }
}
