public class FizzBuzz {
    public static String countOff(int order) {
        return order % 3 != 0 && order % 5 != 0 ? Integer.toString(order) :
                order % 3 == 0 && order % 5 == 0 ? "FizzBuzz" :
                        order % 3 == 0 ? "Fizz" : "Buzz";
    }
}
