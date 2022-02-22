import java.util.Scanner;

public class Criba {
    private static int[] primos;

    public Criba(int max) {
        primos = devuelveVectorPrimos(generarVectorNumeros(max));
    }

    public static boolean[] generarVectorNumeros(int numeroMaximo) {
        int cuenta = 0;
        boolean[] vector = new boolean[0];

        if (numeroMaximo >= 2) {
            int dimension = numeroMaximo + 1;
            vector = new boolean[dimension];

            for (int i = 0; i < dimension; i++) {
                vector[i] = true;
            }
// Utilizamos la Criba de Erastótenes para sacar los primos
            vector[0] = vector[1] = false;

            for (int i = 2; i < Math.sqrt(dimension) + 1; i++) {
                if (vector[i]) {
// Eliminar los múltiplos de i
                    for (int j = 2 * i; j < dimension; j += i) {
                        vector[j] = false;
                    }
                }
            }
        }

        return vector;
    }

    public static int getCuentaPrimos(boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < esPrimo.length; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    public static int[] devuelveVectorPrimos(boolean[] vector) {

        int cuenta = getCuentaPrimos(vector);
        int[] resultado = new int[0];

        if (cuenta > 0) {
            resultado = new int[cuenta];

            for (int i = 0, j = 0; i < vector.length; i++) {
                if (vector[i])
                    resultado[j++] = i;
            }
        }
        return resultado;
    }

    private static void muestraPrimos() {
        for (int i = 0; i < primos.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(primos[i] + "\t");
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int numeroMaximo = teclado.nextInt();

        int vector[] = new int[numeroMaximo];
        System.out.println("\nVector inicial hasta : " + numeroMaximo);
        for (int i = 0; i <= vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + "\t");
        }

        Criba myCriba = new Criba(numeroMaximo);

        System.out.println("\nVector de primos hasta: " + numeroMaximo);
        myCriba.muestraPrimos();
    }


}