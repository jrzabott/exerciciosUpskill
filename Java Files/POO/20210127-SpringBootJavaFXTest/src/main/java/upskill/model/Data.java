/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author user
 */
public class Data {

    private ArrayList<Date> datas;

    public void addData() {
        this.datas.add(new Date());
    }

    public Data() {
        this.datas = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Date data : datas) {
            sb.append(data);
            sb.append("\n");
        }
        return sb.toString();
    }

}
