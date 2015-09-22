/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ursql;

import java.util.Arrays;
import java.util.List;
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
        
       Connection conn = new Connection();
       
       conn.startConnection();
       
       List<String> commands = Arrays.asList(   "CREATE DATABASE serpentario",
                                                "CREATE DATABASE matricula",
                                                "LIST DATABASES",
                                                "SET DATABASE serpentario",
                                                "CREATE TABLE serpiente AS (idSerpiente INTEGER NOT NULL, especie INTEGER NOT NULL, nombre VARCHAR NULL, nacimiento DATETIME NOT NULL, PRIMARY KEY (idSerpiente));",
                                                "CREATE TABLE especie AS (idEspecie INTEGER NOT NULL, nombreComun VARCHAR NULL, familia VARCHAR NOT NULL, PRIMARY KEY (idEspecie));",
                                                "ALTER TABLE serpiente ADD CONSTRAINT FOREIGN KEY especie REFERENCES especie(idEspecie)",
                                                "DISPLAY DATABASE serpentario",
                                                "DROP TABLE especie",
                                                "DROP TABLE serpiente",
                                                "DISPLAY DATABASE serpentario");
       
       
       for (String comd : commands)
       {
           System.out.println(comd);
           conn.executeCommand(comd);
       }
       
    }
    
}
