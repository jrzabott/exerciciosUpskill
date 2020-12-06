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
public class Food implements IEdible {

    /**
     * @return the cookedEdible
     */
    public boolean isCookedEdible() {
        return cookedEdible;
    }

    /**
     * @param rawEdible the rawEdible to set
     */
    public void setRawEdible(boolean rawEdible) {
        this.rawEdible = rawEdible;
    }

    /**
     * @param cookedEdible the cookedEdible to set
     */
    public void setCookedEdible(boolean cookedEdible) {
        this.cookedEdible = cookedEdible;
    }

    private boolean edible = false;
    private boolean rawEdible;
    private boolean cookedEdible;

    /**
     * Get the value of edible
     *
     * @return the value of edible
     */
    public boolean isEdible() {
        return edible;
    }

    /**
     * Set the value of edible
     *
     * @param edible new value of edible
     */
    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    public Food(boolean edible, boolean rawEdible, boolean cookedEdible) {
        this.edible = edible;
        this.rawEdible = rawEdible;
        this.cookedEdible = cookedEdible;
    }

    public Food(boolean rawEdible, boolean cookedEdible) {
        this.edible = false;
        this.rawEdible = rawEdible;
        this.cookedEdible = cookedEdible;
    }

    public Food cloneFood(Food f) {
        return new Food(f.isEdible(), f.isRawEdible(), f.cookedEdible);
    }

    @Override
    public boolean isRawEdible() {
        return this.rawEdible;
    }

    @Override
    public boolean isCoockedEdible() {
        return this.cookedEdible;
    }

    @Override
    public String toString() {
        return "Food{" + "edible=" + edible + ", rawEdible=" + rawEdible + ", cookedEdible=" + cookedEdible + '}';
    }

}
