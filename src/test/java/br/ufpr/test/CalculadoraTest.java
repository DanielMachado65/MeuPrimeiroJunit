package br.ufpr.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {
    @Test
    public void testA() {
        int resultado = Calculadora.soma(2, 3);

        assertEquals(5, resultado);
    }
}



