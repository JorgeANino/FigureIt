import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Letter {
    private char ch;
    private int x,y;
    private boolean found;
    private BufferedImage img;
    private BufferedImage not;

    public Letter(char ch,int x,int y, int num){
        this.ch = ch;
        if(num == 0){
            this.found = true;
        }else{
            this.found = false;
        }

        this.x = x;
        this.y = y;
        try{
            this.img = ImageIO.read(new File("media\\*.png".replace('*',this.ch)));
            this.not = ImageIO.read(new File("media/not.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void render(Graphics g){
        if(this.found == true) {
            g.drawImage(this.img,this.x,this.y,40,50,null);
        }else{
            g.drawImage(this.not,this.x,this.y,40,50,null);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void show(){
        this.found = true;
    }

    public boolean isShown(){
        return found;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}
