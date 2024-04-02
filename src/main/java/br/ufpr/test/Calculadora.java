package br.ufpr.test;

public class Calculadora {
    private final Memoria memoria;

    public Calculadora(Memoria memoria) {
        this.memoria = memoria;
    }

    public int somaComMemoria(int a, int b) {
        int resultado = soma(soma(a, b), memoria.getMemoria());
        memoria.setMemoria(resultado);
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

    public long pa(int inicial, int quociente, long valorMax) {
        long gn = inicial;
        while (gn <= valorMax) {
            gn += quociente;
        }
        return gn;
    }

    public int divide(int dividendo, int divisor, boolean mascaraDivisaoPorZero) {
        if (divisor == 0 && mascaraDivisaoPorZero) return 0;
        return divide(dividendo, divisor);
    }

    public int divide(int dividendo, int divisor) {
        return dividendo / divisor;
    }
}






