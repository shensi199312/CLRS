package com.shensi.clrs.chapter32;

public class SimpleStringMatch {


    public static int search(String t, String p)
    {
        if (p.length() > t.length())
        {
            return -1;
        }
        int n = t.length();
        int m = p.length();
        int result = -1;
        for (int i = -1; i < n - m; i++) {
            int s = i + 1;
            boolean equals = true;
            for (int j = 0; j < p.length(); j++) {
                if (t.charAt(j + s) != p.charAt(j))
                {
                    equals = false;
                }
            }
            if (equals) result = s;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "acaabcb";
        int aab = search(s, "aabd");

        System.out.println(aab);
    }
}
