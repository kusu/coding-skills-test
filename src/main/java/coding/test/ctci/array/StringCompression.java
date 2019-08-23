package coding.test.ctci.array;

public class StringCompression {

    public static String compress(String s) {

        StringBuilder builder = new StringBuilder();
        int count = 1;

        int i = 0;

        while (i < s.length() - 1) {

            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                builder.append(s.charAt(i)).append(count);
                count = 1;
            }

            i++;
        }

        builder.append(s.charAt(i)).append(count);

        if (builder.length() > s.length()) {
            return s;
        }

        return builder.toString();
    }


    public static void main(String[] args) {
        String s2 = "aaaabbbbcccdeeefffffgggghhh";


        System.out.println(compress(s2));
    }
}
