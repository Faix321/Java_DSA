import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// import java.util.Stack;
class Solution {

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		Integer initialSize = input.size();
        // Integer firstElem = input.pop();
        if(input.size() == 0 || input.size() == 1){
            return;
        }
		
        Integer firstElem = input.pop();
        
        reverseStack(input, extra);

        int delElem = 0;
        while(!input.isEmpty()){
            delElem = input.pop();
            extra.push(delElem);
        }

        input.push(firstElem);
        int delElem2 = 0;
        while(!extra.isEmpty()){
            // input.push(firstElem);

            delElem2 = extra.pop();
            input.push(delElem2);

        }
	}
}


public class ReverseStack {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Stack<Integer> takeInput() throws NumberFormatException, IOException {
    	int size = Integer.parseInt(br.readLine().trim());
    	Stack<Integer> input = new Stack<>();

    	if (size == 0) {
    		return input;
    	}
    	
    	String[] values = br.readLine().trim().split(" ");

    	for(int i = 0; i < size; i++) {
    		input.push(Integer.parseInt(values[i]));
    	}

    	return input;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
    	Stack<Integer> input = takeInput();
    	Stack<Integer> empty = new Stack<>();

    	Solution.reverseStack(input, empty);

    	while(!input.isEmpty()) {
    		System.out.print(input.pop() + " ");
    	}

    }
}