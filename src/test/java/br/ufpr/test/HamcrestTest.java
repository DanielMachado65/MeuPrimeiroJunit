package br.ufpr.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class HamcrestTest {
    private List<String> valores;

    @BeforeEach
    public void setUp() {
        valores = new ArrayList<>();
        valores.add("Michel");
        valores.add("João");
        valores.add("Edson");
    }

    @Test
    @DisplayName("Lista sem Hamcrest")
    public void testSemHamcrest() {
        assertEquals(3, valores.size());
        assertTrue(valores.contains("Antonio")
                || valores.contains("Jaco")
                || valores.contains("Mário"));
    }
    @Test
    @DisplayName("Lista com Hamcrest")
    public void testComHamcrest() {
        assertThat(valores, hasSize(3));
        assertThat(valores, hasItem(anyOf(equalTo("Antonio"),
                equalTo("Jaco"),
                equalTo("Mário"))));
    }
}
