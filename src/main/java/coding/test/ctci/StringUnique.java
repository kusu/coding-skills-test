package coding.test.ctci;

public class StringUnique {

    public static boolean checkUnique(String s) {
        int bitVector = 0;

        for (char c : s.toCharArray()) {

            int index = Character.toLowerCase(c) - 'a';

            if ((bitVector & 1 << index) > 0) {
                return false;
            } else {
                bitVector = bitVector | (1 << index);
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String s1 = "TestString";
        String s2 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(checkUnique(s1));

        System.out.println(checkUnique(s2));
    }
}
