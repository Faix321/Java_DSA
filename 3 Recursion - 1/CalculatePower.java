class Solution {

	public static int power(int x, int n) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		int ans = 0;
        
        //base case
        if (n==1)
            ans = x;
        
        //IH
        int smallOutput = power(x,n-1);
        
        //IS
        int Output = smallOutput * x;
        
        return Output;
	}
}

public class CalculatePower{
    public static void main(String[] args){
        // Solution s = new Solution();
        int solution = Solution.power(3,4);
        System.out.println(solution);
    }
}