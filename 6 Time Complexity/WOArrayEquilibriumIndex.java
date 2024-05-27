class Solution{
    public static int arrayEquilibriumIndex(int[] arr){

        int i =0;
        int LSum = 0, RSum = 0; //L == Left, R == Right

        while(i < arr.length){

            for(int j = 0; j < i; ++j)
                LSum += arr[j];

            for(int j = i + 1; j < arr.length; ++j)
                RSum += arr[j];

            if (LSum == RSum){
                return i;
                // break;
            }

            ++i;

        }
        
        return -1;

    }
}

public class WOArrayEquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {2,3,10,-10,4,2,9};
        int ans = Solution.arrayEquilibriumIndex(arr);
        System.out.println(ans);
    }
}
