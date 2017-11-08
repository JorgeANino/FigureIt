import javax.swing.*;
import java.awt.*;
public class GameContext {
    private GameState run;
    private GameState win1;
    private GameState win2;
    private GameState menu;
    private GameState current;
    private GameState countdown;


    public GameContext(){
        run = Factory.getInstance().createState("run");
        win1 = Factory.getInstance().createState("win1");
        win2 = Factory.getInstance().createState("win2");
        menu = Factory.getInstance().createState("menu");
        countdown = Factory.getInstance().createState("countdown");

        countdown.setContext(this);
        run.setContext(this);
        win1.setContext(this);
        win2.setContext(this);
        menu.setContext(this);

        current = menu;
    }
    public GameState getMenu(){
        return menu;
    }

    public GameState getRun(){
        return run;
    }

    public GameState getWin1(){ return win1;}

    public GameState getWin2(){ return win2;}

    public void setCurrent(GameState gamestate){
        current = gamestate;
    }

    public void update(int width, int height){
        current.update(width, height);
    }

    public void render(Graphics g){
        current.render(g);
    }

    public void win1() {
        current=win1;
    }

    public void win2() {
        current=win2;
    }

    public void run(){
        current = run;
    }

    public void menu(){
        current = menu;
    }

    public void countdown(){
        current = countdown;
    }

    public GameState getCurrent() {
        return current;
    }



}
