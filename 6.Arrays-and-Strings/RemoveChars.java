/**
 * Delete characters from an ASCII string. Use the prototype:
 *    String removeChars(String str, String remove);
 * where any character existing in remove must be deleted from str.
 */
import java.util.HashSet;

public class RemoveChars {
    /**
     * Use HashSet to track deleted chars.
     */
    public static String removeChars(String str, String remove) {
        if (str == null) return null;

        HashSet<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i < remove.length(); i++) {
            set.add(remove.charAt(i));
        }

        for (int i = 0; i < builder.length(); i++) {
            if (set.contains(builder.charAt(i))) {
                builder.deleteCharAt(i);
            }
        }
        return builder.toString();
    }
}
