//O(n^2)


import java.util.Scanner;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    LinkedListNode(T data) {
        this.data = data;
    }
}

class CreateDynamicLL {
    public static LinkedListNode<Integer> createLLDynamic() {
        LinkedListNode<Integer> head = null;

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        while (data != -1) {
            LinkedListNode<Integer> currentNode = new LinkedListNode<>(data);

            if (head == null) {
                head = currentNode;
            }

            else {
                LinkedListNode<Integer> tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = currentNode;
            }

            data = sc.nextInt();
        }

        return head;
    }
}

class printLL {
    public static void printLL(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class UseDynamicLL {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = CreateDynamicLL.createLLDynamic();
        printLL.printLL(head);
    }
}
