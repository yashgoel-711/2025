package DP;

public class LongestPalindromeSubString {
    

    public static boolean isPalindrome(String s, int i, int j, int[][] dp) {
        // Base case: single char or empty
        if (i == j) {
            return true;
        }

        // If already computed
        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }

        // Check palindrome
        if (s.charAt(i) == s.charAt(j)) {
            if (isPalindrome(s, i + 1, j - 1, dp)) {
                dp[i][j] = 1;
                return true;
            }
        }

        dp[i][j] = -1;
        return false;
    }

    public static void main(String[] args) {

        String s = "babad";
        int n = s.length();

        int[][] dp = new int[n][n];

        int max = 1; // Single char is always palindrome
        int sp = 0;

        // Check all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(isPalindrome(s, i, j, dp)){
                    if(j - i + 1 > max){
                        max = j - i + 1;
                        sp = i;
                    }
                }
            }
        }

        System.out.println("Longest Palindrome substring = " + s.substring(sp, sp + max));
    }
}
