package combinator.validation;

import combinator.Customer;
import combinator.validation.result.ValidationResult;

import java.util.function.Function;
import java.util.function.Predicate;

import static combinator.validation.result.ValidationResult.*;

public interface CustomerValidation extends Function<Customer, ValidationResult> {
    static CustomerValidation nameIsNotEmpty() {
        return holds(customer -> !customer.getName().trim().isEmpty(), "Name is empty");
    }

    static CustomerValidation emailContainsAtSign() {
        return holds(customer -> customer.getEmail().contains("@"), "Missing @-sign in email");
    }

    static CustomerValidation phoneNumberStartsWithPlus() {
        return holds(customer -> customer.getPhoneNumber().startsWith("+"), "Phone does not start with \"+\"");
    }

    static CustomerValidation holds(Predicate<Customer> p, String message) {
        return customer -> p.test(customer) ? valid() : invalid(message);
    }

    default CustomerValidation and (CustomerValidation other) {
//        return customer -> this.apply(customer) && other.apply(customer);
        return (customer) -> {
            final ValidationResult result = this.apply(customer);
            return result.isValid() ? other.apply(customer) : result;
        };
    }
}
