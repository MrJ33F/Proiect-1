
import com.googlecode.lanterna.screen.Screen;

import java.util.*;
import java.lang.*;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends Thread {
    private int posX;
    private int posY;
    private Levels map;
    private Screen screen;
    private boolean interrupted;
    private String eSprite[][];

    public Enemy(int x, int y, Levels map, Screen sc){
        posX = x;
        posY = y;
        this.map = map;
        screen = sc;
        interrupted = false;
    }

    public void run(){
        eSprite = new String[100][30];
        map.PrintMap(screen);
        while(!interrupted){
            double rand = 0;


            try { Thread.sleep(200);
            } catch (InterruptedException e) {}

            rand = Math.random();
            if(rand > .75){
                moveUp();
            }
            else if(rand > .5){
                moveDown();
            }
            else if(rand > .25){
                moveLeft();
            }
            else{//rand >= 0
                moveRight();
            }
            map.PrintMap(screen);
        }
    }

    public void interrupt(){
        interrupted = true;
    }


    public void moveUp(){
        if(posY > 0 && !map.getStringAt(posX, posY - 1).equals("#")){
            map.setString(" ", posX, posY);
            posY -= 1;
            map.setString("E", posX, posY);
        }
        attack();
    }

    public void moveDown(){
        if(posY + 1 < map.getMaxY() && !map.getStringAt(posX, posY + 1).equals("#")){
            map.setString(" ", posX, posY);
            posY += 1;
            map.setString("E", posX, posY);
        }
        attack();
    }

    public void moveLeft(){
        if(posX > 0 && !map.getStringAt(posX - 1, posY).equals("#")){
            map.setString(" ", posX, posY);
            posX -= 1;
            map.setString("E", posX, posY);
        }
        attack();
    }

    public void moveRight(){
        if(posX + 1 < map.getMaxX() && !map.getStringAt(posX + 1, posY).equals("#")){
            map.setString(" ", posX, posY);
            posX += 1;
            map.setString("E", posX, posY);
        }
        attack();
    }


    public void attack(){
        if(map.getPlayerX() == posX && map.getPlayerY() == posY){
            map.hurtPlayer();
        }
    }

    //Open Beta ))
//    public void enemySprite(){
//        Random rngEn = new Random();
//        String m1, m2, m3, m4, m5, m6, m7, m8, m9, m10,
//                m11, m12, m13, m14, m15, m16, m17, m18, m19, m20,
//                   m21, m22, m23, m24, m25, m26, m27, m28, m29, m30;
//        int rngGen = ThreadLocalRandom.current().nextInt(1, 8 + 1);
//        switch (rngGen){
//            case 1:
//                 m1 ="                                      ▄       ";
//                 m2 ="                                     █     ▄  ";
//                 m3 ="                ▄                   █   ▄  ▀█ ";
//                 m4 ="                 ▀▄             ▄    ▀█ █▀   █";
//                 m5 ="                  █▄███████████▄█      ▀█▄▄▄▀ ";
//                 m6 ="              ▓░███████████████████▓█   █	  ";
//                 m7 ="              ▓████▓███▓▓▓▓███▓▒████▓  █▀     ";
//                 m8 ="               ▓███░░░░▓▓▓▓░░░░████▄  █▀      ";
//                 m9 ="                 █████████████████   █▀       ";
//                 m10 ="                     █████████      █▀       ";
//                 m11 ="                   ▄█▀███████▄▄▀▀▀▀█▀        ";
//                 m12 ="                   █  ██▓▒▒░█     █▀         ";
//                 m13 ="                   ▀  ████▒█     █▀          ";
//                 m14 ="                      █    █    █▀           ";
//                 m15 ="                      ██   ██  █▀            ";
//
//                for(int i = 0; i < 100; i++){
//                    eSprite[i][0] = String.valueOf(m1.charAt(i));  eSprite[i][8] = String.valueOf(m9.charAt(i));
//                    eSprite[i][1] = String.valueOf(m2.charAt(i)); eSprite[i][9] = String.valueOf(m10.charAt(i));
//                    eSprite[i][2] = String.valueOf(m3.charAt(i)); eSprite[i][10] = String.valueOf(m11.charAt(i));
//                    eSprite[i][3] = String.valueOf(m4.charAt(i)); eSprite[i][11] = String.valueOf(m12.charAt(i));
//                    eSprite[i][4] = String.valueOf(m5.charAt(i)); eSprite[i][12] = String.valueOf(m13.charAt(i));
//                    eSprite[i][5] = String.valueOf(m6.charAt(i)); eSprite[i][13] = String.valueOf(m14.charAt(i));
//                    eSprite[i][6] = String.valueOf(m7.charAt(i)); eSprite[i][14] = String.valueOf(m15.charAt(i));
//                    eSprite[i][7] = String.valueOf(m8.charAt(i));
//                }
//
//                break;
//            case 2:
//                m1 ="          ▄▄                           ▄▄	                                      ";
//                m2 ="         █▓▒█▄▄                     ▄▄█▓██                                       ";
//                m3 ="        █▓█▓█▓▓█▄▄               ▄▄█▓▒█░█▓█									  ";
//                m4 ="       ██▒░█▓▒▓░▒░█   █▄▄▄▄▄█   █░░▓▓▓▒█▒▓██                                     ";
//                m5 ="      █▓▒░░█▓▒▒▒░░░█▄▄▓▀█▓█▀▓▄▄█░▓▓▓▒▒▓█▒░▓██	                                  ";
//                m6 ="     █▒▒▒▓▀ ▀█░░▓█████▓▄▄█▄▄█▒▒▒▓▓▒▒██▀ ▀█░▓▓█                                   ";
//                m7 ="      █▓▒    █▓▓▓██░░█▀▓▓▓██▀█▓▒▓▒████    █░█                                    ";
//                m8 ="       ▓    ▄█▓▓███░▓▓█▀▀▓▀▀█▓▒▒████▓█▄    █                                     ";
//                m9 ="           █▀█▓█▀▀ █████████████ ▀▀███▀                                          ";
//                m10 ="       █ █▓▓█▓█    ███▓▓▒█▓▒▒█▒▒   ▓▓▓▓                                         ";
//                m11 ="       ██▓████     █▓██▒██▓▓█▓▒█  ▓█ █▓▓                                        ";
//                m12 ="        █▓█         ██▓▓▓█    █    ▓▓██▓                                        ";
//                m13 ="        ██           ▓▓▓▓▓█▓▓▓▓▓▓   ▓█▓█▓                                       ";
//                m14 ="         █         ▒▒▒███▓▓ █      ▓█   ▓█▄▄                                    ";
//                m15 ="       ▄▄█▄▄      ▒▒███▒█▓▓▓███▓▓  ▓    ▓  ▓                                    ";
//                m16 ="         █▄       ▒▒█ ▒▒▓▓█▓▓██   ▄█  ▓▄▓                                       ";
//                m17 ="       ▄▄▄█▄▄▄      ██▒▒█▓▓█▓██                                                 ";
//                m18 ="          █         ▓██▒▒▒▓███                                                  ";
//                m19 ="         ▒█▄        ▓▓▒▓█▒▓▓▒█                                                  ";
//                m20 ="        ▀█▓█▀      ▓▓▒▒ █▒▒ ██                                                  ";
//                m21 ="        ▀█▀       ▓  ▒██ ▒  ███                                                 ";
//
//                for(int i = 0; i < 100; i++){
//                    eSprite[i][0] = String.valueOf(m1.charAt(i));  eSprite[i][8] = String.valueOf(m9.charAt(i)); eSprite[i][16] = String.valueOf(m15.charAt(i));
//                    eSprite[i][1] = String.valueOf(m2.charAt(i)); eSprite[i][9] = String.valueOf(m10.charAt(i)); eSprite[i][17] = String.valueOf(m15.charAt(i));
//                    eSprite[i][2] = String.valueOf(m3.charAt(i)); eSprite[i][10] = String.valueOf(m11.charAt(i)); eSprite[i][18] = String.valueOf(m15.charAt(i));
//                    eSprite[i][3] = String.valueOf(m4.charAt(i)); eSprite[i][11] = String.valueOf(m12.charAt(i)); eSprite[i][19] = String.valueOf(m15.charAt(i));
//                    eSprite[i][4] = String.valueOf(m5.charAt(i)); eSprite[i][12] = String.valueOf(m13.charAt(i)); eSprite[i][20] = String.valueOf(m15.charAt(i));
//                    eSprite[i][5] = String.valueOf(m6.charAt(i)); eSprite[i][13] = String.valueOf(m14.charAt(i));
//                    eSprite[i][6] = String.valueOf(m7.charAt(i)); eSprite[i][14] = String.valueOf(m15.charAt(i));
//                    eSprite[i][7] = String.valueOf(m8.charAt(i)); eSprite[i][15] = String.valueOf(m15.charAt(i));
//                }
//
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//            case 7:
//                break;
//            case 8:
//                break;
//        }
//
//    }
}
