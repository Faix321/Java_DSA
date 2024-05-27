import java.util.Scanner;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    LinkedListNode(T data) {
        this.data = data;
    }
}

class PrintLL{

    public static void printLL(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class CreateDynamicLL2 {
    public static LinkedListNode<Integer> createDynamicLL2(){
        LinkedListNode<Integer> head = null, tail = null;

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        while(data != -1){
            LinkedListNode<Integer> currentNode = new LinkedListNode<>(data);
            if (head == null){
                head = currentNode;
                tail = currentNode;
            }else{
                tail.next = currentNode;
                tail = currentNode;
            }

            data = sc.nextInt();
        }
        return head;
    }
}

class Solution{
    public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos){
        if (pos == 0){
            head = head.next;
            return head;
        }else{
            LinkedListNode<Integer> previousNode = head;
            int j = 0;
            while ( j < pos - 1 && previousNode != null){
                previousNode = previousNode.next;
                ++j;
            }
            if (previousNode != null && previousNode.next != null){
                previousNode.next = previousNode.next.next;
            }
        }
        return head;
    }
}

public class DeleteNodeInLL {
   public static void main(String[] args) {
       LinkedListNode<Integer> head = CreateDynamicLL2.createDynamicLL2();
       PrintLL.printLL(head);
       LinkedListNode<Integer> head1 = Solution.deleteNode(head, 3);
       PrintLL.printLL(head1);
   }
}
