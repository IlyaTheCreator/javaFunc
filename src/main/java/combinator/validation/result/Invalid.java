package combinator.validation.result;

import java.util.Optional;

//public class Invalid implements ValidationResult {
//    private final String reason;
//
//    public Invalid(String reason) {
//        this.reason = reason;
//    }
//
//    public boolean isValid() {
//        return false;
//    }
//
//    public Optional<String> getReason() {
//        return Optional.of(reason);
//    }
//}

public class Invalid implements ValidationResult {
    private final String reason;

    public Invalid(String reason) {
        this.reason = reason;
    }

    public boolean isValid() {
        return false;
    }

    public Optional<String> getReason() {
        return Optional.of(reason);
    }
}
