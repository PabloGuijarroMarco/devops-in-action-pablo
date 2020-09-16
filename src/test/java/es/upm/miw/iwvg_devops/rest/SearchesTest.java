package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.Fraction;
import es.upm.miw.iwvg_devops.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertEquals(List.of("Torres"), new Searches().findUserFamilyNameByUserNameDistinct("Paula")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFractionNumeratorByFamilyName() {
        assertEquals(List.of(2, 4, 0, 1, 1), new Searches().findFractionNumeratorByUserFamilyName("Torres")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertEquals(List.of("López", "Torres"), new Searches().findUserFamilyNameByFractionDenominator(2)
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFamilyNameInitialByAnyProperFraction() {
        assertEquals(List.of("F", "B", "L", "B"), new Searches().findUserFamilyNameInitialByAnyProperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserIdByAnyProperFraction() {
        assertEquals(List.of("1", "2", "3", "5"), new Searches().findUserIdByAnyProperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testfindFractionMultiplicationByUserFamilyName(){
        Fraction fraction = new Searches().findFractionMultiplicationByUserFamilyName("López");
        assertEquals("Fraction{"+
                "numerator="+12+
                ", denominator="+-240+"}",
                "Fraction{"+ "numerator="+
                fraction.getNumerator()+
                ", denominator="+fraction.getDenominator()+"}");
    }

    @Test
    void testfindFractionDivisionByUserId(){
        Fraction fraction = new Searches().findFirstFractionDivisionByUserId("1");
        assertEquals("Fraction{"+
                        "numerator="+0+
                        ", denominator="+1+"}",
                "Fraction{"+ "numerator="+
                        fraction.getNumerator()+
                        ", denominator="+fraction.getDenominator()+"}");
    }

    @Test
    void testfindFirstDecimalFractionByUserName(){
        Double fraction = new Searches().findFirstDecimalFractionByUserName("Ana");
        assertEquals(2.0,fraction);
    }

    @Test
    void testFindUserIdByAllProperFraction(){
        assertEquals(List.of(),new Searches().findUserIdByAllProperFraction().collect(Collectors.toList()));
    }

    @Test
    void testFindDecimalImproperFractionByUserName(){
        assertEquals(List.of(2.0, 1.3333333333333333),new Searches().findDecimalImproperFractionByUserName("Ana").collect(Collectors.toList()));
    }

    @Test
    void testFindFirstProperFractionByUserId() {
        Fraction fraction = new Searches().findFirstProperFractionByUserId("2");
        assertEquals("Fraction{"+
                        "numerator="+-1+
                        ", denominator="+5+"}",
                "Fraction{"+ "numerator="+
                        fraction.getNumerator()+
                        ", denominator="+fraction.getDenominator()+"}");
    }

    @Test
    void testFindUserFamilyNameByImproperFraction(){
        assertEquals(List.of("Fernandez", "Blanco", "López", "Blanco", "Torres"), new Searches().findUserFamilyNameByImproperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindHighestFraction(){
        Fraction fraction = new Searches().findHighestFraction();
        assertEquals("Fraction{"+
                        "numerator="+2+
                        ", denominator="+1+"}",
                "Fraction{"+ "numerator="+
                        fraction.getNumerator()+
                        ", denominator="+fraction.getDenominator()+"}");
    }

    @Test
    void testFindUserNameByAnyImproperFraction() {
        assertEquals(List.of("Oscar", "Ana", "Oscar", "Antonio", "Paula"), new Searches().findUserNameByAnyImproperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertEquals(List.of("Fernandez"), new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindDecimalFractionByUserName() {
        assertEquals(List.of(2.0, -0.2, 0.5, 1.3333333333333333), new Searches().findDecimalFractionByUserName("Ana")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindDecimalFractionByNegativeSignFraction() {
        assertEquals(List.of(-0.2, -0.5, -0.0), new Searches().findDecimalFractionByNegativeSignFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFractionAdditionByUserId() {
        Fraction fraction = new Searches().findFractionAdditionByUserId("1");
        assertEquals("Fraction{"+
                        "numerator="+3+
                        ", denominator="+1+"}",
                "Fraction{"+ "numerator="+
                        fraction.getNumerator()+
                        ", denominator="+fraction.getDenominator()+"}");
    }

    @Test
    void testFindFractionSubtractionByUserName() {
        Fraction fraction = new Searches().findFirstFractionSubtractionByUserName("Ana");
        assertEquals("Fraction{"+
                        "numerator="+11+
                        ", denominator="+5+"}",
                "Fraction{"+ "numerator="+
                        fraction.getNumerator()+
                        ", denominator="+fraction.getDenominator()+"}");
    }


}
