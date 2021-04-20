package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09000430032"));
        System.out.println("_______________");

        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07000430032"));
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    };

    static Predicate<String> containsNumber3 = phoneNumber -> {
      return phoneNumber.contains("3");
    };

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }
}
