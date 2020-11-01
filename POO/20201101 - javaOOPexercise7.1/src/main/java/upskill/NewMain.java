/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Exercise extracted from: https://www3.ntu.edu.sg/home/ehchua/programming/java/J3f_OOPExercises.html#zz-7.1
 *
 */
package upskill;

import java.util.Date;

/**
 *
 * @author user
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creating 3 customer's Name
        String c1Name = "Not a Member Jones";
        String c2Name = "Silvie Member Silver";
        String c3Name = "Premium Member Preacher";

        // date of the visit (2020/10/31)
        Date todaysDate = new Date((2020 - 1900), 9, 31);
        Visit v1 = new Visit(c1Name, todaysDate);
        Visit v2 = new Visit(c2Name, todaysDate);
        Visit v3 = new Visit(c3Name, todaysDate);

        v1.customer.setMember(false);

        v2.customer.setMember(true);
        v2.customer.setMemberType(Customer.MEMBER_TYPE_SILVER);

        v3.customer.setMember(true);
        v3.customer.setMemberType(Customer.MEMBER_TYPE_PREMIUM);

        // The visits are all similar, let's see how things go.
        v1.setProductExpense(150);
        v1.setProductExpense(50);
        v1.setServiceExpense(50);
        v1.setServiceExpense(25);

        v2.setProductExpense(150);
        v2.setProductExpense(50);
        v2.setServiceExpense(50);
        v2.setServiceExpense(25);

        v3.setProductExpense(150);
        v3.setProductExpense(50);
        v3.setServiceExpense(50);
        v3.setServiceExpense(25);

        System.out.println("X===================================================X");
        System.out.println(v1.getTotalExpense());
        System.out.println(v1.toString());
        System.out.println("X===================================================X");

        System.out.println(v2.getTotalExpense());
        System.out.println(v2.toString());
        System.out.println("X===================================================X");

        System.out.println(v3.getTotalExpense());
        System.out.println(v3.toString());
        System.out.println("X===================================================X");
    }

}
