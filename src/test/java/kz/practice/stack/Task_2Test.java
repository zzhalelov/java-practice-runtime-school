package kz.practice.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task_2Test {
    @Test
    public void test1() {
        assertEquals("gnirts", Task_2.reverse("string"));
    }

    @Test
    public void test2() {
        assertEquals("olleh", Task_2.reverse("hello"));
    }
}