/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter13;

/**
 *
 * @author user
 */
public class GenericMethodDemo {
    static <T extends Comparable<T>, V extends Comparable<V>> boolean arraysEqual(T[] x, V[] y){
        // if lenghts differ, arrays differ
        if (x.length != y.length) {
            return false;
        }
        
        // if the internal contents differ, the arrays also differ
        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals(y[i])) {
                return false;
            }
        }
        return true; //lengths and contents are equal
    }
    
    public static void main(String[] args) {
        Integer nums1[] = { 1, 2, 3, 4, 5 };
        Integer nums2[] = { 1, 2, 3, 4, 5 };
        Integer nums3[] = { 1, 2, 7, 4, 5 };
        Integer nums4[] = { 1, 2, 3, 4, 5, 6 };
        Double  nums5[] = { 1.1, 2.2, 3.3, -4.4, 5.5};
        Double  nums6[] = { 1.0, 2.0, 3.0, 4.0, 5.0};
        Long    nums7[] = { 1L, 2L, 3L, 4L, 5L};
        
        String txt = "";
        txt = String.format("nums1 %s nums1", ((arraysEqual(nums1, nums1)) ? "EQUALS" : "NOT_EQUALS"));
        System.out.println(txt);

        txt = String.format("nums1 %s nums2", ((arraysEqual(nums1, nums2)) ? "EQUALS" : "NOT_EQUALS"));
        System.out.println(txt);

        txt = String.format("nums1 %s nums3", ((arraysEqual(nums1, nums3)) ? "EQUALS" : "NOT_EQUALS"));
        System.out.println(txt);

        txt = String.format("nums1 %s nums4", ((arraysEqual(nums1, nums4)) ? "EQUALS" : "NOT_EQUALS"));
        System.out.println(txt);

        txt = String.format("nums1 %s nums5", ((arraysEqual(nums1, nums5)) ? "EQUALS" : "NOT_EQUALS"));
        System.out.println(txt);
        
        txt = String.format("nums1 %s nums6", ((arraysEqual(nums1, nums6)) ? "EQUALS" : "NOT_EQUALS"));
        System.out.println(txt);
        
        txt = String.format("nums1 %s nums7", ((arraysEqual(nums1, nums7)) ? "EQUALS" : "NOT_EQUALS"));
        System.out.println(txt);
        
    }
    
}
