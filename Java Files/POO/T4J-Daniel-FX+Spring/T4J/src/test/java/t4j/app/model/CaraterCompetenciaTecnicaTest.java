/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Upskill
 */
public class CaraterCompetenciaTecnicaTest {
    private CaraterCompetenciaTecnica cctT;
    public CaraterCompetenciaTecnicaTest() {
        cctT = new CaraterCompetenciaTecnica();
    }


    /**
     * Test of isObrigatorio method, of class CaraterCT.
     */
//    @Test
    public void testIsObrigatorio() {
        System.out.println("isObrigatorio");
        CaraterCompetenciaTecnica instance = new CaraterCompetenciaTecnica();
        boolean expResult = false;
        boolean result = instance.isObrigatorio();
        assertEquals(expResult, result);
    }

    /**
     * Test of setObrigatorio method, of class CaraterCT.
     */
//    @Test
    public void testSetObrigatorio() {
        //Testes de sucesso
        boolean op = true;
        cctT.setObrigatorio(op);
        assertEquals(op, cctT.isObrigatorio());
    }

    /**
     * Test of getCt method, of class CaraterCT.
     */
//    @Test
    public void testGetCt() {
        System.out.println("getCt");
        CaraterCompetenciaTecnica instance = new CaraterCompetenciaTecnica();
        CompetenciaTecnica expResult = null;
        CompetenciaTecnica result = instance.getCompetenciaTecnica();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCt method, of class CaraterCT.
     */
//    @Test
    public void testSetCt() {
        System.out.println("setCt");
        CompetenciaTecnica ct = null;
        CaraterCompetenciaTecnica instance = new CaraterCompetenciaTecnica();
        instance.setCompetenciaTecnica(ct);
    }

    /**
     * Test of getGrau method, of class CaraterCT.
     */
//    @Test
    public void testGetGrau() {
        System.out.println("getGrau");
        CaraterCompetenciaTecnica instance = new CaraterCompetenciaTecnica();
        GrauProficiencia expResult = null;
        GrauProficiencia result = instance.getGrauProficiencia();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGrau method, of class CaraterCT.
     */
//    @Test
    public void testSetGrau() {
        System.out.println("setGrau");
        GrauProficiencia grau = null;
        CaraterCompetenciaTecnica instance = new CaraterCompetenciaTecnica();
        instance.setGrauProficiencia(grau);
    }

    /**
     * Test of equals method, of class CaraterCT.
     */
//    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = null;
        CaraterCompetenciaTecnica instance = new CaraterCompetenciaTecnica();
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }
    
}
