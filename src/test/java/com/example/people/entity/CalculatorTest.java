package com.example.people.entity;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorTest {

       @Test
        public void addTwoNumbers_Test (){
            int result  = Calculator.addTwonumbers(3,6);
            int expected = 9;

           assertThat(result).isEqualTo(expected);

        }

        @Test
    public void subtractTwoNumbers_test(){
           int result = Calculator.substracttwonumbers(6,4);
           int expected = 2 ;

           assertThat(result).isEqualTo(expected);
        }

        @Test
    public void devideTwoNumber_Test(){
           int result = Calculator.dividetwonumbers(8,4);
           int expected = 2 ;

           assertThat(result).isEqualTo(expected);
        }

        @Test
    public void isNumberPositive_Test(){
           boolean result = Calculator.isNumberPositive(6);
           boolean expected = true;

           assertThat(result).isEqualTo(expected);

        }
        @Test
    public void isNumberEven_Test(){
           boolean result = Calculator.isNumberEven(9);
           boolean expected = false;

           assertThat(result).isEqualTo(expected);
        }

    }














