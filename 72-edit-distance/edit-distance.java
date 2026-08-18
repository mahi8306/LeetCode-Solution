class Solution {
    public int minDistance(String word1, String word2) {

        int a = word1.length();
        int b = word2.length();

        int[][] dis = new int[a + 1][b + 1];

        
        for (int i = 0; i <= a; i++) {
            dis[i][0] = i;
        }

        
        for (int j = 0; j <= b; j++) {
            dis[0][j] = j;
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dis[i][j] = dis[i - 1][j - 1];

                } else {
                    dis[i][j] = 1 + Math.min(
                            dis[i - 1][j],
                            Math.min(
                                    dis[i][j - 1],
                                    dis[i - 1][j - 1]
                            )
                    );
                }
            }
        }

        return dis[a][b];
    }
}