// https://leetcode.com/problems/merge-intervals/ 

/*
  Intuition :
  ---------
  Starting pt. k against sort karo.
  Ek Stack bnao
  Now, one by one find overlapping interval against stack's top, if overlapping then merge and push onto the stack else push as it is.
  Last me jo v stack me hoga wo ans hai.
*/

class Solution {
    
    public static class Pair {
        int start = 0;
        int end = 0;
        
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int m = intervals[0].length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        Stack<Pair> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            if(!stack.isEmpty() && stack.peek().end >= interval[0]) {  // Agar pichla end Pt. bada ya equal hai curr start pt. se toh overlap ho raha hai
                Pair pair = stack.pop();
                stack.push(new Pair(pair.start, Math.max(pair.end, interval[1])));  // Pichla and curr end pt. me se jo v bada hoga wo new end pt. bnega 
            }
            else { // No overlapping
                stack.push(new Pair(interval[0], interval[1]));
            }
        }
        
        int i = 0;
        int[][] ans = new int[stack.size()][m];
        for(Pair pair : stack) {
            ans[i][0] = pair.start;
            ans[i++][1] = pair.end;
        }
        return ans;
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
