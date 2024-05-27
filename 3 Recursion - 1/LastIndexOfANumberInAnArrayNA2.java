//Q2 - optimized solution
class Solution {
    public static int lastIndexSolution(int input[], int x,int startIndex){
        
        if (input.length == 0)
            return -1;
        
        int ans1 = lastIndexSolution(int input[], int x, int startIndex + 1);
        if (input[startIndex] == x)
            return startIndex;
        if (ans1 == -1){
            if (input[0] == x)
                return 0;
            else
                return -1;
        }
        else
            return ans1;

    }

    public static int lastIndex(int input[], int x) {
        int finalAns = lastIndexSolution(input, x, 0);
        return finalAns;
    }
}

public class LastIndexOfANumberInAnArrayNA2 {
    public static void main(String[] args) {
        int[] a = { 1, 2, 5, 4, 5, 9, 8 };
        int ans = Solution.lastIndex(a, 5);
        System.out.println(ans);
    }
}
