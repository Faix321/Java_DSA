// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.ArrayList;

public class Platformer {
    ArrayList<Long> list = new ArrayList<>();
    int pos;
    public Platformer(int n, int position) {
        this.pos = position;
        for(int i = 0; i < n; i++){
            Long l= new Long(i);
            list.add(l);
        }
    }

    public void jumpLeft() {
        int temp = (int)pos;
        pos -= 2;
        list.remove(temp);


    }

    public void jumpRight() {
        int temp = (int)pos;
        pos += 1;
        list.remove(temp);
    }

    public int position() {
       Long l= new Long(list.get(pos));
int i=l.intValue(); 
        return i;
    }

    public static void main(String[] args) {
        Platformer platformer = new Platformer(6, 3);
        System.out.println(platformer.position()); // should print 3

        platformer.jumpLeft();
        System.out.println(platformer.position()); // should print 1

        platformer.jumpRight();
        System.out.println(platformer.position()); // should print 4
    }

}