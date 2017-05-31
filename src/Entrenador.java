
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebas
 */
public class Entrenador {
    private String nombre;
    private boolean sexo;
    private int wins;
    private int loses;
    private ArrayList<Pokemon> pokemones;

    public void showPerfil() {
        System.out.println ( "Entrenador{" + "nombre=" + nombre + ", sexo=" + sexo + ", wins=" + wins + ", loses=" + loses + '}');
    }
    public void showPokemon(){
        for(int i=0;i < pokemones.size();i++){
            System.out.println(pokemones.get(i).getNombre());
        }
    } 
    
    
}
