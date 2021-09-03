package algorithms.graphtheory;

import java.util.Arrays;
import java.util.stream.Stream;

public class DepthFirstSearch {

    private static int[] visited;
    private static int[][] adjMat;
    private static int n;

    public static void main(String args[]){
        visited = new int[5];
        adjMat = new int[][]{{0,1,0,0,0},{1,0,1,1,0},{0,1,0,0,0},{0,1,0,0,0},{0,0,0,0,0}};
        n = 5;
        dfs(0);
        Stream.of(visited).flatMapToInt(Arrays::stream).forEach(System.out::println);
    }

    private static void dfs(int startNode) {
        if(visited[startNode]  == 1) return;
        visited[startNode] = 1;

        for(int i =0;i<n ; i ++){
            if(adjMat[startNode][i] == 1 && visited[i] == 0){
                dfs(i);
            }
        }
    }
}
