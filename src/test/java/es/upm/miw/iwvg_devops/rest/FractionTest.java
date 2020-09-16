package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.Fraction;
import es.upm.miw.iwvg_devops.Searches;
import es.upm.miw.iwvg_devops.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FractionTest {
    @Test
    void testGetNumerator() {
        Fraction fraction = new Fraction(1, 0);
        assertEquals(1, fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        Fraction fraction = new Fraction(1, 0);
        fraction.setNumerator(4);
        assertEquals(4, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        Fraction fraction = new Fraction(1, 0);
        assertEquals(0, fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        Fraction fraction = new Fraction(1, 0);
        fraction.setDenominator(5);
        assertEquals(5, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(3, 4);
        assertEquals(0.75, fraction.decimal());
    }

    @Test
    void testProperFraction() {
        Fraction fraction = new Fraction(3, 4);
        assertEquals(true, fraction.ProperFraction());
    }

    @Test
    void testImproperFraction() {
        Fraction fraction = new Fraction(4, 3);
        assertEquals(true, fraction.ImproperFraction());
    }

    @Test
    void testFractionMultiplication() {
        Fraction fraction = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(2, 1);
        Fraction fr3=new Fraction(3,4);
        fr3=fr3.fractionMultiplication(fraction,fraction2);
        assertEquals(1.5, fr3.decimal());
    }

    @Test
    void testFractionDivision() {
        Fraction fraction = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(2, 1);
        Fraction fr3=new Fraction(3,4);
        fr3=fr3.fractionDivision(fraction,fraction2);
        assertEquals(0.375, fr3.decimal());
    }

    @Test
    void testBiggest(){
        Fraction fraction1 = new Fraction(4, 3);
        Fraction fraction2 = new Fraction(4, 2);
        assertEquals(fraction2, fraction1.Biggest(fraction1,fraction2));
    }

    @Test
    void testFractionAddition() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 1);
        Fraction fr3 = new Fraction(5, 2);
        Fraction fr4 = new Fraction(2, 2);
        fr4 = fr4.fractionAddition(fraction, fraction2);
        assertEquals(fr3.decimal(), fr4.decimal());
    }

    @Test
    void testFractionSubtraction() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 1);
        Fraction fr3 = new Fraction(-3, 2);
        Fraction fr4 = new Fraction(2, 2);
        fr4 = fr4.fractionSubtraction(fraction, fraction2);
        assertEquals(fr3.decimal(), fr4.decimal());
    }

    @Test
    void testToString() {
        Fraction f1 = new Fraction(3,2);

        assertEquals("Fraction{" +
                        "numerator=" + 3 +
                        ", denominator=" + 2 +
                        '}',
                "Fraction{" +
                        "numerator=" + f1.getNumerator() +
                        ", denominator=" + f1.getDenominator() +
                        '}');
    }
}
