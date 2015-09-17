/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ursql;

import objects.RuntimeDatabaseProcessor;
import objects.Schema;
import objects.SystemCatalog;
import objects.Table;
        
/**
 *
 * @author Erick
 */
public class UrSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
       RuntimeDatabaseProcessor run = new RuntimeDatabaseProcessor();
       /*SystemCatalog system = new SystemCatalog(); 
       Schema esquema = new Schema("Esquema1","C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Esquemas\\EsquemaEsquema1.xml");
       Table tabla = new Table("Tabla1","C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Tablas\\TablaTabla1.xml");
       Table tabla2 = new Table("Tabla2","C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Tablas\\TablaTabla2.xml");
       */
       /*tabla.saveTable();
       tabla2.saveTable();
       esquema.addTable(tabla);
       esquema.addTable(tabla2);
       esquema.saveTables();
       esquema.loadTables();
       tabla.loadTable("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Tablas\\TablaTabla1.xml");
       esquema.dropSchema();*/
       
      // FileOutputStream file = new FileOutputStream("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Datos\\DatoDato1.bin");
       
    }
    
}
