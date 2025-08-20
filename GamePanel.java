import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{

    // screen setting
    final int originalTileSize = 16; // it means 16 x 16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48 x 48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 px
    final int screenHeight = tileSize * maxScreenRow; // 576 px
    KeyHandler keyH = new KeyHandler();

    Thread gameThread;

    // set player position
    int playerX = 100;
    int playerY = 100;

    int playerSpeed  = 4;
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true); // it means this panel can receive key events
        

    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();  
    }
    @Override
    public void run() {
        //game loop
        while(gameThread != null){
            // System.out.println("The Game loop is running ");
            // 1. update information for example players position
            update();
            // 2. draw the screen based on the updated information
            repaint(); // its confusing but thats how you call paintComponent method in java

        }
    }

    public void update(){
        if(keyH.upPressed == true) {
            playerY -= playerSpeed; // in java y value decreases as you go up
        }
        else if(keyH.downPressed == true) { // in java y value increases as you go down
            playerY += playerSpeed;
        }
        else if(keyH.leftPressed == true) {
            playerX -= playerSpeed;
        }
        else if(keyH.rightPressed == true) {
            playerX += playerSpeed;
        }

    }

    // paintComponent is statndard methods in java means buildin method to draw things on screen
    // its like our pencil or brush to draw sth
    public void paintComponent(Graphics g){
        // graphics is a class that has many functions to draw on screen
        
        super.paintComponent(g);    // calls tha parent class to work on screen

        Graphics2D g2 = (Graphics2D) g; // we can use Graphics2D to draw more complex shapes

        g2.setColor(Color.WHITE);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose(); //dispose  is like closing a file after reading/writing on it

    }
}
