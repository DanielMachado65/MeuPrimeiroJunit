package br.ufpr.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class CalculadoraJava17Test {

    Calculadora calculadora;

    @BeforeEach
    void setUp() {
        String EXPECTED_JAVA_VERSION = "1.8";
        String property = System.getProperty("java.vm.specification.version");
        assumeTrue(property.equals(EXPECTED_JAVA_VERSION),
                "É esperado versão do Java %s, encontrado %s".formatted(EXPECTED_JAVA_VERSION, property));

        calculadora = new Calculadora(new Memoria());
    }

    @Test
    public void testSoma2e3() {
        int resultado = calculadora.soma(2, 3);

        assertEquals(5, resultado, "O resultado de 2+3 é diferente de 5");
    }
}
