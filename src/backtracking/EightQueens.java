package backtracking;

/*
The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other
 */
public class EightQueens {

    /*
        Check if it is safe to place a queen at row and column in the board
     */
    private boolean isSafeToPlace(int row, int column, int[] board) {
        for (int i = 0; i < row; i++) {
            if (column == board[i]) { //  if in the same column, then unsafe. No need to check row, since those aren't even considered.
                return false;
            }
            // using the property that if two points are on each others diagonal then difference between
            // x and y coordinates is same.
            if (Math.abs(row - i) == Math.abs(column - board[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean eightQueens(int[] board, int queenToBePlaced) {

        if (queenToBePlaced == board.length) {
            printSolution(board);
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            // back tracking 1st step, check if it is possible to place a queen at a particular position
            if (isSafeToPlace(queenToBePlaced, i, board)) {
                board[queenToBePlaced] = i;
                // 2nd step check if placing a queen at this position can give a possible correct solution
                if (!eightQueens(board, queenToBePlaced + 1)) {
                    // 3rd step backtrack since the selection does not give a solution
                    board[queenToBePlaced] = 0;
                }
            }
        }

        return false;
    }

    private void printSolution(int[] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i] == j) {
                    System.out.print("|Q|");
                } else {
                    System.out.print("|_|");
                }
            }
            System.out.println();
        }
        System.out.print("\n\n\n");
    }

    public static void main(String args[]) {

        (new EightQueens()).eightQueens(new int[4], 0);
    }
}
