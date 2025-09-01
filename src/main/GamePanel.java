package main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;


import javax.swing.JPanel;
import entity.Player;
import object.SuperObject;
import tile.TileManager;



public class GamePanel extends JPanel implements Runnable {

    // screen settings
    final int originalTileSize = 16; // 16 x 16 pixel
    final int scale = 3; // 3x scaling

    public int tileSize = originalTileSize * scale; // 48 x 48 pixel
    public int maxScreenCol = 16;
    public int maxScreenRow = 12;

    public int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // World setting
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    // public  int worldWidth = tileSize * maxWorldCol;
    // public  int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;
   
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(); // instance of KeyHandler to handle key events
    Sound sound = new Sound();
    Thread gameThread; // thread for game loop
    public CollisionChecker checker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);


    //entity and object
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];


    // // players default position
    // int playerX = 100;
    // int playerY = 100;
    // int playerSpeed = 4;
    // Constructor

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setFocusable(true); // allows the panel to receive key events
        // Add KeyListener here if needed, e.g., new KeyHandler()
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setObject();
        playMusic(0);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); // starts the game loop
    }
     //SLEEP METHOD 
    @Override
    // public void run() {
    //     double drawInterval = 1000000000/FPS; // in nanoseconds
    //     double nextDrawTime = System.nanoTime() + drawInterval;

    //     while(gameThread != null) {
          
    //         //1. UPDATE INFORMATION SUCH AS PLAYER POSITION
    //         update();
    //         //2. DRAW SCREEN USING UPDATE INFORMATION

    //         repaint(); //its confusing but you call paintcomponent() like this
            

    //         try {
    //             double remainingTime = nextDrawTime - System.nanoTime();
    //             remainingTime = remainingTime/1000000; // convert to milliseconds
    //             if(remainingTime < 0) remainingTime = 0;

    //             Thread.sleep((long) remainingTime); // convert to milliseconds

    //             nextDrawTime += drawInterval;
    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }

    // DELTA/ACCUMULATOR METHOD
    public void run(){
        double drawInterval = 1000000000/FPS; // in nanoseconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if(delta>=1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer>=100000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        player.update();
    }
// paintcomponenet is like pen or brush to draw sth
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the game elements here
        Graphics2D g2 = (Graphics2D) g; // cast to Graphics2D for more control
        //tile
        tileM.draw(g2);
        //object
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }
        //player
        player.draw(g2);
        g2.dispose(); // release resources
    }

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();

    }

    public void stopMusic(){
        sound.stop();
    }
    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }

    
}