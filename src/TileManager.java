import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tile[] titles;
    int tileNumbers[][] ;

    public  TileManager(GamePanel gp){
        this.gp = gp;
        this.titles = new Tile[10];
        this.tileNumbers = new int[gp.maxWorldCol][gp.maxWorldRow];
        this.getImageTile();
        this.loadMap("/res/maps/world01.txt");
    }

    public  void loadMap(String filepath){
        try{
            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col =0;
            int row = 0;
            while(col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();
                while (col <gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    tileNumbers[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public  void getImageTile(){
        try{
            titles[0] = new Tile();
            titles[0].image =ImageIO.read(getClass().getResourceAsStream("/res/tile/grass.png"));
            titles[1] = new Tile();
            titles[1].collison = true;
            titles[1].image =ImageIO.read(getClass().getResourceAsStream("/res/tile/wall.png"));
            titles[2] = new Tile();
            titles[2].collison = true;
            titles[2].image =ImageIO.read(getClass().getResourceAsStream("/res/tile/water.png"));
            titles[3] = new Tile();
            titles[3].collison = true;
            titles[3].image =ImageIO.read(getClass().getResourceAsStream("/res/tile/earth.png"));
            titles[4] = new Tile();
            titles[4].collison = true;
            titles[4].image =ImageIO.read(getClass().getResourceAsStream("/res/tile/tree.png"));
            titles[5] = new Tile();
            titles[5].image =ImageIO.read(getClass().getResourceAsStream("/res/tile/sand.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public  void draw(Graphics2D graphics2D){
      int worldCol = 0;
      int worldRow = 0;

      while(worldCol <gp.maxWorldCol && worldRow <gp.maxWorldRow){
          int number = tileNumbers[worldCol][worldRow];
          int worldX = worldCol * gp.tileSize;
          int worldY = worldRow * gp.tileSize;
          int screenX = worldX - gp.player.worldX + gp.player.screenX;
          int screenY = worldY - gp.player.worldY + gp.player.screenY;
          if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
             worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                  worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                  worldY - gp.tileSize< gp.player.worldY + gp.player.screenY
          ){
              graphics2D.drawImage(titles[number].image,screenX,screenY,gp.tileSize, gp.tileSize, null);

          }
          worldCol++;
          if(worldCol == gp.maxScreenCol){
              worldCol = 0;
              worldRow++;
          }
      }
    }


    
}
