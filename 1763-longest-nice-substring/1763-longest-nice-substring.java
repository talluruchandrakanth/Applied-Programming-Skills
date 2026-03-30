class Solution {
    public String longestNiceSubstring(String s) {
        return solve(s);
    }

    private String solve(String s) {
        if (s.length() < 2) return "";

        int[] lower = new int[26];
        int[] upper = new int[26];

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) lower[c - 'a']++;
            else upper[c - 'A']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c) && upper[c - 'a'] == 0 ||
                Character.isUpperCase(c) && lower[c - 'A'] == 0) {

                String left = solve(s.substring(0, i));
                String right = solve(s.substring(i + 1));

                return left.length() >= right.length() ? left : right;
            }
        }

        return s;
    }
}