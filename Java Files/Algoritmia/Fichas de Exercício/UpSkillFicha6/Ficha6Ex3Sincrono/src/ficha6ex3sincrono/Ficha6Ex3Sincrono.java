/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha6ex3sincrono;

import com.sun.xml.internal.bind.v2.util.EditDistance;

/**
 *
 * @author user
 */
public class Ficha6Ex3Sincrono {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] myArr = {1, 1, 1, 2, 3, 4, 4, 4, 3,3, 2};
        printOneDimArray(cleanDuplicates(myArr));

        int[][] arr2 = {
            {1, 2, 3, 4},
            {-4, -1, -2, -3},
            {100, 400, 300, 200},
            {0, 0, 0, 0},
            {4, 3, 2, 1}
        };
//        int[] arr = {1, 2, 3, 2, 3, 4, 5, 4,
//            3, 2, 3, 4, 5, 788, 5, 3, 4, 5, 2, 6, 2, 2, 2, 5, 6, 6676, 3, 6, 3};

        // TODO - Varrer o array uma vez para popular com o números únicos
        int[] uniqueNumbers = {};
        int[][] uniqueNumbersMatrixFrequency = null;
        for (int[] arr2row : arr2) {
            uniqueNumbers = addArray(uniqueNumbers, removeDuplicates(arr2row));
            uniqueNumbersMatrixFrequency = convertToFrequencyArray(uniqueNumbers);
            uniqueNumbersMatrixFrequency = calculateFrequencyMatrix(uniqueNumbersMatrixFrequency, arr2row);
//            printFreqArray(uniqueNumbersMatrixFrequency);
        }
//        printOneDimArray(uniqueNumbers);
        printTwoDimArrayTransposed(uniqueNumbersMatrixFrequency);

    }

    private static int[][] calculateFrequencyMatrix(int[][] uniqueNumbersMatrixFrequency, int[] arr) {
        for (int row = 0; row < uniqueNumbersMatrixFrequency.length; row++) {
            uniqueNumbersMatrixFrequency[row][1] = frequencyOfNumber(arr, uniqueNumbersMatrixFrequency[row][0]);
        }
        return uniqueNumbersMatrixFrequency;
    }

    private static void printFreqArray(int[][] uniqueNumbersMatrixFrequency) {
        // TODO - Imprir vetor multidimensional de elementos e frequência
        for (int row = 0; row < uniqueNumbersMatrixFrequency.length; row++) {
            for (int col = 0; col < uniqueNumbersMatrixFrequency[row].length; col++) {
                System.out.print("row:" + row + ",col:" + col + "=>" + uniqueNumbersMatrixFrequency[row][col] + "\t");
            }
            System.out.println("");
        }
    }

    private static void printFreqArrayTransposed(int[][] uniqueNumbersMatrixFrequency) {
        // TODO - Imprir vetor multidimensional de elementos e frequência
        for (int[] number : uniqueNumbersMatrixFrequency) {
            System.out.print(number[0] + ", ");
        }
    }

    private static int[][] convertToFrequencyArray(int[] uniqueNumbers) {
        int[][] uniqueNumbersMatrixFrequency = new int[uniqueNumbers.length][2];
        for (int i = 0; i < uniqueNumbers.length; i++) {
            uniqueNumbersMatrixFrequency[i][0] = uniqueNumbers[i];
        }
        return uniqueNumbersMatrixFrequency;
    }

    private static int findNum(int[] arr, int num) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                result = i;
            }
        }
        return result;
    }

    public static int[] increaseArraySizeByN(int[] arr, int n) {
        int newLength = arr.length + n;
        int[] newArr = new int[newLength];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static int[] addNum(int[] arr, int num) {
        arr = increaseArraySizeByN(arr, 1);
        arr[arr.length - 1] = num;
        return arr;
    }

    public static int[] addArray(int[] arr1, int[] arr2) {
        int counter = 0;
        int[] newArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            newArr[counter] = arr1[i];
            counter++;
        }
        for (int i = 0; i < arr2.length; i++) {
            newArr[counter] = arr2[i];
            counter++;
        }
        return newArr;
    }

    public static void quicksort(int[] arr, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(arr, begin, end);
        quicksort(arr, begin, pivot - 1);
        quicksort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        int count = begin;
        int pivot = end;

        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int tmp = arr[count];
                arr[count] = arr[i];
                arr[i] = tmp;
                count++;
            }
        }
        int tmp = arr[pivot];
        arr[pivot] = arr[count];
        arr[count] = tmp;
        return count;

    }

    private static int frequencyOfNumber(int[] arr, int num) {
        int count = 0;
        for (int i : arr) {
            if (i == num) {
                count++;
            }
        }
        return count;
    }

    private static int[] removeDuplicates(int[] arrInput) {
        int[] arrOutput = {};
        int item;
        for (int i : arrInput) {
            item = findNum(arrOutput, i);
            if (item == -1) {
                arrOutput = addNum(arrOutput, i);
            }
        }
        return arrOutput;
    }

    private static void printOneDimArray(int[] arr) {
        for (int row = 0; row < arr.length; row++) {
            System.out.println(row + ":" + arr[row]);

        }
    }

    private static void printTwoDimArray(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(row + "," + col + "=" + arr[row][col] + "\t");

            }
            System.out.println("");

        }
    }

    private static void printTwoDimArrayTransposed(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            System.out.print(arr[row][0] + "\t");
        }
        System.out.println("");
        for (int row = 0; row < arr.length; row++) {
            System.out.print(arr[row][1] + "\t");
        }
        System.out.println("");

    }

    private static int[] cleanDuplicates(int[] arr) {
        int numberSample = 2;
        int indexToBeRemoved;
        int counter = 0;
        int[] newArr = arr;
        for (int i = 0; i < arr.length; i++) {
            if (numberSample == arr[i])
                counter++;
            
            if (numberSample == arr[i] && counter > 0) {
                indexToBeRemoved = i;
                newArr = joinArrays(splitArrays(arr, 0, i - 1), splitArrays(arr, i+1, arr.length - 1));
            }
        }
      return newArr;  
    }
    private static int[] joinArrays(int[] arr1, int[] arr2) {
        int[] joinedArr = new int[arr1.length + arr2.length];
        int index = 0;
        for (int i : arr1) {
            joinedArr[index] = i;
            index++;
        }
        for (int i : arr2) {
            joinedArr[index] = i;
            index++;
        }
        return joinedArr;
    }
    private static int[] splitArrays(int[]arr, int begin, int end) {
        int[] splittedArr = new int[end-begin];
        int index = 0;
        for (int i = begin; i < end; i++) {
            splittedArr[index] = arr[i];
            index++;
        }
        return splittedArr;
    }
}
