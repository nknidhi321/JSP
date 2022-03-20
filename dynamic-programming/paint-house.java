// https://www.lintcode.com/problem/515/

public class Solution {
 
    public int minCost(int[][] cost) {
        if(cost.length == 0) return 0;

        int n = cost.length;
        for(int i = 1; i < n; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);
        }
        return Math.min(cost[n - 1][0], Math.min(cost[n - 1][1], cost[n - 1][2]));
    }
}
