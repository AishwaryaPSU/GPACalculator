import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

public class Validation {
    private static final List<String> POSSIBLE_GRADES = Arrays.asList("A", "B", "C", "D", "F");
    private static final String INVALID_CREDITS_MESSAGE = "Invalid Credits entered. A class can have credits between 1 and 5 (inclusive), try again...";

    public static void validateCredit(String credits) {
        try {
            if (Integer.valueOf(credits) > 5) {
                throw new InvalidParameterException(INVALID_CREDITS_MESSAGE);
            }
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(INVALID_CREDITS_MESSAGE);
        }
    }

    public static void validateGrade(String grade) {
        if (!POSSIBLE_GRADES.contains(grade.toUpperCase())) {
            throw new InvalidParameterException("Enter one of the possible grades :" + Arrays.asList(POSSIBLE_GRADES));
        }
    }
}
