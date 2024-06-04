package org.lukas.leetcodejava.p88;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution tested = new Solution();

    @Test
    void merge2Arrays() {
        var length1 = 3;
        var length2 = 4;
        var nums1 = new int[length1 + length2];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 8;
        var nums2 = new int[]{2,6,9,10};
        tested.merge(nums1, length1, nums2, length2);
        assertArrayEquals(new int[]{1,2,3,6,8,9,10}, nums1);
    }

    @Test
    void mergeArrayWithEmptyArray() {
        var length1 = 3;
        var length2 = 0;
        var nums1 = new int[length1 + length2];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 8;
        var nums2 = new int[]{};
        tested.merge(nums1, length1, nums2, length2);
        assertArrayEquals(new int[]{1,3,8}, nums1);
    }

    @Test
    void mergeEmptyArrayWithArray() {
        var length1 = 0;
        var length2 = 3;
        var nums1 = new int[length1 + length2];
        var nums2 = new int[]{2,6,9};
        tested.merge(nums1, length1, nums2, length2);
        assertArrayEquals(new int[]{2,6,9}, nums1);
    }

    @Test
    void mergeArraysWithNegativeNumbers() {
        var length1 = 3;
        var length2 = 4;
        var nums1 = new int[length1 + length2];
        nums1[0] = -1;
        nums1[1] = 3;
        nums1[2] = 8;
        var nums2 = new int[]{-2,6,9,10};
        tested.merge(nums1, length1, nums2, length2);
        assertArrayEquals(new int[]{-2,-1,3,6,8,9,10}, nums1);
    }

    @Test
    void mergeArrayWithSmallAndArrayWithBigNumbers() {
        var length1 = 3;
        var length2 = 3;
        var nums1 = new int[length1 + length2];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        var nums2 = new int[]{4,5,6};
        tested.merge(nums1, length1, nums2, length2);
        assertArrayEquals(new int[]{1,2,3,4,5,6}, nums1);
    }

}