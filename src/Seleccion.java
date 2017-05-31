
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebas
 */
public class Seleccion extends JFrame {
    public ArrayList<Pokemon> pokemones;
    public ArrayList<Pokemon> seleccionados=new ArrayList();
    
    public Seleccion(ArrayList<Pokemon> Pokemones){
        this.pokemones=Pokemones;
        add(new PanelSeleccion(pokemones));
    }
    
   public void Pintar() {
        Seleccion frame = new Seleccion(pokemones);
        frame.setTitle("Pokemon Amethyst- Seleccion");
        frame.setSize(900,735);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    public class PanelSeleccion extends JPanel  implements ActionListener {
    Timer timer;
    int i=0;
    int j=0;
    
    
    public PanelSeleccion(ArrayList<Pokemon> Pokemones){
        timer = new Timer(25, this);
        timer.start();
        addKeyListener(new TAdapter());
        setFocusable(true);
    }

        
        private class TAdapter extends KeyAdapter{
            Graphics u;
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_RIGHT){
                    if(i<pokemones.size()){
                        if((i+1)==pokemones.size()){
                            i=0;
                        }
                        else{
                            i++;
                        }
                    }
                    
                }
                if(key == KeyEvent.VK_LEFT){
                    if(i==0){
                        i=pokemones.size()-1;
                    }
                    else{
                        i--;
                    }
                }
                if(key==KeyEvent.VK_ENTER){
                    seleccionados.add(pokemones.get(i));
                    if(seleccionados.size()==2){
                        
                        
                        Batalla batalla= new Batalla(seleccionados.get(0),seleccionados.get(1));
                        batalla.letsPlay();
                    }
                }
            }
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Image fondoSeleccion = loadImage("FondoSeleccion.jpg");
            g.drawImage(fondoSeleccion,0,0,null);
            
            String imagenpkmn=pokemones.get(i).getImagenFrente();
            Image PokemonImagen= loadImage(imagenpkmn);
            g.drawImage(PokemonImagen, 300, 200, this);
            
            
           
            repaint();
            g.setColor(Color.white);
            g.drawString("¿Qué pokemon desea escoger?", 350, 150);
            Image fD=loadImage("FD.png");
            g.drawImage(fD, 590, 330, null);
            
            Image fI = loadImage("FI.png");
            g.drawImage(fI, 180, 330,null);
            
            g.drawString("Presione ENTER para seleccionar el pokemon", 317, 500);
            
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
        public Image loadImage(String imageName){
                ImageIcon ii = new ImageIcon(imageName);
                Image image = ii.getImage();
                return image;
        }
    }
}

