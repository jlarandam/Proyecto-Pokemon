/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebas
 */
public class Pokemon {
   private int ID;
   private String Nombre;
   private String Tipo;
   private String Naturaleza;
   private int ATK;
   private int DEF;
   private int HP;
   public  Movimiento[] movimientos;

    public Pokemon(int ID, String Nombre, String Tipo, String Naturaleza,  int ATK, int DEF, int HP, Movimiento movimiento1, Movimiento movimiento2, Movimiento movimiento3, Movimiento movimiento4) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Naturaleza = Naturaleza;
        this.ATK = ATK;
        this.DEF = DEF;
        this.HP = HP;
        this.movimientos = new Movimiento[4];
        movimientos[0]=movimiento1;
        movimientos[1]=movimiento2;
        movimientos[2]=movimiento3;
        movimientos[3]=movimiento4;
    }
   
   
   public void showInfo(){
       
   }

    @Override
    public String toString() {
        return "Pokemon{" + "ID=" + ID + ", Nombre=" + Nombre + ", Tipo=" + Tipo + ", Naturaleza=" + Naturaleza + ", ATK=" + ATK + ", DEF=" + DEF + ", HP=" + HP + '}';
    }
   public void newMote(String Mote){
       this.Nombre=Mote;
   } 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getNaturaleza() {
        return Naturaleza;
    }

    public void setNaturaleza(String Naturaleza) {
        this.Naturaleza = Naturaleza;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }
    
    public String getImagenFrente(){
        return Nombre+"-Frente.png";
    }
    
    public String getImagenEspalda(){
        return Nombre+"-Espalda.png";
    }
    
   
   
}
