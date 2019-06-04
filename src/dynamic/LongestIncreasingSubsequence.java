package dynamic;

import java.util.Arrays;
/*
Given an array of numbers, find the length of the longest increasing subsequence in the array. The subsequence does not necessarily have to be contiguous.

For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.
 */
public class LongestIncreasingSubsequence {

    public static void main(String args[]){
        int[] battalions = {5,2,7,4,3,8};

        int[] lisAt = getLISOf(battalions);

        Arrays.stream(lisAt).max().ifPresent(System.out::println);
    }

    /*
        Optimal Substructure:
        If we divide the array into individual elements, for every individual elements the LIS ending at that element would be the element itself. Now
        if we keep combining the elements, and take advantage of the fact that if the one element is greater than the other elements and also comes at a later index,
        we can add conclude that the new LIS that ends at the element with the higher value is of the length equal to LIS of smaller element plus one.

        Overlapping Subproblem:
        The above explanation also justifies that the same solution is used repeatedly.

     */
    private static int[] getLISOf(int[] battalions) {
        int[] lisAt = new int[battalions.length];

        for(int i=0;i<battalions.length;i++){
            for(int j=0;j<i;j++){
                if(battalions[i] > battalions[j] && lisAt[i] < lisAt[j]){
                    lisAt[i] = lisAt[j];
                }
            }
            lisAt[i]++;
        }
        return lisAt;
    }
}
