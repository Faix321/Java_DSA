//creating new array method (less optimized)
class Solution{
    public static int lastIndex(int input[], int x){
        //base case
        if(input.length == 0)
            return -1;

        int[] smallArray = new int[input.length - 1];
        for(int i = 1; i < input.length; ++i)
            smallArray[i-1] = input[i];

        int ans = lastIndex(smallArray, x);
        if (ans == -1){
            if (input[0] == x)
                return 0;
            else
                return -1;
        }
        else
            return ans + 1;
        
    }
}

public class LastIndexOfANumberInAnArrayNA {
    public static void main(String[] args) {
        int[] a = {5,5,5,5,5,5,5};
        int ans = Solution.lastIndex(a, 5);
        System.out.println(ans);
    }
}
