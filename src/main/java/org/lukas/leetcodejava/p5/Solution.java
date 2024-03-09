package org.lukas.leetcodejava.p5;

class Solution {

  /**
   * Time complexity: O(n^2); Space complexity: O(n^2); Fast O(n^2) thanks to memoizing previous
   * palindromes via a boolean lookup table.
   */
  public String longestPalindromeDP(String s) {
    int bestLeft = 0;
    int bestRight = 0;
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int right = 0; right < s.length(); right++) {
      dp[right][right] = true;
      for (int left = 0; left < right; left++) {
        var isObviousPalindrome = right - left <= 2;
        var wasSubstrPalindrome = dp[left + 1][right - 1];
        if (s.charAt(left) == s.charAt(right) && (isObviousPalindrome || wasSubstrPalindrome)) {
          dp[left][right] = true;
          var curMaxLen = right - left + 1;
          var maxLen = bestRight - bestLeft + 1;
          if (curMaxLen > maxLen) {
            bestLeft = left;
            bestRight = right;
          }
        }
      }
    }
    return s.substring(bestLeft, bestRight + 1);
  }

  /**
   * Time complexity: O(n^2); Space complexity: O(1); O(n^2) thanks to avoiding call isPalindrome
   */
  public String longestPalindromeExpandCenters(String s) {
    var bestLeft = 0;
    var bestRight = 0;
    for (int i = 0; i < s.length(); i++) {
      var bestLength = bestRight - bestLeft;

      var centerSteps = expandCenter(s, i);
      var centerLeft = i - centerSteps;
      var centerRight = i + centerSteps + 1;
      var centerLength = centerRight - centerLeft;

      var gapSteps = expandGap(s, i);
      var gapLeft = i - gapSteps + 1;
      var gapRight = i + gapSteps + 1;
      var gapLength = gapRight - gapLeft;

      if (Math.max(centerLength, gapLength) > bestLength) {
        bestLeft = centerLength > gapLength ? centerLeft : gapLeft;
        bestRight = centerLength > gapLength ? centerRight : gapRight;
      }
    }
    return s.substring(bestLeft, bestRight);
  }

  int expandCenter(String s, int center) {
    int left = center - 1;
    int right = center + 1;
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) != s.charAt(right)) {
        break;
      }
      left--;
      right++;
    }
    return center - left - 1;
  }

  int expandGap(String s, int gap) {
    int left = gap;
    int right = gap + 1;
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) != s.charAt(right)) {
        break;
      }
      left--;
      right++;
    }
    return gap - left;
  }

  /**
   * Time complexity: O(n^3); Space complexity: O(1)
   */
  public String longestPalindromeBruteForce(String s) {
    var bestLeft = 0;
    var bestRight = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < s.length(); j++) {
        var curLen = j - i;
        var maxLen = bestRight - bestLeft;
        if (isPalindrome(s, i, j) && curLen > maxLen) {
          bestLeft = i;
          bestRight = j;
        }
      }
    }
    return s.substring(bestLeft, bestRight + 1);
  }

  boolean isPalindrome(String s, int left, int right) {
    for (int i = left, j = right; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}
