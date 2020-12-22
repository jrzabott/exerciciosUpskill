/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavBegGui_chapter14;

interface StringFunc {

    String func(String str);
}

/**
 *
 * @author user
 */
public class LambdaArgumentDemo {

    // This method has a func interface as the type of ites 1st param.
    // Thus, it can be passed a ref to any instance of that interface.
    // Including an instance created by a lambda exp. 2nd param specifies 
    // the string to operate on.
    static String changeStr(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambda Expressions Expand Java";
        String outStr;

        System.out.println("Here is the input string: " + inStr);

        StringFunc reverse = (str) -> {
            String result = "";

            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }

            return result;
        };

        // Pass reverse to the first argument o changeStr().
        // Pass the input string as the second argument.
        outStr = changeStr(reverse, inStr);
        System.out.println("The string reversed: " + outStr);

        outStr = changeStr((str) -> {
            String result = "";
            result = str.replace(" ", "-");
            return result;
        }, inStr);
        System.out.println("The spaces were replaced by hyphens: " + outStr);
        
        outStr = changeStr((str) -> {
            String result = "";
            char ch;

            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (Character.isUpperCase(ch)) {
                    result += Character.toLowerCase(ch);
                } else {
                    result += Character.toUpperCase(ch);
                }
            }
            return result;
        }, inStr);
        System.out.println("The string in reversed case: " + outStr);
    }
}
