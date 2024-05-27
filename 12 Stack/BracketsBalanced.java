import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
class Solution {

    public static boolean isBalanced(String expression) {
        Stack<String> stack = new Stack<>();
        for(String exp : stack){
            if(exp == "(" ){
                stack.push(exp);
            }
            else if(exp == ")" ){
                if(stack.peek() != exp){
                    return false;
                }
                else if(stack.size() == 0){
                    return false; //closing brackets more condn
                }
                else{
                    stack.pop();
                }
            }
        }
        if(stack.size() > 0){
            return false; //opening brackets more condition
        }else{
            return true;
        }
    }
}

// public class BracketsBalanced {
//     public static void main(String[] args) {
        
//     }
// }

public class BracketsBalanced {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String expression = br.readLine().trim();
        System.out.println(Solution.isBalanced(expression));
    }
}
