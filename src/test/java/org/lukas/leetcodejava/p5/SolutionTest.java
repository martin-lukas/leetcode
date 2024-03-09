package org.lukas.leetcodejava.p5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

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
        String tested, int centerIndex, int expectedSteps, String longest
    ) {}
    var testCases = List.of(
        new ExpandCenterCase("abacaba", 0, 0, "a"),
        new ExpandCenterCase("abacaba", 1, 1, "aba"),
        new ExpandCenterCase("abacaba", 3, 3, "abacaba"),
        new ExpandCenterCase("abba", 1, 0, "b"),
        new ExpandCenterCase("a", 0, 0, "a")
    );
    testCases.forEach(tc -> {
      System.out.println(STR."Processing test case: \{tc}");
      var stepsFrom = tested.expandCenter(tc.tested, tc.centerIndex);
      assertEquals(tc.expectedSteps, stepsFrom);
      assertEquals(
          tc.longest,
          tc.tested.substring(
              tc.centerIndex - stepsFrom,
              tc.centerIndex + stepsFrom + 1
          )
      );
      System.out.println(STR."Passed test case: \{tc}");
    });
  }

  @Test
  void expandGapTest() {
    record ExpandGapCase(String tested, int gapIndex, int expectedSteps, String longest) {}
    var testCases = List.of(
        new ExpandGapCase("garrabbarrag", 0, 0, ""),
        new ExpandGapCase("garrabbarrag", 2, 2, "arra"),
        new ExpandGapCase("garrabbarrag", 5, 6, "garrabbarrag"),
        new ExpandGapCase("garrabbarrag", 10, 0, ""),
        new ExpandGapCase("aba", 1, 0, ""),
        new ExpandGapCase("abb", 1, 1, "bb"),
        new ExpandGapCase("a", 0, 0, "")
    );
    testCases.forEach(tc -> {
      System.out.println(STR."Processing test case: \{tc}");
      var stepsFrom = tested.expandGap(tc.tested, tc.gapIndex);
      assertEquals(tc.expectedSteps, stepsFrom);
      assertEquals(
          tc.longest,
          tc.tested.substring(
              tc.gapIndex - stepsFrom + 1,
              tc.gapIndex + stepsFrom + 1
          )
      );
      System.out.println(STR."Passed test case: \{tc}");
    });
  }

  @Test
  void isPalindromeTest() {
    assertTrue(tested.isPalindrome("a"));
    assertTrue(tested.isPalindrome("bb"));
    assertTrue(tested.isPalindrome("bab"));
    assertTrue(tested.isPalindrome("abba"));
    assertFalse(tested.isPalindrome("abb"));
    assertFalse(tested.isPalindrome("abaca"));
  }
}
