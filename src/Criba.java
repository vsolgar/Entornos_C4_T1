import java.util.Scanner;
/**
 * Clase utilizada para hallar los numeros primos que existen hasta un numero que se introduce por teclado
 * no acepta parámetros.
 * @author Vicente Soler
 * @version 1.0.2
 */
public class Criba {
    private static int[] primos;

    /**
     * Constructor de la Clase Criba
     * @param max Numero entero positivo, que sirve de tope para buscar primmos
     */
    public Criba(int max) {
        primos = devuelveVectorPrimos(generarVectorBooleanoNumeros(max));
    }

    /**
     * Metodo que retorna un vector Booleano donde los numeros primos están marcados a true
     * y los no primos a false, los numeros van de 0 hasta el numero proporcionado por teclado
     * @param numeroMaximo Numero entero positivo, que sirve de tope para buscar primmos
     * @return Vector booleano con valores true en los elementos cuyo numero de indice es primo
     */
    public static boolean[] generarVectorBooleanoNumeros(int numeroMaximo) {
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

    /**
     * Funcion que nos devuelve el numero de elementos true que tiene un vector de tipo booleano
     * @param esPrimo Vector booleano que indica que numeros son primos
     * @return el numero de elementos true que posee el vector
     */
    public static int getCuentaPrimos(boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < esPrimo.length; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    /**
     * Metodo que retorna un vector de enteros a partir de un vector de booleanos, y devuelve
     * un vector de numeros enteros con los indices de los elementos true del vector que recibe como parametro
     * @param vector Vector de numeros enteros primos
     * @return resultado
     */
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

    /**
     * Metodo que muestra en bloques de 10 elementos el contenido del atributo primos de la clase
     */
    private static void muestraPrimos() {
        for (int i = 0; i < primos.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(primos[i] + "\t");
        }
    }

    /**
     * Main incluido en la clase para demostracion del uso de la misma, aunque por defecto posee la deficion
     * de parametros no hace uso de los mismos.
     * @param args No utilizado
     */
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