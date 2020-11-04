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

    private int hora;
    private int minuto;
    private int segundo;

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
    private final String AMPM_FORMAT_STRING = "%02d:%02d:%02d %s";
    private final String DEFAULT_FORMAT_STRING = "%02d:%02d:%02d %s";
//    private final int SECONDS_TO_MINUTES_CONVERSION_FACTOR = 1 / 60;
//    private final int SECONDS_TO_HOURS_CONVERSION_FACTOR = 1 / 3600;

    /**
     *
     * @param hh
     * @param mm
     * @param ss Constructor using the three time parameters, hour, min and sec.
     */
    public Tempo(int hh, int mm, int ss) {
        this.hora = hh;
        this.minuto = mm;
        this.segundo = ss;
    }

    /**
     *
     * @param hh
     * @param mm Constructor that uses only hour and min to return a Time -
     * hora:minuto:00
     */
    public Tempo(int hh, int mm) {
        this.hora = hh;
        this.minuto = mm;
        this.segundo = SS_DEFAULT;
    }

    /**
     *
     * @param hh Constructor that uses only the hours to create a time.
     * hora:00:00
     */
    public Tempo(int hh) {
        this.hora = hh;
        this.minuto = MM_DEFAULT;
        this.segundo = SS_DEFAULT;
    }

    /**
     * Constructor that uses defalut values: all zeroes 00:00:00
     */
    public Tempo() {
        this.hora = HH_DEFAULT;
        this.minuto = MM_DEFAULT;
        this.segundo = SS_DEFAULT;
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @return the minuto
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * @return the segundo
     */
    public int getSsegundo() {
        return segundo;
    }

    /**
     * @param hh the hora to set
     */
    public void setHora(int hh) {
        this.hora = hh;
    }

    /**
     * @param mm the minutes to set
     */
    public void setMinuto(int mm) {
        this.minuto = mm;
    }

    /**
     * @param ss the seconds to set
     */
    public void setSegundo(int ss) {
        this.segundo = ss;
    }

    @Override
    public String toString() {
        return String.format(DEFAULT_FORMAT_STRING, getHora(), getMinuto(), getSsegundo());
    }

    /**
     * Ticks the clock, one second at time.
     */
    public void tick() {
        secondInc();
        // if after increment SECOND field is 0 add 1 to minute.
        if (this.getSsegundo() == 0) {
            minuteInc();
            // if after min increment, MINUTE field is 0, add 1 to hour.
            if (this.getMinuto() == 0) {
                hourInc(); // if HOUR reaches 23 the next hour will be 00
            }
        }
    }

    /**
     *
     * @param t1
     * @return FALSE if param t1 is greater.
     */
    public boolean isGreater(Tempo t1) {
        return (convertTimeToSeconds(this) > convertTimeToSeconds(t1));
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
     * @return a String of the current Time in [1-12]:[0-59]:[0-59] AM-PM
     * forsmat
     */
    public String formatAMPM() {
        String amPm = (this.getHora() >= HOURS_IN_AMPM_HOURS)
                ? PM_STRING
                : AM_STRING;

        int hour = (this.getHora() % HOURS_IN_AMPM_HOURS != 0)
                ? this.getHora() % HOURS_IN_AMPM_HOURS
                : HOURS_IN_AMPM_HOURS;

        return String.format(AMPM_FORMAT_STRING, hour, this.getMinuto(),
                this.getSsegundo(), amPm);
    }

    /**
     *
     * @param t
     * @return the number seconds of a given hour:min:seg
     */
    public int convertTimeToSeconds(Tempo t) {
        return convertHoursToSeconds(t.getHora())
                + convertMinutesToSeconds(t.getMinuto())
                + t.getSsegundo();
    }

    /**
     *
     * @param h - hours to be converted to sec
     * @param m - mintes to be cnoverted to sec
     * @param s - will be added to the end
     * @return the number of seconde of a given time.
     */
    public int convertHourMinutesAndSecondsToSeconds(int h, int m, int s) {
        return convertHoursToSeconds(h)
                + convertMinutesToSeconds(m)
                + s;
    }

    /**
     * Convert an number of hours in seconds.
     *
     * @param hours
     * @return a integer represeting the amount of seconds
     */
    private int convertHoursToSeconds(int hours) {
        return hours * HOUR_IN_SECONDS;
    }

    /**
     * Convert an number of minutes in seconds.
     *
     * @param minutes
     * @return a integer representing the amount of seconds
     */
    private int convertMinutesToSeconds(int minutes) {
        return minutes * MINUTES_IN_SECONDS;
    }

    /**
     * increments one unity into the property Segundo
     */
    private void secondInc() {
        this.setSegundo((this.getSsegundo() + 1) % MINUTES_IN_SECONDS);
    }

    /**
     * increments one unity into the property Minuto
     */
    private void minuteInc() {
        this.setMinuto((this.getMinuto() + 1) % HOUR_IN_MINUTES);
    }
    
    /**
     * increments one unity into the property Hora
     */
    private void hourInc() {
        this.setHora((this.getHora() + 1) % DAY_IN_HOURS);
    }

}
