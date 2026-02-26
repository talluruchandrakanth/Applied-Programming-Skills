class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder firstPass = new StringBuilder();
        int open = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
                firstPass.append(ch);
            } 
            else if (ch == ')') {
                if (open > 0) {
                    open--;
                    firstPass.append(ch);
                }
            } 
            else {
                firstPass.append(ch); 
            }
        }

        StringBuilder result = new StringBuilder();
        int close = 0;
        for (int i = firstPass.length() - 1; i >= 0; i--) {
            char ch = firstPass.charAt(i);

            if (ch == ')') {
                close++;
                result.append(ch);
            } 
            else if (ch == '(') {
                if (close > 0) {
                    close--;
                    result.append(ch);
                }
            } 
            else {
                result.append(ch);
            }
        }

        return result.reverse().toString();
    }
}
