package org.lukas.leetcodejava.p169;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution tested = new Solution();

  @Test
  void filledArrayWithMajorityElement() {
    var arr = new int[]{3, 2, 3};
    assertEquals(3, tested.majorityElement(arr));
    arr = new int[]{2, 2, 1, 1, 1, 2, 2};
    assertEquals(2, tested.majorityElement(arr));
    arr = new int[]{-2, -2, 1, -2, 2, 2};
    assertEquals(-2, tested.majorityElement(arr));
  }

  @Test
  void emptyArray() {
    var arr = new int[0];
    assertThrows(IllegalArgumentException.class, () -> tested.majorityElement(arr));
  }

  @Test
  void filledArrayWithoutMajorityElement() {
    var arr = new int[]{1, 1, 2, 2, 3, 3, 3};
    assertThrows(IllegalArgumentException.class, () -> tested.majorityElement(arr));
  }
}
