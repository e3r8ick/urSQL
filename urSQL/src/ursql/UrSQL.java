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
       Table tabla2 = new Table("Tabla2");
       
       tabla.saveTable();
       tabla2.saveTable();
       esquema.addTable(tabla);
       esquema.addTable(tabla2);
       esquema.saveSchema();
       esquema.loadSchema("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\src\\Metadata\\Esquemas\\EsquemaEsquema1.xml");
       tabla.loadTable("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\src\\Metadata\\Tablas\\TablaTabla1.xml");
    }
    
}
