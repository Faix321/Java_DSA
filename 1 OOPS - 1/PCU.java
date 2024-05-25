import java.util.Scanner;

// class DynamicArray{
//     int[] data;
//     private int nextElementIndex;

//     public DynamicArray(){
//         data = new int[5];
//         nextElementIndex = 0;
//     }

//     public int[] insertEnd(int deg) {
//         if (deg == data.length)
//             doubleCapacity();

//         data = new int[deg];
//         return data;
//     }

//     private void doubleCapacity() {
//         int[] temp = data;
//         data = new int[2 * temp.length];
//         for (int i = 0; i <= temp.length - 1; ++i)
//             data[i] = temp[i];
//     }

// }

class Polynomial {

    // DynamicArray d = new DynamicArray();

    private int[] degree;
    private int nextElementIndex;

    private void DynamicArray(){
        degree = new int[5];
        nextElementIndex = 0;
    }

    // public int[] increaseCapacity(int deg) {
    //     if (deg == data.length)
    //         doubleCapacity();

    //     data = new int[deg];
    //     return data;
    // }

    private void doubleCapacity() {
        int[] temp = degree;
        degree = new int[2 * temp.length];
        for (int i = 0; i <= temp.length - 1; ++i)
            degree[i] = temp[i];
    }

    public void setCoefficient(int deg, int coeff) {
        if (deg == degree.length)
            doubleCapacity();
        for (int i = 0; i <= deg; ++i) {
            if (i == deg)
                degree[deg] = coeff;
            else
                degree[i] = 0;
        }
    }

    public void print() {
        for (int i = 0; i <= degree.length - 1; ++i) {
            if (degree[i] != 0)
                System.out.println(degree[i] + "x" + i + " ");
        }
    }

}

public class PCU {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int degree1[] = new int[n];
        for (int i = 0; i < n; i++) {
            degree1[i] = s.nextInt();
        }
        int coeff1[] = new int[n];
        for (int i = 0; i < n; i++) {
            coeff1[i] = s.nextInt();
        }
        Polynomial first = new Polynomial();
        for (int i = 0; i < n; i++) {
            first.setCoefficient(degree1[i], coeff1[i]);
        }
        n = s.nextInt();
        int degree2[] = new int[n];
        for (int i = 0; i < n; i++) {
            degree2[i] = s.nextInt();
        }
        int coeff2[] = new int[n];
        for (int i = 0; i < n; i++) {
            coeff2[i] = s.nextInt();
        }
        Polynomial second = new Polynomial();
        for (int i = 0; i < n; i++) {
            second.setCoefficient(degree2[i], coeff2[i]);
        }
        // int choice = s.nextInt();
        // Polynomial result;
        // switch(choice){
        // Add
        // case 1:
        // result = first.add(second);
        // result.print();
        // break;
        // Subtract
        // case 2 :
        // result = first.subtract(second);
        // result.print();
        // break;
        // Multiply
        // case 3 :
        // result = first.multiply(second);
        // result.print();
        // break;
    }

}

