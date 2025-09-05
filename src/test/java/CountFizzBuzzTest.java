import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountFizzBuzzTest {

    @Test
    void should_return_1_when_input_1() {
        //Given
        int order = 1;
        //When
        String word = FizzBuzz.countOff(order);
        //Then
        assertEquals("1", word);
    }

    @Test
    void should_return_FizzBuzz_when_input_15() {
        //Given
        int order = 15;
        //When
        String word = FizzBuzz.countOff(order);
        //Then
        assertEquals("FizzBuzz", word);
    }

    @Test
    void should_return_Fizz_when_input_3() {
        //Given
        int order = 3;
        //When
        String word = FizzBuzz.countOff(order);
        //Then
        assertEquals("Fizz", word);
    }

    @Test
    void should_return_Buzz_when_input_5() {
        //Given
        int order = 5;
        //When
        String word = FizzBuzz.countOff(order);
        //Then
        assertEquals("Buzz", word);
    }
}
