package br.ufpr.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculadoraTest {
    Calculadora calculadora;

    @BeforeAll
    static void setUpClass() {
        System.out.println("Este método é executado apenas uma vez todos os testes desta classe, no início.");
    }

    @AfterAll
    static void tearDownClass() {
        System.out.println("Este método é executado apenas uma vez todos os testes desta classe, no final.");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Este método é executado antes de cada um dos testes desta classe.");
        calculadora = new Calculadora();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Este método é executado após de cada um dos testes desta classe.");
    }

    @Test
    @Tag("Positivos")
    @DisplayName("Teste simples de soma")
    public void testSoma2e3() {
        int resultado = calculadora.soma(2, 3);

        assertEquals(5, resultado);
    }

    @Test
    @Tag("Positivos")
    @DisplayName("Teste simples de multiplicação")
    public void testMultiplica2e3() {
        int resultado = calculadora.multiplica(2, 3);

        assertEquals(6, resultado);
    }

    @Test
    @Tag("Negativos")
    @DisplayName("Teste simples de multiplicação negativa")
    public void testMultiplica2eMenos3() {
        int resultado = calculadora.multiplica(2, -3);

        assertEquals(-6, resultado);
    }

    @Test
    @DisplayName("Teste com valor máximo do integer, que deverá falhar. 😱")
    @Disabled("Desabilitado, já que vai falhar sempre mesmo.")
    public void testSomaMuitoGrande() {
        int resultado = calculadora.soma(Integer.MAX_VALUE, 2);

        assertTrue(resultado > Integer.MAX_VALUE);
    }
}



