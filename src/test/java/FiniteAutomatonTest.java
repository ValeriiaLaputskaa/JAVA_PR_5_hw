import org.example.FiniteAutomaton;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.FiniteAutomaton.State.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.provider.Arguments;

public class FiniteAutomatonTest {

    @ParameterizedTest
    @MethodSource("provideTestCasesForRecognizeTestWord")
    void testRecognizeTestWord(String input, FiniteAutomaton.State expected) {
        assertEquals(expected, FiniteAutomaton.recognizeTestWord(input));
    }

    private static Stream<Arguments> provideTestCasesForRecognizeTestWord() {
        return Stream.of(
                Arguments.arguments("abcTESTabc", F),
                Arguments.arguments("TESTTEST", F),
                Arguments.arguments("TTEST", F),
                Arguments.arguments("abcTTESTabc", F),
                Arguments.arguments("TEST", F),
                Arguments.arguments("TES", S3),
                Arguments.arguments("T", S1),
                Arguments.arguments("TE", S2),
                Arguments.arguments("", S0),
                Arguments.arguments("TESTing", F),
                Arguments.arguments("abcTESTingTEST", F),
                Arguments.arguments("abc", S0),
                Arguments.arguments("TEX", S0),
                Arguments.arguments("TESabcTEST", F),
                Arguments.arguments("TESabcTET", S1)
        );
    }
}
