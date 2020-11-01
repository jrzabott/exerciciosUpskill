/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill;

import java.util.Date;

/**
 *
 * @author user
 */
public class Visit {

    public Customer customer;
    private String name;
    private Date date;
    private double serviceExpense;
    private double productExpense;
    private double totalExpense;

    final private double SERVICE_EXPENSE_DEFAULT = 0.0;
    final private double PRODUCT_EXPENSE_DEFAULT = 0.0;
    final private double TOTAL_EXPENSE_DEFAULT = 0.0;

    public Visit(String name, Date date) {
        this.name = name;
        this.date = date;
        this.serviceExpense = SERVICE_EXPENSE_DEFAULT;
        this.productExpense = PRODUCT_EXPENSE_DEFAULT;
        this.totalExpense = TOTAL_EXPENSE_DEFAULT;
        this.customer = new Customer(this.name);
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public double getTotalExpense() {
        return serviceExpense + productExpense;
    }

    public void setServiceExpense(double ex) {
        String mt = customer.getMemberType();
        double d = DiscountRate.getServiceDiscoutRate(mt);
        this.serviceExpense += ex * (1 - d);
    }

    public void setProductExpense(double ex) {
        String mt = this.customer.getMemberType();
        double d = DiscountRate.getProductDiscountRate(mt);
        this.productExpense += ex * (1 - d);
    }

    @Override
    public String toString() {
        return "Visit{"
                + "customer=" + customer
                + ", name=" + name
                + ", date=" + date
                + ", serviceExpense=" + serviceExpense
                + ", productExpense=" + productExpense
                + ", productDiscount=" + DiscountRate.getProductDiscountRate(customer.getMemberType())
                + ", serviceDiscount=" + DiscountRate.getServiceDiscoutRate(customer.getMemberType());
    }

}
