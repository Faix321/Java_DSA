//code 2
import java.util.Arrays;
class Solution {	
	public static int tripletSum(int[] arr, int num) {
		Arrays.sort(arr);
        int numOfTriplets = 0;
        for(int k = 0; k < arr.length; ++k){
            int targetSum = num - arr[k];
            int i = 1, j = arr.length - 1;
            while(i < j){
                if(arr[i] + arr[j] == targetSum){
                    ++numOfTriplets;
                    ++i;
                    --j;
                }else if(arr[i] + arr[j] < targetSum){
                    ++i;
                }else{
                    --j;
                }
            }
        }
        return numOfTriplets;
	}
}



// class Solution {	

// 	public static int tripletSum(int[] arr, int num) {
// 		int count = 0;
//         for(int i = 0; i < arr.length; ++i){
//             for(int j = 0; j < arr.length; ++j){
//                 for(int k = 0; k < arr.length; ++k){
//                     if(arr[i] + arr[j] + arr[j] == num){
//                         count++;
//                     }
//                 }
//             }
//         }
//         return count;
// 	}
// }

// class Solution {	

// 	public static int tripletSum(int[] arr, int num) {
// 		int count = 0;
//         for(int i = 0; i < arr.length; ++i){
//             for(int j = i + 1; j < arr.length; ++j){
//                 for(int k = j + 1; k < arr.length; ++k){
//                     if(arr[i] + arr[j] + arr[k] == num){
//                         count++;
//                     }
//                 }
//             }
//         }
//         return count;
// 	}
// }

public class TripletSum {
    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arr = {2, -5, 8, -6, 0, 5, 10, 11, -3};
        int ans = Solution.tripletSum(arr, 10);
        System.out.println(ans);
    }
}
