//optimized
class Solution{
    public static int arrayEquilibriumIndex(int[] arr){
        int i = 0;
        int LSum = 0, RSum = 0, TSum = 0;

        while(i < arr.length){
            TSum += arr[i];
            ++i;
        }

        i = 0;
        while(i < arr.length){
            RSum = TSum - LSum - arr[i];

            if (LSum == RSum)
                return i;

            LSum += arr[i];
            ++i;
        }

        return -1;

    }
}

public class ArrayEquilibriumIndex {
    public static void main(String[] args) {
        // int[] arr = {2,3,10,-10,4,2,9};
        int[] arr = {1, 4, 9, 3, 2};
        // int[] arr = {1, 4, 6};
        // int[] arr = {1, -1, 4};
        int ans = Solution.arrayEquilibriumIndex(arr);
        System.out.println(ans);
    }
}
