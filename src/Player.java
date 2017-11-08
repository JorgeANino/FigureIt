import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private int x,y,lives;
    private BufferedImage img;
    private int num;
    private boolean lost;
    private boolean win;

    public Player(int x, int y,int num){
        this.x = x;
        this.y = y;
        this.lost = false;
        this.win = false;
        this.num = num;
        try {
            this.img = ImageIO.read(new File("media/hang1.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        this.lives = 4;
    }

    public void render(Graphics g){
        if(lost == false && win == false) {
            try {
                if (this.lives == 4) {
                    g.drawImage(this.img, this.x, this.y, 200, 196, null);
                } else if (this.lives == 3) {
                    if(num == 1){
                        this.img = ImageIO.read(new File("media/hang2.png"));
                    }else{
                        this.img = ImageIO.read(new File("media/hang2b.png"));
                    }
                    g.drawImage(this.img, this.x, this.y, 200, 196, null);
                } else if (this.lives == 2) {
                    if(num == 1){
                        this.img = ImageIO.read(new File("media/hang3.png"));
                    }else{
                        this.img = ImageIO.read(new File("media/hang3b.png"));
                    }
                    g.drawImage(this.img, this.x, this.y, 200, 196, null);
                } else if (this.lives == 1) {
                    if(num == 1){
                        this.img = ImageIO.read(new File("media/hang4.png"));
                    }else{
                        this.img = ImageIO.read(new File("media/hang4b.png"));
                    }
                    g.drawImage(this.img, this.x, this.y, 200, 196, null);
                } else if (this.lives == 0) {
                    if(num == 1){
                        this.img = ImageIO.read(new File("media/hang5.png"));
                    }else{
                        this.img = ImageIO.read(new File("media/hang5b.png"));
                    }
                    g.drawImage(this.img, this.x, this.y, 200, 196, null);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public int getLives(){
        return this.lives;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public void loseLive(){
        this.lives-=1;
        if(this.lives < 0){
            this.lose();
        }
    }

    public void lose(){
        this.lives = 0;
        lost = true;
    }

    public void win(){
        win = true;
    }

}



