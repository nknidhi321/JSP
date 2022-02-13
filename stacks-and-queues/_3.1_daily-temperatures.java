// https://leetcode.com/problems/daily-temperatures/

class Solution {
    
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        return nextGreaterToRight(n, temperatures);
    }
    
    public static int[] nextGreaterToRight(int n, int[] temp) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temp[stack.peek()] <= temp[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) ans[i] = stack.peek() - i;
            else ans[i] = 0;
            stack.push(i);
        }
        return ans;
    }
}
