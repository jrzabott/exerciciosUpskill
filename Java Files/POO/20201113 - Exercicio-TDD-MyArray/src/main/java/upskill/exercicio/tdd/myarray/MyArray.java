/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicio.tdd.myarray;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class MyArray {

    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    int obterNumeroElementos() {
        return this.array.length;
    }

    int obterMaiorElemento() {
        int max = this.array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    int obterNumeroElementosNaoNulos() {
        int counter = 0;
        for (int i : array) {
            if (i != 0) {
                counter++;
            }
        }
        return counter;
    }

    double calcularMediaElementos() {
        double soma = 0;
        for (int i : array) {
            soma += i;
        }
        return soma / this.array.length;
    }

    double calcularMediaDosMultiplosDe(int num) {
        double soma = 0;
        double count = 0;
        for (int i : array) {
            if (i % num == 0) {
                soma += i;
                count++;
            }
        }
        return soma / count;
    }

    boolean isEmpty() {
//        return (this.array == null || this.array.length == 0);
        return (this.array.length == 0);
    }

    boolean isOnlyEven() {
        for (int i : array) {
            if (i % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    int[] getAllNumbersComposedByEvenNumbers() {
        ArrayList al = new ArrayList();
        int num = 0;
        int dig = 0;
        for (int i : array) {
            num = i;
            while (num > 0) {
                dig = num % 10;
                num /= 10;

                if (dig % 2 != 0) {
                    break;
                }
                if (num == 0) {
                    al.add(i);
                }
            }
        }
        System.out.println("ArrayList: " + al);
        int[] result = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            result[i] = (int) al.get(i);
        }
        return result;
    }

    int[] getAllNumbersComposedBySameNumber() {
        ArrayList al = new ArrayList();
        int num = 0;
        int algorismo = 0;
        int dig = 0;
        for (int i : array) {
            algorismo = i % 10;
            num = i;
            if (i == 0) {
                al.add(i);
            }
            while (num > 0) {
                dig = num % 10;
                num /= 10;
                if (dig != algorismo) {
                    break;
                }
                if (num == 0) {
                    al.add(i);
                }
            }
        }
        System.out.println("ArrayList (sameNumber): " + al);
        int[] result = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            result[i] = (int) al.get(i);
        }
        return result;
    }

    int[] getAllNumbersComposedInCrescentOrder() {
        ArrayList al = new ArrayList();
        int num = 0;
        int dig = 0;
        for (int i : array) {
            num = i;
            if (i >= 0 && i < 10) {
                al.add(i);
            }
            while (num > 0 && i >= 10) {
                dig = num % 10;
                num /= 10;
                if (dig <= num % 10) {
                    break;
                }
                if (num == 0) {
                    al.add(i);
                }
            }
        }
        System.out.println("ArrayList (Crescent Sequence): " + al);
        int[] result = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            result[i] = (int) al.get(i);
        }
        return result;
    }

    boolean isEqual(int[] otherArr) {
        if (otherArr.length != array.length) {
            return false;
        }
        for (int i = 0; i < otherArr.length; i++) {
            if (array[i] != otherArr[i]) {
                return false;
            }
        }
        return true;
    }

    int[] invertArray() {
        int[] inv = new int[this.array.length];
        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            inv[index] = array[i];
            index++;
        }
        return inv;
    }
}
