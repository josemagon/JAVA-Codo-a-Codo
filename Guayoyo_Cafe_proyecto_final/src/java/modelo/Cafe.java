/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author josema
 */
public class Cafe {
    private String ID, nombre, origen, descripcion, img, color;
    private int stock;

    public Cafe(String ID, String nombre, String origen, String descripcion, int stock, String Color, String img){
        this.ID = ID;
        this.nombre = nombre;
        this.origen = origen;
        this.stock = stock;
        this.descripcion = descripcion;
        this.color = color;
        this.img = img;
    }

    public String getID() {
        return ID;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public int getStock() {
        return stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImg() {
        return img;
    }

    public String getColor() {
        return color;
    }
    
    
    
    
    public String toString(){
        return "ID : " + ID + " NOMBRE: " + nombre + " ORIGEN:" + origen + " DESCRIPCION:" + descripcion + " STOCK: " + stock;
    }
    
    public String toJSON(){
        return "{\"ID\" : \"" + ID + "\", \"nombre\": \"" + nombre + "\", \"origen\": \"" + origen + "\", \"descripcion\" : \"" + descripcion + "\", \"stock\" : \"" + stock + "\"}";
    }
}
