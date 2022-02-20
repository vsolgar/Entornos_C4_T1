import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CribaTest {
    Criba myCriba1;
    int[] vectorI1 = new int[] {2,3,5};
    int[] vectorI2 = new int[0];
    boolean[] vectorB1 = new boolean[] {false, false, true, true, false, true};
    boolean[] vectorB2 = new boolean[0];

    @Test
    void generarPrimosTest() {
        myCriba1 = new Criba(5);
        vectorB2 = Criba.generarPrimos(5);
        assertArrayEquals(vectorB1,vectorB2);

        vectorB1 = new boolean[0];
        assertFalse(vectorB1.equals(vectorB2));
        myCriba1 = new Criba(1);

        vectorB2 = Criba.generarPrimos(1);
        assertArrayEquals(vectorB1,vectorB2);
    }

    @Test
    void devuelvePrimosTest(){
        myCriba1 = new Criba(5);
        vectorI2 = Criba.devuelvePrimos(vectorB1);
        assertArrayEquals(vectorI1,vectorI2);
    }

    @Test
    void getCuentaTest(){
        myCriba1 = new Criba(5);
        int primos = 3;
        assertEquals(primos, myCriba1.getCuenta(vectorB1));

    }


    @Test
    void main() {
        myCriba1 = new Criba(5);
        assertEquals(3,myCriba1.getCuenta(vectorB1));
    }

}