/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciotempo;

/**
 *
 * @author user
 */
public class Tempo {

    private int hh;
    private int mm;
    private int ss;

    private final int HH_DEFAULT = 0;
    private final int MM_DEFAULT = 0;
    private final int SS_DEFAULT = 0;
    private final int HOURS_TO_SECONDS_CONVERSION_FACTOR = 3600;
    private final int MINUTES_TO_SECONDS_CONVERSION_FACTOR = 60;
    private final int SECONDS_TO_MINUTES_CONVERSION_FACTOR = 1 / 60;
    private final int SECONDS_TO_HOURS_CONVERSION_FACTOR = 1 / 3600;

    public Tempo(int hh, int mm, int ss) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }

    public Tempo(int hh, int mm) {
        this.hh = hh;
        this.mm = mm;
        this.ss = SS_DEFAULT;
    }

    public Tempo(int hh) {
        this.hh = hh;
        this.mm = MM_DEFAULT;
        this.ss = SS_DEFAULT;
    }

    public Tempo() {
        this.hh = HH_DEFAULT;
        this.mm = MM_DEFAULT;
        this.ss = SS_DEFAULT;
    }

    /**
     * @return the hh
     */
    public int getHh() {
        return hh;
    }

    /**
     * @return the mm
     */
    public int getMm() {
        return mm;
    }

    /**
     * @return the ss
     */
    public int getSs() {
        return ss;
    }

    /**
     * @param hh the hh to set
     */
    public void setHh(int hh) {
        this.hh = hh;
    }

    /**
     * @param mm the minutes to set
     */
    public void setMm(int mm) {
        this.mm = mm;
    }

    /**
     * @param ss the seconds to set
     */
    public void setSs(int ss) {
        this.ss = ss;
    }

    @Override
    public String toString() {
        return String.format("%d:%d:%d", getHh(), getMm(), getSs());
    }
   

}
