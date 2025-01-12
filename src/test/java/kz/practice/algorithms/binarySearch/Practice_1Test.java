package kz.practice.algorithms.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Practice_1Test {
    @Test
    public void test1() {
        assertEquals(2, Practice_1.binarySearch(new int[]{1, 3, 5, 7, 9}, 5));
    }

    @Test
    public void test2() {
        assertEquals(-1, Practice_1.binarySearch(new int[]{1, 3, 5, 7, 9}, 6));
    }
}