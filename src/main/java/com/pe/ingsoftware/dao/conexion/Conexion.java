/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DiegoDavid
 */
public class Conexion {

    public static Conexion instance;
    private Connection cnn;

    private Conexion() {
        try {
            // Class.forName("com.mysql.jdbc.Driver");//Driaver mysql
            Class.forName("org.postgresql.Driver");// Driver postgresql
            cnn = DriverManager.getConnection("jdbc:postgresql://pellefant.db.elephantsql.com/cvaukjrp", "cvaukjrp",
                    "FAjrG79pBA1CDxrcLuztKRq-sFWpUjEe");// URL,USUARIO,CONTRASEÑA
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized static Conexion crearConexion() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void cerrarConexion() {
        instance = null;
    }
}
