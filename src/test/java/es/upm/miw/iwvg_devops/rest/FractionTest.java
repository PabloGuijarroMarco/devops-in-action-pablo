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
}
