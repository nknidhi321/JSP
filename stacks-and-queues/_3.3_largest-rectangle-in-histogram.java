// https://leetcode.com/problems/largest-rectangle-in-histogram/

class Solution {
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] ls = nextSmallerToLeft(n, heights);
        int[] rs = nextSmallerToRight(n, heights);
        
        // Sbka nextSmallerToLeft and nextSmallerToRight, ls and rs array se nikalo and max calulate karte chalo   
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int width =  rs[i] - ls[i] - 1; // Na nextSmallerToLeft ko lena hai, na nextSmallerToRight ko lena hai islye -1 v hoga
            max = Math.max(max, heights[i] * width); // Calulate area and then max
        }
        return max;
    }
    
    public static int[] nextSmallerToLeft(int n, int[] heights) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1); // Agar kisi ka nextSmallerToLeft nahi mil raha toh wo -1 hoga
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++) { // Left calculate karna hai toh left se iterate karo
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();  //Khudse bade ya equal ko pop karwao
            if(!stack.isEmpty()) ans[i] = stack.peek(); // Ab jo v hai wo, val se chota hoga
            stack.push(i); // Tum v kisi ka answer bn saktey ho
        }
        return ans;
    }
    
    public static int[] nextSmallerToRight(int n, int[] heights) {
        int[] ans = new int[n];
        Arrays.fill(ans, n); // Agar kisi ka nextSmallerToRight nahi mil raha toh wo n hoga
        Stack<Integer> stack = new Stack<>();
        
        for(int i = n - 1; i >= 0; i--) { // Right calculate karna hai toh right se iterate karo
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop(); //Khudse bade ya equal ko pop karwao
            if(!stack.isEmpty()) ans[i] = stack.peek();  // Ab jo v hai wo, val se chota hoga
            stack.push(i); // Tum v kisi ka answer bn saktey ho
        }
        return ans;
    }
}
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
