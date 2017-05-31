
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebas
 */
public class main  extends JFrame{
    public static ArrayList<Pokemon> read() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("movimientos.txt"));
        ArrayList<Movimiento> Movimientos= new ArrayList<Movimiento>();
        try {
            
            String line = br.readLine();
            String[] datos;
            while (line != null) {
                datos = line.split(",");
                int DMG = Integer.parseInt(datos[1]);
                Movimientos.add(new Movimiento(datos[0],DMG,datos[2]));
                line = br.readLine();
                
            }
        } finally {
            br.close();
        }    
        BufferedReader brp = new BufferedReader(new FileReader("pokemones.txt"));
        ArrayList<Pokemon> Pokemones= new ArrayList<Pokemon>();
        try {
            String linea = brp.readLine();
            while (linea != null) {
                String[] datos = linea.split(",");
                
                int ID =Integer.parseInt(datos[0]);
                Movimiento[] movimientos= new Movimiento[4];
                for(int i=0;i<Movimientos.size();i++){
                    if(datos[7].equals(Movimientos.get(i).getNombre())){
                        movimientos[0]=Movimientos.get(i);
                    }
                    if(datos[8].equals(Movimientos.get(i).getNombre())){
                        movimientos[1]=Movimientos.get(i);
                    }
                    if(datos[9].equals(Movimientos.get(i).getNombre())){
                        movimientos[2]=Movimientos.get(i);
                    }
                    if(datos[10].equals(Movimientos.get(i).getNombre())){
                        movimientos[3]=Movimientos.get(i);
                    }
                    
                }
                int ATK =Integer.parseInt(datos[4]);
                int DEF =Integer.parseInt(datos[5]);
                int HP =Integer.parseInt(datos[6]);
                Pokemones.add(new Pokemon(ID,datos[1],datos[2],datos[3],ATK,DEF,HP,movimientos[0],movimientos[1],movimientos[2],movimientos[3]));
                linea = brp.readLine();
                
            }

        } finally {
            brp.close();
        }    
        return Pokemones;
    }
    public static void main(String[] args) throws IOException {
       
        ArrayList<Pokemon> Pokemones = read();
        Seleccion frame = new Seleccion(Pokemones);
        frame.Pintar();
//        java.util.Scanner a= new java.util.Scanner(System.in);
//        boolean again=true;
//        while (again){
//        System.out.println("Cual Pokemon desea el jugador 1?");
//        for(int i=0;i<Pokemones.size();i++){
//            System.out.println("("+(i+1)+")"+Pokemones.get(i).getNombre());
//        }
//        int eleccion = a.nextInt();
//        Pokemon pokemon1=Pokemones.get(eleccion-1);
//        System.out.println("Cual Pokemon desea el jugador 2 ?");
//        for(int i=0;i<Pokemones.size();i++){
//            System.out.println("("+(i+1)+")"+Pokemones.get(i).getNombre());
//        }
//        int eleccion2=a.nextInt();
//        Pokemon pokemon2= Pokemones.get(eleccion2-1);
//        Batalla battle= new Batalla(pokemon1,pokemon2);
//        battle.letsPlay();
//        System.out.println("Desea Jugar otra vez ?");
//        int data=a.nextInt();
//           if(data==0){
//               again=false;
//           } 
//        }
          
    }
}
