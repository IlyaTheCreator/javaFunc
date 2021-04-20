package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer customer = new Customer("Maria", "999999");

        greetCustomer(customer);
        greetCustomerConsumer.accept(customer);
        greetCustomerConsumerV2.accept(customer, false);
        greetCustomerConsumerWithMsg.accept(customer, "You are beautiful!");
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " +
                (showPhoneNumber ? customer.customerPhoneNumber : "*************"));
    };

    static BiConsumer<Customer, String> greetCustomerConsumerWithMsg = (customer, message) -> {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " +
                customer.customerPhoneNumber);

        System.out.println("Our message to you is: " + message);
    };

    static Consumer<Customer> greetCustomerConsumer = customer -> {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " +
                customer.customerPhoneNumber);
    };

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " +
                customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
