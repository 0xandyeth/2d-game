
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

     // Scree setting
   public final int originalTileSize = 16; // 16*16
   public final int scale = 3;
    public final int tileSize = originalTileSize * scale;

    // how many tiles display in screen
    public  final int maxScreenCol = 16;
    public final int maxScreenRow = 12;

    public final  int FPS = 60;

    public final int screenWidth = tileSize * maxScreenCol;
    public  final int screenHeight = tileSize * maxScreenRow;

    // world map setting
    public final  int maxWorldCol = 50;
    public final  int maxWorldRow = 50;
    public  final  int worldWidth = tileSize * maxWorldCol;
    public final  int worldHeight = tileSize * maxWorldRow;
     KeyHandler  keyH = new KeyHandler();
    // thread ( withdrawing screen 60 times per second )
    Thread gameThread;
    TileManager tileManager = new TileManager(this);
    public Player player = new Player(this,keyH);
    CollisonChecker collisonChecker = new CollisonChecker(this);
    //set player's default positions
    int playX = 100;
    int playY = 100;
    int playSpeed = 4;

    // create constructor
    public  GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        setBackground(Color.black);
        setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void  startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

//    @Override
//    public void run() {
//         // while gameThread exist, the task repeats
//         double drawInterval = 1000000000/FPS; // 0.0166 second draw screen 60 times
//         double nextDrawTime = System.nanoTime() + drawInterval;
//         while(gameThread != null){
//            //System.out.println("game loop is running");
//             long currenTime = System.nanoTime(); // system time
//             long currentTime1 = System.currentTimeMillis();
//             //1 Update: update the information such as character position
//             update();
//             //2. Draw: draw the screen with updated information
//             repaint();
//             try{
//                 double remainingTime = nextDrawTime - System.nanoTime();
//                 remainingTime = remainingTime/1000000;
//                 if(remainingTime <0){
//                     remainingTime = 0;
//                 }
//                 // sleep screen in remaining time
//                 Thread.sleep((long) remainingTime);
//                 nextDrawTime += drawInterval;
//             }catch (InterruptedException e){
//                 e.printStackTrace();
//             }
//
//         }
//    }

     public  void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer  =0;
        int drawCount = 0;
        while (gameThread !=null){
            currentTime = System.nanoTime();

            delta +=(currentTime - lastTime)/drawInterval;
            timer = (currentTime -lastTime);
            lastTime = currentTime;
            if(delta >=1){
                update();
                repaint();
                delta --;
                drawCount ++;
            }

            if(timer >=1000000000){
                System.out.println(drawCount);

            }


        }
     }
    public  void update(){
       player.update();
    }

    public  void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D =(Graphics2D)g;
        tileManager.draw(graphics2D);
        player.draw(graphics2D);
        graphics2D.dispose();

    }
}
