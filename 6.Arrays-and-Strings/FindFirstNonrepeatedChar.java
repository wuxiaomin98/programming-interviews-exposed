/**
 * Find the first nonrepeated character in a string.
 */
import java.util.HashMap;

public class FindFirstNonrepeatedChar {
    /**
     * Use hashmap to track the numbers of chars in the string, then iterate the
     * string again to find the first nonrepeated char.
     */
    public static Character find(String str) {  // return Character, not char
        if (str == null) return null;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int times = map.get(c);
            if (times == 1) {
                return c;
            }
        }
        return null;
    }
}