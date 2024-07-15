package org.lukas.leetcode.p5;

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

  public enum Origin {CHAR, GAP}

  /**
   * Time complexity: O(n^2); Space complexity: O(1); O(n^2) thanks to avoiding call isPalindrome
   */
  public String longestPalindromeExpandCenters(String s) {
    var bestLeft = 0;
    var bestRight = 0;
    for (int i = 0; i < s.length(); i++) {
      var centerSteps = expandCenter(s, i, Origin.CHAR);
      var gapSteps = expandCenter(s, i, Origin.GAP);

      var centerLength = centerSteps * 2 + 1;
      var gapLength = gapSteps * 2;
      var bestLength = bestRight - bestLeft;
      if (Math.max(centerLength, gapLength) > bestLength) {
        if (centerLength > gapLength) {
          bestLeft = i - centerSteps;
          bestRight = i + centerSteps + 1;
        } else {
          bestLeft = i - gapSteps + 1;
          bestRight = i + gapSteps + 1;
        }
      }
    }
    return s.substring(bestLeft, bestRight);
  }

  int expandCenter(String s, int center, Origin origin) {
    int left = switch (origin) {
      case Origin.CHAR -> center - 1;
      case Origin.GAP -> center;
    };
    int right = center + 1;
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) != s.charAt(right)) {
        break;
      }
      left--;
      right++;
    }
    return switch (origin) {
      case Origin.CHAR -> center - left - 1;
      case Origin.GAP -> center - left;
    };
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
