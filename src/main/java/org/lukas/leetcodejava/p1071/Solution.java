package org.lukas.leetcodejava.p1071;

class Solution {

  public String gcdOfStrings(String str1, String str2) {
    var base = str1.length() <= str2.length() ? str1 : str2;
    var other = str1.length() > str2.length() ? str1 : str2;
    for (int limit = base.length(); limit > 0; limit--) {
      var gcd = base.substring(0, limit);
      if (base.equals(gcd.repeat(base.length() / limit))
          && other.equals(gcd.repeat(other.length() / limit))
      ) {
        return gcd;
      }
    }
    return "";
  }
}
