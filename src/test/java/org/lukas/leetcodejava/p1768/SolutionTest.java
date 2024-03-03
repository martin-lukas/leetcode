package org.lukas.leetcodejava.p1768;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution tested = new Solution();
    
    @Test
    void mergeAlternatelyForLoop() {
        assertEquals("apbqcr", tested.mergeAlternatelyForLoop("abc", "pqr"));
        assertEquals("apbqrs", tested.mergeAlternatelyForLoop("ab", "pqrs"));
        assertEquals("apbqcd", tested.mergeAlternatelyForLoop("abcd", "pq"));
    }
    
    @Test
    void mergeAlternatelyForEach() {
        assertEquals("apbqcr", tested.mergeAlternatelyForEach("abc", "pqr"));
        assertEquals("apbqrs", tested.mergeAlternatelyForEach("ab", "pqrs"));
        assertEquals("apbqcd", tested.mergeAlternatelyForEach("abcd", "pq"));
    }
    
    @Test
    void mergeAlternatelyFunctional() {
        assertEquals("apbqcr", tested.mergeAlternatelyFunctional("abc", "pqr"));
        assertEquals("apbqrs", tested.mergeAlternatelyFunctional("ab", "pqrs"));
        assertEquals("apbqcd", tested.mergeAlternatelyFunctional("abcd", "pq"));
    }
}
