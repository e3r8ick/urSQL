/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ursql;

import API.*;


/**
 *
 * @author Erick
 */
public class UrSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Schema esquema = new Schema("Esquema1");
       Table tabla = new Table("Tabla1");
       
       tabla.saveTable();
       esquema.saveSchema();
    }
    
}
