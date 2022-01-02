package com.company.DynamicProgramming;

import java.util.*;
import java.util.Scanner;
import java.io.*;
public class Main {
    // Online Java Compiler
// Use this editor to write, compile and run your Java code online
        public static int kGoodnessString(String s, int k){
            int minOperations = 0;
            int x = 0;
            for(int i=0; i < s.length()/2; i++){
                if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                    x++;
                }
            }

            if(x == k){
                minOperations = 0;
            }
            else if(x > k){
                minOperations = x-k;
            }
            else {
                minOperations = k - x;
            }
            return minOperations;
        }

        public static void main(String [] args){
            Scanner sc = new Scanner(System.in);
            // Take number of test Cases From the USER
            int t = sc.nextInt();
            int i= 0;
            while(t-- > 0){
                int n = sc.nextInt();
                int k = sc.nextInt();
                String s = sc.next(); // String of lenght n in UPPERCASE always
                // Output FORMAT
                // Case #x
                System.out.print("Case #" + i + ": " + kGoodnessString(s, k));
                i++;
            }
        }
    }