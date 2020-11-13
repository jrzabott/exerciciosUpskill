/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicio.tdd.myarray;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class MyArrayTest {

    int arr1[] = {1, 2, 3, 4};
    int arrEven[] = {2, 4, 6, 8, 2000, 444};
    int arrEvenAndOdd[] = {2, 2000, 444, 111, 333, 221};
    int arrOdd[] = {1, 3, 5, 7, 1001, 1003};
    int arrEmpty[] = {};
    int arrWithNulls[] = {0, 1, 2, 0, 3};
    int arrWithSameNumbers[] = {0, 11, 222, 3333, 99999};
    int arrWithNumbersCrescentOrder[] = {0, 1, 2, 23, 567, 1489};

    public MyArrayTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    public void testObterNumeroElementos() {
        // Arrange

        MyArray instance = new MyArray(arr1);
        int expResult = 4;

        // Act
        int result = instance.obterNumeroElementos();

        assertEquals(expResult, result);
    }

    public void testObterNumeroElementos_Vazio() {
        // Arrange

        MyArray instance = new MyArray(arrEmpty);
        int expResult = 0;

        // Act
        int result = instance.obterNumeroElementos();

        assertEquals(expResult, result);
    }

    public void testObterMaiorElemento() {

        MyArray instance = new MyArray(arr1);

        int expResult = 4;
        assertEquals(expResult, instance.obterMaiorElemento());

    }

    public void testObterNumeroElementosNaoNulos() {

        MyArray instance = new MyArray(arrWithNulls);

        double expResult = 3.0;
        assertEquals(expResult, instance.obterNumeroElementosNaoNulos());

    }

    public void testCalcularMediaElementos() {
        MyArray instance = new MyArray(arr1);

        double expResult = 2.5;
        assertEquals(expResult, instance.calcularMediaElementos());
    }

    public void testMediaDosMultiplosDe() {
        MyArray instance = new MyArray(arr1);

        double expResult = 3.0;
        assertEquals(expResult, instance.calcularMediaDosMultiplosDe(2));
    }

    public void testIsEmptyFalse() {
        MyArray instance = new MyArray(arr1);
        assertFalse(instance.isEmpty());
    }

    public void testIsEmptyTrue() {
        MyArray instance = new MyArray(arrEmpty);
        assertTrue(instance.isEmpty());
    }

    public void testIsOnlyEvenTrue() {
        MyArray instance = new MyArray(arrEven);
        assertTrue(instance.isOnlyEven());
    }

    public void testIsOnlyEvenFalse() {
        MyArray instance = new MyArray(arrOdd);
        assertFalse(instance.isOnlyEven());
    }

    public void testGetAllNumbersComposedByEvenNumbers_True() {
        MyArray instance = new MyArray(arrEven);
        int[] expResult = {2, 4, 6, 8, 2000, 444};
        assertArrayEquals(expResult, instance.getAllNumbersComposedByEvenNumbers());
    }

    public void testGetAllNumbersComposedByEvenNumbers_False() {
        MyArray instance = new MyArray(arrOdd);
        int[] expResult = {};
        assertArrayEquals(expResult, instance.getAllNumbersComposedByEvenNumbers());
    }

    public void testGetAllNumbersComposedByEvenNumbers_EvenAndOdd() {
        MyArray instance = new MyArray(arrEvenAndOdd);
        int[] expResult = {2, 2000, 444};
        assertArrayEquals(expResult, instance.getAllNumbersComposedByEvenNumbers());
    }

    public void testGetAllNumbersComposedBySameNumber_True() {
        MyArray instance = new MyArray(arrWithSameNumbers);
        int[] expResult = arrWithSameNumbers;
        assertArrayEquals(expResult, instance.getAllNumbersComposedBySameNumber());
    }

    public void testGetAllNumbersComposedInCrescentOrder_True() {
        MyArray instance = new MyArray(arrWithNumbersCrescentOrder);
        int[] expResult = arrWithNumbersCrescentOrder;
        assertArrayEquals(expResult, instance.getAllNumbersComposedInCrescentOrder());
    }

    public void testGetAllNumbersComposedInCrescentOrder_False() {
        MyArray instance = new MyArray(arrEven);
        int[] expResult = {2, 4, 6, 8};
        assertArrayEquals(expResult, instance.getAllNumbersComposedInCrescentOrder());
    }

    public void testIsEqual_True() {
        MyArray instance = new MyArray(arrEven);
        assertTrue(instance.isEqual(arrEven));
    }

    public void testIsEqual_False() {
        MyArray instance = new MyArray(arrEven);
        assertFalse(instance.isEqual(arrOdd));
    }

    public void testInvertArray_True() {
        MyArray instance = new MyArray(arrEven);
        int[] expResult = {444, 2000, 8, 6, 4, 2};
        assertArrayEquals(expResult, instance.invertArray());
    }

    @Test
    public void DISABLED_testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
