public class FizzBuzz {
    public static String countOff(int order) {
        if (((order % 3) != 0) && ((order % 5) != 0)) return "%d".formatted(order);
        if (((order % 3) == 0) && ((order % 5) == 0)) return "FizzBuzz";
        if ((order % 3) == 0) return "Fizz";
        return "Buzz";
    }
}
