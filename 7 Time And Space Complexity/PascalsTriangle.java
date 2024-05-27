import java.util.* ;
import java.io.*; 
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// public class Solution {
// 	public static ArrayList<ArrayList<Long>> printPascal(int n) {
//                  // Write your code here.
// 	}
// }


//code 1
public class PascalsTriangle {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
		ArrayList<ArrayList<Long>> ans = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> current, prev = null;
		for(int row = 0; row < n; ++row){
			current = new ArrayList<Long>();
			int numOfColsInRow = row;
			for(int cols = 0; cols < numOfColsInRow; ++cols){
				if(cols == 0 ||  cols == numOfColsInRow - 1){
					current.add((long)1);
				}else{
					current.add(prev.get(cols - 1) + prev.get(cols));
				}
			}
			prev = current;
			ans.add(current);

			System.out.println();
		}
	}

    public static void main(String[] args) {
        
    }
}
