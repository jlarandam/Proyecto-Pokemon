/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pokemon;

/**
 *
 * @author Koonda15
 */
public class Faculty extends Employee{
    private String rango;

    public Faculty(String nombre, String apellido, String salario) {
        super(nombre, apellido, salario);
        this.rango=rango;
    }
    
    public void showInfo(){
        System.out.println("");
    }
    
}
