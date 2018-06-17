import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage starImage;//ten bien ro rang, de lam gi
    public GameCanvas(){
        this.setSize(1024,600);

        try {//thu load anh neu loi se nhay xg catch
            this.starImage = ImageIO.read(new File("resources/images/star.png")); //dua duong dan tuong doi
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) { //ve tat ca mmoi thu o trong nay thoi (graphic la ve)
       // Color = new Color();//chon bang mau
        g.setColor(Color.BLACK);//tao nen
        g.fillRect(0,0,1024,600);// but ve hinh chu nhat
        g.drawImage(this.starImage, 400,200,null);//bat dau ve buc anh(truyen anh,toa do)
    }
}
