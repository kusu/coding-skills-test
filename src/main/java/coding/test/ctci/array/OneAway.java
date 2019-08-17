package coding.test.ctci.array;

public class OneAway {

    public static boolean oneEditAway(String s1, String s2) {

        if (s1.length() == s2.length()) {
            return isReplace(s1, s2);
        } else if (s1.length() == (s2.length() + 1)) {
            return isInsert(s1, s2);
        } else if (s1.length() == (s2.length() - 1)) {
            return isInsert(s2, s1);
        }

        return false;
    }

    private static boolean isReplace(String s1, String s2) {

        boolean foundDiff = false;

        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {

                if (foundDiff) {
                    return false;
                }

                foundDiff = true;
            }

        }

        return true;

    }

    private static boolean isInsert(String longs1, String short2) {

        int j = 0;
        int i = 0;
        while (i < longs1.length()) {
            if (longs1.charAt(i) == short2.charAt(j)) {
                i++;
                j++;
            } else {
                if (i != j) {
                    return false;
                }
                i++;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(oneEditAway("Test", "Rest"));
        System.out.println(oneEditAway("Testr", "estr"));
        System.out.println(oneEditAway("Driver", "Diver"));
        System.out.println(oneEditAway("Diver", "Driver"));

        System.out.println(oneEditAway("Test", "Rist"));
        System.out.println(oneEditAway("Diver", "Drover"));
    }
}
