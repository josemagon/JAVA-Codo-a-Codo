
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Josema
 */
public class CafeModelo {
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
    
    public ArrayList getAllCafe() throws ClassNotFoundException{
        ArrayList<Cafe> result = new ArrayList<Cafe>();
        
        try {
            Connection connection = this.conectar();
            ResultSet resultset = connection.createStatement().executeQuery("SELECT * FROM cafe ORDER BY fecha_ingreso DESC");
            while(resultset.next()){
                result.add(new Cafe(resultset.getString("ID_CAFE"), resultset.getString("nombre"), resultset.getString("origen"), resultset.getString("descripcion"), resultset.getInt("stock"), resultset.getString("color"), resultset.getString("img")));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CafeModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean guardarNuevoCafe(Cafe cafe){
        try {
            Connection connection = this.conectar();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO cafe (ID_CAFE, nombre, descripcion, origen, stock, img)"
                    + " VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, cafe.getID());
            stmt.setString(2, cafe.getNombre());
            stmt.setString(3, cafe.getDescripcion());
            stmt.setString(4, cafe.getOrigen());
            stmt.setInt(5, cafe.getStock());
            stmt.setString(6, cafe.getImg());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CafeModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void editarCafe(Cafe cafe){
        try {
            Connection connection = this.conectar();
            PreparedStatement stmt = connection.prepareStatement("UPDATE cafe SET nombre = ?, origen = ?, stock = ?"
                    + " WHERE ID_CAFE = ?");
            stmt.setString(1, cafe.getNombre());
//            stmt.setString(2, cafe.getDescripcion());
            stmt.setString(2, cafe.getOrigen());
            stmt.setInt(3, cafe.getStock());
            stmt.setString(4, cafe.getID());
            stmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CafeModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cafe getCafeByID(String anID){
        try {
            Connection connection = this.conectar();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cafe WHERE ID_CAFE = ?");
            stmt.setString(1, anID);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new Cafe(rs.getString("ID_CAFE"), rs.getString("nombre"), rs.getString("origen"), rs.getString("descripcion"), rs.getInt("stock"), rs.getString("color"), rs.getString("img"));
            }else{
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(CafeModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void eliminarCafe(String anID){
        try {
            Connection connection = this.conectar();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM cafe WHERE ID_CAFE = ?");
            stmt.setString(1, anID);
            stmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CafeModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
