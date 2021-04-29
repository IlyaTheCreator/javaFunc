package finalsection;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        hello("iluha", "klimov", () -> "there's something wrong with your last name!");
    }

    static void hello(String firstName, String lastName, Supplier<String> provideFeedback) {
        System.out.println(firstName);

        if (lastName != null) {
            System.out.println(lastName);
        } else {
            System.out.println(provideFeedback.get());
        }
    }
}
