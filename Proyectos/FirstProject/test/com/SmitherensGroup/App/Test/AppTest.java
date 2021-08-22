package com.SmitherensGroup.App.Test;

import org.junit.Test;
import java.sql.Connection;
import com.SmitherensGroup.Conexiones.ConexionBD;
import com.SmitherensGroup.ManejoTablas.ManejoTablas;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* Clase de testing para probar funcionalidades de la aplicacion
* @author TheSrSmith
* @email sayerpro.op7@gmail.com
*/
public class AppTest {

    private final ConexionBD baseDeDatos = new ConexionBD();
    private final ManejoTablas manejoTablas = new ManejoTablas();

    /*
     * Metodo para llamar y probar diferentes funcionalidades del proyecto
     */
    @Test
    public void testA() throws SQLException, Exception {
        String nombreBD = "centro_medico";
        String puerto = "3306";
        String user = "root";
        String password = "";
        String nombreTabla = "medicos";
        String campos[] = new String[4];
        campos[0] = "nombre VARCHAR(100) NOT NULL";
        campos[1] = "edad VARCHAR(3) NOT NULL";
        campos[2] = "telefono VARCHAR(100) NOT NULL";
        campos[3] = "descripcion VARCHAR(100) NOT NULL";
        String columnas[] = new String[4];
        columnas[0] = "nombre";
        columnas[1] = "edad";
        columnas[2] = "telefono";
        columnas[3] = "descripcion";
        String datos[] = new String[4];
        datos[0] = "\'Smitherens\'";
        datos[1] = "\'22\'";
        datos[2] = "\'3197502666\'";
        datos[3] = "\'PER ASPERA AD ASTRA\'";
        String datos2[] = new String[4];
        datos2[0] = "\'Smitherens - 2\'";
        datos2[1] = "\'222\'";
        datos2[2] = "\'3197502666 - 2\'";
        datos2[3] = "\'PER ASPERA AD ASTRA - 2\'";
        String camposABuscar = "nombre, edad, telefono, descripcion";
        String instruccion = "";
        try (Connection conexion = baseDeDatos.getConexion(nombreBD, puerto, user, password)) {
            if (manejoTablas.crearTablaSql(conexion, nombreTabla, campos)) {
                if (manejoTablas.insertarRegistrosSql(conexion, nombreTabla, columnas, datos)) {
                    System.out.println("El medico " + datos[0] + " a sido registrado");
                }
                if (manejoTablas.insertarRegistrosSql(conexion, nombreTabla, columnas, datos2)) {
                    System.out.println("El medico " + datos2[0] + " a sido registrado");
                }
                ResultSet rs = manejoTablas.obtenerDatos(conexion, nombreTabla, camposABuscar, instruccion);
                while (rs.next()) {
                    System.out.println("nombre = " + rs.getString("nombre"));
                    System.out.println("edad = " + rs.getString("edad"));
                    System.out.println("telefono = " + rs.getString("telefono"));
                    System.out.println("descripcion = " + rs.getString("descripcion"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la ejecucion del código " + e.getClass().getName() + ":" + e.getMessage());
        }
    }
}