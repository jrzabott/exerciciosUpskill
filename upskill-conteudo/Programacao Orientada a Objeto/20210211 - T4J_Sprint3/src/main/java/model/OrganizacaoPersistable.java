/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nunocastro
 */
public class OrganizacaoPersistable {

    private int persistenceType;
    private Organizacao org;
    
    public OrganizacaoPersistable(int persistenceType, Organizacao org) {
        this.persistenceType = persistenceType;
        this.org = org;
    }
    
    public IPersistable getPersistenceObject() {
        if (persistenceType == 1) {
            return getDatabasePersistence();
        }
        return getFilesPersistence();
    }
    
    private IPersistable getDatabasePersistence() {
        return new IPersistable() {
            @Override
            public boolean save() {
                //Save to db
                return false;
            }
        };
    }
    
    private IPersistable getFilesPersistence() {
        return new IPersistable() {
            @Override
            public boolean save() {
                //Save to file
                return false;
            }
        };
    }
}
