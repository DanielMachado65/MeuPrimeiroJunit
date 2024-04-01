package br.ufpr.test;

public class Calculadora {
    static int memoria = 0;

    public int somaComMemoria(int a, int b) {
        int resultado = soma(soma(a, b), memoria);
        memoria = resultado;
        return resultado;
    }

    public int soma(int a, int b) {
        return a + b;
    }

    public int multiplica(int a, int b) {
        return a * b;
    }

    public long pg(int inicial, int quociente, long valorMax) {
        long gn = inicial;
        while (gn <= valorMax) {
            gn *= quociente;
        }
        return gn;
    }

    public Object divide(int dividendo, int divisor, boolean mascaraDivisaoPorZero) {
        if (divisor == 0 && mascaraDivisaoPorZero) return 0;
        return dividendo / divisor;
    }

    public Object divide(int dividendo, int divisor) {
        return dividendo / divisor;
    }
}






