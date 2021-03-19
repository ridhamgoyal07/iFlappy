package iflappy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

public class piller {

    

    Random rand = new Random();
    public  int X;
    public int gap = 200;
    public  int Y = rand.nextInt(gamePanel.HEIGHT - 300) + 200;// max 600 min 200
    private int piller_width = 70;
    private int height = gamePanel.HEIGHT - Y;
   
    public static  int speed = -6;

    public BufferedImage upper, buttom;

    piller(int x) {

        this.X = x;
        loadImage();

    }

    private void loadImage() {
        try {
            upper = ImageIO.read(new File("E://iflappy//src//images//upperpiller.png"));
            buttom = ImageIO.read(new File("E://iflappy//src//images//bottomPiller.png"));
        } catch (Exception e) {
            System.out.println("Error in pillers");
        }
    }

    public void drawPiller(Graphics g) {

        g.drawImage(buttom, X, Y, null);
        g.drawImage(upper, X, (-gamePanel.HEIGHT) + (Y - gap), null);
    }

    public void wall_Movement()  {
        X += speed;

        if (X <= -piller_width) {

            X = gamePanel.WIDTH;
            Y = rand.nextInt(gamePanel.HEIGHT - 300) + 200;
            height = gamePanel.HEIGHT - Y;

        }

    

    Rectangle lowerpiller = new Rectangle(X, Y, piller_width, height);
    Rectangle upperpiller = new Rectangle(X, 0, piller_width, gamePanel.HEIGHT  -height - gap);
    
    if(lowerpiller.intersects(bird.getBirdRect()) || upperpiller.intersects(bird.getBirdRect())){
        try { 
            Thread.sleep(500);
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
        bird.reset();
        wallReset();
        gamePanel.score=0;
    
    }
    
    }
    private  void wallReset() {
        Y = rand.nextInt(gamePanel.HEIGHT - 300) + 200;
        height = gamePanel.HEIGHT - Y;
        gamePanel.GameOver = true ;
    }
}