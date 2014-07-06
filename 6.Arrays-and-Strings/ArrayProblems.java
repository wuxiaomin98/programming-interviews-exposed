import java.util.HashMap;

public class ArrayProblems {
    /**
     * Find the first nonrepeated character in a string.
     */
    public static Character findFirstNonRepeated_flaw(String str) {
        HashMap<Character, Integer> charHash = new HashMap<Character, Integer>();
        // scan str, building hashmap<character, appearing times>
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charHash.containsKey(c)) {
                charHash.put(c, charHash.get(c) + 1);
            } else {
                charHash.put(c, 1);
            }
        }
        // search hashmap in order of str
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (charHash.get(c) == 1) {
                return c;
            }
        }
        return null;
    }

    public static String findFirstNonRepeated(String str) {
        HashMap<Integer, Object> charHash = new HashMap<Integer, Object>();
        Object once = new Object(), multiple = new Object();
        Object seen;
        int i;  //?
        final int length = str.length();
        // build hashmap<codePoint, seenTimes>
        for (i = 0; i < length;) {
            final int codePoint = str.codePointAt(i);
            i += Character.charCount(codePoint); // ?? Determines the number of char values needed to represent the specified character (Unicode code point).
            seen = charHash.get(codePoint);
            if (seen == null) {  // not present
                charHash.put(codePoint, once);
            } else if (seen == once) {
                charHash.put(codePoint, multiple);
            }
        }
        // search str
        for (i = 0; i < length;) {
            final int codePoint = str.codePointAt(i);
            i += Character.charCount(codePoint);
            if (charHash.get(codePoint) == once) {
                return new String(Character.toChars(codePoint));
            }
        }
        return null;
    }

    /** ?
     * Delete characters from an ASCII string. Use the prototype:
     *    String removeChars(String str, String remove);
     * where any character existing in remove must be deleted from str.
     */
    public static String removeChars(String str, String remove) {
        char[] strChar = str.toCharArray();
        char[] removeChar = remove.toCharArray();
        int src, dst = 0;
        boolean[] flags = new boolean[128]; // size of 128 assumes ASCII
        // set flags of char in remove to true
        for(src = 0; src < removeChar.length; ++src) {
            flags[removeChar[src]] = true;
        }
        for (src = 0; src < strChar.length; ++src) {
            if (!flags[strChar[src]]) {
                strChar[dst++] = strChar[src];
            }
        }
        return new String(strChar, 0, dst);  // String(char[] value, int offset, int count)
    }

    /**
     * Reverse the order of the words in a string. Assume all words are space
     * delimited and treat punctuation the same as letters.
     */
    public static String reverseWords(String str) {
        if (str == null) return null;
        String[] strArray = str.split(" ");  /* forgot " " */
        StringBuilder builder = new StringBuilder();
        for (int i = strArray.length - 1; i >= 0; i--) {
            builder.append(strArray[i] + " ");  /* forgot + " " */
        }
        return builder.toString();
    }

    /**
     * Write two conversion routines:
     * 1. converts a string to a signed integer. -> Integer.parseInt()
     * 2. converts a signed integer to string. -> Integer.toString()
     * Assume int only contains digits and minus(-).
     */
    public static int strToInt(String str) {
        int result = 0;
        boolean isNeg = false;
        int i = 0;
        if (str.startsWith("-")) {
            isNeg = true;
            i++;
        }
        while (i < str.length()) {
            result *= 10;
            result += str.charAt(i++) - '0';  //?
        }
        return isNeg ? -result : result;
    }

    public static String intToStr(int num) {
        if (num == 0) return "0";

        final int MAX_DIGITS = 10;
        StringBuilder builder = new StringBuilder();
        if (num < 0) {
            builder.append("-");
            num = -num;
        }
        // put each digit to char buffer
        char[] temp = new char[MAX_DIGITS + 1];  // + 1 for negative char
        int i = 0;
        while (num != 0) {
            temp[i++] = (char)(num % 10 + '0'); //?
            num /= 10;
        }
        // build string in reverse order of buffer
        while (i > 0) {
            builder.append(temp[--i]); /* decrease i first */
        }
        return builder.toString();
    }




    public static void main(String[] args) {
        System.out.println(findFirstNonRepeated("Hello"));
        System.out.println(removeChars("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
        System.out.println(reverseWords("Do or do not, there is no try."));
        System.out.println(strToInt("-123"));
        System.out.println(intToStr(-123));
    }
}