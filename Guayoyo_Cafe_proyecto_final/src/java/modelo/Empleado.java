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
public class Empleado {
    String nombre, email_empleado;

    public Empleado(String nombre, String email_empleado) {
        this.nombre = nombre;
        this.email_empleado = email_empleado;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getEmail_empleado() {
        return email_empleado;
    }
    
    
}
