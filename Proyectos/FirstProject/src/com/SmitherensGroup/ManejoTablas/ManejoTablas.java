package com.SmitherensGroup.ManejoTablas;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import com.SmitherensGroup.Utilidades.Utilidades;
import java.sql.ResultSet;

/**
 * Esta clase tiene la funcionalidad de crear tablas en una base de datos
 * @author TheSrSmith
 * @email sayerpro.op7@gmail.com
 */
public class ManejoTablas {
    
    private final Utilidades utilidades = new Utilidades();
    
    /*
    * Metodo que crea tablas según los parametros que reciba
    * @params Connection, String, String[]
    * @throws SQLException
    * @return boolean
    */
    public boolean crearTablaSql(Connection conn, String nombreTabla, String[] campos) {
        boolean tablaLlena = utilidades.validarStringLleno(nombreTabla);
        if (!tablaLlena) {
            System.out.println("No se puede crear la tabla porque el parametro nombreTabla esta vacío");
        }
        
        boolean camposLleno = utilidades.validarStringArrayLleno(campos);
        if (!camposLleno) {
            System.out.println("No se puede crear la tabla porque el parametro campos esta vacío");
        }
        
        
        
        boolean tablaCreada = false;
        if (tablaLlena && camposLleno) {
            try {
                Statement statement = conn.createStatement(); 
                if (this.eliminarTablasSql(conn, nombreTabla)) {
                    statement.executeUpdate("CREATE TABLE " + nombreTabla + " (ID int NOT NULL AUTO_INCREMENT PRIMARY KEY)");
                    System.out.println("Tabla " + nombreTabla + " creada exitosamente");
                    String camposACrear = utilidades.convertirStringArrayAString(campos);
                    String instruccion = "ADD (" + camposACrear + ")";
                    this.alterarTablasSql(conn, nombreTabla, instruccion);
                    tablaCreada = true;
                }               
            } catch (SQLException  e) {
                System.out.println("Error al crear tabla " + nombreTabla + " en " + e.getClass().getName() + ":" + e.getMessage());
            }
        }
        return tablaCreada;
    }
    
    /*
    * Metodo que elimina tablas según los parametros que reciba
    * @params Connection, String
    * @throws SQLException
    * @return boolean
    */
    public boolean eliminarTablasSql(Connection conn, String nombreTabla) {
        boolean tablaLlena = utilidades.validarStringLleno(nombreTabla);
        if (!tablaLlena) {
            System.out.println("No se puede eliminar la tabla porque el parametro nombreTabla esta vacío");
        }
        
        boolean tablaEliminada = false;
        if (tablaLlena) {
            try {
                Statement statement = conn.createStatement();
                statement.executeUpdate("DROP TABLE IF EXISTS " + nombreTabla + "");
                System.out.println("Tabla " + nombreTabla + " eliminada exitosamente");
                tablaEliminada = true;
            } catch (SQLException e) {
                System.out.println("Error al eliminar tabla " + nombreTabla + " en " + e.getClass().getName() + ":" + e.getMessage());
            }            
        }
        return tablaEliminada;
    }
 
    /*
    * Metodo que altera tablas según los parametros que reciba
    * @params Connection, String, String
    * @throws SQLException
    * @return boolean
    */
    public boolean alterarTablasSql(Connection conn, String nombreTabla, String instruccion) {
        boolean tablaLlena = utilidades.validarStringLleno(nombreTabla);
        if (!tablaLlena) {
            System.out.println("No se puede alterar la tabla porque el parametro nombreTabla esta vacío");
        }
        
         boolean instruccionLlena = utilidades.validarStringLleno(instruccion);
        if (!instruccionLlena) {
            System.out.println("No se puede alterar la tabla porque el parametro instruccion esta vacío");
        }
        
        boolean tablaAlterada = false;
        if (tablaLlena && instruccionLlena) {
            try {
                Statement statement = conn.createStatement();
                statement.executeUpdate("ALTER TABLE " + nombreTabla + " " + instruccion);
                tablaAlterada = true;
                System.out.println("Tabla " + nombreTabla + " alterada exitosamente");
            } catch (SQLException e) {
                System.out.println("Error al alterar tabla " + nombreTabla + " en " + e.getClass().getName() + ":" + e.getMessage());
            }
        }
        return tablaAlterada;
    }
    
        /*
    * Metodo que inserta registros en una tabla según los parametros que reciba
    * @params Connection, String, String[], String[]
    * @throws SQLException
    * @return boolean
    */
    public boolean insertarRegistrosSql(Connection conn, String nombreTabla, String[] columnas, String[] datos) {
        boolean tablaLlena = utilidades.validarStringLleno(nombreTabla);
        if (!tablaLlena) {
            System.out.println("No se puede insertar registros en la tabla porque el parametro nombreTabla esta vacío");
        }
        
        boolean columnasLlena = utilidades.validarStringArrayLleno(columnas);
        if (!columnasLlena) {
            System.out.println("No se puede insertar registros en la tabla porque el parametro columnas esta vacío");
        }
        
        boolean datosLleno = utilidades.validarStringArrayLleno(datos);
        if (!datosLleno) {
            System.out.println("No se puede insertar registros en la tabla porque el parametro datos esta vacío");
        }
        
        
        boolean registrosInsertados = false;
        if (tablaLlena && columnasLlena && datosLleno) {
            try {
                Statement statement = conn.createStatement();
                String columnasAModificar = utilidades.convertirStringArrayAString(columnas);
                String datosAInsertar = utilidades.convertirStringArrayAString(datos);                
                statement.executeUpdate("INSERT INTO " + nombreTabla + " (" + columnasAModificar + ") VALUES (" + datosAInsertar + ")");
                registrosInsertados = true;
                System.out.println("La insercion de registros en la " + nombreTabla + " ha sido exitoso");
            } catch (SQLException e) {
                System.out.println("Error al insertar registros en la  tabla " + nombreTabla + " en " + e.getClass().getName() + ":" + e.getMessage());
            }
        }
        return registrosInsertados;
    }
    
        public ResultSet obtenerDatos(Connection conn, String nombreTabla, String camposABuscar, String instruccion) {
        boolean tablaLlena = utilidades.validarStringLleno(nombreTabla);
        if (!tablaLlena) {
            System.out.println("No se puede buscar los registros en la tabla porque el parametro nombreTabla esta vacío");
        }
        
        boolean camposLleno = utilidades.validarStringLleno(camposABuscar);
        if (!camposLleno) {
            System.out.println("No se puede buscar los registros en la tabla porque el parametro camposABuscar esta vacío");
        }
        
        ResultSet rs = null;
        if (tablaLlena && camposLleno) {
            try {
                Statement statement = conn.createStatement();
                rs = statement.executeQuery("SELECT " + camposABuscar + " FROM " + nombreTabla + " " + instruccion);
                System.out.println("La busqueda de registros en la tabla " + nombreTabla + " ha sido exitoso");
            } catch (SQLException e) {
                System.out.println("Error al buscar registros en la  tabla " + nombreTabla + " en " + e.getClass().getName() + ":" + e.getMessage());
            }
        }
        return rs;
    }
}
