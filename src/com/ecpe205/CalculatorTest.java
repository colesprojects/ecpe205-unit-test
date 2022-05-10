package com.ecpe205;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
    Calculator calc;

    @BeforeAll
    void setup(){
        calc = new Calculator();
    }

    //CREATE A TEST TO TEST isEven
    @Test
    void shouldCheckValueIsEven() {
        assertEquals(true,calc.isEven(2));
        assertEquals(false,calc.isEven(1));
    }

    @Test
    void shouldCheckValueIsOdd() {
        assertEquals(true,calc.isOdd(1));
        assertEquals(false,calc.isOdd(2));
    }


    @Test
    @DisplayName("Sum 2 encoded values")
    void shouldSumTwoEncodedValues() {

        // 1 + 2 = 3
        assertEquals(3, calc.sum(1,2) );
        assertEquals(9, calc.sum(5,4) );
        assertEquals(5, calc.sum(3,2) );
        assertEquals(14, calc.sum(5,9) );
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void shouldSumValueWithOne( int value ) {
        assertEquals(value + 1, calc.sum(value, 1));
    }

    @ParameterizedTest
    @MethodSource("sumInputValues")
    void shouldSumTwoInputValues(int a, int b) {
        assertEquals(a + b, calc.sum(a, b));
    }

    static Stream<Arguments> sumInputValues () {
        return Stream.of(
                Arguments.of(1,2),
                Arguments.of(4,6),
                Arguments.of(2,7),
                Arguments.of(3,7),
                Arguments.of(3,0)
        );
    }

    static Stream<Arguments> arrayOfIntegerSets () {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,1}),
                Arguments.of(new int[]{7,1,5,4,1}),
                Arguments.of(new int[]{7,2,8,3,4})
        );
    }
    
    @Test
    public void computeExponentTest() {
        ComputeExponent ce = new ComputeExponent();
        assertEquals(625, ce.computeExponent(5, 4));
        assertEquals(1296, ce.computeExponent(6, 4));
        assertEquals(81, ce.computeExponent(9, 2));
        assertEquals(128, ce.computeExponent(2, 7));
        assertEquals(512, ce.computeExponent(8, 3));
    }
    
    @Test
    public void computeFactorial() {
        ComputeFactorial cf = new ComputeFactorial();
        assertEquals(720, cf.computeFactorial(6));
        assertEquals(0, cf.computeFactorial(-1));
        assertEquals(362880, cf.computeFactorial(9));
        assertEquals(6, cf.computeFactorial(3));
        assertEquals(24, cf.computeFactorial(4));
    }
    
    @Test
    public void isPalindrome() {
        IsPalindrome ipTest = new IsPalindrome();

        assertEquals(true, ipTest.isPalindrome("redivider"));
        assertEquals(false, ipTest.isPalindrome("word"));
        assertEquals(true, ipTest.isPalindrome("civic"));
        assertEquals(false, ipTest.isPalindrome("word2"));
        assertEquals(true, ipTest.isPalindrome("radar"));

    }
}
