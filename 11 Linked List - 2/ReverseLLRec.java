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


class Solution {

	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
		if (head == null || head.next == null){
            return head;
        }else{
            LinkedListNode<Integer> reversedHead = reverseLinkedListRec(head.next);
            LinkedListNode<Integer> tail = reversedHead;
            while(tail != null){
                tail = tail.next;
            }
            tail.next = head;
            head = null;
            return reversedHead;
        }
	}

}

public class ReverseLLRec {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = CreateDynamicLL2.createDynamicLL2();
        PrintLLRecur.printLLRecur(head);
        LinkedListNode<Integer> revHead = Solution.reverseLinkedListRec(head);
        PrintLLRecur.printLLRecur(revHead);
    }
}
