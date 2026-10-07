class Solution {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int idx) {

       
        if (idx == word.length()) {
            return true;
        }

       
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != word.charAt(idx)) {
            return false;
        }

        
        char temp = board[row][col];
        board[row][col] = '0';

        boolean found =
            dfs(board, word, row + 1, col, idx + 1) ||
            dfs(board, word, row - 1, col, idx + 1) ||
            dfs(board, word, row, col + 1, idx + 1) ||
            dfs(board, word, row, col - 1, idx + 1);

        board[row][col] = temp;

        return found;
    }
}