import javax.swing.*;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;// dung de ve tat ca moi thu len

    public  GameWindow(){
        this.setSize(1024,600);

        this.gameCanvas = new GameCanvas();

        this.add(this.gameCanvas);//truyen game nay vao windown

        this.setVisible(true);
    }

}
