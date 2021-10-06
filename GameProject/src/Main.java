import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;


public class Main {
    public static void main(String[] args) throws InterruptedException{
        //Title String
        String title0 = " ▄████████   ▄▄▄▄███▄▄▄▄      ▄████████  ▄█        ▄█          ▄████████    ▄███████▄    ▄██████▄  ";
        String title1 = " ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███ ███       ███         ███    ███   ███    ███   ███    ███";
        String title2 = " ███    █▀  ███   ███   ███   ███    ███ ███       ███         ███    ███   ███    ███   ███    █▀ ";
        String title3 = " ███        ███   ███   ███   ███    ███ ███       ███        ▄███▄▄▄▄██▀   ███    ███  ▄███       ";
        String title4 = "███████████ ███   ███   ███ ▀███████████ ███       ███       ▀▀███▀▀▀▀▀   ▀█████████▀  ▀▀███ ████▄";
        String title5 = "        ███ ███   ███   ███   ███    ███ ███       ███       ▀███████████   ███          ███    ███";
        String title6 = "  ▄█    ███ ███   ███   ███   ███    ███ ███▌    ▄ ███▌    ▄   ███    ███   ███          ███    ███";
        String title7 = "▄████████▀   ▀█   ███   █▀    ███    █▀  █████▄▄██ █████▄▄██   ███    ███  ▄████▀        ████████▀ ";
        String title8 = "                                         ▀         ▀           ███    ███                          ";

        //Terminal GUI
        Screen screen = TerminalFacade.createScreen();
        screen.startScreen();

        //Dimensiune Ecran

        int maxX = screen.getTerminalSize().getColumns();
        int maxY = screen.getTerminalSize().getRows();

        for(int i = 1; i < maxY - 1; i++) {
            screen.clear();
            screen.putString(3, maxY - i, title0, Terminal.Color.WHITE, Terminal.Color.BLACK);
            screen.putString(3, maxY - i + 1, title1, Terminal.Color.WHITE, Terminal.Color.BLACK);
            screen.putString(3, maxY - i + 2, title2, Terminal.Color.WHITE, Terminal.Color.BLACK);
            screen.putString(3, maxY - i + 3, title3, Terminal.Color.WHITE, Terminal.Color.BLACK);
            screen.putString(3, maxY - i + 4, title4, Terminal.Color.WHITE, Terminal.Color.BLACK);
            screen.putString(3, maxY - i + 5, title5, Terminal.Color.WHITE, Terminal.Color.BLACK);
            screen.putString(3, maxY - i + 6, title6, Terminal.Color.WHITE, Terminal.Color.BLACK);
            screen.putString(3, maxY - i + 7, title7, Terminal.Color.WHITE, Terminal.Color.BLACK);
            screen.putString(3, maxY - i + 8, title8, Terminal.Color.WHITE, Terminal.Color.BLACK);
        }

        //Start prompt
        Thread.sleep(300);
        screen.putString(maxX/2 - 12, maxY - 3, "--Press Enter to begin--", Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.refresh();

        boolean stop = false;
        while(!stop){
            Key key = screen.readInput();
            while (key == null){
                key = screen.readInput();
            }
            switch (key.getKind()){
                case Escape :
                    stop = true;
                    break;
                case Enter:
                    Game.startGame(screen);
                    stop = true;
                    gameOver(screen);
                    break;
            }
        }

        screen.stopScreen();
        System.exit(0);
    }
    public static void gameOver(Screen screen){
        screen.clear();
        String s0 = "     _____";
        String s1 = "  /~/~   ~\\ ";
        String s2 = " | |       \\";
        String s3 = " \\ \\        \\ ";
        String s4 = "  \\ \\        \\";
        String s5 = " --\\ \\       .\\''";
        String s6 = "--==\\ \\     ,,i!!i,";
        String s7 = "  ''''',,}{,,";

        screen.putString(6, 8, s0, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(6, 9, s1, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(6, 10, s2, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(6, 11, s3, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(6, 12, s4, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(6, 13, s5, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(6, 14, s6, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(6, 15, s7, Terminal.Color.WHITE, Terminal.Color.BLACK);

        String g0 = "  ####";
        String g1 = " #######";
        String g2 = "####      ######  ##### ###    ###";
        String g3 = "###      ######  ##########  ######";
        String g4 = "##  ###  ### ##  ### ### ##  ##  ##";
        String g5 = "## ####  ##  ##  ##  ##  ##  ######";
        String g6 = "### ###  ## ###  ##  ##  ##  ###";
        String g7 = "#######  ###### ### ### ###  #####";
        String g8 = " #####   #####  ### ### ###   ####";

        String g9 =  "  ####";
        String g10 = " #######";
        String g11 = "###  ###  ##  ###   ###    ####";
        String g12 = "###   ##  ## ###  ######  ######";
        String g13 = "##    ##  ## ##   ##  ##  ###";
        String g14 = "##   ###  #####   ######  ##";
        String g15 = "### ###   ####    ###     ##";
        String g16 = "#######   ####    #####  ###";
        String g17 = " ####     ###      ####  ###";

        screen.putString(50, 3, g0, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 4, g1, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 5, g2, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 6, g3, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 7, g4, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 8, g5, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 9, g6, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 10, g7, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 11, g8, Terminal.Color.WHITE, Terminal.Color.BLACK);

        screen.putString(50, 13, g9, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 14, g10, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 15, g11, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 16, g12, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 17, g13, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 18, g14, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 19, g15, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 20, g16, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(50, 21, g17, Terminal.Color.WHITE, Terminal.Color.BLACK);

        screen.refresh();

        try { Thread.sleep(4000);
        } catch (InterruptedException e) {}
    }
}