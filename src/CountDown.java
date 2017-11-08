import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class CountDown implements GameState{
    private GameContext gc;
    private BufferedImage img;
    private BufferedImage bgi;
    private int i;
    private Turns turn;

    public CountDown() {
        i = 0;
        try{
            img = ImageIO.read(new File("media/1c.png"));
            bgi = ImageIO.read(new File("media/bg.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }

    @Override
    public void render(Graphics g) {
        this.i+=1;
        g.drawImage(bgi,0,0,762,429,null);
        try {
            if (this.i < 100) {
                img = ImageIO.read(new File("media/1c.png"));
                g.drawImage(img,0,0,762,429,null);
            } else if (this.i > 100 && this.i < 200) {
                img = ImageIO.read(new File("media/1b.png"));
                g.drawImage(img,0,0,762,429,null);
            }else if(this.i > 200 && this.i < 300 ){
                img = ImageIO.read(new File("media/1a.png"));
                g.drawImage(img,0,0,762,429,null);
            } else if(this.i > 300){
                this.i = 0;
                img = ImageIO.read(new File("media/1c.png"));
                gc.setCurrent(gc.getRun());
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(int width, int height) {

    }

    @Override
    public void setContext(GameContext gc) {
        this.gc = gc;
    }



    @Override
    public void win1() {

    }

    @Override
    public void win2() {

    }

    @Override
    public void menu() {

    }

    @Override
    public Turns getTurn(){
        return turn;
    }
    @Override
    public void restart(){
    }



}
