package com.company.model;
import com.company.exception.DataInvalidaException;
import java.io.Serializable;

public class Data implements Serializable {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        checkData(dia, mes, ano);
    }

    public Data(Data data) {
        checkData(data.dia, data.mes, data.ano);
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void setData(int dia, int mes, int ano) {
        checkData(dia, mes, ano);
    }

    private void checkData(int dia, int mes, int ano) throws DataInvalidaException {
        if (eValida(dia, mes, ano) == true) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            throw new DataInvalidaException(dia + "/" + mes + "/" + ano + ": data invalida");
        }
    }

    private boolean eBissexto(int ano) {
        if (((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0)) {
            return true;
        }
        return false;
    }

    private boolean eValida(int dia, int mes, int ano) {
        boolean f = false;
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dia > 0 && dia <= 31) {
                    f = true;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (dia > 0 && dia <= 30) {
                    f = true;
                }
                break;
            case 2:
                if (eBissexto(ano) == true) {
                    if (dia > 0 && dia <= 29) {
                        f = true;
                    }
                } else {
                    if (dia > 0 && dia <= 28) {
                        f = true;
                    }
                }
                break;
            default:
                break;
        }
        return f;
    }
}
