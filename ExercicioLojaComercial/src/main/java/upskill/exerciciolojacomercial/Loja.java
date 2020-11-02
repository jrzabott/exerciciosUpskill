/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciolojacomercial;

/**
 *
 * @author user
 */
public class Loja {

    private int id;
    private String desc;
    private double area;
    private double receitas;
    private String classificaoLoja;

    private final String DESC_DEFAULT = "";
    private final String CLASSIFICACAO_LOJA_DEFAULT = "";

    private static double rendaFixa = 1.0;
    private static double areaLojaPequena = 20.0;
    private static double areaLojaMedia = 100.0;

    private static final double RECEITAS_DEFAULT = 0.0;
    private static final double AREA_DEFAULT = 0.0;
    private static final int ID_DEFAULT = 0;
    private static final String CLASSIFICACAO_LOJA_PEQUENA = "pequena";
    private static final String CLASSIFICACAO_LOJA_MEDIA = "media";
    private static final String CLASSIFICACAO_LOJA_GRANDE = "grande";

    public Loja(int id, String desc, double area, double receitas) {
        this.id = id;

        if (desc.isEmpty()) {
            this.desc = DESC_DEFAULT;
        } else {
            this.desc = desc;
        }

        this.area = area;
        this.receitas = receitas;

        if (area < areaLojaPequena) {
            this.classificaoLoja = CLASSIFICACAO_LOJA_PEQUENA;
        } else if (area <= areaLojaMedia) {
            this.classificaoLoja = CLASSIFICACAO_LOJA_MEDIA;
        } else {
            this.classificaoLoja = CLASSIFICACAO_LOJA_GRANDE;
        }
    }

    public Loja() {
        this.id = ID_DEFAULT;
        this.desc = DESC_DEFAULT;
        this.area = AREA_DEFAULT;
        this.receitas = RECEITAS_DEFAULT;
        this.classificaoLoja = this.CLASSIFICACAO_LOJA_DEFAULT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getReceitas() {
        return receitas;
    }

    public void setReceitas(double receitas) {
        this.receitas = receitas;
    }

    public String getClassificaoLoja() {
        return classificaoLoja;
    }

    public void setClassificaoLoja(String classificaoLoja) {
        this.classificaoLoja = classificaoLoja;
    }

    public static double getRendaFixa() {
        return rendaFixa;
    }

    public static void setRendaFixa(double rendaFixa) {
        Loja.rendaFixa = rendaFixa;
    }

    public static void setAREA_MAX_LOJA_PEQUENA(double AREA_MAX_LOJA_PEQUENA) {
        Loja.areaLojaPequena = AREA_MAX_LOJA_PEQUENA;
    }

    public static void setAREA_MAX_LOJA_MEDIA(double AREA_MAX_LOJA_MEDIA) {
        Loja.areaLojaMedia = AREA_MAX_LOJA_MEDIA;
    }

    public double getRenda() {
        return rendaFixa * (1 + area / 100) + (receitas / 100);
    }

    @Override
    public String toString() {
        return "Loja{" + "id=" + id + ", desc=" + desc + ", area=" + area + ", receitas=" + receitas + ", classificaoLoja=" + classificaoLoja + ", renda=" + getRenda() + ", DESC_DEFAULT=" + DESC_DEFAULT + ", CLASSIFICACAO_LOJA_DEFAULT=" + CLASSIFICACAO_LOJA_DEFAULT + '}';
    }

}
