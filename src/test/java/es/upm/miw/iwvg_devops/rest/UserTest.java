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
        List<Fraction> fractions = new ArrayList<>(2);
        Fraction f1 = new Fraction(3,2);
        Fraction f2 = new Fraction(3,3);
        fractions.add(f1);
        fractions.add(f2);
        User user = new User("1", "Juan", "Gonzalez", fractions);
        assertEquals(fractions, user.getFractions());
    }

    @Test
    void testSetFractions() {
        List<Fraction> fractions = new ArrayList<>(2);
        Fraction f1 = new Fraction(3,2);
        Fraction f2 = new Fraction(3,3);
        fractions.add(f1);
        User user = new User("1", "Juan", "Gonzalez", fractions);
        fractions.add(f2);
        user.setFractions(fractions);
        assertEquals(fractions, user.getFractions());
    }

    @Test
    void testAddFraction() {
        List<Fraction> fractions = new ArrayList<>(2);
        Fraction f1 = new Fraction(3,2);
        Fraction f2 = new Fraction(3,3);
        fractions.add(f1);
        User user = new User("1", "Juan", "Gonzalez", fractions);
        user.addFraction(f2);
        user.setFractions(fractions);
        assertEquals(fractions, user.getFractions());
    }

    @Test
    void testFullName() {
        List<Fraction> fractions = new ArrayList<>(2);
        Fraction f1 = new Fraction(3,2);
        Fraction f2 = new Fraction(3,3);
        fractions.add(f1);
        User user = new User("1", "Juan", "Gonzalez", fractions);
        assertEquals("Juan Gonzalez", user.fullName());
    }

    @Test
    void testInitials() {
        List<Fraction> fractions = new ArrayList<>(2);
        Fraction f1 = new Fraction(3,2);
        Fraction f2 = new Fraction(3,3);
        fractions.add(f1);
        User user = new User("1", "Juan", "Gonzalez", fractions);
        assertEquals("J.", user.initials());
    }

    @Test
    void testToString() {
        List<Fraction> fractions = new ArrayList<>(2);
        Fraction f1 = new Fraction(3,2);
        Fraction f2 = new Fraction(3,3);
        fractions.add(f1);
        User user = new User("1", "Juan", "Gonzalez", fractions);
        assertEquals("User{" +
                        "id='" + "1" + '\'' +
                        ", name='" + "Juan" + '\'' +
                        ", familyName='" + "Gonzalez" + '\'' +
                        ", fractions=" + fractions +
                        '}',
                "User{" +
                        "id='" + user.getId() + '\'' +
                        ", name='" + user.getName() + '\'' +
                        ", familyName='" + user.getFamilyName() + '\'' +
                        ", fractions=" + user.getFractions() +
                        '}');
    }
}
