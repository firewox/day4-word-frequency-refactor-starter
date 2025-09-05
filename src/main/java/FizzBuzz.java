public class FizzBuzz {
    public static String countOff(int order) {
        if ((order % 3) != 0 && (order % 5) != 0) {
            return Integer.toString(order);
        } else if ((order % 15) == 0) {
            return "FizzBuzz";
        } else if ((order % 3) == 0) {
            return "Fizz";
        }
        return "Buzz";
    }
}
