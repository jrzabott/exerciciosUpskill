/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill;

/**
 *
 * @author user
 */
public class DiscountRate {

    final static public double serviceDiscountPremium = 0.2;
    final static public double serviceDiscountGold = 0.15;
    final static public double serviceDiscountSilver = 0.1;

    static public double productDiscountPremium = 0.1;
    static public double productDiscountGold = 0.1;
    static public double productDiscountSilver = 0.1;

    public static double getServiceDiscoutRate(String mt) {
        double result = 0.0;
        switch (mt.toLowerCase()) {
            case Customer.MEMBER_TYPE_GOLD:
                result = serviceDiscountGold;
                break;
            case Customer.MEMBER_TYPE_PREMIUM:
                result = serviceDiscountPremium;
                break;
            case Customer.MEMBER_TYPE_SILVER:
                result = serviceDiscountSilver;
                break;
            default:
        }
        return result;
    }

    public static double getProductDiscountRate(String mt) {
        double result = 0.0;
        switch (mt.toLowerCase()) {
            case Customer.MEMBER_TYPE_GOLD:
                result = productDiscountGold;
                break;
            case Customer.MEMBER_TYPE_PREMIUM:
                result = productDiscountPremium;
                break;
            case Customer.MEMBER_TYPE_SILVER:
                result = productDiscountSilver;
                break;
            default:
        }
        return result;
    }

}
