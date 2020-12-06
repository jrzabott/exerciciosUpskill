/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.adapter.Human;

/**
 *
 * @author user
 */
public class Human implements IFeed {

    String name;
    String age;
    int countMeals;

    public Human(String name, String age) {
        this.name = name;
        this.age = age;
        this.countMeals = this.countMeals++;
    }

    
    
    @Override
    public void eat(Food f) {
        this.countMeals += 1;
        if (f.isRawEdible()) {
            System.out.printf("%d - Eating %s raw...%n",this.countMeals, f.toString());
        } else if (f.isCookedEdible()) {
            if (!f.isEdible()) {
                FoodAdapter_Cooking cF = new FoodAdapter_Cooking(f);
                f = cF.cookFood();
                System.out.printf("%d - %s is now cooked. Eating it...%n",this.countMeals,  f.toString());
            }
        } else {
            System.out.printf("%d - Inedible... [Spitted]...%n", this.countMeals);
        }

    }

//    @Override
//    public void deployDejects() {
//        System.out.printf("%s just Pooped.%nNow he is hungry again...%n%n", this.name);
//    }

}
