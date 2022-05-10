package com.ecpe205;

public class Calculator {
    public double sum( double a, double b ) {
        return a + b;
    }
    public boolean isEven (int value) {
        return value % 2 == 0;
    }
    public boolean isOdd (int value) {
        return value % 2 == 1;
    }

    //create a method that computes base x power of y
    //use parameterizedTest methodsource - 5 sets to test
    public int computeExponent(int a, int b) {
        return (int) Math.pow(a,b);
    }

    //create a method that computes for the factorial of a value
    //use parameterizedTest- 5 values to test
    public int computeFactorial(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }else {
            return(n * computeFactorial(n-1));
         }
    }

    //create a method that checks if a given string is a palindrome
    //use parameterizedTest - 5 values to test
    public boolean isPalindrome(String str){
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    //create a method that accepts an array of integer values, the method then sorts the value in ascending order
    //** you may choose whatever sort data structure (bubble sort, shell sort,...)
    //use parameterizedTest methodSource
}

//https://github.com/colesprojects/ecpe205-unit-test/tree/main/src/com/ecpe205
