import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import javax.swing.*;
public interface GameState {
    void run();
    void menu();
    void win1();
    void win2();
    void render(Graphics g);
    void update(int width, int height);
    void setContext(GameContext gc);
    Turns getTurn();
    void restart();

}
