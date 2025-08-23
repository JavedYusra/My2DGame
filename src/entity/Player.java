package entity; // (only if your Player is in entity package, adjust if different)

import main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.KeyHandler;
import java.awt.Color;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            System.out.println(getClass().getResource("/res/player/boy_down_1.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_2.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update() {

        if (keyH.upPressed) {
            direction = "up";
            y -= speed; // move up
        } else if (keyH.downPressed) {
            direction = "down";
            y += speed; // move down
        } else if (keyH.leftPressed) {
            direction = "left";
            x -= speed; // move left
        } else if (keyH.rightPressed) {
            direction = "right";
            x += speed; // move right
        }
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize , gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
}
