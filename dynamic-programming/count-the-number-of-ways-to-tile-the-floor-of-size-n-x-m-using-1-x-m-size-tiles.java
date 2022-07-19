// https://practice.geeksforgeeks.org/problems/count-the-number-of-ways-to-tile-the-floor-of-size-n-x-m-using-1-x-m-size-tiles0509/1

class Solution {
    
    int mod = (int)1e9 + 7;
    
    public int countWays(int n, int m) {
        int[] dp = new int[n + 1];  
        return ways(n, m, dp);
    }
    
    public int ways(int N, int m, int[] dp) {
        dp[0] = 0;
        for(int n = 1; n <= N; n++) {
            if(n < m) {
                dp[n] = 1;
            }
            else if(n == m) {
                dp[n] = 2;
            }
            else {
                dp[n] = (dp[n - 1] + dp[n - m]) % mod;
            }
        }
        return dp[N];
    }

}
