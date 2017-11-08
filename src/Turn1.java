import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Turn1 implements Turns{
    private GameContext gc;
    private Board board;
    private BufferedImage bgi;
    private BufferedImage turni;



    public Turn1() {
        board = new Board(1);
        try {
            bgi = ImageIO.read(new File("media/play.png"));
            turni = ImageIO.read(new File("media/turn1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void reset(){
        this.board.reset();
    }

    public Board getBoard(){
        return this.board;
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(bgi,0,0,762,429,null);
        board.render(g);
        g.drawImage(turni,550,13,130,53,null);
    }

    @Override
    public void update(int width, int height) {
        board.update();
    }

    @Override
    public void setContext(GameContext gc) {
        this.gc = gc;
    }



}