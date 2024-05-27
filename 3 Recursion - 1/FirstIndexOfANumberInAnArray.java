//Q1 - preferred approach
class Solution {

    public static int firstIndexSolution(int input[], int x, int startIndex) {
        if (startIndex == input.length)
            return -1;

        if (input[startIndex] == x)
            return startIndex;

        int inSmallArray = firstIndexSolution(input, x, startIndex + 1);
        return inSmallArray;
    }

    public static int firstIndex(int input[], int x) {
        int ans = firstIndexSolution(input, x, 0);
        return ans;
    }
}

public class FirstIndexOfANumberInAnArray {
    public static void main(String[] args) {
        int[] input = { 1, 5, 2, 3, 4, 5 };
        int ans = Solution.firstIndex(input, 5);
        System.out.println(ans);
    }
}
