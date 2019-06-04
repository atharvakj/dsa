package backtracking;

import java.util.concurrent.atomic.AtomicInteger;

public class EightQueens {

    private AtomicInteger atomicInteger;

    public EightQueens() {
        atomicInteger = new AtomicInteger();

    }

    private boolean isSafeToPlace(int row, int column, int[] board) {
        for (int i = 0; i < row; i++) {
            if (column == board[i]) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(column - board[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean eightQueens(int[] board, int queenToBePlaced) {

        if (queenToBePlaced == board.length) {
            atomicInteger.incrementAndGet();
            printSolution(board);
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafeToPlace(queenToBePlaced, i, board)) {
                board[queenToBePlaced] = i;
                if (!eightQueens(board, queenToBePlaced + 1)) {
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
        System.out.print("\n\n\n" + atomicInteger.get());
    }

    public static void main(String args[]) {

        (new EightQueens()).eightQueens(new int[4], 0);
    }
}
