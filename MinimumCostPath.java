
package com.company.DPRevision;

import java.util.Arrays;

public class MinimumCostPath {
    public static int minCostPath(int [][]a){
        return minCostPath(a, 0, 0);
    }
    private static int minCostPath(int [][]a, int i, int j){
        if(i >= a.length || j >= a[0].length){
            return Integer.MAX_VALUE;
        }
        // Base Case
        if(i == a.length-1 && j == a[0].length-1){
            return a[i][j];
        }
        // Explore all Options
        int horizontal = minCostPath(a, i+1, j) ;
        int diagonal = minCostPath(a, i+1, j+1);
        int vertical = minCostPath(a, i, j+1);

        return a[i][j] + Math.min(Math.min(horizontal, diagonal), vertical);
    }

    // Memoization Approach
    public static int minCostPathM(int [][]a){
        int m = a.length;
        int n = a[0].length;
        int [][]storage = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                storage[i][j] = -1;
            }
        }
        return minCostPathM(a, storage, 0, 0);
    }
    private static int minCostPathM(int [][]a, int [][]storage, int i, int j){
        // Edge Cases
        if(i >= a.length || j >= a[0].length){
            return Integer.MAX_VALUE;
        }
        // Base Case
        if(i == a.length-1 && j == a[0].length-1){
            storage[i][j] = a[i][j];
            return storage[i][j];
        }
        // if Result is Already calculated
        if(storage[i][j] != -1){
            return storage[i][j];
        }
        // Otherwise Calculate the Result
        // Explore all directions
        int opt1 = minCostPathM(a, storage, i+1, j);
        int opt2 = minCostPathM(a, storage, i+1, j+1);
        int opt3 = minCostPathM(a, storage, i, j+1);

        storage[i][j] = a[i][j] + Math.min(Math.min(opt1, opt2), opt3);
        return storage[i][j];
    }

    // DP Approach
    public static int minCostPathDP(int [][]a){
        int m = a.length;
        int n = a[0].length;
        int [][]storage = new int[m][n];
        storage[0][0] = a[0][0];
        for(int i=1; i<m; i++){
                storage[i][0] = a[i][0] + storage[i-1][0];
        }
        for(int j=1; j<n; j++){
            storage[0][j] = a[0][j] + storage[0][j-1];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                storage[i][j] = a[i][j] + Math.min(storage[i-1][j], Math.min(storage[i-1][j-1], storage[i][j-1]));
            }
        }
        for(int []row : storage) {
            System.out.println(Arrays.toString(row));
        }
        return storage[m-1][n-1];
    }
    public static void main(String []args){
        int [][]a = {{1, 2, 4, 8},
                     {9, 5, 1, 6},
                     {3, 2, 4, 5}};
        System.out.println(minCostPath(a));
        System.out.println(minCostPathM(a));
        System.out.println(minCostPathDP(a));
    }
}
