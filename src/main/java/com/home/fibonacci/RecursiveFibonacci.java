package com.home.fibonacci;

/*
 * 
 * Bad use of recursion. dont do this, program will never end even small like 100
 * the Big O complexity of recursive fibonacci is 2^n. it increases expnentially as n increases
 *
 */
public class RecursiveFibonacci {

    public static int getFibonacci(int n) {
        if (n == 0)
        {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFibonacci(n - 2) + getFibonacci(n - 1);
        }
    }

    public static void main(String args[]) {
        /*try with smaller inputs. it will work. but for larger values like 50 the prgram will get sluggish and will eventually get stuck

         */
        for (int i = 0; i < 10; i++) {
            System.out.println("Position " + i + " " + RecursiveFibonacci.getFibonacci(i));
        }
    }

}
