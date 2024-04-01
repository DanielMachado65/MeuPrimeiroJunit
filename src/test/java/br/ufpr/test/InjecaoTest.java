package br.ufpr.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InjecaoTest {
    @BeforeEach
    public void setUp(TestInfo testInfo) {
        System.out.printf("Display name no before each: %s%n", testInfo.getDisplayName());
    }

    @Test
    public void test1(TestInfo testInfo) {
        assertEquals("test1(TestInfo)", testInfo.getDisplayName());
    }

    @Test
    public void test2(TestInfo testInfo) {
        assertEquals("test2(TestInfo)", testInfo.getDisplayName());
    }
}
