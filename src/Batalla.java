/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.sun.java.accessibility.util.EventID.MOUSE;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author sebas
 */
public class Batalla extends JFrame {
    int vida1;
    int vida2;
    Pokemon pokemon1;
    Pokemon pokemon2;
    int turno=0;
    int fase=1;
    int mov;
    int desX=0;
    int desY=0;
    
    
    public Batalla(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1=pokemon1;
        this.pokemon2=pokemon2;
        this.vida1=pokemon1.getHP();
        this.vida2=pokemon2.getHP();
        add(new PanelBatalla(pokemon1,pokemon2));
    }
    public void letsPlay(){
            Batalla bt = new Batalla(pokemon1,pokemon2);
            bt.setTitle("Pokemon Amethyst- Batalla");
            bt.setSize(900,735);
            bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            bt.setLayout(null);
//            JButton jp1 = new JButton("Boton 1");
//            //jp1.setBounds(10, 10, 1, 5);
//            bt.add(jp1);
            //jp1.setBounds(300,300,100,150);
            
            //JLabel label = new JLabel("nida");
//            JButton button = new JButton();
//            button.setText("fjdls");
//            bt.add(button);
            //bt.add(label);
//            bt.setLayout(new BorderLayout());
//            JPanel sP = new JPanel(new GridLayout(2,2));
//            bt.add(sP,BorderLayout.CENTER);
            bt.setVisible(true);
            
//            System.out.println("HP de "+pokemon1.getNombre()+" = "+vida1);
//            System.out.println("HP de "+pokemon2.getNombre()+" = "+vida2);
//            while((vida1>0)&&(vida2>0)){
//                java.util.Scanner a=new java.util.Scanner(System.in);
//                System.out.println("Que deberia hacer "+pokemon1.getNombre());
//                int i = a.nextInt();
//                Movimiento move= pokemon1.getMovimientos()[i-1];
//                System.out.println(pokemon1.getNombre()+ " uso "+move.getNombre());
//                vida2=vida2-calcularDMG(move);
//                if(vida2>0){
//                    System.out.println("HP de "+pokemon2.getNombre()+" = "+vida1);
//                }
//                else{
//                    System.out.println("HP de "+pokemon2.getNombre()+" = 0 ");
//                }
//                turno++;
//                if(vida2<0){
//                    break;
//                }
//                System.out.println("Que deberia hacer "+pokemon2.getNombre());
//                i = a.nextInt();
//                move= pokemon2.getMovimientos()[i-1];
//                System.out.println(pokemon2.getNombre()+ " uso "+move.getNombre());
//                vida1=vida1-calcularDMG(move);
//                if(vida1>0){
//                    System.out.println("HP de "+pokemon1.getNombre()+" = "+vida1);
//                }
//                else{
//                    System.out.println("HP de "+pokemon1.getNombre()+" = 0 ");
//                }
//                turno++;
//            }
//            System.out.println("La batalla ha terminado");
//            if(vida1<0){
//                System.out.println(pokemon2.getNombre()+" Ha ganado");
//            }
//            if(vida2<0){
//                System.out.println(pokemon1.getNombre()+" Ha ganado");
//            }
        }
    
    
    public class PanelBatalla extends JPanel implements ActionListener, MouseListener {
        Timer timer;
        JLabel etiqueta = new JLabel();
        int x=0;
        int y=0;
        
        public PanelBatalla(Pokemon pokemon1,Pokemon pokemon2){
            this.addMouseListener(this);
            timer = new Timer(25,this);
            timer.start();
            addKeyListener(new TAdapter());
            setFocusable(true);
            
        }

        
        private class TAdapter extends KeyAdapter{
            Graphics u;
            @Override
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
               
                    if(key==KeyEvent.VK_1){
                        mov=0;
                        System.out.println("nigs");
                    }
                    if(key==KeyEvent.VK_2){
                       mov =1;
                    }
                    if(key==KeyEvent.VK_3){
                        mov =2;
                    }
                    if(key==KeyEvent.VK_4){
                        mov=3;
                    }
                
                if(key==KeyEvent.VK_ENTER){
                    timer.start();
                }
                if(key==KeyEvent.VK_LEFT){
                    desX-=173;
                }
                if(key==KeyEvent.VK_RIGHT){
                    desX+=173;
                }
                if(key==KeyEvent.VK_DOWN){
                    desY+=50;
                }
                if(key==KeyEvent.VK_UP){
                    desY-=50;
                }
                if(key== KeyEvent.VK_K){
                    //4to ataque
                    if(desX==173&&desY==50){
                        System.out.println("hidcs");
                    }
                    //1er ataque
                    if(desX==0&&desY==0){
                        System.out.println("primero");
                    }
                    //2do ataque
                    if(desX==173&&desY==0){
                        System.out.println("segundo");
                    }
                    //3er ataque
                    if(desX==0&&desY==50){
                        System.out.println("tercero");
                    }
                    turno++;
                    //if(turno%2==0)(primer jugador hace el movimiento)
                    //if(turno%2!=0)(segundo jugador hace movimiento)
                }
            }
        }
        
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Image fondoBatalla = loadImagen("Fondo.png");
            g.drawImage(fondoBatalla, 0, 0, null);
            
            Image poke1 = loadImagen(pokemon1.getNombre()+"-Espalda.png");  
            g.drawImage(poke1, 0, 220, this);

            
            Image poke2 = loadImagen(pokemon2.getNombre()+"-Frente.png");
            g.drawImage(poke2, 530, 105, this);
            
            Image barra = loadImagen("Barra Combate.png");
            g.drawImage(barra, 0, 530, null);
            g.setColor(Color.white);
            Font fuente=new Font("Dialog", Font.BOLD, 36);
            g.drawString("¿Qué debería hacer "+pokemon1.getNombre()+" ?", 100, 590);
            g.drawString("Seleccione la tecla corespondiente al ataque", 100, 620);
            g.drawString("O presione 'k' para escoger el ataque", 100, 640);
            
            Color c=new Color(225, 217, 228);
            Color a=new Color(200, 168, 72);
            g.setColor(a);
            
            g.fillRect(530,560, 100, 50);
            g.fillRect(700,560, 100, 50);
            g.fillRect(530,615, 100, 50);
            g.fillRect(700,615, 100, 50);
            
            
            g.setColor(a);
            
            
            Image fS = loadImagen("FSel.png");
            g.drawImage(fS, desX+467, desY+567, null);
            
            g.setColor(Color.red);
            
            //g.fillRect(desX+430, desY+560, 100, 50);
            
            g.setColor(Color.black);
            g.drawString("1. "+pokemon1.getMovimientos()[0].getNombre(), 543, 590);
            g.drawString("2. "+pokemon1.getMovimientos()[1].getNombre(), 715, 590);
            g.drawString("3. "+pokemon1.getMovimientos()[2].getNombre(), 550, 645);
            g.drawString("4. "+pokemon1.getMovimientos()[3].getNombre(), 725, 645);
            
            
//            while(vida1>0 && vida2>0){
//               
//                g.setColor(Color.white);
//                g.drawString("¿Qué debería hacer "+pokemon1.getNombre(), 100, 590);
//                timer.stop();
//                mov=-1;
//                while(mov<0 || mov>3){
//                    g.drawImage(fondoBatalla, 0, 0, null);
//                    g.drawImage(poke1, 0, 220, this);
//                    g.drawImage(barra, 0, 530, null);
//                    g.drawString("(1) "+pokemon1.getMovimientos()[0], 100, 590);
//                    g.drawString("(2) "+pokemon1.getMovimientos()[1], 200, 590);
//                    g.drawString("(3) "+pokemon1.getMovimientos()[2], 100, 620);
//                    g.drawString("(4) "+pokemon1.getMovimientos()[3], 200, 620);
//                }
//                vida2=vida2-calcularDMG(pokemon1.getMovimientos()[mov]);
//                g.drawString("HP de "+pokemon2.getNombre()+" reducidos a "+vida2, 100, 590);
//                turno++;
//                g.drawString("¿Qué debería hacer "+pokemon2.getNombre(), 100, 590);
//                timer.stop();
//                mov=-1;
//                while(mov<0 || mov>3){
//                    g.drawImage(fondoBatalla, 0, 0, null);
//                    g.drawImage(poke1, 0, 220, this);
//                    g.drawImage(barra, 0, 530, null);
//                    g.drawString("(1) "+pokemon2.getMovimientos()[0], 100, 590);
//                    g.drawString("(2) "+pokemon2.getMovimientos()[1], 200, 590);
//                    g.drawString("(3) "+pokemon2.getMovimientos()[2], 100, 620);
//                    g.drawString("(4) "+pokemon2.getMovimientos()[3], 200, 620);
//                }
//                vida1=vida1-calcularDMG(pokemon2.getMovimientos()[mov]);
//                g.drawString("HP de "+pokemon2.getNombre()+" reducidos a "+vida2, 100, 590);
//                turno++;
//            }
            repaint();
        }
        
//        public boolean checkCollisions(){
//            Rectangle tanque = getBounds();
//            
//            if(tanque.intersects(objeto)){
//                return true;
//            }
//            else{
//                return false;
//            }
//        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }
        

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }

        private Image loadImagen(String imageName) {
            ImageIcon ii = new ImageIcon(imageName);
            Image image = ii.getImage();
            return image;
        }
        
    }
    public int calcularDMG(Movimiento move){
        int multiplicador=1;
        String tipo1=pokemon1.getTipo();
        String tipo2=pokemon2.getTipo();
        if (turno%2==0){
            if((move.getTipo()=="agua")&&(tipo2=="fuego")){
                multiplicador=2;
            }
            else if((move.getTipo()=="planta")&&(tipo2=="agua")){
                multiplicador=2;
            }
            else if((move.getTipo()=="fuego")&&(tipo2=="planta")){
                multiplicador=2;
            }
            else if((move.getTipo()=="volador")&&(tipo2=="planta")){
                multiplicador=2;
            }
            System.out.println("Multiplicador de daño = "+multiplicador);
            System.out.println(((pokemon1.getATK()*move.getDMG()/20)-pokemon2.getDEF())*multiplicador+" de daño");
            return ((pokemon1.getATK()*move.getDMG()/20)-pokemon2.getDEF())*multiplicador;
        }
        else{
            if((move.getTipo()=="agua")&&(tipo1=="fuego")){
                multiplicador=2;
            }
            else if((move.getTipo()=="planta")&&(tipo1=="agua")){
                multiplicador=2;
            }
            else if((move.getTipo()=="fuego")&&(tipo1=="planta")){
                multiplicador=2;
            }
            else if((move.getTipo()=="volador")&&(tipo1=="planta")){
                multiplicador=2;
            }
            System.out.println(((pokemon2.getATK()*move.getDMG()/20)-pokemon1.getDEF())*multiplicador+" de daño");
            return ((pokemon2.getATK()*move.getDMG()/20)-pokemon1.getDEF())*multiplicador;
        }
    }
    
}

