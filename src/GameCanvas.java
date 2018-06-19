import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage starImage;//ten bien ro rang, de lam gi
    BufferedImage enemyImage;
    BufferedImage playerImage;


    //BackBuffered lat hinh anh
    BufferedImage backBuffered;
    Graphics graphics;//co ve nay se ve het len buffered

    Random random = new Random();

    public int positionXStar = 400;
    int positionYStar = 200; //vi tri


    public int positionXEnemy = 100;
    public int positionYEnemy = 200;


    public int positionXPlayer = 200;
    public int positionYPlayer = 300;

    public int moveXEnemy = 8;
    public int moveYEnemy = 8;


    public GameCanvas(){
        this.setSize(1024,600);

        this.backBuffered = new BufferedImage(1024,600,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();//gan vao backbuffered

        try {//thu load anh neu loi se nhay xg catch
            this.starImage = ImageIO.read(new File("resources/images/star.png")); //dua duong dan tuong doi

            this.enemyImage = ImageIO.read(new File("resources/images/circle.png"));
            this.playerImage = ImageIO.read(new File ("resources/images/circle.png") );
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setVisible(true);
    }
    //paintComponent chi la de ve va lat hinh anh
    @Override
    protected void paintComponent(Graphics g) { //ve tat ca mmoi thu o trong nay thoi (graphic la ve hien thi g)
       // Color = new Color();//chon bang mau
//

        g.drawImage(this.backBuffered, 0,0,null);
    }


    public void renderAll(){
        this.graphics.setColor(Color.BLACK);//tao nen
        this.graphics.fillRect(0,0,1024,600);// but ve hinh chu nhat
        this.graphics.drawImage(this.starImage, this.positionXStar, this.positionYStar,5,5, null);
        this.graphics.drawImage(this.enemyImage,this.positionXEnemy,this.positionYEnemy,20,20,null);
        this.graphics.drawImage(this.playerImage,this.positionXPlayer,this.positionYPlayer,10,10,null);

        this.repaint();// be tu gamewindow va this chinh la gamecavas
    }
}
