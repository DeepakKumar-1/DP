package com.company.DPRevision;

import java.util.Arrays;

public class EditDistance1 {
    // Recursive Approach
    public static int editDist(String s, String t){
        // Base Case
        if(s.length() == 0){
            return t.length();
        }
        if(t.length() == 0){
            return s.length();
        }
        if(s.charAt(0) == t.charAt(0)){
            return editDist(s.substring(1), t.substring(1));
        } else{
            int opt1 = editDist(s, t.substring(1));
            int opt2 = editDist(s.substring(1), t);
            int opt3 = editDist(s.substring(1), t.substring(1));
            return 1 + Math.min(opt1, Math.min(opt2, opt3));
        }
    }

    //Memoization Approach
    public static int editDistM(String s, String t){
        int m = s.length();
        int n = t.length();
        int [][]storage = new int[m + 1][n + 1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                storage[i][j] = -1;
            }
        }
        return editDistM(s, t, storage);
    }
    private static int editDistM(String s, String t, int [][]storage){
        int m = s.length();
        int n = t.length();
        // Base Case
        if(s.length() == 0){
            storage[m][n] = t.length();
            return storage[m][n];
        }
        if(t.length() == 0){
            storage[m][n] = s.length();
            return storage[m][n];
        }
        // if result is already calculated
        if(storage[m][n] != -1){
            return storage[m][n];
        }
        // otherwise calculate the result
        if(s.charAt(0) == t.charAt(0)){
            storage[m][n] = editDistM(s.substring(1), t.substring(1), storage);
            return storage[m][n];
        } else{
            int opt1 = editDistM(s, t.substring(1), storage);
            int opt2 = editDistM(s.substring(1), t, storage);
            int opt3 = editDistM(s.substring(1), t.substring(1), storage);
            storage[m][n] = 1 + Math.min(opt1, Math.min(opt2, opt3));
            return storage[m][n];
        }
    }

    // DP Approach
    public static int editDistDP(String s, String t){
        int m = s.length();
        int n = t.length();
        int [][]storage = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            storage[i][0] = i;
        }
        for(int j=0; j<=n; j++){
            storage[0][j] = j;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(m-i) == t.charAt(n-j)){
                    storage[i][j] = storage[i-1][j-1];
                }else{
                    int opt1 = storage[i][j-1];
                    int opt2 = storage[i-1][j];
                    int opt3 = storage[i-1][j-1];
                    storage[i][j] = 1 + Math.min(opt1, Math.min(opt2, opt3));
                }
            }
        }
        for(int []row : storage){
            System.out.println(Arrays.toString(row));
        }
        return storage[m][n];
    }

    public static void main(String []args){
        String s = "agh";
        String t = "egi";
        System.out.println(editDistM(s, t));
        System.out.println(editDistDP(s, t));
        System.out.println(editDist(s, t));
    }
}
