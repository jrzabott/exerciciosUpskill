/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciosegmentodereta;

/**
 *
 * @author user
 */
public class Ponto {

    private int X, Y;

    static final int X_DEFAULT = 0;
    static final int Y_DEFAULT = 0;

    public Ponto(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public Ponto() {
        this.X = Ponto.X_DEFAULT;
        this.Y = Ponto.Y_DEFAULT;
    }

    /**
     * @return the X
     */
    public int getX() {
        return X;
    }

    /**
     * @return the Y
     */
    public int getY() {
        return Y;
    }

    /**
     * @param X the X to set
     */
    public void setX(int X) {
        this.X = X;
    }

    /**
     * @param Y the Y to set
     */
    public void setY(int Y) {
        this.Y = Y;
    }

    /**
     * Move a Ponto from the actual coordinates to another pair of (x, y) and 
     * returns a new instance of Ponto with the previous coordinates. 
     * For calculate distances, for example.
     *
     * @param x1
     * @param y1
     * @return a new instance of Ponto with the old coordinates;
     */
    public Ponto movePoint(int x1, int y1) {
        Ponto oldP = new Ponto(this.getX(), this.getY());
        setX(x1);
        setY(y1);
        return oldP;
    }

    /**
     * Move a Ponto from one coordinate to another e returns a new instance of
     * Ponto with the previous coordinates. For calculate distances,for example.
     *
     * @param otherP
     * @return a new instance of Ponto with the old coordinates;
     */
    public Ponto movePoint(Ponto otherP) {
        Ponto oldP = new Ponto(this.getX(), this.getY());
        setX(otherP.getX());
        setY(otherP.getY());
        return oldP;
    }

    @Override
    public Ponto clone() {
        return new Ponto(this.getX(), this.getY());
    }
    
    public void incX(int i) {
        this.setX(this.getX()+i);
    }
    
    public void incY(int i) {
        this.setY(this.getY()+i);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.X;
        hash = 79 * hash + this.Y;
        return hash;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ponto other = (Ponto) obj;
        if (this.X != other.X) {
            return false;
        }
        if (this.Y != other.Y) {
            return false;
        }
        return true;
    }
    
    
}
