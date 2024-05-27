class Solution {

	public static int findUnique(int[] arr) {
        int unique = 0;
		for(int i = 0; i < arr.length; ++i){
            unique ^= arr[i];
        }
        return unique;
	}
}

class FindTheUniqueElement{
    public static void main(String[] args) {
        // int[] arr = {2, 3, 1, 6, 3, 6, 2};
        // int[] arr = {2, 4, 7, 2, 7};
        int[] arr = {1, 3, 1, 3, 6, 6, 7, 10, 7};
        int ans = Solution.findUnique(arr);
        System.out.println(ans);
    }
}