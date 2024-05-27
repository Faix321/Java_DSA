import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}







//code -2
class Solution {
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        if (head == null) {
            return null;
        }

        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            if (temp.next != null && temp.data.equals(temp.next.data)) {
                LinkedListNode<Integer> temp2 = temp.next.next;
                temp.next = temp2;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}







// code - prolly same as before
class Solution {
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        if (head == null) {
            return null;
        }

        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            if (temp.next != null && temp.data == temp.next.data) {
                LinkedListNode<Integer> temp2 = temp.next.next;
                temp.next = temp2;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}

// code
// class Solution {
// public static LinkedListNode<Integer>
// removeDuplicates(LinkedListNode<Integer> head) {
// if (head == null){
// return null;
// }

// LinkedListNode<Integer> temp = head;
// while(temp != null){
// if(temp.next != null && temp.data == temp.next.data){
// LinkedListNode<Integer> temp2 = temp.next.next;
// temp.next = temp2;
// // break;
// }
// else{
// temp = temp.next;
// }
// }
// return head;
// }
// }

public class EliminateDuplicatesFromLL {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while (i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }

    public static void print(LinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode<Integer> head = takeInput();

            head = Solution.removeDuplicates(head);
            print(head);

            t -= 1;
        }

    }
}
