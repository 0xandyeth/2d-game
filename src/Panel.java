import javax.swing.*;

public class Panel extends JPanel {

    public final int originalTileSize = 16; // 16*16
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale;

    // how many tiles display in screen
    public  final int maxScreenCol = 16;
    public final int maxScreenRow = 12;

    public final  int FPS = 60;

    public final int screenWidth = tileSize * maxScreenCol;
    public  final int screenHeight = tileSize * maxScreenRow;
}
