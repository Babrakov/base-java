package ru.infoza.part2;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!"));
        System.out.println(isPalindrome("Abracadabra"));
    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        String lowerCase = removeNonAlphanumeric(text).toLowerCase();
        StringBuilder sb = new StringBuilder(lowerCase);
        String reverse = sb.reverse().toString();
//        System.out.println(reverse);
        return reverse.equals(lowerCase); // your implementation here
    }

    // Function to remove non-alphanumeric
    // characters from string
    public static String removeNonAlphanumeric(String str) {
        // replace the given string
        // with empty string
        // except the pattern "[^a-zA-Z0-9]"
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        // return string
        return str;
    }
}
