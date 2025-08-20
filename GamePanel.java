import java.awt.Color;
import java.awt.Dimension;

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
    
    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        

    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();  
    }
    @Override
    public void run() {
        //game loop
        while(gameThread != null){
            System.out.println("The Game loop is running ");
        }
    }
}
