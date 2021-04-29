package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        Optional.ofNullable("john@gmail.com")
//                .ifPresentOrElse(
//                        (email) -> System.out.println("Sending email to: " + email),
//                        () -> System.out.println("Cannot send the email"));
////                .orElseThrow(() -> new IllegalStateException("exception"));
////                .orElseGet(() -> "default value");

//        String name = null;
        Optional<String> opt = Optional.ofNullable("iluha");

        opt.ifPresent(name -> System.out.println(name.length()));
        opt.ifPresent(System.out::println);

//        try {
//            Optional<String> opt = Optional.of(name);
//            System.out.println(opt.isPresent());
//        } catch (ArithmeticException e) {
//            System.out.println("There is a null pointer exception!!!");
////            e.printStackTrace();
//        }

    }
}
