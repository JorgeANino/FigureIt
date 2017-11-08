import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.concurrent.TimeUnit;

public class Run implements GameState{
    private GameContext gc;
    private Turns turn1,turn2,current;


    public Run() {
        turn1 = new Turn1();
        turn2 = new Turn2();
        current = turn1;
    }

    public void setTurn(Turns turn){
        this.current = turn;
    }

    @Override
    public void run() {
        System.out.println("Game is already running");
    }

    @Override
    public void render(Graphics g) {
        current.render(g);
    }

    @Override
    public void update(int width, int height) {
        current.update(width,height);
        if(current.getBoard().getFlag() == 1 && current == turn1){
            turn1.getBoard().setFlag(0);
            current = turn2;
        }else if(current.getBoard().getFlag() == 1 && current == turn2){
            turn2.getBoard().setFlag(0);
            current = turn1;
        }else if(current.getBoard().getFlag() == 2 && current == turn1){
            gc.setCurrent(gc.getWin1());
            turn1.getBoard().setFlag(0);
        }else if(current.getBoard().getFlag() == 2 && current == turn2){
            gc.setCurrent(gc.getWin2());
            turn2.getBoard().setFlag(0);
        }else if(current.getBoard().getFlag() == 3 && current == turn1){
            gc.setCurrent(gc.getWin2());
            turn1.getBoard().setFlag(0);
        }else if(current.getBoard().getFlag() == 3 && current == turn2){
            gc.setCurrent(gc.getWin1());
            turn2.getBoard().setFlag(0);
        }
    }

    @Override
    public void setContext(GameContext gc) {
        turn1.setContext(gc);
        turn2.setContext(gc);
        this.gc = gc;
    }


    @Override
    public void win1() {
        gc.setCurrent(gc.getWin1());
    }

    @Override
    public void win2() {
        gc.setCurrent(gc.getWin2());
    }


    @Override
    public void menu() {
        gc.setCurrent(gc.getMenu());
    }

    @Override
    public Turns getTurn(){return current;}

    @Override
    public void restart(){
        turn1.reset();
        turn2.reset();
        current = turn1;
    }


}
