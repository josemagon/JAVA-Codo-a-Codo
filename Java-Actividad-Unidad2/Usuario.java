/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidad2;

/**
 *
 * @author Josema
 */
public class Usuario {
    String nombre, apellido, hobbie, editor_favorito, sistema_operativo;
    int edad;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    public void setEditor_favorito(String editor_favorito) {
        this.editor_favorito = editor_favorito;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getDatosUsuario(){
        return "El usuario " + nombre + " " + apellido + " tiene " + edad + 
                " anhos de edad. Su hobbie es " + hobbie + 
                " .Su editor de código preferido es " + editor_favorito + " y utiliza el sistema operativo " + sistema_operativo;
    }
}
