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
                                                "CREATE TABLE especie AS (idEspecie INTEGER NOT NULL, nombreComun VARCHAR NULL, familia VARCHAR NULL, PRIMARY KEY (idEspecie));",
                                                "CREATE TABLE animal AS (idAnimal INTEGER NOT NULL, habitat INTEGER NULL, PRIMARY KEY (idAnimal));",
                                                "INSERT INTO animal (idAnimal,habitat) VALUES (3,1)",
                                                "INSERT INTO animal (idAnimal,habitat) VALUES (7,2)",
                                                "ALTER TABLE serpiente ADD CONSTRAINT FOREIGN KEY especie REFERENCES especie(idEspecie)",
                                                "DISPLAY DATABASE serpentario",
                                                "INSERT INTO serpiente (idSerpiente,especie,nombre,nacimiento) VALUES (3,1,\"django\",\"14/8/1999 6:6:6\")",
                                                "INSERT INTO serpiente (idSerpiente,especie,nombre,nacimiento) VALUES (5,5,\"coco\",\"15/9/2000 3:3:3\")",
                                                "INSERT INTO serpiente (idSerpiente,especie,nombre,nacimiento) VALUES (4,5,\"beto\",\"15/1/1995 6:30:0\")",
                                                "INSERT INTO serpiente (idSerpiente,especie,nombre,nacimiento) VALUES (7,3,\"Lord Voldemort\",\"18/8/1998 6:30:0\")",
                                                "INSERT INTO serpiente (idSerpiente,especie,nombre,nacimiento) VALUES (8,2,\"cocori\",\"18/8/1998 6:30:0\")",
                                                "INSERT INTO especie (idEspecie,nombreComun) VALUES (5,\"Boa Constrictor\")",
                                                "INSERT INTO especie (idEspecie,nombreComun) VALUES (1,\"Cascabel\")",
                                                "INSERT INTO especie (idEspecie,nombreComun) VALUES (3,\"Piton\")",
                                                "DELETE FROM serpiente WHERE nacimiento > \"1/1/2001 0:0:0\"",
                                                "SELECT * FROM serpiente WHERE nacimiento < \"1/1/1998 0:0:0\"",
                                                "SELECT * FROM serpiente WHERE nombre LIKE \"co\"",
                                                "SELECT * FROM serpiente WHERE nombre NOT \"co\"",
                                                "SELECT nombre,nacimiento FROM serpiente JOIN especie ON especie = idEspecie",
                                                "SELECT nombre,nacimiento FROM serpiente JOIN especie ON especie = idEspecie JOIN animal ON idSerpiente = idAnimal",
                                                "SELECT * FROM especie",
                                                //"INSERT INTO serpiente (idSerpiente,especie) VALUES (9,2)",
                                                "SELECT * FROM serpiente GROUP BY especie",
                                                "SELECT especie, COUNT(especie) FROM serpiente GROUP BY especie");
       
       
       for (String comd : commands)
       {
           System.out.print("> ");
           System.out.println(comd);
           conn.executeCommand(comd);
           System.out.println("");
       }
       
    }
    
}
