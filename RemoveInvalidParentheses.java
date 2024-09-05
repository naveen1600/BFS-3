// Time Complexity:  O(2^n)
// Space Complexity: O(2^n)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        q.add(s);
        set.add(s);
        boolean flag = false;

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (isBalanced(curr)) {
                flag = true;
                result.add(curr);
            }

            if (!flag) {
                for (int i = 0; i < curr.length(); i++) {
                    if (Character.isAlphabetic(curr.charAt(i)))
                        continue;
                    String str = curr.substring(0, i) + curr.substring(i + 1);
                    if (!set.contains(str)) {
                        set.add(str);
                        q.add(str);
                    }
                }
            }
        }

        return result;
    }

    private boolean isBalanced(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(s.charAt(i)))
                continue;
            if (c == '(')
                count++;
            else
                count--;
            if (count < 0)
                return false;
        }

        return count == 0;

    }
}