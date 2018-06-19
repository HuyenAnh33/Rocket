import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;// dung de ve tat ca moi thu len
    long lastTime = 0;
    Random random = new Random();

    public  GameWindow() {

        this.setSize(1024, 600);

        this.gameCanvas = new GameCanvas();

        this.add(this.gameCanvas);//truyen game nay vao windown

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.positionXPlayer -= 8;

                    if (gameCanvas.positionXPlayer <= 0){
                        gameCanvas.positionXPlayer = 1024;
                        gameCanvas.positionYPlayer = random.nextInt(601);}

                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.positionXPlayer += 8;

                    if (gameCanvas.positionXPlayer >=1024){
                        gameCanvas.positionXPlayer = 0;
                        gameCanvas.positionYPlayer = random.nextInt(601);}
                       }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    gameCanvas.positionYPlayer += 8;

                    if (gameCanvas.positionYPlayer >= 600){
                        gameCanvas.positionYPlayer = 0;
                        gameCanvas.positionXPlayer = random.nextInt(1025);}
                    }
                 if (e.getKeyCode() == KeyEvent.VK_UP){
                    gameCanvas.positionYPlayer -=8;
                    if (gameCanvas.positionYPlayer <= 0){
                        gameCanvas.positionYPlayer = 600;
                        gameCanvas.positionXPlayer = random.nextInt(1025);}
                    }
                }




            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });


        this.setVisible(true);
    }


    public void gameLoop() {

        while (true) {
            long currentTime = System.nanoTime();//tinh tu 0 gio 0 phut 0 giay ngay 1 thang 1 nam 1970 den thoi diem hien tai
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.positionXStar -= 3;//toc do chay cua ngoi sao la 3

                //cho enemy di chuyen cheo
                this.gameCanvas.positionXEnemy -= 1;
                this.gameCanvas.positionYEnemy -= 1;

                this.gameCanvas.positionXEnemy += this.gameCanvas.moveXEnemy;
                this.gameCanvas.positionYEnemy += this.gameCanvas.moveYEnemy;

                if (this.gameCanvas.positionXEnemy >= 1024 || this.gameCanvas.positionXEnemy <=0){
                    this.gameCanvas.moveXEnemy = -this.gameCanvas.moveXEnemy;
                }
                if (this.gameCanvas.positionYEnemy >= 600 || this.gameCanvas.positionYEnemy <= 0){
                    this.gameCanvas.moveYEnemy = -this.gameCanvas.moveYEnemy;
                }

                this.gameCanvas.renderAll();
                //this.gameCanvas.positionXPlayer -= 1; tu dong di chuyen =1
                this.lastTime = currentTime;
            }

        }

        //Thread.sleep(20);// dung de nghi
    }
    }























