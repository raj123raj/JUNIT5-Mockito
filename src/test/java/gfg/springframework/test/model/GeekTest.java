package gfg.springframework.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import gfg.springframework.model.Geek;
import gfg.springframework.test.ModelTests;

class GeekTest implements ModelTests {

    @Test
    void groupedAssertions() {
        //given
        Geek person = new Geek(1l, "Ross", "Geller");

        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Ross"),
                () -> assertEquals(person.getLastName(), "Geller"));
    }

    @Test
    void groupedAssertionMsgs() {
        //given
        Geek person = new Geek(1l, "Chandler", "Bing");

        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Ross", "Input First Name is wrong"),
                () -> assertEquals(person.getLastName(), "Geller", "Input Last Name is wrong"));
    }
}