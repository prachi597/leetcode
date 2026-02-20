
import java.util.*;

class Solution {

    // Function to print the board (for debugging, not part of the solution)
    public void printBoard(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    // Helper function to check if placing a queen is safe
    public boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        
        // Vertical check
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Horizontal check
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal left check
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal right check
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Backtracking function to solve the N-Queens problem
    public int nQueens(char[][] board, int row) {
        int n = board.length;
        
        // If all queens are placed
        if (row == n) {
            printBoard(board); // Optional, you can remove this if you don't need to print
            return 1;
        }

        int count = 0;
        
        // Try placing a queen in all columns of the current row
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';  // Place the queen
                count += nQueens(board, row + 1);  // Recur for the next row
                board[row][j] = '.';  // Backtrack
            }
        }

        return count;
    }

    // Main function to return all the solutions
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with '.' indicating empty spaces
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solveNQueensHelper(board, 0, result);
        return result;
    }

    // Helper function to collect the results into List<List<String>>
    public void solveNQueensHelper(char[][] board, int row, List<List<String>> result) {
        int n = board.length;
        
        // If all queens are placed, convert the board to a list of strings and add to result
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }

        // Try placing a queen in all columns of the current row
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';  // Place the queen
                solveNQueensHelper(board, row + 1, result);  // Recur for the next row
                board[row][j] = '.';  // Backtrack
            }
        }
    }
}
