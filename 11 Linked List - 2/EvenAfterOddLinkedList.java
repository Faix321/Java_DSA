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







//code
class Solution {
	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        if(head == null){
            return null;
        }
		LinkedListNode<Integer> OddH = null, OddT = null, EvenH = null, EvenT = null;
        while(head != null){
            // System.out.println("headData=" + head.data);
            if((head.data) % 2 == 0){ //even
                // System.out.println("evenData");
                if(EvenH == null){
                    EvenH = head;
                    EvenT = head;
                    System.out.println("EvenH=" + EvenH.data);
                }else{
                    EvenT.next = head;
                    EvenT = head;
                    System.out.println("EvenT=" + EvenT.data);
                }   
            }else{   //odd
                // System.out.println("oddData");
                if(OddH == null){
                    OddH = head;
                    OddT = head;
                    System.out.println("OddH=" + OddH.data);
                }else{
                    OddT.next = head;
                    OddT = head;
                    System.out.println("OddT=" + OddT.data);
                }
            }
            head = head.next;
        }
        
        if(OddH != null && EvenH != null){
            OddT.next = EvenH;
        }
        
        if(EvenH != null){
        	EvenT.next = null;
        }
        
        
        if(OddH != null){
        	return OddH;
        }else{
            return EvenH;
        }
        
        // if(OddH != null){
        //     OddT.next = EvenH;
        // }
        
        
	}
}










public class EvenAfterOddLinkedList {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }
    
    public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode<Integer> head = takeInput(); 

            LinkedListNode<Integer> newHead = Solution.evenAfterOdd(head);
            print(newHead);

            t -= 1;
        }

    }
}
