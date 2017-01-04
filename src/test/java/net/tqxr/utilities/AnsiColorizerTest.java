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
                        + (char)27
                        + "[0m";

        String actual = String.format(
                "This is %sa test%s",
                RED,
                RESET
        );

        assertThat(actual)
                .isEqualTo(expected);

    }

}
