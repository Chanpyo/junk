package leetcode;

/**
 * Given a String s, find the length of the longest substring without repeating characters.
 * Ex1 "abcabcbb" -> 3, "abc"
 * Ex2 "bbbbb" -> 1, "b"
 * Ex3 "pwwkew" -> 3, "wke"
 * @author Chanpyo Hong
 */
public class LongestSubstring {
    public static void main(String[] args) {
        subStringWoRepeat("abcabcbb");
        subStringWoRepeat("bbbbb");
        subStringWoRepeat("pwwkew");
        subStringWoRepeat("abcadfe");
    }

    private static void subStringWoRepeat(String original) {
        if (original.length() <= 1) {
            System.out.println("length : " + original.length() + ", substring : " + original);
            return;
        }

        char[] separated = new char[original.length()];
        for (int i=0; i<original.length(); i++) {
            separated[i] = original.charAt(i);
        }

        char[] candidate1 = new char[0];
        char[] candidate2 = new char[0];

        for (int i=0; i<separated.length; i++) {
            int repeatIndex = contains(candidate2, separated[i]);
            if (candidate2.length == 0 || repeatIndex < 0) {
                char[] newCandi2 = new char[candidate2.length + 1];
                for (int j = 0; j < candidate2.length; j++) {
                    newCandi2[j] = candidate2[j];
                }
                newCandi2[candidate2.length] = separated[i];
                candidate2 = newCandi2;
            } else {
                if (candidate1.length < candidate2.length) {
                    candidate1 = candidate2;
                }

                char[] newCandi2 = new char[candidate2.length - repeatIndex];
                for (int j=0; j<newCandi2.length - 1; j++) {
                    newCandi2[j] = candidate2[j + repeatIndex + 1];
                }
                newCandi2[newCandi2.length - 1] = separated[i];
                candidate2 = newCandi2;

            }
        }
        if (candidate1.length < candidate2.length) {
            candidate1 = candidate2;
        }

        System.out.println("input : " + original);
        System.out.println("length : " + candidate1.length);
        System.out.print("substring : ");
        for (int i=0; i< candidate1.length; i++) {
            System.out.print(candidate1[i]);
        }
        System.out.println("\n===========================");
    }

    private static int contains(char[] chars, char target) {
        if (chars == null || chars.length < 1) {
            return -1;
        }

        for (int i=0; i<chars.length; i++) {
            if (chars[i] == target) return i;
        }

        return -1;
    }
}
