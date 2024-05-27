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

class DoubleNode{
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
}

class ReverseLLRecurBetter{
    public static DoubleNode reverseLLRecurBetter(LinkedListNode<Integer> head){
        DoubleNode ans;
        if (head == null || head.next == null){
            ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }

        DoubleNode smallAns = reverseLLRecurBetter(head.next);

        smallAns.tail.next = head;
        head.next = null;
        ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
    }

    public static LinkedListNode<Integer> reverseLLRecurBetterHelperFunction(LinkedListNode<Integer> head){
        DoubleNode ans = reverseLLRecurBetter(head);
        return ans.head;
    }
}



public class ReverseLLRecurBetterUse {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = CreateDynamicLL2.createDynamicLL2();
        PrintLLRecur.printLLRecur(head);
        LinkedListNode<Integer> head1 = ReverseLLRecurBetter.reverseLLRecurBetterHelperFunction(head);
        PrintLLRecur.printLLRecur(head1);
    }
}
