package net.tqxr.utilities

import org.junit.Test

import static net.tqxr.utilities.AnsiColorizer.RED
import static net.tqxr.utilities.AnsiColorizer.RESET
import static org.assertj.core.api.Assertions.assertThat

class AnsiColorizerGroovyTest {

    static final char ESC = 27

    @Test
    void canProduceTextWithRedPortion() {
        String expected =
                "This is ${ESC}[31ma test${ESC}[0m"

        String actual = "This is ${RED}a test${RESET}"

        assertThat(actual)
                .isEqualTo(expected)

    }


    @Test
    void willResetAttributesAfterUse() {
        String expected =
                "${ESC}[31;4mUNDERLINE ... ${ESC}[0mNO UNDERLINE${ESC}[0m"

        String actual =
                "${RED.underline()}UNDERLINE ... ${RESET}NO UNDERLINE${RESET}"

        assertThat(actual)
                .isEqualTo(expected)

        String expectedPlainRed =
                "${ESC}[31mPLAIN_RED${ESC}[0m"

        String actualPlainRed =
                "${RED}PLAIN_RED${RESET}"

        assertThat(actualPlainRed)
                .isEqualTo(expectedPlainRed)

    }
}
