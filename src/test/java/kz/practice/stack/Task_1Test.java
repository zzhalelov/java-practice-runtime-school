package kz.practice.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task_1Test {
    @Test
    public void test1() {
        assertTrue(Task_1.areBracketsBalanced("(a+b)"));
    }

    @Test
    public void test2() {
        assertTrue(Task_1.areBracketsBalanced("((a+b))"));
    }

    @Test
    public void test3() {
        assertFalse(Task_1.areBracketsBalanced("(a+b]"));
    }
}