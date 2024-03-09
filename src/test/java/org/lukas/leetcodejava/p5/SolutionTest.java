package org.lukas.leetcodejava.p5;

import static org.junit.jupiter.api.Assertions.*;
import static org.lukas.leetcodejava.p5.Solution.Origin.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.lukas.leetcodejava.p5.Solution.Origin;

class SolutionTest {

  Solution tested = new Solution();

  @Test
  void longestPalindromeDPTest() {
    assertEquals("bab", tested.longestPalindromeDP("babad"));
    assertEquals("a", tested.longestPalindromeDP("a"));
    assertEquals("bb", tested.longestPalindromeDP("cbbd"));
    assertEquals("abba", tested.longestPalindromeDP("notabba"));
  }

  @Test
  void longestPalindromeExpandCentersTest() {
    assertEquals("bab", tested.longestPalindromeExpandCenters("babad"));
    assertEquals("a", tested.longestPalindromeExpandCenters("a"));
    assertEquals("bb", tested.longestPalindromeExpandCenters("cbbd"));
  }

  @Test
  void longestPalindromeBruteForceTest() {
    assertEquals("bab", tested.longestPalindromeBruteForce("babad"));
    assertEquals("a", tested.longestPalindromeBruteForce("a"));
    assertEquals("bb", tested.longestPalindromeBruteForce("cbbd"));
  }

  @Test
  void expandCenterTest() {
    record ExpandCenterCase(
        String tested, int centerIndex, Origin origin, int expectedSteps, String longest
    ) {}
    var testCases = List.of(
        new ExpandCenterCase("abacaba", 0, CHAR, 0, "a"),
        new ExpandCenterCase("abacaba", 1, CHAR, 1, "aba"),
        new ExpandCenterCase("abacaba", 3, CHAR, 3, "abacaba"),
        new ExpandCenterCase("abba", 1, CHAR, 0, "b"),
        new ExpandCenterCase("a", 0, CHAR, 0, "a"),
        new ExpandCenterCase("garrabbarrag", 0, GAP, 0, ""),
        new ExpandCenterCase("garrabbarrag", 2, GAP, 2, "arra"),
        new ExpandCenterCase("garrabbarrag", 5, GAP, 6, "garrabbarrag"),
        new ExpandCenterCase("garrabbarrag", 10, GAP, 0, ""),
        new ExpandCenterCase("aba", 1, GAP, 0, ""),
        new ExpandCenterCase("abb", 1, GAP, 1, "bb"),
        new ExpandCenterCase("a", 0, GAP, 0, "")
    );
    testCases.forEach(tc -> {
      System.out.println(STR."Processing test case: \{tc}");
      var stepsFrom = tested.expandCenter(tc.tested, tc.centerIndex, tc.origin);
      assertEquals(tc.expectedSteps, stepsFrom);
      assertEquals(
          tc.longest,
          switch (tc.origin) {
            case CHAR -> tc.tested.substring(
                tc.centerIndex - stepsFrom,
                tc.centerIndex + stepsFrom + 1
            );
            case GAP -> tc.tested.substring(
                tc.centerIndex - stepsFrom + 1,
                tc.centerIndex + stepsFrom + 1
            );
          }

      );
      System.out.println(STR."Passed test case: \{tc}");
    });
  }

  @Test
  void isPalindromeTest() {
    var evenStr = "abba";
    assertTrue(tested.isPalindrome(evenStr, 0, 0));
    assertTrue(tested.isPalindrome(evenStr, 1, 2));
    assertFalse(tested.isPalindrome(evenStr, 0, 2));
    assertTrue(tested.isPalindrome(evenStr, 0, 3));
    var oddStr = "abaca";
    assertTrue(tested.isPalindrome(oddStr, 0, 2));
    assertFalse(tested.isPalindrome(oddStr, 0, 4));
  }
}
