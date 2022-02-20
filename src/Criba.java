import java.util.Scanner;

public class Criba {
    //Creamos un atributo de la clase donde guardamos los numeros primos
    private static int[] primos;

    public Criba(int max) {
//Creamos un constructor donde sacamos los números primos dentro del rango y luego lo volvamos en el
//el atributo de la clase
        boolean[] vector;
        vector = generarPrimos(max);
        primos = devuelvePrimos(vector);
    }

    // Generar números primos de 1 a max
    public static boolean[] generarPrimos(int max) {
//Por defecto no tenemos ningun primo
        int cuenta = 0;
        boolean[] esPrimo = new boolean[0];
// Borramos intentamos que las variables estén lo mas contenidas posible en su ambito
        if (max >= 2) {
// Declaraciones
            int dim = max + 1; // Tamaño del array
            esPrimo = new boolean[dim];
// Inicializar el array
            for (int i = 0; i < dim; i++) {
                esPrimo[i] = true;
            }
// Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
// Criba
            for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
// Eliminar los múltiplos de i
                    for (int j = 2 * i; j < dim; j += i) {
                        esPrimo[j] = false;
                    }
                }
            }
        }
//Sea cual sea el camino recorrido 2 > max o bien max >= 2 tendremos el resultado
        return esPrimo;
    }

    public static int getCuenta(boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < esPrimo.length; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    public static int[] devuelvePrimos(boolean[] vector) {

        int cuenta = getCuenta(vector);
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
        int dato = teclado.nextInt();
        //int dato = readInteger(teclado, "Introduce el número para la criba de Erastótenes:");
        int vector[] = new int[dato];
        System.out.println("\nVector inicial hasta : " + dato);
        for (int i = 0; i <= vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + "\t");
        }
        Criba myCriba = new Criba(dato);
        //vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta: " + dato);
        myCriba.muestraPrimos();
    }


}