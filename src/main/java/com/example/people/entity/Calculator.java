package com.example.people.entity;

import java.util.Scanner;

public class Calculator {
    public static int addTwonumbers(int a , int b){
        return a+b;
    }

    public static int substracttwonumbers (int a  , int b){
        return a-b;
    }

    public static  int  dividetwonumbers (int a , int b){
        return a/b;
    }

    public static boolean isNumberPositive(int a) {
        if (a > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNumberEven (int a) {
        if (a%2 == 0) {
            return true;
        }else return false;
        }


    }








