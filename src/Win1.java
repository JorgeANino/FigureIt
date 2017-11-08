import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Win1 implements GameState{
    private BufferedImage img;
    private Turns turn;

    public Win1() {
        try {
            img = ImageIO.read(new File("media/player1won.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img,0,0,762,429,null);

    }

    @Override
    public void update(int width, int height) {

    }

    @Override
    public void setContext(GameContext gc) {

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