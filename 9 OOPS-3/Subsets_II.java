// import java.util.*;

// class Subsets_II {
//     public List<List<Integer>> subsetsWithDup(int[] arr) {
//         int N = arr.length;
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
//         List<Integer> smallAns = new ArrayList<Integer>();
//         helper(arr, N, ans, smallAns, 0, 0);
//         //Collections.sort(ans); --- works sithout writing this line as well
//         return ans;
//     }

//     void helper(int[] arr, int N, List<List<Integer>> ans, List<Integer> smallAns, int si, int sum){
//         //base case
//         if(si == N){
//             // if(ans.contains(su))
//             ans.add(sum, smallAns);
//             return;
//         }
        

//         // helper(arr, N, ans, smallAns, si + 1, ans.add(si, smallAns));
//         helper(arr, N, ans, smallAns, si + 1, smallAns.add(si));
//         helper(arr, N, ans, smallAns, si + 1, sum);
//     }

//     public static void main(String[] args) {
//         // ArrayList<String> arr = new ArrayList<>();
//         // arr.add(5);
//         // arr.add(2);
//         // arr.add(1);

//         int[] arr = {1, 2, 2};
//         ArrayList<String> ans = subsetsWithDup(arr);
//         for(int i = 0; i < ans.size(); ++i){
//             System.out.println(ans.get(i));
//         }
//     }
// }


//***************************************************************

//works
import java.util.*;

class Subsets_II {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> ds = new ArrayList<Integer>();
        helper(nums, 0, ans, ds);
        return ans;
    }

    private static void helper(int[] nums, int si, List<List<Integer>> ans, List<Integer> ds) {
        // base case
        if (si == nums.length) {
            if (!ans.contains(ds)) {
                ans.add(new ArrayList<Integer>(ds));
            }
            return;
        }

        ds.add(nums[si]);
        helper(nums, si + 1, ans, ds);
        ds.remove(ds.size() - 1);
        helper(nums, si + 1, ans, ds);
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 2, 2 };
        int[] nums = { 2, 2, 2, 1, 2 };
        // int[] nums = { 4, 4, 4, 1, 4 };  //works
        List<List<Integer>> ans = subsetsWithDup(nums);
        for (int i = 0; i < ans.size(); ++i) {
            for (int j = 0; j < ans.get(i).size(); ++j) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}



//************************************************************ */
//chatgpt -- garbage code
// import java.util.*;

// class Subsets_II {
//     public static List<List<Integer>> subsetsWithDup(int[] nums) {
//         Arrays.sort(nums);
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> ds = new ArrayList<>();
//         helper(nums, 0, ans, ds);
//         return ans;
//     }

//     private static void helper(int[] nums, int si, List<List<Integer>> ans, List<Integer> ds) {
//         // base case
//         if (si == nums.length) {
//             if (!ans.contains(ds)) {
//                 ans.add(new ArrayList<>(ds));
//             }
//             return;
//         }

//         // exclude current element
//         helper(nums, si + 1, ans, ds);

//         // include current element
//         if (si == 0 || nums[si] != nums[si-1] || ds.contains(nums[si-1])) {
//             ds.add(nums[si]);
//             helper(nums, si + 1, ans, ds);
//             ds.remove(ds.size() - 1);
//         }
//     }

//     public static void main(String[] args) {
//         // int[] nums = { 1, 2, 2 }; //works
//         // int[] nums = { 4, 4, 4, 1, 4 };  //works
//         // int[] nums = { 2, 1, 2 }; //works
//         // int[] nums = { 2, 2, 1 }; //works
//         // int[] nums = { 2, 2, 2 }; //works
//         int[] nums = { 2, 1, 2, 2 }; // works
//         List<List<Integer>> ans = subsetsWithDup(nums);
//         for (int i = 0; i < ans.size(); ++i) {
//             for (int j = 0; j < ans.get(i).size(); ++j) {
//                 System.out.print(ans.get(i).get(j) + " ");
//             }
//             System.out.println();
//         }
//     }
// }



//********************************************************* */
//chatgpt modified
// import java.util.*;

// class Subsets_II {
//     public static List<List<Integer>> subsetsWithDup(int[] nums) {
//         Arrays.sort(nums);
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> ds = new ArrayList<>();
//         helper(nums, 0, ans, ds);
//         return ans;
//     }

//     private static void helper(int[] nums, int si, List<List<Integer>> ans, List<Integer> ds) {
//         // base case
//         if (si == nums.length) {
//             if (!ans.contains(ds)) {
//                 ans.add(new ArrayList<>(ds));
//             }
//             return;
//         }

//         // exclude current element
//         helper(nums, si + 1, ans, ds);

//         // include current element
//         // if (si == 0 || nums[si] != nums[si-1] /* || ds.contains(nums[si-1]) */) {
//         if (si == 0 || nums[si] != nums[si-1] || ds.contains(nums[si-1])) {
//             ds.add(nums[si]);
//             helper(nums, si + 1, ans, ds);
//             ds.remove(ds.size() - 1);
//         }
//     }

//     public static void main(String[] args) {
//         // int[] nums = { 1, 2, 2 }; //works
//         // int[] nums = { 4, 4, 4, 1, 4 };  //works
//         int[] nums = { 1, 4, 4, 4, 4 };  //works
//         // int[] nums = { 2, 1, 2 }; //works
//         // int[] nums = { 2, 2, 1 }; //works
//         // int[] nums = { 2, 2, 2 }; //works
//         // int[] nums = { 2, 1, 2, 2 }; // works
//         // int[] nums = { 1, 4 }; // works
//         List<List<Integer>> ans = subsetsWithDup(nums);
//         for (int i = 0; i < ans.size(); ++i) {
//             for (int j = 0; j < ans.get(i).size(); ++j) {
//                 System.out.print(ans.get(i).get(j) + " ");
//             }
//             System.out.println();
//         }
//     }
// }