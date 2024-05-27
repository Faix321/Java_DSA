//incorrect approach
// class Solution {

// 	public static int findDuplicate(int[] arr) {
// 		int N = arr.length;
//         int sumUptoNMinusTwo = ((N - 2)*(N-1))/2;
//         int sumOfAllElements = sumUptoNMinusTwo + arr[arr.length - 1];
//         return sumOfAllElements - sumUptoNMinusTwo;
// 	}
// }


//O(n)
class Solution {

    public static int findDuplicate(int[] arr) {
        int sumOfAllElements = 0;
        for (int i = 0; i < arr.length; ++i) {
            sumOfAllElements += arr[i];
        }

        int lengthOfEntireArray = arr.length;
        int sumUptoNMinusTwoNaturalNum = ((lengthOfEntireArray - 2) * (lengthOfEntireArray - 1)) / 2;
        return sumOfAllElements - sumUptoNMinusTwoNaturalNum;
    }
}

public class DuplicateInArray {
    public static void main(String[] args) {
        // int[] arr = {0, 7, 2, 5, 4, 7, 1, 3, 6};
        // int[] arr = {0, 2, 1, 3, 1}; //correct
        // int[] arr = {0, 3, 1, 5, 4, 3, 2};
        int ans = Solution.findDuplicate(arr);
        System.out.println(ans);
    }
}
