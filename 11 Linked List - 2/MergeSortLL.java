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

	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {

        if (head == null || head.next == null){
            return head;
        }

		LinkedListNode<Integer> slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode<Integer> temp = head;
        while(head != slow){
            head = head.next;
        }
        head.next = null;

        LinkedListNode<Integer> head1 = mergeSort(head);
        LinkedListNode<Integer> head2 = mergeSort(slow.next);
        LinkedListNode<Integer> ansHead = mergingTwoSortedLinkedLists(head1,head2);

        return ansHead;

	}

    public static LinkedListNode<Integer> mergingTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        LinkedListNode<Integer> t1 = head1, t2 = head2;
        LinkedListNode<Integer> grandHead = null, grandTail = null;

        if(t1.data < t2.data){
            grandHead = head1;
            grandTail = t1;
            t1 = t1.next;
        }else{
            grandHead = head2;
            grandTail = t2;
            t2 = t2.next;
        }

        while(t1 != null && t2 != null){
            if(t1.data < t2.data){
                grandTail.next = t1;
                grandTail = t1;
                t1 = t1.next;
            }else{
                grandTail.next = t2;
                grandTail = t2;
                t2 = t2.next;
            }
        }

        if(t1 != null){
            grandTail.next = t1;
        }
        if(t2 != null){
            grandTail.next = t2;
        }

        return grandHead;
    }

}

public class MergeSortLL {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = CreateDynamicLL2.createDynamicLL2();
        PrintLLRecur.printLLRecur(head);
        LinkedListNode<Integer> head2 = Solution.mergeSort(head);
        PrintLLRecur.printLLRecur(head2);
    }
}
