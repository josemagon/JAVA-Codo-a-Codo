/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidad2;

import java.util.Scanner;

/**
 *
 * @author Josema
 */
public class Unidad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // usamos la clase Scanner para obtener input del usuario
        Scanner sc = new Scanner(System.in);
        
        Usuario usuario = new Usuario();
        
        System.out.println("Ingrese nombre del usuario");
        usuario.setNombre(sc.nextLine());
        
        System.out.println("Ingrese apellido del usuario");
        usuario.setApellido(sc.nextLine());
        
        System.out.println("Ingrese la edad del usuario");
        usuario.setEdad(sc.nextInt());
        
        sc.nextLine(); //limpiar despues del int
        
        System.out.println("Ingrese el hobbie del usuario");
        usuario.setHobbie(sc.nextLine());
        
        System.out.println("Ingrese sistema operativo que usa el usuario");
        usuario.setSistema_operativo(sc.nextLine());
        
        System.out.println("Ingrese el editor de codigo favorito del usuario");
        usuario.setEditor_favorito(sc.nextLine());
        
        System.out.println("Datos completados!\n\n\n");
        System.out.println(usuario.getDatosUsuario());
    }
    
}
