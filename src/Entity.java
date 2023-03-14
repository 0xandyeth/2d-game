import java.awt.*;

public class Entity {
    // player, monster etc
    public  int worldX;
    public  int worldY;
    public  int speed;

    public  int spriteCounter = 0;
    public  int spriteNumber = 1;
    public Rectangle solidArea; // solid part inside character , x,y,width,height
    public boolean collison = false;

    public  String direction;
}
