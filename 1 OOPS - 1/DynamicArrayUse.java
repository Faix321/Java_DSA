import java.util.Scanner;

class DynamicArray {

    int[] data;
    int nextElementIndex;

    public DynamicArray() {
        data = new int[5];
        nextElementIndex = 0;
    }

    // m1
    public int size() {
        return nextElementIndex;
    }

    // m2
    public int getElement(int i) {
        if (i >= nextElementIndex)
            return -1;
        return data[i];
    }

    // m3
    public boolean isEmpty() {
        return (nextElementIndex == 0);
    }

    // m4
    public void setElement(int i, int element) {
        if (i > nextElementIndex)
            return;
        data[i] = element;
    }

    // m5
    public void insert(int element) {
        if (nextElementIndex == data.length)
            doubleCapacity();

        data[nextElementIndex] = element;
        nextElementIndex++;
    }

    private void doubleCapacity() {
        int[] temp = data;
        data = new int[2 * temp.length];
        for (int i = 0; i <= (temp.length) - 1; ++i)
            data[i] = temp[i];
    }

    // m6
    public int removeLast() {
        if (nextElementIndex == 0)
            return -1;
        int temp = nextElementIndex - 1;
        --nextElementIndex;
        return data[temp];
    }

    // m7
    public void insertAtAnyPosition(int i, int element) {
        // for (int j = i; j <= size() - 1; ++j){
        // data[(j++) + 1] = data[j++];
        // }
        // data[i] = element;
        for (int j = size() - 1; j > i; --j) {
            data[j] = data[j - 1];
        }
        data[i] = element;
        nextElementIndex++;
    }

    // m8
    public int removeFromAnyPosition(int i) {
        if (nextElementIndex == 0)
            return -1;
        int temp = data[i];
        for (int j = i + 1; j <= size() - 1; ++j)
            data[j - 1] = data[j];
        --nextElementIndex;
        return temp;
    }

}

public class DynamicArrayUse {

    public static void main(String[] args) {
        DynamicArray d = new DynamicArray();

        // m1
        for (int i = 1; i <= 2; ++i) {
            Scanner sc = new Scanner(System.in);
            int element = sc.nextInt();
            d.insert(element);
        }

        // m2
        for (int i = 0; i < 2; ++i)
            System.out.print(d.getElement(i) + " ");

        System.out.println(" ");

        //m3
        System.out.println(d.isEmpty());

        // m4
        System.out.println("\nsize = " + d.size());
        System.out.println("\n");

        // m5
        d.setElement(1, 66);
        for (int i = 0; i < 2; ++i)
            System.out.print(d.getElement(i) + " ");
        System.out.println("\n");

        // m6
        System.out.println("element removed from last index is : " +d.removeLast());
        for (int i = 0; i < 1; ++i)
        System.out.print(d.getElement(i) + " ");
        System.out.println("\n");
        System.out.println("updated size = " + d.size());

        // m7
        d.insertAtAnyPosition(7, 1234);
        for (int i = 0; i < d.size() - 1; ++i)
            System.out.print(d.getElement(i) + " ");
        System.out.println("\nsize = " + d.size());

        // m8
        System.out.println("element removed from 5th index : " + d.removeFromAnyPosition(5));
        for (int i = 0; i < d.size() - 1; ++i)
            System.out.print(d.getElement(i) + " ");
        System.out.println("\nsize = " + d.size());

    }

}
