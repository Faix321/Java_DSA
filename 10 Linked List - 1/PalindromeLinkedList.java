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






// code - 2
class Solution {
	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		if(head == null){
            return true;
        }
        
        LinkedListNode<Integer> temp = head;
        int length = 0;
        while(temp != null){
            ++length;
            temp = temp.next;
        }
        System.out.println("length=" + length);
        
        if(length == 1 ){
            return true;
        }
        
        int mid = length/2;
        LinkedListNode<Integer> temp2 = head;
        while(mid != 0){
            temp2 = temp2.next;
            --mid;
        }
        
        LinkedListNode<Integer> secondHead = null;
        secondHead = temp2.next;
        temp2.next = null;
        
        LinkedListNode<Integer> reversedSecondHead = reverseLinkedListRec(secondHead);
        
        boolean ans = false;
        LinkedListNode<Integer> firstHead = head;
        if(length % 2 == 0){
        	while(firstHead != null && reversedSecondHead != null){
                System.out.println("1.firstHeadData=" + firstHead.data);
                System.out.println("1.reversedSecondHeadData=" + reversedSecondHead.data);
                if(firstHead != null && reversedSecondHead != null && firstHead.data.equals(reversedSecondHead.data)){
                    ans = true;
                }else{
                    ans = false;
                    break;
                }
                firstHead = firstHead.next; reversedSecondHead = reversedSecondHead.next;
        	}
            if(firstHead.data.equals(reversedSecondHead.data)){
                ans = true;
            }else{
                ans = false;
            }

        }else{
            while(firstHead != null && reversedSecondHead != null){
                System.out.println("2.firstHeadData=" + firstHead.data);
                System.out.println("2.reversedSecondHeadData=" + reversedSecondHead.data);
                if(firstHead != null && reversedSecondHead != null && firstHead.data.equals(reversedSecondHead.data)){
                    ans = true;
                }else{
                    ans = false;
                    break;
                }
                firstHead = firstHead.next; reversedSecondHead = reversedSecondHead.next;
            }
        }
        return ans;
	}
    
    private static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
		if (head == null || head.next == null){
            return head;
        }else{
            LinkedListNode<Integer> reversedHead = reverseLinkedListRec(head.next);
            LinkedListNode<Integer> tail = reversedHead;
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = head;
            head.next = null;
            return reversedHead;
        }
	}
    
}






























//code - wrong logic
// class Solution {
// 	public static boolean isPalindrome(LinkedListNode<Integer> head) {
// 		if(head == null){
//             return true;
//         }
        
//         LinkedListNode<Integer> temp = head;
//         int length = 0;
//         while(temp != null){
//             ++length;
//             temp = temp.next;
//         }
//         System.out.println("length=" + length);
        
//         int mid = length/2;
//         System.out.println("mid=" + mid);
//         LinkedListNode<Integer> temp2 = head;
//         while((mid - 1) != 0){ //imp - dry run to find out why minus one was necessary /* 2 3 5 3 2 dry run on this & see */
//             temp2 = temp2.next;
//             --mid;
//         }
//         System.out.println("temp2Data=" + temp2.data);
        
//         LinkedListNode<Integer> secondHead = null;
//         secondHead = temp2.next;
//         temp2.next = null;
//         System.out.println("secondHeadData=" + secondHead.data);
        
//         boolean ans = false;
//         LinkedListNode<Integer> firstHead = head;
//         while(firstHead != null && secondHead != null){
//             if(mid % 2 == 0){
//                 if(firstHead.data.equals(secondHead.data)){
//                     ans = true;
//                 }
//             }else{
//                 System.out.println("secondHead.next ka data =" + secondHead.next.data);
//                 if(firstHead.data.equals(secondHead.next.data)){
//                     ans = true;
//                 }
//             }
//             firstHead = firstHead.next; secondHead = secondHead.next;
//         }
//         return ans;
// 	}
// }










public class PalindromeLinkedList {
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

            boolean ans = Solution.isPalindrome(head);
            System.out.println(ans);

            t -= 1;

        }
        
    }
}
