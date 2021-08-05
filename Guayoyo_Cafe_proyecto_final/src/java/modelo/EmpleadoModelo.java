/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josema
 */
public class EmpleadoModelo {
    private String SERVIDOR = "localhost:3306/";
    private String BASEDEDATOS = "guayoyo_cafe";
    private String USUARIO = "root";
    private String CLAVE = "";
    
    public Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + SERVIDOR 
                +  BASEDEDATOS + "?autoReconnect=true&useSSL=false", USUARIO,CLAVE);
        return connection;
    }
    
    public Empleado empleadoExiste(String anEmail, String aPassword) throws ClassNotFoundException{
        try {
            Connection connection = this.conectar();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM empleado WHERE email_empleado = ? AND clave_ingreso = ?");
            stmt.setString(1, anEmail);
            stmt.setString(2, aPassword);
            ResultSet resultset = stmt.executeQuery();
            if(resultset.next()){
                return new Empleado(resultset.getString("nombre"), resultset.getString("email_empleado"));
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CafeModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
