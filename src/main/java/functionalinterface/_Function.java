package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(0);
        System.out.println(increment);

        Function<Integer, String> doTheMagic = number -> {
            double random = Math.round(Math.random() * (100 - 10 + 1) - 10);
            double newNumber = random * number;

            return "The result of this shit is: " + newNumber;
        };

        int increment2 = incrementByOneFunction.apply(10);
        String increment3 = doTheMagic.apply(10);

        // Function chaining
        Function<Integer, Integer> incrementByOneAndMultiplyByTenFunction =
                incrementByOneFunction.andThen(multiplyByTenFunction);

        // A BiFunction is like a regular function but it takes two arguments

        int result = incrementByOneAndMultiplyByTenFunction.apply(20);
        int result2 = incrementByOneAndMultiplyBiFunction.apply(10, 10);

        System.out.println(result2);
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (number, numToMultiply) -> (number + 1) * numToMultiply;

    static int incrementByOneAndMultiply(int number, int numToMultiply) {
        return (number + 1) * numToMultiply;
    }
}
