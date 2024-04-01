package br.ufpr.test;

public class Calculadora {
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
}






