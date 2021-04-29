package combinator.validation.result;

import java.util.Optional;

//public interface ValidationResult {
//    static ValidationResult valid() {
//        return ValidationSupport.valid();
//    }
//
//    static ValidationResult invalid(String reason) {
//        return new Invalid(reason);
//    }
//
//    boolean isValid();
//
//    Optional<String> getReason();
//}

public interface ValidationResult {
    static ValidationResult valid() {
        return ValidationSupport.valid();
    }

    static ValidationResult invalid(String reason) {
        return new Invalid(reason);
    }

    boolean isValid();

    Optional<String> getReason();
}

//private final static class Invalid implements ValidationResult {
//
//}

