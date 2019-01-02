/*
LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequence {

    public static void main(String args[]) {
        String adam = "AGGTAB";
        String eve = "GXTXAYB";

        int lcs = calculateLongestCommonSubsequence(adam, eve);

        System.out.print(lcs);
    }

    private static int calculateLongestCommonSubsequence(String adam, String eve) {
        int[][] solTable = new int[adam.length() + 1][eve.length() + 1];

        for (int row = adam.length() - 1; row >= 0; row--) {
            for (int col = eve.length() - 1; col >= 0; col--) {
                if (adam.charAt(row) == eve.charAt(col)) {
                    solTable[row][col] = 1 + solTable[row + 1][col + 1];
                } else {
                    solTable[row][col] = Math.max(solTable[row+1][col],solTable[row][col+1]);
                }
            }
        }

        return solTable[0][0];
    }
}
