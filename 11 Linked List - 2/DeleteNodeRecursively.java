import java.util.Scanner;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    LinkedListNode(T data) {
        this.data = data;
    }
}

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

class PrintLLRecur {
    public static void printLLRecur(LinkedListNode<Integer> head) {
        if (head == null) {
            // System.out.println("\nLL printed recursively");
            System.out.println(" ");
            return;
        }

        System.out.print(head.data + " ");
        printLLRecur(head.next);

        // to print in reverse order
        // printLLRecur(head.next);
        // System.out.print(head.data + " ");

    }
}

class InsertLLNodeRecur {
    public static LinkedListNode<Integer> insertNodeRecur(LinkedListNode<Integer> head, int data, int pos) {

        if (head == null && pos > 0)
            return head;

        if (pos == 0) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
            newNode.next = head;
            head = newNode;
            return head;
        } else {
            LinkedListNode<Integer> newHead = insertNodeRecur(head.next, data, pos - 1);
            head.next = newHead;
            return head;
        }

    }
}

class Solution {

    public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
        if (head == null && pos > 0) {
            return head;
        }

        if (pos == 0) {
            head = head.next;
            return head;
        } else {
            LinkedListNode<Integer> smallHead = deleteNodeRec(head.next, pos - 1);
            head.next = smallHead;
            return head;
        }
    }

}

public class DeleteNodeRecursively {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = CreateDynamicLL2.createDynamicLL2();
        PrintLLRecur.printLLRecur(head);
        LinkedListNode<Integer> head1 = Solution.deleteNodeRec(head, 6);
        PrintLLRecur.printLLRecur(head1);
    }
}
