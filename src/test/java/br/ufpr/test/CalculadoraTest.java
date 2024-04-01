package br.ufpr.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

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

    @Tag("Positivos")
    @DisplayName("Teste simples de soma")
    @RepeatedTest(value = 5)
    public void testSoma2e3() {
        int resultado = calculadora.soma(2, 3);

        assertEquals(5, resultado, "O resultado de 2+3 é diferente de 5");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 20, 25})
    @DisplayName("Teste simples de soma de memória")
    public void testSoma2e3Memoria(int memoria) {
        int resultado = calculadora.somaComMemoria(2, 3);

        assertEquals(memoria, resultado, "O resultado de 2+3 é diferente de 5");
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

        assertAll(() -> assertEquals(-6, resultado),
                () -> assertTrue(resultado < 0));
    }

    @Test
    @DisplayName("Teste simples de progressão geométrica")
    public void testPG() {
        assertTimeoutPreemptively(ofMillis(500), () -> calculadora.pg(1, 2, 32));
    }

    @Test
    @DisplayName("Teste simples de não exceção")
    public void testNoException() {
        assertDoesNotThrow(() -> calculadora.divide(5, 0, true));
    }

    @Test
    @DisplayName("Teste simples de exceção")
    public void testException() {
        assertThrows(ArithmeticException.class, () -> calculadora.divide(5, 0));
        assertThrows(ArithmeticException.class, () -> calculadora.divide(5, 0, false));
    }
}



