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
public abstract class Person {
    protected String nombre;
    protected String apellido;
    protected String salario;

    public Person(String nombre, String apellido, String salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }
    
    public abstract void showInfo();
}
