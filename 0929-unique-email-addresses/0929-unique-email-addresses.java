import java.util.*;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            int at = email.indexOf('@');
            String local = email.substring(0, at);
            String domain = email.substring(at);

            int plus = local.indexOf('+');
            if (plus != -1) local = local.substring(0, plus);

            local = local.replace(".", "");

            set.add(local + domain);
        }

        return set.size();
    }
}