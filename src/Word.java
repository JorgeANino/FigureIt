import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Random;

public class Word {
    private ArrayList<Letter> word;
    private int num;
    private Letter letter;
    private String[] dictionary = new String[]{"good","bad","friend","cousin","brother","dad","son","family","happy","company","food","eye","towel"};
    private String chosen;
    private LinkedList<Character> notshown = new LinkedList<Character>();
    private LinkedList<Character> shown = new LinkedList<Character>();



    public Word() {
        Random r = new Random();
        num = r.nextInt(dictionary.length);
        word = new ArrayList<Letter>();
        this.chosen = dictionary[num];
        generateWord(chosen);
    }

    private void generateWord(String w){
        int x = 370 + 328/w.length();
        int y = 300;
        Random r = new Random();
        for(int i=0;i<w.length();i++){
            num = r.nextInt(2);
            x = 370 + (328*(i+1))/w.length();
            if(num == 0){
                if(shown.contains((char)w.charAt(i))){
                    word.add(new Letter(w.charAt(i),x,y,1));
                }else {
                    word.add(new Letter(w.charAt(i), x, y, num));
                    notshown.add((char) w.charAt(i));
                }
            }else{
                if(notshown.contains((char) w.charAt(i))){
                    word.add(new Letter(w.charAt(i),x,y,0));
                }else{
                    word.add(new Letter(w.charAt(i),x,y,num));
                    shown.add((char) w.charAt(i));
                }
            }

        }
    }

    public void render(Graphics g){
        for(int i=0; i<word.size();i++) {
            letter = word.get(i);
            letter.render(g);
        }
    }

    public ArrayList<Letter> getWord(){
        return this.word;
    }

    public String getChosen(){
        return this.chosen;
    }

    public boolean isFullyShown(){
        for(int i=0; i<word.size();i++) {
            if(word.get(i).isShown() == false){
                return false;
            }
        }
        return true;
    }
}
