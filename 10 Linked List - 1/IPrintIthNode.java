class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

class LinkedListUse{
    public static LinkedListNode<Integer> createLL(){
        LinkedListNode<Integer> n1 = new LinkedListNode<>(10);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(20);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(30);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(40);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        return n1;
    }

    public static void printLL(LinkedListNode<Integer> head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}

class Solution {

	public static void printIthNode(LinkedListNode<Integer> head, int i){
		LinkedListNode<Integer> temp = head;
        for (int j = 0; j < i; ++j){
            temp = temp.next;
        }
        System.out.println(temp.data);
	}
}

public class IPrintIthNode {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListUse.createLL();
        LinkedListUse.printLL(head);
        Solution.printIthNode(head, 2);
    }
}
