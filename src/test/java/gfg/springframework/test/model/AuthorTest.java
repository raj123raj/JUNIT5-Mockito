package gfg.springframework.test.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import gfg.springframework.model.Author;
import gfg.springframework.model.AuthorType;
import gfg.springframework.test.ModelTests;

class AuthorTest implements ModelTests {

    @Test
    void assertionsTest() {

        Author author = new Author(1l, "Rachel", "Green");
        author.setCity("Seatle");
        author.setTelephone("1002003001");

        assertAll("Properties Test",
                () -> assertAll("Geek Properties",
                        () -> assertEquals("Rachel", author.getFirstName(), "First Name Did not Match"),
                        () -> assertEquals("Green", author.getLastName())),
                () -> assertAll("Author Properties",
                        () -> assertEquals("Seatle", author.getCity(), "City Did Not Match"),
                        () -> assertEquals("1002003001", author.getTelephone())
                ));

        assertThat(author.getCity(), is("Seatle"));
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "GFG"})
    void valueSourceTest(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(AuthorType.class)
    void enumTest(AuthorType authorType) {
        System.out.println(authorType);
    }  



    

}