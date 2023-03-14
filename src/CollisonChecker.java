public class CollisonChecker {

    GamePanel  gp;
    public  CollisonChecker(GamePanel gp){
        this.gp = gp;
    }

//    public  void checkTile(Entity entity){
//        int entityLeftX = entity.x + entity.solidArea.x;
//        int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
//        int entityTopY = entity.y + entity.solidArea.y;
//        int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;
//
//        int entityLeftCol = entityLeftX /gp.tileSize;
//        int entityRightCol = entityRightX / gp.tileSize;
//        int entityTopRow = entityTopY / gp.tileSize;
//        int entityBottomRow = entityBottomY/ gp.tileSize;
//
//         int tileNum1,tileNum2;
//        switch (entity.direction){
//            case "up":
//                entityTopRow = (entityTopRow - entity.speed)/gp.tileSize;
//                tileNum1 = gp.tileManager.tileNumbers[entityLeftCol][entityTopRow];
//                tileNum2 = gp.tileManager.tileNumbers[entityRightCol][entityTopRow];
//                if(gp.tileManager.titles[tileNum1].collison == true || gp.tileManager.titles[tileNum2].collison == true){
//                    entity.collison = true;
//                }
//                break;
//            case "down":
//                entityBottomRow = (entityBottomRow + entity.speed)/gp.tileSize;
//                tileNum1 = gp.tileManager.tileNumbers[entityLeftCol][entityBottomRow];
//                tileNum2 = gp.tileManager.tileNumbers[entityRightCol][entityBottomRow];
//                if(gp.tileManager.titles[tileNum1].collison == true || gp.tileManager.titles[tileNum2].collison == true){
//                    entity.collison = true;
//                }
//                break;
//            case "left":
//                entityLeftCol = (entityLeftCol - entity.speed)/gp.tileSize;
//                tileNum1 = gp.tileManager.tileNumbers[entityLeftCol][entityTopRow];
//                tileNum2 = gp.tileManager.tileNumbers[entityLeftCol][entityBottomRow];
//                if(gp.tileManager.titles[tileNum1].collison == true || gp.tileManager.titles[tileNum2].collison == true){
//                    entity.collison = true;
//                }
//                break;
//            case "right":
//                entityRightCol = (entityRightCol + entity.speed)/gp.tileSize;
//                tileNum1 = gp.tileManager.tileNumbers[entityRightCol][entityTopRow];
//                tileNum2 = gp.tileManager.tileNumbers[entityRightCol][entityBottomRow];
//                if(gp.tileManager.titles[tileNum1].collison == true || gp.tileManager.titles[tileNum2].collison == true){
//                    entity.collison = true;
//                }
//                break;
//        }
//    }
}
