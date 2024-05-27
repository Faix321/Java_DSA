import java.util.Arrays;

class Solution {	

	public static int pairSum(int[] arr, int num) {
		Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        int count = 0, count_i = 0, count_j = 0;
        while(i < j){
            if(arr[i] + arr[j] == num){
                for(int k = i + 1; k < j; ++k){
                    if(arr[i] == arr[k]){
                        count_i++;
                    }
                    if(arr[j] == arr[k]){
                        count_j++;
                    }
                }
                count += count_i * count_j;
                ++i;
                --j;
            }

            else if(arr[i] + arr[j] > num){
                --j;
            }

            else{
                ++i;
            }
        }
        return count;
	}
}

public class PairSum {
    public static void main(String[] args) {
        // int[] arr = {1, 3, 6, 2, 5, 4, 3, 2, 4};
        // int ans = Solution.pairSum(arr, 7);
        // int[] arr = {1, 3, 6, 2, 5, 4, 3, 2, 4};
        // int ans = Solution.pairSum(arr, 12);
        int[] arr = {2, 8, 10, 5, -2, 5};
        int ans = Solution.pairSum(arr, 10);
        System.out.println(ans);
    }
}
