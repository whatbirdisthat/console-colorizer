package net.tqxr.utilities;

import org.junit.Test;

import static net.tqxr.utilities.AnsiColorizer.RED;
import static net.tqxr.utilities.AnsiColorizer.RESET;
import static org.assertj.core.api.Assertions.assertThat;

public class AnsiColorizerTest {

    @Test
    public void canProduceTextWithRedPortion() {
        String expected =
                "This is "
                        + (char) 27
                        + "[31m"
                        + "a test"
                        + (char) 27
                        + "[0m";

        String actual = String.format(
                "This is %sa test%s",
                RED,
                RESET
        );

        assertThat(actual)
                .isEqualTo(expected);

    }


    @Test
    public void willResetAttributesAfterUse() {
        String expected = (char) 27
                + "[31;4m"
                + "UNDERLINE ... "
                + (char) 27
                + "[0m"
                + "NO UNDERLINE"
                + (char) 27
                + "[0m";

        String actual = RED.underline()
                + "UNDERLINE ... "
                + RESET
                + "NO UNDERLINE"
                + RESET;

        assertThat(actual)
                .isEqualTo(expected);

        String expectedPlainRed = (char) 27
                + "[31m"
                + "PLAIN_RED"
                + (char) 27
                + "[0m";

        String actualPlainRed = RED
                + "PLAIN_RED"
                + RESET;

        assertThat(actualPlainRed)
                .isEqualTo(expectedPlainRed);

    }
}
