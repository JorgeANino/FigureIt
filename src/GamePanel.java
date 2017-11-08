import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/***
 *  Autor: Jorge Alberto Nino Cabal A01172309
 * 07/11/2017
 */



public class GamePanel extends JPanel implements Runnable{

    private static final long serialVersionUID = 1L;
    private int PWIDTH = 762;
    private int PHEIGHT =  429; //tamaño del panel

    private Thread animator; //controla la animación
    private volatile boolean running = false;
    private volatile boolean gameOver = false;
    private volatile boolean isPaused = false;
    private GameContext context;

    public GamePanel() {
        setBackground(Color.black);
        this.revalidate();
        setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
        setFocusable(true);
        requestFocus();
        readyForTermination();
        context = new GameContext();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(context.getCurrent() == context.getMenu() && e.getX() >= 286 && e.getY() >= 237
                        && e.getX() <= 476 && e.getY() <= 330){
                    context.countdown();
                }
                // fila 1
                if(context.getCurrent() == context.getRun() && e.getX() >= 7 && e.getY() >= 9
                        && e.getX() <= 62 && e.getY() <= 71){
                    context.getRun().getTurn().getBoard().addLetter('a');
                }

                else if(context.getCurrent() == context.getRun() && e.getX() >= 92 && e.getY() >= 9
                        && e.getX() <= 153 && e.getY() <= 71){
                    context.getRun().getTurn().getBoard().addLetter('b');
                }

                else if(context.getCurrent() == context.getRun() && e.getX() >= 176 && e.getY() >= 9
                        && e.getX() <= 239 && e.getY() <= 71){
                    context.getRun().getTurn().getBoard().addLetter('c');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 260 && e.getY() >= 9
                        && e.getX() <= 320 && e.getY() <= 71){
                    context.getRun().getTurn().getBoard().addLetter('d');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 345 && e.getY() >= 9
                        && e.getX() <= 408 && e.getY() <= 71){
                    context.getRun().getTurn().getBoard().addLetter('e');
                }
                // fila 2
                else if(context.getCurrent() == context.getRun() && e.getX() >= 7 && e.getY() >= 80
                        && e.getX() <= 62 && e.getY() <= 141){
                    context.getRun().getTurn().getBoard().addLetter('f');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 92 && e.getY() >= 80
                        && e.getX() <= 153 && e.getY() <= 141){
                    context.getRun().getTurn().getBoard().addLetter('g');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 176 && e.getY() >= 80
                        && e.getX() <= 239 && e.getY() <= 141){
                    context.getRun().getTurn().getBoard().addLetter('h');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 260 && e.getY() >= 80
                        && e.getX() <= 320 && e.getY() <= 141){
                    context.getRun().getTurn().getBoard().addLetter('i');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 345 && e.getY() >= 80
                        && e.getX() <= 408 && e.getY() <= 141){
                    context.getRun().getTurn().getBoard().addLetter('j');
                }
                // fila 3
                else if(context.getCurrent() == context.getRun() && e.getX() >= 7 && e.getY() >= 151
                        && e.getX() <= 62 && e.getY() <= 211){
                    context.getRun().getTurn().getBoard().addLetter('k');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 92 && e.getY() >= 151
                        && e.getX() <= 153 && e.getY() <= 211){
                    context.getRun().getTurn().getBoard().addLetter('l');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 176 && e.getY() >= 151
                        && e.getX() <= 239 && e.getY() <= 211){
                    context.getRun().getTurn().getBoard().addLetter('m');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 260 && e.getY() >= 151
                        && e.getX() <= 320 && e.getY() <= 211){
                    context.getRun().getTurn().getBoard().addLetter('n');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 345 && e.getY() >= 151
                        && e.getX() <= 408 && e.getY() <= 211){
                    context.getRun().getTurn().getBoard().addLetter('o');
                }
                // fila 4
                else if(context.getCurrent() == context.getRun() && e.getX() >= 7 && e.getY() >= 222
                        && e.getX() <= 62 && e.getY() <= 281){
                    context.getRun().getTurn().getBoard().addLetter('p');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 92 && e.getY() >= 222
                        && e.getX() <= 153 && e.getY() <= 281){
                    context.getRun().getTurn().getBoard().addLetter('q');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 176 && e.getY() >= 222
                        && e.getX() <= 239 && e.getY() <= 281){
                    context.getRun().getTurn().getBoard().addLetter('r');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 260 && e.getY() >= 222
                        && e.getX() <= 320 && e.getY() <= 281){
                    context.getRun().getTurn().getBoard().addLetter('s');
                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 345 && e.getY() >= 222
                        && e.getX() <= 408 && e.getY() <= 281){
                    context.getRun().getTurn().getBoard().addLetter('t');
                }
                // fila 5
                else if(context.getCurrent() == context.getRun() && e.getX() >= 7 && e.getY() >= 293
                        && e.getX() <= 62 && e.getY() <= 351){
                    context.getRun().getTurn().getBoard().addLetter('u');

                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 92 && e.getY() >= 293
                        && e.getX() <= 153 && e.getY() <= 351){
                    context.getRun().getTurn().getBoard().addLetter('v');

                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 176 && e.getY() >= 293
                        && e.getX() <= 239 && e.getY() <= 351){
                    context.getRun().getTurn().getBoard().addLetter('w');

                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 260 && e.getY() >= 293
                        && e.getX() <= 320 && e.getY() <= 351){
                    context.getRun().getTurn().getBoard().addLetter('x');

                }
                else if(context.getCurrent() == context.getRun() && e.getX() >= 345 && e.getY() >= 293
                        && e.getX() <= 408 && e.getY() <= 351){
                    context.getRun().getTurn().getBoard().addLetter('y');

                }
                // Z
                else if(context.getCurrent() == context.getRun() && e.getX() >= 7 && e.getY() >= 363
                        && e.getX() <= 62 && e.getY() <= 421){
                    context.getRun().getTurn().getBoard().addLetter('z');
                }
                // Restart
                else if(context.getCurrent() == context.getWin1() || context.getCurrent() == context.getWin2() && e.getX() >= 211 && e.getY() >= 223
                        && e.getX() <= 553 && e.getY() <= 365){
                    context.setCurrent(context.getRun());
                    context.getCurrent().restart();
                }
                // Submit
                else if(context.getCurrent() == context.getRun() &&  e.getX() >= 598 && e.getY() >= 362
                        && e.getX() <= 752 && e.getY() <= 418 ){
                    context.getRun().getTurn().getBoard().submit();
                }
                //Clear
                else if(context.getCurrent() == context.getRun() &&  e.getX() >= 464 && e.getY() >= 362
                        && e.getX() <= 589 && e.getY() <= 418 ){
                    context.getRun().getTurn().getBoard().clearLetters();
                }
            }
        });
    }//GamePanel()

    public void addNotify()	{
        super.addNotify();
        startGame();
    }//addNotify

    private void startGame(){
        if(animator == null || !running){
            animator = new Thread(this);
            animator.start();
        }
    }//startGame()

    public void stopGame(){
        running = false;
    }//stopGame()

    public void run(){
        running = true;
        while(running) {
            gameUpdate(PWIDTH, PHEIGHT);
            gameRender();
            paintScreen();
            readyForTermination();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
        }

    }//run()

    private void gameUpdate(int width, int height){

        context.update(width, height);
        if(!isPaused && !gameOver){


        }

    }//gameUpdate()

    private Graphics dbg;
    private Image dbImage = null;

    private void gameRender(){
        if(dbImage == null)
        {
            dbImage = createImage(PWIDTH,PHEIGHT);
            if(dbImage == null){
                System.out.println("dbImage is null");
                return;
            }else{
                dbg = dbImage.getGraphics();
            }

        }
        dbg.setColor(Color.white);
        dbg.fillRect(0,0,PWIDTH,PHEIGHT);
        context.render(dbg);
    }//gameRender()


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(dbImage != null)
            g.drawImage(dbImage, 0, 0, null);
    }

    private void readyForTermination() {
        addKeyListener( new KeyAdapter() { // listen for esc, q, end, ctrl-c
            public void keyPressed(KeyEvent e) {
                try {
                    if (e.getKeyCode() == KeyEvent.VK_Q) {
                        System.exit(0);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                    }
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                    }
                } catch(NullPointerException x){
                    System.out.println("Game has ended");
                }
            }
        });
    }// end of readyForTermination()



    private void testPress(int x, int y) {
        if (!gameOver && !isPaused) {
            // Do Something
        }

    }//testPress

    private void paintScreen(){
        Graphics g;
        try{
            g = this.getGraphics();
            if((g != null) && (dbImage != null))
                g.drawImage(dbImage,0,0,null);
            Toolkit.getDefaultToolkit().sync();
        }catch(Exception e){
            System.out.println("Graphics context error: "+e);
        }
    }

    public void pauseGame(){
        isPaused = true;
    }

    public void resumeGame(){
        isPaused = false;
    }

    public static void main(String[] args) {
        JFrame app = new JFrame("Guess it!");
        GamePanel gp = new GamePanel();
        app.getContentPane().add(gp, BorderLayout.CENTER);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setResizable(false);
        app.setVisible(true);
    }
}
