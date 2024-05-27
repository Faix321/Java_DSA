//Q2 - optimized solution
class Solution{
    public static int lastIndexSolution(int input[], int x,int startIndex){
        
        if(startIndex == input.length)
            return -1;

        int ans1 = lastIndexSolution(input, x, startIndex + 1);
        if (ans1 == -1){
            if (input[startIndex] == x)
                return startIndex;
            else
                return -1;
        }
        else
            return ans1 ;    //doubt

    }

    public static int lastIndex(int input[], int x){
        int finalAns = lastIndexSolution(input, x, 0);
        return finalAns;
    }

}

public class LastIndexOfANumberInAnArray {
    public static void main(String[] args) {
        int[] a = {5,5,5,5,5,5,5,};
        int ans = Solution.lastIndex(a, 5);
        System.out.println(ans);
    }
}
