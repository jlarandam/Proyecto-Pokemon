/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pokemon;
import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
/**
 *
 * @author Koonda15
 */
public class ProyectoPokemon extends JFrame{
    public ProyectoPokemon(){
        add(new Panel());
    }
    public static void main(String[] args) {
        ProyectoPokemon frame = new ProyectoPokemon();
        frame.setTitle("Pokemon Cuarzo");
        frame.setSize(900,735);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new BorderLayout());
        
//        JPanel southPanel = new JPanel (new GridLayout(2,2));
//        for(int i=1; i<=4;i++){
//            frame.add(new JButton("button " + i));
//        }
//        frame.add(southPanel, BorderLayout.CENTER);
//        frame.pack();
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        frame.setLocation(dim.width/2-frame.getSize().width/2, 
//                dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }
    
    public class Panel extends JPanel implements ActionListener{
        private int x=0;
        private int y=0;
        private int j=0;
        private int k=0;
        private int q=-20000;
        private Timer timer;
        private int secuencia =0;
        
        public Panel(){
            timer = new Timer(25, this);
            addKeyListener(new TAdapter());
            setFocusable(true);
            timer.start();
        }
        
        private class TAdapter extends KeyAdapter{
            Graphics u;
            public void keyReleased(KeyEvent e){
                System.out.println("Tecla soltada");
            }
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_RIGHT){
                    System.out.println("tecla presionada");
                    j+=129450;
                    System.out.println(j);
                }
//                if(key == KeyEvent.VK_RIGHT){
//                    //Panel.remove();
//                    Image opcion= loadImage("Combate opcion.png");
//                    u.drawImage(opcion, x, y, null);
//                }
            }
            
        }
        
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Image fondo = loadImage("Fondo.png");
            g.drawImage(fondo,j,k,null);
            
            Image poke1 = loadImage("Blastoise-Espalda.png");
            g.drawImage(poke1, j+0, k+220, rootPane);
            Image poke2 = loadImage("Charizard-Frente.png");
            g.drawImage(poke2, j+530, k+105, null);
            
            Image barra = loadImage("Barra Combate.png");
            g.drawImage(barra, j, k+530, null);
            //g.setFont();
            g.setColor(Color.white);
            g.drawString("¿Qué debería hacer charizard?", 100, 590);
//            Font font = new Font("Verdana", Font.BOLD, 78329573);
//            g.drawString("LUCHA", 600, 580);
            //g.fillRect(x+500, y+500, 100, 100);
            
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        public Image loadImage(String imageName){
                ImageIcon ii = new ImageIcon(imageName);
                Image image = ii.getImage();
                return image;
            }
    }
    
    
}
