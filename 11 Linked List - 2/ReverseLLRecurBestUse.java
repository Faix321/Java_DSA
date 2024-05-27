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
            System.out.println(" ");
            return;
        }

        System.out.print(head.data + " ");
        printLLRecur(head.next);

    }
}

class ReverseLLRecurBest{
    public static LinkedListNode<Integer> reverseLLRecurBest(LinkedListNode<Integer> head){
        if (head == null || head.next == null)
            return head;

        LinkedListNode<Integer> revHead = reverseLLRecurBest(head.next);
        LinkedListNode<Integer> revTail = head.next;
        revTail.next = head;
        head.next = null;
        return revHead; 
    }
}

public class ReverseLLRecurBestUse {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = CreateDynamicLL2.createDynamicLL2();
        PrintLLRecur.printLLRecur(head);
        LinkedListNode<Integer> head1 = ReverseLLRecurBest.reverseLLRecurBest(head);
        PrintLLRecur.printLLRecur(head1);
    }
}
