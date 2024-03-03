package org.lukas.leetcodejava.p1071;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution tested = new Solution();
    
    int gcd(int a, int b) {
        var lower = Math.min(a, b);
        var higher = Math.max(a, b);
        for (int i = lower; i > 1; i--) {
            if (lower % i == 0 && higher % i == 0) {
                return i;
            }
        }
        return 1;
    }
    
    int gcdB(int a, int b) {
        if (b % a == 0)
            return a;
        else
            return gcd(a - 1, b);
    }
    
    @Test
    void gcdTest() {
        assertEquals(4, gcd(4, 8));
        assertEquals(11, gcd(11, 121));
        assertEquals(7, gcd(28, 63));
    }
    
    @Test
    void gcdOfStrings() {
        assertEquals("ABC", tested.gcdOfStrings("ABCABC", "ABC"));
        assertEquals("AB", tested.gcdOfStrings("ABABAB", "ABAB"));
        assertEquals("", tested.gcdOfStrings("LEET", "CODE"));
    }
}
