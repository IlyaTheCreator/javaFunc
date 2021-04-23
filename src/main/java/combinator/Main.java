package combinator;

import combinator.validation.CustomerValidation;
import combinator.validation.result.ValidationResult;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;

import static combinator.validation.CustomerValidation.*;

public class Main {
    public static void main(String[] args) {
        CustomerValidation validation = nameIsNotEmpty().and(emailContainsAtSign().and(phoneNumberStartsWithPlus()));

        Customer customer = new Customer(
                "iluha",
                "alice@gmail.com",
                "+0134905801353",
                LocalDate.of(2000, 1, 1)
        );

        ValidationResult result = validation.apply(customer);
        result.getReason().ifPresentOrElse(System.out::println, () -> System.out.println("Congrats, you're fine :D"));
    }
}
