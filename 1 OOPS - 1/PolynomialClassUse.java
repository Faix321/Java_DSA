// import java.util.Scanner;

// // class DynamicArray{
// //     int[] data;
// //     private int nextElementIndex;

// //     public DynamicArray(){
// //         data = new int[5];
// //         nextElementIndex = 0;
// //     }

// //     public int[] insertEnd(int deg) {
// //         if (deg == data.length)
// //             doubleCapacity();

// //         data = new int[deg];
// //         return data;
// //     }

// //     private void doubleCapacity() {
// //         int[] temp = data;
// //         data = new int[2 * temp.length];
// //         for (int i = 0; i <= temp.length - 1; ++i)
// //             data[i] = temp[i];
// //     }

// // }

// class Polynomial {

//     private int[] data;
//     private int nextElementIndex;

//     public Polynomial() {
//         data = new int[5];
//         nextElementIndex = 0;
//     }

//     // DynamicArray d = new DynamicArray();

//     // private void DynamicArray(){
//     // data = new int[5];
//     // nextElementIndex = 0;
//     // }

//     // public int[] increaseCapacity(int deg) {
//     // if (deg == data.length)
//     // doubleCapacity();

//     // data = new int[deg];
//     // return data;
//     // }

//     private void doubleCapacity() {
//         int[] temp = data;
//         data = new int[2 * temp.length];
//         for (int i = 0; i <= temp.length - 1; ++i)
//             data[i] = temp[i];
//     }

//     public void setCoefficient(int deg, int coeff) {
//         if (nextElementIndex == data.length)
//             doubleCapacity();
//         for (int i = 0; i <= deg; ++i) {
//             if (i == deg){
//                 data[deg] = coeff;
//                 nextElementIndex++;
//             }
//             else{
//                 data[i] = 0;
//                 nextElementIndex++;
//             }
//         }
//     }

//     // public void setCoefficient(int deg, int coeff) {
//     // for (int i = 0; i <= deg; ++i) {
//     // if (i == deg)
//     // data[i] = coeff;
//     // else
//     // data[i] = 0;
//     // }
//     // }

//     public void print() {
//         for (int i = 0; i <= data.length - 1; ++i) {
//             if (data[i] != 0)
//                 System.out.println(data[i] + "x" + i + " ");
//         }
//     }

// }

// public class PolynomialClassUse {

//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         int n = s.nextInt();
//         int degree1[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             degree1[i] = s.nextInt();
//             System.out.println("hello1");
//         }
//         int coeff1[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             coeff1[i] = s.nextInt();
//             System.out.println("hello2");
//         }
//         Polynomial first = new Polynomial();
//         for (int i = 0; i < n; i++) {
//             first.setCoefficient(degree1[i], coeff1[i]);
//         }
//         n = s.nextInt();
//         int degree2[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             degree2[i] = s.nextInt();
//         }
//         int coeff2[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             coeff2[i] = s.nextInt();
//         }
//         Polynomial second = new Polynomial();
//         for (int i = 0; i < n; i++) {
//             second.setCoefficient(degree2[i], coeff2[i]);
//         }
//         int choice = s.nextInt();
//         Polynomial result;
//         switch(choice){
//         // Add
//         // case 1:
//         // result = first.add(second);
//         // result.print();
//         // break;
//         // Subtract
//         // case 2 :
//         // result = first.subtract(second);
//         // result.print();
//         // break;
//         // Multiply
//         // case 3 :
//         // result = first.multiply(second);
//         // result.print();
//         // break;
//         }
//     }

// }

//revised
import java.util.Scanner;

//code
class Polynomial {
    int[] poly;

    Polynomial() {
        poly = new int[10];
    }

    /*
     * This function sets coefficient for a particular degree value, if degree is
     * not there in the polynomial
     * then corresponding term(with specified degree and value is added int the
     * polynomial. If the degree
     * is already present in the polynomial then previous coefficient is replaced by
     * new coefficient value passed as function argument
     */
    public void setCoefficient(int degree, int coeff) {

        if (degree > poly.length - 1) {
            // doubleCapacity();
            int[] temp = poly;
            poly = new int[degree + 1];
            for(int i = 0; i < temp.length; ++i){
                poly[i] = temp[i];
            }
        }
        poly[degree] = coeff;

    }


    // Prints all the terms(only terms with non zero coefficients are to be printed)
    // in increasing order of degree.
    public void print() {

        for (int i = 0; i < poly.length; ++i){
            if (poly[i] != 0){
                System.out.print(poly[i] + "x" + i + " ");
            }
        }
        System.out.println();

    }

    // Adds two polynomials and returns a new polynomial which has result
    public Polynomial add(Polynomial p) {

        Polynomial ans = new Polynomial();
        int p1len = this.poly.length;
        int p2len = p.poly.length;
        int len = Math.min(p1len, p2len);

        int i;
        for (i = 0; i < len; ++i){
            ans.setCoefficient(i, this.poly[i] + p.poly[i]);
        }

        while(i < p1len){
            ans.setCoefficient(i, this.poly[i]);
        }

        while(i < p2len){
            ans.setCoefficient(i, p.poly[i]);
        }

        return ans;

    }

    // Subtracts two polynomials and returns a new polynomial which has result
    public Polynomial subtract(Polynomial p) {

        Polynomial ans = new Polynomial();
        int p1len = this.poly.length;
        int p2len = p.poly.length;
        int len = Math.min(p1len, p2len);

        int i;
        for (i = 0; i < len; ++i){
            ans.setCoefficient(i, this.poly[i] - p.poly[i]);
        }

        while(i < p1len){
            ans.setCoefficient(i, this.poly[i]);
        }

        while(i < p2len){
            ans.setCoefficient(i, -p.poly[i]);
        }

        return ans;

    }

    // Multiply two polynomials and returns a new polynomial which has result
    public Polynomial multiply(Polynomial p) {
        Polynomial ans = new Polynomial();
        for (int i = 0; i < this.poly.length; ++i){
            for (int j = 0; j < p.poly.length; ++j){
                int degreeOfTheTerm = i + j;
                int newCoefficientOfTheTerm = this.poly[i] * p.poly[j];
                int oldCoefficientOfTheTerm = ans.getCoefficient(degreeOfTheTerm);
                ans.setCoefficient(degreeOfTheTerm, oldCoefficientOfTheTerm + newCoefficientOfTheTerm);
            }
        }
        return ans;
    }

    private int getCoefficient(int degreeOfTheTerm){
        if (degreeOfTheTerm > this.poly.length){
            return 0;
        }
        return poly[degreeOfTheTerm];
    }

}

public class PolynomialClassUse {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
        int choice = s.nextInt();
        Polynomial result;
        switch (choice) {
            // Add
            case 1:
                result = first.add(second);
                result.print();
                break;
            // Subtract
            case 2:
                result = first.subtract(second);
                result.print();
                break;
            // Multiply
            case 3:
                result = first.multiply(second);
                result.print();
                break;
        }

    }

}
