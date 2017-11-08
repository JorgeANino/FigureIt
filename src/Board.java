import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class Board {
    private Player player;
    private Word w;
    private BufferedImage bgi;
    private int flag;
    private LinkedList<Letter> letters;
    private int x,y;
    private int num;

    public Board(int num){
        w = new Word();
        this.num = num;
        flag = 0;
        letters = new LinkedList<Letter>();
        player = new Player(480,73,num);
        x = 91;
        y = 363;
        try{
            bgi = ImageIO.read(new File("media/play.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void render(Graphics g){
        g.drawImage(bgi,0,0,762,429,null);
        w.render(g);
        player.render(g);
        for(int i=0;i<letters.size();i++){
            letters.get(i).render(g);
        }
    }

    public void update(){
        if(w.isFullyShown()){
            flag = 2;
        }
        if(player.isLost()){
            flag=3;
        }
    }


    public void addLetter(char ch){
        if(x>414){
            this.clearLetters();
            return;
        }
        letters.add(new Letter(ch,x,y,0));
        x+=50;
        return;
    }

    public void submit(){
        if(letters.size() > 1){
            for(int i=0;i<letters.size();i++){
                if(attempt(letters.get(i).getCh(),letters.size()) == false){
                    player.lose();
                }
            }
        }else if(letters.size() == 1){
            attempt(letters.get(0).getCh(),1);
        }
        this.clearLetters();
    }

    public void clearLetters(){
        letters.clear();
        this.x = 91;
    }

    public boolean attempt(char ch, int size){
        boolean state = false;
        for(int i=0; i<this.w.getWord().size();i++){
            if(this.w.getWord().get(i).getCh() == ch){
                this.w.getWord().get(i).show();
                state = true;
            }
        }
        if(state == false && size == 1){
            player.loseLive();
            flag = 1;
        }
        return state;
    }

    public void reset(){
        w = new Word();
        flag = 0;
        player = new Player(480,73,this.num);
        this.letters.clear();
        this.x = 91;
    }

    public int getFlag(){
        return this.flag;
    }

    public void setFlag(int flag){
        this.flag = flag;
    }

}
