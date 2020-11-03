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
public class Customer {

    final private String name;
    private boolean member;
    private String memberType;

    final private String NAME_DEFAULT = "jane doe";
    final private boolean MEMBER_DEFAULT = false;
    final private String MEMBER_TYPE_DEFAULT = "";

    final public static String MEMBER_TYPE_GOLD = "gold";
    final public static String MEMBER_TYPE_PREMIUM = "premium";
    final public static String MEMBER_TYPE_SILVER = "silver";

    public Customer(String name) {
        if (name.isEmpty()) {
            this.name = NAME_DEFAULT;
        } else {
            this.name = name;
        }
        this.member = MEMBER_DEFAULT;
        this.memberType = MEMBER_TYPE_DEFAULT;
    }

    public String getName() {
        return name;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public void setMemberType(String memberType) {
        switch (memberType.toLowerCase()) {
            case MEMBER_TYPE_GOLD:
                this.memberType = MEMBER_TYPE_GOLD;
                break;
            case MEMBER_TYPE_PREMIUM:
                this.memberType = MEMBER_TYPE_PREMIUM;
                break;
            case MEMBER_TYPE_SILVER:
                this.memberType = MEMBER_TYPE_SILVER;
                break;
            default:
                this.memberType = "";
        }
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", member=" + member + ", memberType=" + memberType + '}';
    }

    public boolean isMember() {
        return member;
    }

}
