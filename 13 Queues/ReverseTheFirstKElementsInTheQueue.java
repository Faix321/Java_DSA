import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
    // int initialSize = input.size();
    // if (input.size() == initialSize - k){
    // return input;
    // }

    // Integer top = input.poll();

    // Queue smallOutput = reverseKElements(input, k - 1);

    // Queue<Integer> temp = new LinkedList<>();

    // while(input.size() != 0){
    // temp.add(input.poll());
    // }

    // input = smallOutput;
    // while(temp.size() != 0){
    // input.add(temp.poll());
    // }
    // }

    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {

        int initialSize = input.size();
        reverseQueue(input, k);
        
        for(int i = 0; i < initialSize - k; ++i){
            Integer top = input.poll();
            input.add(top);
        }

        return input;

    }

    public static void reverseQueue(Queue<Integer> input, int k) {
        int initialSize = input.size();
        if (input.size() == initialSize - k) {
            return;
        }

        int delElem = input.poll();

        reverseQueue(input, k - 1);

        input.add(delElem);
        input.peek()
    }

}

public class ReverseTheFirstKElementsInTheQueue {
public static void main(String[] args) {
    
}
}
