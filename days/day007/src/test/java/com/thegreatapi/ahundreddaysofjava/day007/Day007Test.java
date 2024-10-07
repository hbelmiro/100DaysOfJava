package com.thegreatapi.ahundreddaysofjava.day007;

import java.text.MessageFormat;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Day007Test {

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

}