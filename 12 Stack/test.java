// public class test {
//     public static void main(String[] args) {
//         System.out.println(131%36);
//         System.out.println(157%36);
//         System.out.println(183%36);
//         // System.out.println(576%6);
//         // System.out.println(876%6);
//         // System.out.println(1206%6);
//     }
// }

import java.util.*;
class test1{
    public int x;
    private int y;
    void cal(int a, int b){
        x=a+1;
        y=b;
    }
}
class test {
    public static void main (String[] args) {
        test1 obj = new test1();
        obj.cal(2,3);
        System.out.println(obj.x + " " + obj.y);

    }
}
