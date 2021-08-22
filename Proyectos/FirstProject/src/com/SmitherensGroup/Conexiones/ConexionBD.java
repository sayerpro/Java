package com.SmitherensGroup.Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import com.SmitherensGroup.Utilidades.Utilidades;
/**
 * Clase para conectar java con la Base de datos
 * @author TheSrSmith
 * @email sayerpro.op7@gmail.com
 */
public class ConexionBD {
    
    private String nombreBD;
    private String puerto;
    private String user;
    private String password;
    
    private final Utilidades utilidades = new Utilidades();
    
    private void setNombreBD(String nombreBd) {
        this.nombreBD = nombreBd;
    }
    
    private String getNombreBD(){
        return nombreBD;
    }
    
    private void setPuerto(String puerto) {
        this.puerto = puerto;
    }
    
    private String getPuerto(){
        return puerto;
    }
    
    private void setUser(String user) {
        this.user = user;
    }
    
    private String getUser(){
        return user;
    }
    
    private void setPassword(String password) {
        this.password = password;
    }
    
    private String getPassword(){
        return password;
    }
    
    /*
    * Constructor de la clase para llenar el modelo de la misma
    * @params String, String, String, String
    */
    private void ConexionBD(String nombreBd, String puerto, String user, String password) {
        this.setNombreBD(nombreBd);
        this.setPuerto(puerto);
        this.setUser(user);
        this.setPassword(password);
    }
    
    /*
    * Metodo que llena el objeto del modelo BD atravez del constructor con validaciones
    * @params String, String, String, String
    * @return boolean
    */
    private boolean llenarModeloBD(String nombreBD, String puerto, String user, String password){
        boolean modeloLleno = true;
         if (!utilidades.validarStringLleno(nombreBD)) {
            System.out.println("Debe especificar un nombre para establecer la conexion a base de datos");
            modeloLleno = false;
        }
        if (!utilidades.validarStringLleno(puerto)) {
            System.out.println("Debe especificar un puerto para establecer la conexion a base de datos");
            modeloLleno = false;
        }
        this.ConexionBD(nombreBD, puerto, user, password);
        return modeloLleno;
    }
         
    /*
    * Metodo que obtiene la conexión con la base de datos creada
    * @params String, String, String, String
    * @throws Exception
    * @return Connection
    */
    public Connection getConexion(String nombreBD, String puerto, String user, String password){
        boolean modeloLleno = this.llenarModeloBD(nombreBD, puerto, user, password);
        Connection con = null;
        if (modeloLleno) {
            String URL = "jdbc:mysql://localhost:" + this.getPuerto() + "/" + this.getNombreBD() + "";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(URL, this.getUser(), this.getPassword());
                System.out.println("Conexión exitosa a la base de datos " + this.getNombreBD());
            }catch(Exception e){
                System.out.println("Error de conexión a bade de datos: " + e.getMessage());
            }
        } else {
            System.out.println("El modelo esta vacio conexion: null");
        }
        return con;
    }
}
