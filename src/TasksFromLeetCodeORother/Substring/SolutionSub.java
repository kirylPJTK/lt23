package TasksFromLeetCodeORother.Substring;

import java.util.Arrays;

public class SolutionSub {
    public static void main(String[] args) {
        String s = "a dfsnvkladnfjk;v";
        System.out.println(s.length());

        char[] tab = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            tab[i] = s.charAt(i);
        }

        System.out.println(Arrays.toString(tab));
    }
}


class Solution{
    public int lengthOfLongestSubstring(String s) {
        String s1 = "nsljndvlks";
        System.out.println(s1.length());
        return 0;
    }
}