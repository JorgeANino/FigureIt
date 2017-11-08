import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu implements GameState{
    private GameContext gc;
    private BufferedImage img;
    private Turns turn;


    public Menu(){
        try{
            img = ImageIO.read(new File("media/menu.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        System.out.println("Game has already ended.");
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
        gc.setCurrent(gc.getMenu());
    }

    @Override
    public Turns getTurn(){
        return turn;
    }
    @Override
    public void restart(){

    }


}
