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
import static org.junit.jupiter.api.Assertions.assertArrayEquals ;

public class UserTest {
    /*@BeforeEach
    void createUser(){
        List<Fraction> fractions = new ArrayList<>();
        User user = new User("1", "Juan", "Gonzalez", fractions);
    }*/

    @Test
    void testGetId() {
        List<Fraction> fractions = new ArrayList<>();
        User user = new User("1", "Juan", "Gonzalez", fractions);
        assertEquals("1", user.getId());
    }

    @Test
    void testGetName() {
        List<Fraction> fractions = new ArrayList<>();
        User user = new User("1", "Juan", "Gonzalez", fractions);
        assertEquals("Juan", user.getName());
    }

    @Test
    void testSetName() {
        List<Fraction> fractions = new ArrayList<>();
        User user = new User("1", "Juan", "Gonzalez", fractions);
        user.setName("Pepe");
        assertEquals("Pepe", user.getName());
    }

    @Test
    void testGetFamilyName() {
        List<Fraction> fractions = new ArrayList<>();
        User user = new User("1", "Juan", "Gonzalez", fractions);
        assertEquals("Gonzalez", user.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        List<Fraction> fractions = new ArrayList<>();
        User user = new User("1", "Juan", "Gonzalez", fractions);
        user.setFamilyName("Pepeto");
        assertEquals("Pepeto", user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        /*List<Fraction> fractions = new ArrayList<>(2);
        fractions.set(0, new Fraction(0, 1));
        fractions.set(0, new Fraction(2, 4));
        User user = new User("1", "Juan", "Gonzalez", fractions);
        List<Fraction> Fractions2=user.getFractions();
        System.out.println(Fractions2.toArray());
        assertEquals(fractions.toArray(), Fractions2.toArray());*/
    }


}
