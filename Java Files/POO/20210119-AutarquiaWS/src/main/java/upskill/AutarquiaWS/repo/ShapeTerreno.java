/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.repo;

/**
 *
 * @author user
 */
public enum ShapeTerreno {
        CIRCLE {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Circular");
                return sb.toString();
            }

      
        },
        RECTANGLE {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Retangular");
                return sb.toString();
            }

        },
        TRIANGLE {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Triangular");
                return sb.toString();
            }


        }
    }
