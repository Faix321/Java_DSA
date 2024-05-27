//Ass26
class S {
    int x;

    S(int x1) {
        x = x1;
    }

    void display() {
        System.out.println("In class S :");
        System.out.println(x);
    }
}

class T extends S {
    String x;

    T(int x1, String s1) {
        super(x1);
        x = s1;
    }

    void display1() {
        System.out.println("In class T :");
        System.out.println(x);
    }
}

public class Encapsulation {
    public static void main(String args[]) {
        S s2 = new S(10);
        T t1 = new T(10, "Haldia");
        s2.display();
        t1.display1();
    }
}