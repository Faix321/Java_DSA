import java.util.Scanner;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    LinkedListNode(T data) {
        this.data = data;
    }
}

// class PrintLL {

//     public static void printLL(LinkedListNode<Integer> head) {
//         LinkedListNode<Integer> temp = head;
//         while (temp != null) {
//             System.out.print(temp.data + " ");
//             temp = temp.next;
//         }
//         System.out.println();
//     }
// }

class CreateDynamicLL2 {
    public static LinkedListNode<Integer> createDynamicLL2() {
        LinkedListNode<Integer> head = null, tail = null;

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        while (data != -1) {
            LinkedListNode<Integer> currentNode = new LinkedListNode<>(data);
            if (head == null) {
                head = currentNode;
                tail = currentNode;
            } else {
                tail.next = currentNode;
                tail = currentNode;
            }

            data = sc.nextInt();
        }
        return head;
    }
}

class Solution{
    public static void printLLRecur(LinkedListNode<Integer> head){
        if (head == null){
            System.out.println("\nLL printed recursively");
            return;
        }

        System.out.print(head.data + " ");
        printLLRecur(head.next);

        //to print in reverse order
        // printLLRecur(head.next);
        // System.out.print(head.data + " ");
        
    }
}


public class printLLRecur {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = CreateDynamicLL2.createDynamicLL2();
        Solution.printLLRecur(head);
    }
}
