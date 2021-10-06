import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;

public class Game {
    private static Levels level;
    public static void startGame(Screen screen){

        level = new Levels();


        int num = level.getNumEnemy();
        Enemy eList[] = new Enemy[num];
        for(int i = 0; i < num; i++){
            int x = level.enemyPos[i][0];
            int y = level.enemyPos[i][1];
            eList[i] = new Enemy(x, y, level, screen);
            eList[i].start();
        }

        level.PrintMap(screen);


        boolean stop = false;
        while(!stop){
            Key key = screen.readInput();
            while(key == null){
                key = screen.readInput();
            }

            switch(key.getKind()){
                case Escape:
                    stop = true;
                    break;
                case ArrowRight:
                    if(validMove("right")){
                        level.movePlayerRight();
                    }
                    level.PrintMap(screen);
                    break;

                case ArrowLeft:
                    if(validMove("left")){
                        level.movePlayerLeft();
                    }
                    level.PrintMap(screen);
                    break;

                case ArrowDown:
                    if(validMove("down")){
                        level.movePlayerDown();
                    }
                    level.PrintMap(screen);
                    break;

                case ArrowUp:
                    if(validMove("up")){
                        level.movePlayerUp();
                    }
                    level.PrintMap(screen);
                    break;
            }

            for(Enemy e: eList){

                e.attack();
            }

            if(level.getPlayerHealth() <= 0){
                stop = true;
            }
        }


        for(Enemy e: eList){
            e.interrupt();
        }

        try { Thread.sleep(200);
        } catch (InterruptedException e) {}

    }


    public static boolean validMove(String move){
        int posX = level.getPlayerX();
        int posY = level.getPlayerY();
        int maxX = level.getMaxX();
        int maxY = level.getMaxY();

        if(move.equals("right")){
            if(posX < maxX && !level.getStringAt(posX + 1, posY).equals("#")){
                return true;
            }
            return false;
        }
        else if(move.equals("left")){
            if(posX > 0 && !level.getStringAt(posX - 1, posY).equals("#")){
                return true;
            }
            return false;
        }
        else if(move.equals("down")){
            if(posY < maxY && !level.getStringAt(posX, posY + 1).equals("#")){
                return true;
            }
            return false;
        }
        else{
            if(posY > 0 && !level.getStringAt(posX, posY - 1).equals("#")){
                return true;
            }
            return false;
        }
    }
}