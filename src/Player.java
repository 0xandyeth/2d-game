
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;

    public  Player(GamePanel gp,KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2 -(gp.tileSize/2);
        screenY = gp.screenHeight/2 -(gp.tileSize/2);
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImages();

    }

    public  void getPlayerImages(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void setDefaultValues(){
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction="up";
    }

    public void update(){
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed == true){
                direction ="up";
                worldY -= speed;

            } else if (keyH.downPressed) {
                direction ="down";
                worldY += speed;
            } else if (keyH.leftPressed) {
                direction ="left";
                worldX -= speed;

            } else if (keyH.rightPressed) {
                direction ="right";
                worldX += speed;

            }
//            collison = false;
//            gp.collisonChecker.checkTile(this);
//            if(collison ==false){
//                switch (direction){
//                    case "up":
//                        y -= speed;
////                        if(y == 0){
////                            y +=speed;
////                        }
//                        break;
//                    case "down":
//                        y += speed;
////                        if(y == gp.screenHeight){
////                            y -=speed;
////                        }
//                        break;
//                    case "left":
//                        x -= speed;
////                        if(x == 0){
////                            x += speed;
////                        }
//                        break;
//                    case "right":
//                        x += speed;
////                        if(x == gp.screenWidth){
////                            x -=speed;
////                        }
//                        break;
//                }
//            }


            spriteCounter++;
            if(spriteCounter >10){
                if(spriteNumber ==1){
                    spriteNumber =2;
                } else if (spriteNumber ==2) {
                    spriteNumber =1;

                }
                spriteCounter =0;
            }
        }

    }

    public  void draw(Graphics2D graphics2D){
       // graphics2D.setColor(Color.white);
        //graphics2D.fillRect(x,y,gp.tileSize,gp.tileSize);
        BufferedImage image = null;
        switch (direction){
            case "up":
                if(spriteNumber == 1){
                    image = up1;

                } else if (spriteNumber ==2) {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNumber == 1){
                    image = down1;

                } else if (spriteNumber ==2) {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNumber == 1){
                    image = left1;

                } else if (spriteNumber ==2) {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNumber == 1){
                    image = right1;

                } else if (spriteNumber ==2) {
                    image = right2;
                }
                break;

        }
        graphics2D.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
    }
}
