//Q1 - less optimized solution
class Solution {
    public static int firstIndex(int input[], int x) {
        if (input.length == 0)
            return -1;

        if (input[0] == x)
            return 0;

        int[] smallArray = new int[input.length - 1];
        for (int i = 1; i < input.length; ++i)
            smallArray[i - 1] = input[i];

        int ans = firstIndex(smallArray, x);
        if (ans == -1)
            return -1;
        else
            return ans + 1;

    }
}

public class FirstIndexOfANumberInAnArrayNA {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 5, 5, 7, 5 };
        int finalAnswer = Solution.firstIndex(a, 5);
        System.out.println(finalAnswer);
    }
}
