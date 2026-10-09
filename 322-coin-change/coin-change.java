// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int dp [][] = new int[n+1][amount+1];

//         for(int i=0; i<n+1; i++){
//             dp[i][0] = 0;
//         } 
//         dp[0][0] =0;
//         for( int j=1; j<amount ; j++){
//             dp[0][j] = Integer.MATH_VALUE;
//         }
    
//         for(int i=1; i<n+1; i++){
//             for(int j=1; j< amount+1; j++){
//                 if(coins[i-1]<= j){
//                     dp[i][j] = Math.min(coins[n-1]+dp[i]+amount[i-1], dp[i-1]);

//                 }
//             }
//         }

//         return dp[n][amount];
        
//     }
// }


class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int notTake = dp[i - 1][j];
                    int take = Integer.MAX_VALUE;

                    if (dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                        take = 1 + dp[i][j - coins[i - 1]];
                    }

                    dp[i][j] = Math.min(take, notTake);
                }
            }
        }

        return dp[n][amount] == Integer.MAX_VALUE
                ? -1
                : dp[n][amount];
    }
}




