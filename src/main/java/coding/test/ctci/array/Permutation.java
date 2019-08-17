package coding.test.ctci.array;

public class Permutation {

    public static boolean checkPermutation(String s1, String s2) {

        int[] freq1 = new int[128];
        int[] freq2 = new int[128];

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s2.length(); i++) {
            freq1[s1.charAt(i) - 'a'] += 1;
            freq2[s2.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < 128; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkPermutationPalindrome(String s1) {

        int[] freq1 = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a'] += 1;
        }

        int oddCount = 0;

        for (int f : freq1) {
            if (f == 1) {
                oddCount++;
            }

            if (oddCount > 1) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String s1 = "TestString";
        String s2 = "abcdefghijklmnopqrstuvwxyz";


        System.out.println(checkPermutation(s1, s2));
        System.out.println(checkPermutation("abcde", "cbaed"));
    }
}
