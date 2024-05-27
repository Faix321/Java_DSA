import java.util.Scanner;
import java.util.Stack;

class QueueUsingStacks<T> {
    Stack<T> s1;
    Stack<T> s2;

    public QueueUsingStacks(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public int getSize(){
        return s1.size();
    }

    public boolean isEmpty(){
        return s1.isEmpty();
    }

    public void enqueue(T elem){
        s1.add(elem);
    }

    public T dequeue(){
        while(s1.size() != 1){
            s2.add(s1.pop());
        }

        T delElem = s1.pop();

        while(s2.size() != 0){
            s1.add(s2.pop());
        }

        return delElem;

    }

    public T front(){
        while (s1.size() != 1){
            s2.add(s1.pop());
        }
        T frontElem = s1.peek();
        while(s2.size() != 0){
            s1.add(s2.pop());
        }
        return frontElem;
    }

}

public class QueueUsingStacksUse{

        private static Scanner s = new Scanner(System.in);

        public static void main(String[] args) {
            QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
    
            int q = s.nextInt();
    
            while (q > 0) {
                int choice, input;
                choice = s.nextInt();
    
                switch(choice) {
                    case 1:
                        input = s.nextInt();
                        queue.enqueue(input);
                        break;
    
                    case 2:
                        System.out.println(queue.dequeue());
                        break;
    
                    case 3:
                        System.out.println(queue.front());
                        break;
    
                    case 4:
                        System.out.println(queue.getSize());
                        break; 
    
                    default: 
                        System.out.println((queue.isEmpty()) ? "true" : "false");
                }
    
                q -= 1;
            }
    
        }
}
