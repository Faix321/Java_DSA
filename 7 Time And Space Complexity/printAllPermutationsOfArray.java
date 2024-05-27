import java.util.*;

class printAllPermutationsOfArray {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recPermuteHelper(ans, ds, freq, nums);
        return ans; 
    }

    private static void recPermuteHelper(List<List<Integer>> ans, List<Integer> ds, boolean[] freq, int[] nums){
        //base case
        if(ds.size() == nums.length){
            ans.add(new ArrayList<Integer>(ds));
            return;
        }

        for(int i = 0; i < nums.length; ++i){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                recPermuteHelper(ans, ds, freq, nums);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = permute(nums);
        for(int i = 0; i < ans.size(); ++i){
            for(int j = 0; j < ans.get(i).size(); ++j){
                System.out.print(ans.get(i).get(j));
            }
            System.out.println();
        }
    }
}