 
package iflappy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class iflappy_Main {
    
    JFrame window ; 
    Timer timer ;
    

    public iflappy_Main() { 
        
        window  =  new JFrame();
        window.setSize(600, 800);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("iFlappy");
        window.setLocationRelativeTo(null);
        //window.setVisible(true);
    }
    
     void display(){
         gameMenu menu  = new gameMenu();
         gamePanel game = new gamePanel();
         
         timer = new Timer(20, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 game.repaint();
                 game.MoveBird();
                   
             }
         });
         
         window.setVisible(true);
         window.add(menu);
         menu.setLayout(null);
         
         while(menu.start  ==  false){
             try {
                 Thread.sleep(10);
                 
             }catch(Exception e){
                 System.out.println("Error");
             }
             
         }
         //System.out.println(""+menu.start);
         window.remove(menu);
         window.add(game);
         game.setVisible(true);
         window.revalidate();
         timer.start();
         
     } 
         
    
    
    public static void main(String[] args) {
        iflappy_Main flappy = new iflappy_Main();
        
        flappy.display(); 
    }
    
}
