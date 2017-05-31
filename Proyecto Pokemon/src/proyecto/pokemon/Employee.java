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
public class Employee extends Person{
    protected String oficina;
    protected String fechaContratación;
    
    public Employee(String nombre, String apellido, String salario) {
        super(nombre, apellido, salario);
        this.oficina=oficina;
        this.fechaContratación=fechaContratación;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getFechaContratación() {
        return fechaContratación;
    }

    public void setFechaContratación(String fechaContratación) {
        this.fechaContratación = fechaContratación;
    }
    
    

    @Override
    public void showInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
