/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciotempo;

/**
 *
 * @author Daniel Junior
 * @date 2020-11-03
 * @version 0.1
 */
public class Tempo {

    private int hh;
    private int mm;
    private int ss;

    private final int HH_DEFAULT = 0;
    private final int MM_DEFAULT = 0;
    private final int SS_DEFAULT = 0;
    private final int HOUR_IN_SECONDS = 3600;
    private final int MINUTES_IN_SECONDS = 60;
    private final int HOUR_IN_MINUTES = 60;
    private final int DAY_IN_HOURS = 24;
    private final int HOURS_IN_AMPM_HOURS = 12;
    private final String AM_STRING = "AM";
    private final String PM_STRING = "PM";
//    private final int SECONDS_TO_MINUTES_CONVERSION_FACTOR = 1 / 60;
//    private final int SECONDS_TO_HOURS_CONVERSION_FACTOR = 1 / 3600;

    /**
     *
     * @param hh
     * @param mm
     * @param ss
     * Constructor using the three time parameters, hour, min and sec.
     */
    public Tempo(int hh, int mm, int ss) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }

    /**
     *
     * @param hh
     * @param mm
     * Constructor that uses only hour and min to return a Time - hh:mm:00
     */
    public Tempo(int hh, int mm) {
        this.hh = hh;
        this.mm = mm;
        this.ss = SS_DEFAULT;
    }

    /**
     *
     * @param hh
     * Constructor that uses only the hours to create a time. hh:00:00
     */
    public Tempo(int hh) {
        this.hh = hh;
        this.mm = MM_DEFAULT;
        this.ss = SS_DEFAULT;
    }

    /**
     * Constructor that uses defalut values: all zeroes 00:00:00
     */
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
        return String.format("%02d:%02d:%02d", getHh(), getMm(), getSs());
    }

    /**
     * Ticks the clock, one second at time.
     */
    public void tick() {
        secondInc();
        // if after increment SECOND field is 0 add 1 to minute.
        if (this.getSs() == 0) {
            minuteInc();
            // if after min increment, MINUTE field is 0, add 1 to hour.
            if (this.getMm() == 0) {
                hourInc(); // if HOUR reaches 23 the next hour will be 00
            }
        }
    }

    private void secondInc() {
        this.setSs((this.getSs() + 1) % MINUTES_IN_SECONDS);
    }

    private void minuteInc() {
        this.setMm((this.getMm() + 1) % HOUR_IN_MINUTES);
    }

    private void hourInc() {
        this.setHh((this.getHh() + 1) % DAY_IN_HOURS);
    }

    /**
     *
     * @param t
     * @return the number seconds of a given hour:min:seg
     */
    public int convertTimeToSeconds(Tempo t) {
        return t.getHh() * HOUR_IN_SECONDS
                + t.getMm() * MINUTES_IN_SECONDS
                + t.getSs();
    }

    /**
     *
     * @param h - hours to be converted to sec
     * @param m - mintes to be cnoverted to sec
     * @param s - will be added to the end
     * @return the number of seconde of a given time.
     */
    public int convertHourMinutesAndSecondsToSeconds(int h, int m, int s) {
        return h * HOUR_IN_SECONDS
                + m * MINUTES_IN_SECONDS
                + s;
    }

    /**
     *
     * @param t1
     * @return true if param t1 is greater.
     */
    public boolean isGreater(Tempo t1) {
        return (convertTimeToSeconds(this) < convertTimeToSeconds(t1));
    }

    /**
     *
     * @param h - hour to compare
     * @param m - min to compare
     * @param s - seconds to compare
     * @return true is the time, composed by the parameters, is greater.
     */
    public boolean isGreater(int h, int m, int s) {
        return (convertTimeToSeconds(this)
                < convertHourMinutesAndSecondsToSeconds(h, m, s));
    }

    /**
     *
     * @param secondsToConvert
     * @return a new object Tempo with the converted hours, minutes and seconds.
     */
    public Tempo secondsToTempoObject(int secondsToConvert) {
        int h, m, s;
        h = secondsToConvert / HOUR_IN_SECONDS;
        m = secondsToConvert % HOUR_IN_SECONDS / MINUTES_IN_SECONDS;
        s = secondsToConvert % HOUR_IN_SECONDS % MINUTES_IN_SECONDS;
        return new Tempo(h, m, s);
    }

    /**
     *
     * @param tempo1
     * @return the difference of two times in seconds.
     */
    public int calcDiffReturnsSeconds(Tempo tempo1) {
        int thisSeconds = convertTimeToSeconds(this);
        int temp1Seconds = convertTimeToSeconds(tempo1);
        return Math.abs(thisSeconds - temp1Seconds);
    }

    /**
     *
     * @param tempo1
     * @return the difference of two times in the form of a Tempo Object
     */
    public Tempo calcDiffReturnsTempoObject(Tempo tempo1) {
        int thisSeconds = convertTimeToSeconds(this);
        int temp1Seconds = convertTimeToSeconds(tempo1);
        return secondsToTempoObject(Math.abs(thisSeconds - temp1Seconds));
    }

    /**
     *
     * @return a String of the current Time in [1-12]:[0-59]:[0-59] AM-PM forsmat
     */
    public String formatAMPM() {
        String amPm = (this.getHh() >= HOURS_IN_AMPM_HOURS)
                ? PM_STRING
                : AM_STRING;

        int hour = (this.getHh() % HOURS_IN_AMPM_HOURS != 0)
                ? this.getHh() % HOURS_IN_AMPM_HOURS
                : HOURS_IN_AMPM_HOURS;

        return String.format("%02d:%02d:%02d %s", hour, this.getMm(),
                this.getSs(), amPm);
    }

}
