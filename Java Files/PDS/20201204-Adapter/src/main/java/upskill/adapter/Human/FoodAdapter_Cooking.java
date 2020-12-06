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
public class FoodAdapter_Cooking implements IEdible {

    /**
     * @return the f
     */
    public Food getF() {
        return f;
    }

    /**
     * @param f the f to set
     */
    public void setF(Food f) {
        this.f = f;
    }
    private Food f;

    public FoodAdapter_Cooking(Food f) {
        this.f = f;
    }
        
    
    public Food cookFood(){
        Food cookedF = f.cloneFood(f);
        if (cookedF.isCookedEdible()) {
            System.out.printf("Cooking %s...%n", f.toString());
        }
        cookedF.setEdible(true);
        
        return cookedF;
    }

    @Override
    public boolean isRawEdible() {
        return f.isRawEdible();
    }

    @Override
    public boolean isCoockedEdible() {
        return f.isCookedEdible();
    }
}
