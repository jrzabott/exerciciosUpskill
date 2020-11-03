/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioutentedeginasio;

/**
 *
 * @author Daniel Junior - Utente de Ginásio
 */
public class Utente {

    private String name;
    private String gender;
    private int age;
    private double height;
    private double weight;

    private final String NAME_DEFAULT = "John Smith";
    private final String GENDER_DEFAULT = "none";
    private final int AGE_DEFAULT = 0;
    private final double HEIGHT_DEFAULT = 0.0;
    private final double WEIGHt_DEFAULT = 0.0;

    private static int classificacaoMagro = 18;
    private static int classificacaoSaudavel = 25;
    
    private static int countUtentes = 0; // Count numer of instantiated Utentes

    public static final String MAGRO_TEXTO_CLASSIFICACAO = "magro";
    public static final String SAUDAVEL_TEXTO_CLASSIFICACAO = "saudável";
    public static final String OBESO_TEXTO_CLASSIFICACAO = "obeso";

    /**
     * Constructor with defaults.
     */
    public Utente() {
        this.name = NAME_DEFAULT;
        this.gender = GENDER_DEFAULT;
        this.age = AGE_DEFAULT;
        this.height = HEIGHT_DEFAULT;
        this.weight = WEIGHt_DEFAULT;

        countUtentes++;
    }

    /**
     * Constructor with partial data.
     *
     * @param name
     * @param age
     */
    public Utente(String name, int age) {
        this.name = name;
        this.age = age;

        this.gender = GENDER_DEFAULT;
        this.height = HEIGHT_DEFAULT;
        this.weight = WEIGHt_DEFAULT;

        countUtentes++;
    }

    /**
     * Constructor with all parameters.
     *
     * @param name
     * @param gender
     * @param age
     * @param height
     * @param weigth
     */
    public Utente(String name, String gender, int age, double height, double weigth) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weigth;

        countUtentes++;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return the weight
     */
    public double getWeigth() {
        return weight;
    }

    /**
     * @return the total Number of Existing Utentes
     */
    public static int getCountUtentes() {
        return countUtentes;
    }

    /**
     * @return classificacaoMagro - the IMC value for the classificacaoMagro
     */
    public static int getClassificacaoMagro() {
        return classificacaoMagro;
    }

    /**
     * @return classificacaoMagro - the IMC value for the classificacaoSaudavel
     */
    public static int getClassificacaoSaudavel() {
        return classificacaoSaudavel;
    }

    /**
     * @param name - Change the name of the Utente
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param gender - Set Utente's gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @param age - Age's setting
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @param height - the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @param weigth - the weight to set
     */
    public void setWeigth(double weigth) {
        this.weight = weigth;
    }

    /**
     * @param aClassificacaoMagro - the IMC index to set for Magro
     */
    public static void setClassificacaoMagro(int aClassificacaoMagro) {
        classificacaoMagro = aClassificacaoMagro;
    }

    /**
     * @param aClassificacaoSaudavel the IMC index to set for Saudavel
     */
    public static void setClassificacaoSaudavel(int aClassificacaoSaudavel) {
        classificacaoSaudavel = aClassificacaoSaudavel;
    }

    @Override
    public String toString() {
        return "Utente{" + "name=" + name + ", gender=" + gender + ", age=" + age + ", height=" + height + ", weight=" + weight + '}';
    }

    /**
     *
     * @return IMC Index
     */
    public double calcIMC() {
        return this.getWeigth() / Math.pow(this.getHeight(), 2);
    }

    /**
     *
     * @param anotherPerson
     * @return The difference between two Utente's ages.
     */
    public int ageDiff(Utente anotherPerson) {
        return Math.abs(this.getAge() - anotherPerson.getAge());
    }

    /**
     *
     * @return a string between "Magro, Saudável and Obeso" according to IMC and
     * veriables classificacaoMagro and ClassificacaoSaudavel
     */
    public String weightCategory() {
        return (this.calcIMC() < classificacaoMagro)
                ? "Magro"
                : (this.calcIMC() < classificacaoSaudavel)
                ? "Saudável"
                : "Obeso";
    }

    /**
     *
     * @param pessoa2
     * @return 0, for same age, 1 when this is Older, 2 when the comparison is
     * older.
     */
    public Utente isYounger(Utente pessoa2) {
        if (this.getAge() == pessoa2.getAge()) {
            System.out.println("Utentes de mesma idade.");
        }
        return (this.getAge() == pessoa2.getAge())
                ? null
                : (this.getAge() > pessoa2.getAge())
                ? this
                : pessoa2;
    }
    
}
