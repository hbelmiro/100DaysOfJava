package com.thegreatapi.ahundreddaysofjava.day007;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.MessageFormat;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day007Test {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void shouldFormatMessageCorrectly() {
        // Arrange
        String param1 = "Hello";
        String param2 = "World";
        String param3 = "Java";

        // Act
        String actualMessage = MessageFormat.format(
                "This message contains 3 parameters. The #1 is ''{0}'', "
                + "the #2 is ''{1}'', and the #3 is ''{2}''.",
                param1, param2, param3);

        // Assert
        String expectedMessage = "This message contains 3 parameters. The #1 is"
                + " 'Hello', the #2 is 'World', and the #3 is 'Java'.";
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
