package iflappy;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class gamePanel extends JPanel {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 700;

    private int xCor = 0;
    private BufferedImage img = null;
    public static int score = 0;
    public static boolean GameOver = false;

    bird Bird = new bird();   //// bird  object
    piller pillerWall = new piller(gamePanel.WIDTH);
    piller pillerWall2 = new piller(gamePanel.WIDTH + (gamePanel.WIDTH / 2 + 30));

    public gamePanel() {

        loadImage();
//        this.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);
//
//                Bird.goupward();
//
//            }
//        });
        this.addKeyListener(new KeyListener() {

            public void keyPressed(KeyEvent ke) {
                 
                if (ke.getKeyChar()== 'a') {

                    Bird.goupward();
                    //call your method
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    private void loadImage() {
        try {
            img = ImageIO.read(new File("E://iflappy//src//images//gamepanelBG.png"));
        } catch (Exception e) {
            System.out.println(""
                    + "Some Error to load menu image");
        }

    }

    public void paint(Graphics g) {

        super.paint(g);
        g.drawImage(img, xCor, 0, null);

        g.drawImage(img, xCor + 1400, 0, null);

        Bird.drawBird(g);
        pillerWall.drawPiller(g);
        pillerWall2.drawPiller(g);

        // g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 28));
        g.drawString("Score " + score, 250, 100);

    }

    public void MoveBird() {
        Bird.birdMovement();
        pillerWall.wall_Movement();
        pillerWall2.wall_Movement();
        if (GameOver) {
            pillerWall.X = gamePanel.WIDTH;
            pillerWall2.X = gamePanel.WIDTH + (gamePanel.WIDTH / 2 + 30);
            GameOver = false;

        }
        xCor += piller.speed;
        if (xCor == -1398) {
            xCor = 0;

        }
        if (pillerWall.X == bird.x || pillerWall.Y == bird.y) {
            score += 1;

        }
        if (pillerWall2.X == bird.x || pillerWall2.Y == bird.y) {
            score += 1;

        }
    }
}
