package net.tqxr.utilities

import org.junit.Test

import static net.tqxr.utilities.AnsiColorizer.RED
import static net.tqxr.utilities.AnsiColorizer.RESET
import static org.assertj.core.api.Assertions.assertThat

class AnsiColorizerGroovyTest {

    @Test
    void canProduceTextWithRedPortion() {
        String expected =
                "This is ${(char) 27}[31ma test${(char) 27}[0m"

        String actual = "This is ${RED}a test${RESET}"

        assertThat(actual)
                .isEqualTo(expected)

    }


    @Test
    void willResetAttributesAfterUse() {
        String expected =
                "${(char) 27}[31;4mUNDERLINE ... ${(char) 27}[0mNO UNDERLINE${(char) 27}[0m"

        String actual =
                "${RED.underline()}UNDERLINE ... ${RESET}NO UNDERLINE${RESET}"

        assertThat(actual)
                .isEqualTo(expected)

        String expectedPlainRed =
                "${(char) 27}[31mPLAIN_RED${(char) 27}[0m"

        String actualPlainRed =
                "${RED}PLAIN_RED${RESET}"

        assertThat(actualPlainRed)
                .isEqualTo(expectedPlainRed)

    }
}
