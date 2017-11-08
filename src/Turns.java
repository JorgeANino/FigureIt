import java.awt.*;

public interface Turns {
    void render(Graphics g);
    void update(int width, int height);
    void setContext(GameContext gc);
    void reset();
    Board getBoard();
}
