//Time Comlexity : O(nlogn)
import java.util.Arrays;

class Solution {

	public static int findDuplicate(int[] arr) {
		Arrays.sort(arr);
        for(int i = 1; i < arr.length; ++i){
            if (arr[i - 1] == arr[i])
                return arr[i-1];
        }
        return -1;
	}
}

public class DuplicateInArrayWO {
    public static void main(String[] args) {
        // int[] arr = {0, 7, 2, 5, 4, 7, 1, 3, 6};
        // int[] arr = {0, 2, 1, 3, 1};
        // int[] arr = {0, 3, 1, 5, 4, 3, 2};
        // int[] arr = {4, 4, 1, 5, 4, 7, 2};
        int[] arr = {4, 4, 1, 5, 4, 7, 2, 2};
        int ans = Solution.findDuplicate(arr);
        System.out.println(ans);
    }
}
