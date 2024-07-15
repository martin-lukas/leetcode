package org.lukas.leetcode.p169;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {

  public int majorityElement(int[] nums) {
    var map = new HashMap<Integer, Integer>();
    for (var num : nums) {
      map.compute(
          num,
          (k, count) -> count == null
              ? 1
              : count + 1
      );
    }
    var maxOccurElement = map.entrySet().stream()
        .max(Comparator.comparingInt(Entry::getValue))
        .map(Entry::getKey)
        .orElseThrow(
            () -> new IllegalArgumentException("Empty array doesn't contain majority element"));
    if (map.get(maxOccurElement) < (nums.length / 2.0)) {
      throw new IllegalArgumentException("The array didn't contain majority element");
    }
    return maxOccurElement;
  }
}