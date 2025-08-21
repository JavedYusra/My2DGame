import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    // screen settings
    final int originalTileSize = 16; // 16 x 16 pixel
    final int scale = 3; // 3x scaling

    final int tileSize = originalTileSize * scale; // 48 x 48 pixel
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //FPS
    int FPS = 60;
    long period = 1000000000 / FPS; // period in nanoseconds
    KeyHandler keyH = new KeyHandler(); // instance of KeyHandler to handle key events
    Thread gameThread; // thread for game loop

    // players default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    // Constructor

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setFocusable(true); // allows the panel to receive key events
        // Add KeyListener here if needed, e.g., new KeyHandler()
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); // starts the game loop
    }
     
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; // in nanoseconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) {
          
            //1. UPDATE INFORMATION SUCH AS PLAYER POSITION
            update();
            //2. DRAW SCREEN USING UPDATE INFORMATION

            repaint(); //its confusing but you call paintcomponent() like this
            

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000; // convert to milliseconds
                if(remainingTime < 0) remainingTime = 0;

                Thread.sleep((long) remainingTime); // convert to milliseconds

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        if(keyH.upPressed) {
            playerY -= playerSpeed; // move up
        }
        else if(keyH.downPressed) {
            playerY += playerSpeed; // move down
        }
        else if(keyH.leftPressed) {
            playerX -= playerSpeed; // move left
        }
        else if(keyH.rightPressed) {
            playerX += playerSpeed; // move right
        }
    }
// paintcomponenet is like pen or brush to draw sth
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the game elements here
        Graphics2D g2 = (Graphics2D) g; // cast to Graphics2D for more control
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize , tileSize);
        g2.dispose(); // release resources
    }
}